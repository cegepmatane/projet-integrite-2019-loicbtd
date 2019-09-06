package donnee;

public interface VoitureSQL {
	
	String SQL_LISTER_VOITURES = "SELECT * FROM voiture";
	String SQL_LISTER_VOITURES_PAR_MARQUE = "SELECT * from voiture WHERE id_marque = ?";
	String SQL_AJOUTER_VOITURE = "INSERT into voiture(modele, couleur, puissance, annee, id_marque) VALUES(?,?,?,?,?)";
	String SQL_MODIFIER_VOITURE = "UPDATE voiture SET modele = ?, couleur = ?, puissance = ?, annee = ? WHERE id = ?";
	String SQL_RAPPORTER_VOITURE = "SELECT * FROM voiture WHERE id = ?";

}
