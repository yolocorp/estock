package yolocorp.estock.DAO;

import java.util.List;

import yolocorp.estock.Mlnterface.I_Produit;

public interface I_ProduitDAO {
	
	public abstract boolean addProduit(String nom, double prix, int qte);
	public abstract boolean removeProduit(String nom);
	public abstract List<I_Produit> getProduits();
	
}
