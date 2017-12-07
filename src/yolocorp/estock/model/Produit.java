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
		
		return true;
	}
	
	public boolean enlever(int quantiteVendue){
		return true;
	}
	
	public float getPrixUnitaireHT() {
		return this.prixUnitaireHT;
	}
}
