package donnee;

public interface VoitureSQL {
	
	public static final String SQL_LISTER_VOITURES = "SELECT * FROM voiture";
	public static final String SQL_AJOUTER_VOITURE = "INSERT into voiture(modele, couleur, puissance, annee, id_modele) VALUES(?,?,?,?,?)";
	public static final String SQL_MODIFIER_VOITURE = "UPDATE voiture SET modele = ?, couleur = ?, puissance = ?, annee = ?, id_marque = ? WHERE id = ?";
	public static final String SQL_RAPPORTER_VOITURE = "SELECT * FROM voiture WHERE id = ?";

	public static final String SQL_LISTER_VOITURES_PAR_MARQUE = "SELECT * FROM voiture WHERE id_marque = ?";
}
