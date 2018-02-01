package yolocorp.estock.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public abstract class DAOFactory {
	
	private static Connection cn;
	
	public Connection getDBConnection () {
		if(this.cn == null) {
			try {
				Class.forName("oracle.jdbc.driver.OracleDriver");
				this.cn = DriverManager.getConnection("jdbc:oracle:thin:@162.38.222.149:1521:iut", "collety", "1108009694N");
			} catch (SQLException e ) {
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
		}
		return this.cn;
	}
	
	public static DAOFactory getFactory(String nom)
	{
		if(nom.equalsIgnoreCase("produit"))
			return new ProduitDAOFactory();
		if(nom.equalsIgnoreCase("catalogue"))
			return new CatalogueDAOFactory();
		
		return null;
	}
	
	public abstract I_DAO getDAO(String databaseType);

}
