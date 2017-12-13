package yolocorp.estock.model;

public class Produit implements I_Produit {
	
	private int quantiteStock;
	private String nom;
	private double prixUnitaireHT;
	private double tauxTVA = 0.2f;
	
	public Produit(String nom, double prixUnitaireHT, int quantiteStock) {
		this.nom = nom;
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
		double prixUnitaireHT = Math.round(this.prixUnitaireHT * 100)/100;
		return prixUnitaireHT;
	}
	
	public double getPrixUnitaireTTC(){
		double prixUnitaireTTC = Math.round((this.prixUnitaireHT * tauxTVA) * 100)/100;
		return prixUnitaireTTC;
	}
	
	public double getPrixStockTTC(){
		double prixStockTTC = Math.round((quantiteStock * getPrixUnitaireTTC()) * 100)/100;
		return prixStockTTC;
	}
	
	public String getNom() {
		return this.nom;
	}
	
	public int getQuantite() {
		return quantiteStock;
	}
	
	public String toString(){
		return "Nom : " + getNom() + ", Quantité : " + quantiteStock + ", Prix Unitaire HT : " + getPrixUnitaireHT()
				+ ", Prix Unitaire TTC : " + getPrixUnitaireTTC() + ", Prix Stock TTC : " + getPrixStockTTC();
	}
}
