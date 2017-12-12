package yolocorp.estock.model;

public class Produit {
	
	private int quantiteStock;
	private String nom;
	private float prixUnitaireHT;
	private float tauxTVA = 0.2f;
	
	public Produit(String nom, float prixUnitaireHT, int quantiteStock) {
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
	
	public float getPrixUnitaireHT() {
		return this.prixUnitaireHT;
	}
	
	public float getPrixUnitaireTTC(){
		return this.prixUnitaireHT * tauxTVA;
	}
	
	public float getPrixStockTTC(){
		return quantiteStock * getPrixUnitaireTTC();
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
