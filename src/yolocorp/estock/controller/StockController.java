package yolocorp.estock.controller;

import yolocorp.estock.model.*;

public class StockController {
	
	private static Catalogue cat = Catalogue.getCatalogue();
	
	public static void getProduits() {
		cat.getProduits();
	}
	
	public static String[] getDetailProduits() {
		String[] nomProduits = cat.getNomProduits();
		return nomProduits;
	}

}
