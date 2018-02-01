package yolocorp.estock.DAO;

import java.util.List;

import yolocorp.estock.model.I_Produit;

public class AdapterXML implements I_ProduitDAO {
	
	private ProduitDAO_XML produitDAO_XML;
	
	public boolean addProduit(I_Produit produit) {
		return produitDAO_XML.creer(produit);
	}
	
	public boolean removeProduit(I_Produit produit) {
		return produitDAO_XML.supprimer(produit);
	}
	
	public List<I_Produit> getProduits(){
		return produitDAO_XML.lireTous();
	}

	@Override
	public boolean updateProduit(I_Produit produit) {
		return produitDAO_XML.maj(produit);
	}
}
