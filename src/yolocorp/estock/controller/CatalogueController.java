package yolocorp.estock.controller;

import java.util.List;

import yolocorp.estock.DAO.DAOFactory;
import yolocorp.estock.DAO.I_CatalogueDAO;
import yolocorp.estock.DAO.I_ProduitDAO;
import yolocorp.estock.GUI.FenetreAccueil;
import yolocorp.estock.GUI.FenetrePrincipale;
import yolocorp.estock.model.I_Catalogue;

public class CatalogueController {
	
	I_ProduitDAO produitDao;
	I_CatalogueDAO catalogueDao;
	
	List<I_Catalogue> catalogues;
	I_Catalogue catalogueSelect;
	
	public CatalogueController () {
		produitDao = (I_ProduitDAO) DAOFactory.getFactory("produit").getDAO("SQL");
		catalogueDao = (I_CatalogueDAO) DAOFactory.getFactory("catalogue").getDAO("SQL");
		
		catalogues = catalogueDao.getAll();
	}
	
	public boolean catalogueSelection (String catalogueName) {
		boolean res = false;
		for(I_Catalogue cat : catalogues) {
			if(cat.getNom().equals(catalogueName)) {
				this.catalogueSelect = catalogueDao.getCatalogue(cat.getNom(), this.produitDao);
				new FenetrePrincipale(this);
				res = true;
			}
		}
		return res;
	}
	
	public I_Catalogue getCatalogue () {
		return this.catalogueSelect;
	}
	
	public StockController getStockController () {
		return new StockController(this.catalogueSelect);
	}
	
	private String[] getNomCatalogues () {
		String[] catalogueNames = new String[catalogues.size()];
		int i = 0;
		for(I_Catalogue cat : catalogues) {
			catalogueNames[i] = cat.getNom();
		}
		return catalogueNames;
	}
	
	private String[] getDetailCatalogues () {
		String[] catalogueDetails = new String[catalogues.size()];
		int i = 0;
		for(I_Catalogue cat : catalogues) {
			catalogueDetails[i] = cat.getNom() + " : " + cat.getNombreProduits() + " produits";
		}
		return catalogueDetails;
	}
	
	public static void main (String[] args) {
		CatalogueController catalogueCtrl = new CatalogueController();
		new FenetreAccueil(catalogueCtrl.getNomCatalogues(), catalogueCtrl.getDetailCatalogues(), catalogueCtrl);
	}

}
