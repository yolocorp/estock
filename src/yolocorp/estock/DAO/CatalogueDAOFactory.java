package yolocorp.estock.DAO;

import java.sql.Connection;

public class CatalogueDAOFactory extends DAOFactory {

	
	public CatalogueDAOFactory () {
	}
	
	public I_DAO getDAO (String DataBaseType) {
		I_CatalogueDAO catalogueDAO = null;
		
		if(DataBaseType.equals("SQL"))
			catalogueDAO = new CatalogueDAO_SQL(super.getDBConnection());

		return catalogueDAO;
	}

}
