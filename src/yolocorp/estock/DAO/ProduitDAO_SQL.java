package yolocorp.estock.DAO;


import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import yolocorp.estock.model.I_Produit;
import yolocorp.estock.model.Produit;

public class ProduitDAO_SQL implements I_ProduitDAO {
	
	private static String selectAll = "SELECT produit_nom, produit_prix_ht, produit_quantite_stock FROM Produits";
	private static String removeProduit = "DELETE FROM Produits WHERE produit_nom = ?";
	private static String updateProduit = "UPDATE Produits SET produit_quantite_stock = ? WHERE produit_nom = ?";
	
	private Connection cn;
	
	public ProduitDAO_SQL() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			this.cn = DriverManager.getConnection("jdbc:oracle:thin:@162.38.222.149:1521:iut", "collety", "1108009694N");
		} catch (SQLException e ) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	
	}
	
	@Override
	public boolean addProduit(I_Produit produit) {
		boolean res = false;
		try {
			CallableStatement cst = cn.prepareCall("{call procedure_add_produit(?,?,?)}");
			cst.setString(1, produit.getNom());
			cst.setDouble(2, produit.getPrixUnitaireHT());
			cst.setInt(3, produit.getQuantite());
			int rows = cst.executeUpdate();
			if(rows == 1) res = true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return res;
	}
	
	@Override
	public boolean removeProduit(I_Produit produit) {
		boolean res = false;
		try {
			PreparedStatement pst = cn.prepareStatement(ProduitDAO_SQL.removeProduit);
			pst.setString(1, produit.getNom());
			int rows = pst.executeUpdate();
			if(rows == 1) res = true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return res;
	}
	
	@Override
	public List<I_Produit> getProduits() {
		List<I_Produit> produits = new ArrayList<I_Produit>();
		try {
			PreparedStatement pst = cn.prepareStatement(ProduitDAO_SQL.selectAll);
			ResultSet rs = pst.executeQuery();
			while(rs.next()) {
				I_Produit produit = new Produit(rs.getString("produit_nom"),
											rs.getDouble("produit_prix_ht"),
											rs.getInt("produit_quantite_stock"));
				produits.add(produit);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return produits;
	}
	
	@Override
	public boolean updateProduit (I_Produit produit) {
		boolean res = false;
		try {
			PreparedStatement pst = cn.prepareStatement(ProduitDAO_SQL.updateProduit);
			pst.setString(2, produit.getNom());
			pst.setInt(1, produit.getQuantite());
			int rows = pst.executeUpdate();
			if(rows == 1) res = true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return res;
	}
}
