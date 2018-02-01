package yolocorp.estock.model;

import java.math.BigDecimal;
import java.text.NumberFormat;

public class Produit implements I_Produit {
	
	private int quantiteStock;
	private String nom;
	private double prixUnitaireHT;
	private double tauxTVA = 0.2;
	
	public Produit(String nom, double prixUnitaireHT, int quantiteStock) {
		this.nom = nom.trim().replace("\t",  " ");
		this.prixUnitaireHT = prixUnitaireHT;
		this.quantiteStock = quantiteStock;
	}
	
	public boolean ajouter(int quantiteAchetee){
		quantiteStock = quantiteStock + quantiteAchetee;
		return true;
	}
	
	public boolean enlever(int quantiteVendue){
		quantiteStock = quantiteStock - quantiteVendue;
		return true;
	}
	
	public double getPrixUnitaireHT() {
		return this.prixUnitaireHT;
	}
	
	public double getPrixUnitaireTTC(){
		return (this.getPrixUnitaireHT() * (1+this.tauxTVA));
	}
	
	public double getPrixStockTTC(){
		return (quantiteStock * this.getPrixUnitaireTTC());
	}
	
	public String getNom() {
		return this.nom;
	}
	
	public int getQuantite() {
		return quantiteStock;
	}
	
	public String toString(){
		//Prix HT
		String prixHT = doubleToEuros(doubleRounded(getPrixUnitaireHT()));
		//Prix TTC
		String prixTTC = doubleToEuros(doubleRounded(getPrixUnitaireTTC()));
		return getNom() + " - prix HT : " + prixHT + " - prix TTC : " + prixTTC
				+ " - quantité en stock : " + this.getQuantite();
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
