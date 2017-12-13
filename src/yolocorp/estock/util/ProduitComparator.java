package yolocorp.estock.util;

import java.util.Comparator;

import yolocorp.estock.Mlnterface.I_Produit;

public class ProduitComparator implements Comparator<I_Produit> {
	
	@Override
	public int compare(I_Produit p1, I_Produit p2) {
		return p1.getNom().compareTo(p2.getNom());
	}

}
