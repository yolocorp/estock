package yolocorp.estock.controller;

import yolocorp.estock.model.Catalogue;
import yolocorp.estock.model.I_Catalogue;

public class GestionStockController {
	
	private I_Catalogue cat;
	
	public GestionStockController (I_Catalogue cat) {
		this.cat = cat;
	}
	
	public void achatProduit(String nomProduit, String qteAcheteeStr) {
		int qteAchetee = Integer.parseInt(qteAcheteeStr);
		if(nomProduit != null && nomProduit.trim().length() > 0) {
			if(qteAchetee > 0) {
				cat.acheterStock(nomProduit, qteAchetee);
			}
		}
	}
	
	public void vendreProduit(String nomProduit, String qteVendueStr) {
		int qteVendue = Integer.parseInt(qteVendueStr);
		if(nomProduit != null && nomProduit.trim().length() > 0) {
			if(qteVendue > 0) {
				cat.vendreStock(nomProduit, qteVendue);
			}
		}
	}
}
