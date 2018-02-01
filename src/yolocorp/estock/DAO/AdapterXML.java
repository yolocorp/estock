package yolocorp.estock.DAO;

import java.util.List;

import yolocorp.estock.Mlnterface.I_Produit;

public class AdapterXML {
	
	private ProduitDAO_XML produitDAO_XML;
	
	public boolean addProduit(I_Produit p) {
		return produitDAO_XML.creer(p);
	}
	
	public boolean removeProduit(I_Produit p) {
		return produitDAO_XML.supprimer(p);
	}
	
	public List<I_Produit> getProduits(){
		return produitDAO_XML.lireTous();
	}
}
