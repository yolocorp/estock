package yolocorp.estock.DAO;

import java.util.List;

import yolocorp.estock.Mlnterface.I_Produit;

public interface I_ProduitDAO {
	
	public abstract boolean addProduit(I_Produit produit);
	public abstract boolean removeProduit(I_Produit produit);
	public abstract List<I_Produit> getProduits();
	public abstract boolean updateProduit(I_Produit produit);
	
}
