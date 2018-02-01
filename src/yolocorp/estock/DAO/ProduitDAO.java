package yolocorp.estock.DAO;

import java.sql.*;

public class ProduitDAO {
	
	private Connection cn;
	private Statement st;
	
	public ProduitDAO() {
	
		Connection cn;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			cn = DriverManager.getConnection("jdbc:oracle:thin:@162.38.222.149:1521:iut", "collety", "1108009694N");
			st = cn.createStatement();
		} catch (SQLException e ) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	
	}
	
	public void createProduit(String nom, double prix, int quantite ) {
		try {
			CallableStatement cst = cn.prepareCall("{call ajouterProduit(?,?,?)}");
			cst.setString(1, nom);
			cst.setDouble(2, prix);
			cst.setInt(3, quantite);
			cst.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void readProduit(String nom) {
	
		try {
			PreparedStatement pst = cn.prepareStatement("SELECT * FROM PRODUITS WHERE produit_nom = ?");
			pst.setString(1, nom);
			pst.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	public void updateProduit(String nom, double prix, int quantite) {
		try {
			CallableStatement cst = cn.prepareCall("{call modifierProduit(?,?,?)}");
			cst.setString(1, nom);
			cst.setDouble(2, prix);
			cst.setInt(3, quantite);
			cst.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void deleteProduit(String nom) {
		try {
			CallableStatement cst = cn.prepareCall("{call ajouterProduit(?)}");
			cst.setString(1, nom);
			cst.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
