CREATE TABLE produit (
	produit_id number constraint produit_id_nn not null,
	produit_nom nvarchar2 constraint produit_nom_nn not null,
	produit_prix_ht double constraint produit_prix_ht_nn not null,
	produit_quantite_stock int constraint produit_quantite_stock_nn not null
);
