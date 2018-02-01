package yolocorp.estock.DAO;

import java.sql.Connection;

public class ProduitDAOFactory extends DAOFactory {
		
	public ProduitDAOFactory () {
	}

	public I_ProduitDAO getDAO (String DataBaseType) {
		I_ProduitDAO produitDAO = null;
		
		if(DataBaseType.equals("SQL"))
			produitDAO = new ProduitDAO_SQL(super.getDBConnection());
		
		return produitDAO;
	}

	
}
