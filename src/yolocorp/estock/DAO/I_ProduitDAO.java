package yolocorp.estock.DAO;

import java.util.List;

import yolocorp.estock.model.I_Produit;

public interface I_ProduitDAO extends I_DAO{
	
	public abstract boolean addProduit(I_Produit produit);
	public abstract boolean removeProduit(I_Produit produit);
	public abstract List<I_Produit> getProduits();
	public abstract boolean updateProduit(I_Produit produit);
	
}
