CREATE TABLE produit (
	produit_id number constraint produit_id_nn not null,
	produit_nom nvarchar2 constraint produit_nom_nn not null,
	produit_prix_ht constraint produit_prix_ht_nn not null,
	produit_taux_tva constraint produit_taux_tva not null
);
