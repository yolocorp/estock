package yolocorp.estock.DAO;

public class ConcreteFactoryProduitDAO {
	
	public I_ProduitDAO createProduitDAO() {
		ProduitDAO produitDAO = new ProduitDAO();
		
		return produitDAO;
	}
	
	public I_ProduitDAO createProduitDAOXML() {
		AdapterXML produitDAOXML = new AdapterXML();
		
		return produitDAOXML;
	}
}
