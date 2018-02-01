package yolocorp.estock.DAO;

import java.util.List;

import yolocorp.estock.Mlnterface.I_Produit;

public interface I_ProduitDAO {

	public abstract boolean createProduit(String nom, double prix, int quantite);
	public abstract boolean addProduit(String nom, double prix, int qte);
	public abstract int addProduits(List<I_Produit> l);
	public abstract boolean removeProduit(String nom);
}
