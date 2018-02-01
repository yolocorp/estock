package yolocorp.estock.DAO;

public class ConcreteFactoryProduitDAO {
	
	public ProduitDAO createProduitDAO() {
		ProduitDAO produitDAO = new ProduitDAO();
		
		return produitDAO;
	}
	
	public ProduitDAO_XML createProduitDAOXML() {
		ProduitDAO_XML produitDAOXML = new ProduitDAO_XML();
		
		return produitDAOXML;
	}
}
