package yolocorp.estock.DAO;

import java.util.List;

import yolocorp.estock.model.I_Catalogue;

public interface I_CatalogueDAO extends I_DAO{
	
	public abstract List<I_Catalogue> getAll ();
	public abstract I_Catalogue getCatalogue (String nom, I_ProduitDAO produitDAO);
	public abstract boolean addCatalogue (I_Catalogue catalogue);
	public abstract boolean removeCatalogue (I_Catalogue catalogue);
	
}
