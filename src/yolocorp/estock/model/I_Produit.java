package yolocorp.estock.model;

public interface I_Produit {

	public abstract boolean ajouter(int qteAchetee);
	public abstract boolean enlever(int qteVendue);
	public abstract String getNom();
	public abstract int getQuantite();
	public abstract float getPrixUnitaireHT();
	public abstract float getPrixUnitaireTTC();
	public abstract float getPrixStockTTC();
	public abstract String toString();

}