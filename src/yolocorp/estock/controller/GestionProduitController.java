package yolocorp.estock.controller;

import yolocorp.estock.model.Catalogue;

public class GestionProduitController {
	
	private static Catalogue cat = Catalogue.getCatalogue();
	
	public static void addProduit(String nomProduit, String prixProduitStr, String qteProduitStr) {
		double prixProduit = Double.parseDouble(prixProduitStr);
		int qteProduit = Integer.parseInt(qteProduitStr);
		if(nomProduit != null) {
			if(nomProduit.trim().length() > 0 && prixProduit > 0 && qteProduit > 0) {
				cat.addProduit(nomProduit, prixProduit, qteProduit);
			}
		}
	}
	
	public static void removeProduit(String nomProduit) {
		cat.removeProduit(nomProduit);		
	}
}
