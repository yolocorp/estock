package yolocorp.estock.model;

import java.util.Iterator;
import java.util.List;
import java.util.ArrayList;

public class Catalogue implements I_Catalogue {
	
	List<I_Produit> produits = new ArrayList<I_Produit>();
	
	public boolean addProduit(I_Produit produit) {
		return this.produits.add(produit);
	}
	
	public boolean addProduit(String nom, double prix, int qte) {
		Produit produit = new Produit(nom, prix, qte);
		return this.produits.add((I_Produit) produit);
	}
	
	public int addProduits(List<I_Produit> l) {
		if(l.size() == 0) return 0;
		boolean boolRes = this.produits.addAll(l);
		int intRes = boolRes? l.size() : -1;
		return intRes;
	}
	
	public boolean removeProduit(String nom) {
		boolean res = false;
		for(Iterator<I_Produit> i = this.produits.iterator(); i.hasNext(); ) {
			I_Produit produit = i.next();
			if(produit.getNom().equals(nom)) {
				res = this.produits.remove(produit);
			}
		}
		return res;
	}
	
	public boolean acheterStock(String nomProduit, int qteAchetee) {
		boolean res = false;
		for(I_Produit produit : this.produits) {
			if(produit.getNom().equals(nomProduit)) {
				produit.ajouter(qteAchetee);
				res = true;
			}
		}
		return res;
	}
	
	public boolean vendreStock(String nomProduit, int qteVendue) {
		boolean res = false;
		for(I_Produit produit : this.produits) {
			if(produit.getNom().equals(nomProduit)) {
				produit.enlever(qteVendue);
				res = true;
			}
		}
		return res;
	}
	
	public String[] getNomProduits() {
		String[] res = new String[this.produits.size()];
		for(int i = 0; i < this.produits.size(); i++) {
			res[i] = this.produits.get(i).getNom();
		}
		return res;
	}
	
	public double getMontantTotalTTC() {
		float montant = 0f;
		for(I_Produit produit : this.produits) {
			montant += produit.getPrixStockTTC();
		}
		return montant;
	}
	
	public String toString() {
		String res = "[ ";
		for(I_Produit produit : this.produits) {
			res += this.produits.toString() + ", ";
		}
		return res;
	}

	public void clear() {
		this.produits = new ArrayList<I_Produit>();
	}

}
