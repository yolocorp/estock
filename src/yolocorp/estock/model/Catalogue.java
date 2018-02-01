package yolocorp.estock.model;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.List;

import yolocorp.estock.DAO.ConcreteFactoryProduitDAO;
import yolocorp.estock.DAO.I_ProduitDAO;
import yolocorp.estock.util.ProduitComparator;

import java.util.ArrayList;
import java.util.Collections;

public class Catalogue implements I_Catalogue {
	
	private List<I_Produit> produits = new ArrayList<I_Produit>();
	private static Catalogue cat = new Catalogue();
	
	private ConcreteFactoryProduitDAO factoryProduitDAO;
	private I_ProduitDAO produitDAOSQL;
	
	private Catalogue() {
		factoryProduitDAO = new ConcreteFactoryProduitDAO();
		produitDAOSQL = factoryProduitDAO.createProduitDAOSQL();
	}
	
	public static Catalogue getCatalogue() {
		return cat;
	}
	
	public boolean addProduit(I_Produit produit) {
		if(produit != null && !this.isProduit(produit.getNom())) {
			if(produit.getPrixUnitaireHT() > 0.0 && produit.getQuantite() >= 0) {
				return this.produits.add(produit);
			}
		}
		return false;
	}
	
	public boolean addProduit(String nom, double prix, int qte) {
		if(!this.isProduit(nom)) {
			if(prix > 0.0 && qte >= 0) {
				Produit produit = new Produit(nom, prix, qte);
				produitDAOSQL.addProduit(produit);
				return this.produits.add((I_Produit) produit);
			}
		}
		return false;
	}
	
	public int addProduits(List<I_Produit> l) {
		if(l == null || l.size() == 0) return 0;
		int res = 0;
		for(I_Produit produit : l) {
			if(produit != null && !isProduit(produit.getNom())) {
				if(produit.getPrixUnitaireHT() > 0 && produit.getQuantite() >= 0) {
					boolean boolRes = this.produits.add(produit);
					res += boolRes? 1 : 0;
				}
			}
		}
		return res;
	}
	
	public boolean removeProduit(String nom) {
		for(int i = 0; i < this.produits.size(); i++) {
			I_Produit produit = this.produits.get(i);
			if(produit.getNom().equals(nom)) {
				this.produitDAOSQL.removeProduit(produit);
				this.produits.remove(i);
				return true;
			}
		}
		return false;
	}
	
	public boolean acheterStock(String nomProduit, int qteAchetee) {
		boolean res = false;
		if(qteAchetee > 0) {
			for(I_Produit produit : this.produits) {
				if(produit.getNom().equals(nomProduit)) {
					produit.ajouter(qteAchetee);
					produitDAOSQL.updateProduit(produit);
					res = true;
				}
			}
		}
		return res;
	}
	
	public boolean vendreStock(String nomProduit, int qteVendue) {
		boolean res = false;
		if(qteVendue > 0) {
			for(I_Produit produit : this.produits) {
				if(produit.getNom().equals(nomProduit) && qteVendue <= produit.getQuantite()) {
					produit.enlever(qteVendue);
					produitDAOSQL.updateProduit(produit);
					res = true;
				}
			}
		}
		return res;
	}
	
	public String[] getNomProduits() {
		String[] res = new String[this.produits.size()];
		Collections.sort(this.produits, new ProduitComparator());
		for(int i = 0; i < this.produits.size(); i++) {
			res[i] = this.produits.get(i).getNom();
		}
		return res;
	}
	
	public void getProduits() {
		produits = produitDAOSQL.getProduits();
	}
	
	public double getMontantTotalTTC() {
		double montant = 0.0;
		for(I_Produit produit : this.produits) {
			montant += produit.getPrixStockTTC();
		}
		return doubleRounded(montant);
	}
	
	public String toString() {
		String res = "";
		for(I_Produit produit : this.produits) {
			res += produit.toString() + "\n";
		}
		return res + "\n" + "Montant total TTC du stock : " + doubleToEuros(getMontantTotalTTC());
	}

	public void clear() {
		this.produits = new ArrayList<I_Produit>();
	}
	
	private boolean isProduit(String nomProduit) {
		for(I_Produit produit: this.produits) {
			if(produit.getNom().trim().equals(nomProduit.trim().replaceAll("\t", " ")))
				return true;
		}
		return false;
	}

	private double doubleRounded(double dval) {
		BigDecimal montantRounded = new BigDecimal(dval);
		montantRounded = montantRounded.setScale(2,BigDecimal.ROUND_HALF_EVEN);
		return montantRounded.doubleValue();
	}
	
	private String doubleToEuros(double dvalue) {
		NumberFormat formatter = NumberFormat.getCurrencyInstance(java.util.Locale.FRANCE);
		return formatter.format(dvalue);
	}

}
