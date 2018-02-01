package yolocorp.estock.DAO;


import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import yolocorp.estock.Mlnterface.I_Produit;
import yolocorp.estock.model.Produit;

public class ProduitDAO implements I_ProduitDAO {
	
	private static String selectAll = "SELECT produit_nom, produit_prix_ht, produit_quantite_stock FROM Produits";
	private static String removeProduit = "DELETE FROM Produits WHERE produit_nom = ?";
	
	private Connection cn;
	
	public ProduitDAO() {
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
	public boolean addProduit(String nom, double prix, int qte) {
		try {
			CallableStatement cst = cn.prepareCall("{call ajouterProduit(?,?,?)}");
			cst.setString(1, nom);
			cst.setDouble(2, prix);
			cst.setInt(3, qte);
			cst.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	@Override
	public boolean removeProduit(String nom) {
		boolean res = false;
		try {
			PreparedStatement pst = cn.prepareStatement(ProduitDAO.removeProduit);
			pst.setString(1, nom);
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
		System.out.println("coucou");
		try {
			PreparedStatement pst = cn.prepareStatement(ProduitDAO.selectAll);
			ResultSet rs = pst.executeQuery();
			System.out.println("coucouvbis");
			while(rs.next()) {
				System.out.println("4");
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
}
