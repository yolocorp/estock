package yolocorp.estock.controller;

import yolocorp.estock.model.*;

public class StockController {
	
	private I_Catalogue cat;
	
	public StockController (I_Catalogue cat) {
		this.cat = cat;
	}
	
	public String[] getNomProduits () {
		return cat.getNomProduits();
	}
	
	public String getDetailProduits() {
		String produits = cat.toString();
		return produits;
	}

}
