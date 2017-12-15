package yolocorp.estock.controller;

import yolocorp.estock.model.Catalogue;

public class GestionStockController {
	
	private static Catalogue cat = Catalogue.getCatalogue();
	
	public static void achatProduit(String nomProduit, String qteAcheteeStr) {
		int qteAchetee = Integer.parseInt(qteAcheteeStr);
		if(nomProduit != null && nomProduit.trim().length() > 0) {
			if(qteAchetee > 0) {
				cat.acheterStock(nomProduit, qteAchetee);
			}
		}
	}
	
	public static void vendreProduit(String nomProduit, String qteVendueStr) {
		int qteVendue = Integer.parseInt(qteVendueStr);
		if(nomProduit != null && nomProduit.trim().length() > 0) {
			if(qteVendue > 0) {
				cat.vendreStock(nomProduit, qteVendue);
			}
		}
	}
}
