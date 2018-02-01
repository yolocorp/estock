package yolocorp.estock.controller;

import yolocorp.estock.model.*;

public class StockController {
	
	private static Catalogue cat = Catalogue.getCatalogue();
	
	public static void getProduits() {
		cat.getProduits();
	}
	
	public static String[] getNomProduits () {
		return cat.getNomProduits();
	}
	
	public static String getDetailProduits() {
		String produits = cat.toString();
		return produits;
	}

}
