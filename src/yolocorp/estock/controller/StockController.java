package yolocorp.estock.controller;

import yolocorp.estock.model.*;

public class StockController {
	
	private static Catalogue cat = Catalogue.getCatalogue();
	
	public static String[] getProduits() {
		String[] nomProduits = cat.getNomProduits();
		return nomProduits;
	}
	
	public static String[] getDetailProduits() {
		String[] nomProduits = cat.getProduits();
		return nomProduits;
	}

}
