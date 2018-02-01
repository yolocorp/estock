package yolocorp.estock.DAO;

public class ConcreteFactoryProduitDAO {
	
	public I_ProduitDAO createProduitDAOSQL() {
		ProduitDAO_SQL produitDAO = new ProduitDAO_SQL();
		
		return produitDAO;
	}
	
	public I_ProduitDAO createProduitDAOXML() {
		AdapterXML produitDAOXML = new AdapterXML();
		
		return produitDAOXML;
	}

	
}
