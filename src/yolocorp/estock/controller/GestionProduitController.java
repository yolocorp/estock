package yolocorp.estock.controller;

import yolocorp.estock.model.I_Catalogue;

public class GestionProduitController {
	
	private I_Catalogue cat;
	
	public GestionProduitController (I_Catalogue cat) {
		this.cat = cat;
	}
	
	public void addProduit(String nomProduit, String prixProduitStr, String qteProduitStr) {
		double prixProduit = Double.parseDouble(prixProduitStr);
		int qteProduit = Integer.parseInt(qteProduitStr);
		if(nomProduit != null) {
			if(nomProduit.trim().length() > 0 && prixProduit > 0 && qteProduit > 0) {
				cat.addProduit(nomProduit, prixProduit, qteProduit);
			}
		}
	}
	
	public void removeProduit(String nomProduit) {
		cat.removeProduit(nomProduit);		
	}
}
