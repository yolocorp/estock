package yolocorp.estock.DAO;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import yolocorp.estock.model.Catalogue;
import yolocorp.estock.model.I_Catalogue;
import yolocorp.estock.model.I_Produit;
import yolocorp.estock.model.Produit;

public class CatalogueDAO_SQL implements I_CatalogueDAO {
	
	private static String getAllRequest = "SELECT catalogue_nom, count(produit_nom) AS nb_produits FROM Catalogues3 "
									+ "LEFT JOIN Produits3 ON catalogue_id = produit_catalogue "
									+ "GROUP BY catalogue_nom";
	
	private static String getRequest = "SELECT produit_nom, produit_prix_ht, produit_quantite_stock "
									+ "FROM Produits3 JOIN Catalogues3 ON produit_catalogue = catalogue_id "
									+ "WHERE catalogue_nom = ?";
	
	private static String removeRequest = "DELETE FROM Catalogues3 WHERE catalogue_nom = ?";
	
	Connection cn;
	
	public CatalogueDAO_SQL (Connection cn) {
		this.cn = cn;
	}
	
	@Override
	public List<I_Catalogue> getAll() {
		List<I_Catalogue> catalogues = new ArrayList<I_Catalogue>();
		try {
			PreparedStatement pst = cn.prepareStatement(CatalogueDAO_SQL.getAllRequest);
			ResultSet rs = pst.executeQuery();
			if(rs.next()) {
				I_Catalogue catalogue = new Catalogue(rs.getString("catalogue_nom"), rs.getInt("nb_produits"));
				catalogues.add(catalogue);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return catalogues;
	}

	@Override
	public I_Catalogue getCatalogue (String nom, I_ProduitDAO produitDAO) {
		I_Catalogue catalogue = null;
		try {
			PreparedStatement pst = cn.prepareStatement(CatalogueDAO_SQL.getRequest);
			pst.setString(1, nom);
			ResultSet rs = pst.executeQuery();
			catalogue = new Catalogue(produitDAO, nom);
			if(rs.next()) {
				I_Produit produit = new Produit(rs.getString("produit_nom"),
												rs.getDouble("produit_prix_ht"),
												rs.getInt("produit_quantite_stock"));
				catalogue.addProduit(produit);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return catalogue;
	}

	@Override
	public boolean addCatalogue(I_Catalogue catalogue) {
		boolean res = false;
		try {
			CallableStatement cst = cn.prepareCall("{call procedure_add_catalogue(?)}");
			cst.setString(1, catalogue.getNom());
			int rows = cst.executeUpdate();
			if(rows == 1) res = true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return res;
	}

	@Override
	public boolean removeCatalogue(I_Catalogue catalogue) {
		boolean res = false;
		try {
			PreparedStatement pst = cn.prepareStatement(CatalogueDAO_SQL.removeRequest);
			pst.setString(1, catalogue.getNom());
			int rows = pst.executeUpdate();
			if(rows > 1) res = true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return res;
	}

	@Override
	public I_DAO getDAO(String databaseType) {
		// TODO Auto-generated method stub
		return null;
	}

	

}
