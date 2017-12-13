package yolocorp.estock.model;

import java.math.BigDecimal;

import yolocorp.estock.Mlnterface.I_Produit;

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
		BigDecimal HTRounded = new BigDecimal(this.getPrixUnitaireHT());
		HTRounded= HTRounded.setScale(2,BigDecimal.ROUND_HALF_EVEN);
		//Prix TTC
		BigDecimal TTCRounded = new BigDecimal(this.getPrixUnitaireTTC());
		TTCRounded= TTCRounded.setScale(2,BigDecimal.ROUND_HALF_EVEN);
		return getNom() + " - prix HT : " + HTRounded.doubleValue() + " € - prix TTC : " + TTCRounded.doubleValue()
				+ " € - quantité en stock : " + this.getQuantite();
	}
}
