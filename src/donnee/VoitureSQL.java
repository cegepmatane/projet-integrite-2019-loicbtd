package donnee;

public interface VoitureSQL {
	
	public static final String SQL_LISTER_VOITURES = "SELECT * FROM voiture";
	public static final String SQL_AJOUTER_VOITURES = "INSERT into voiture(modele, couleur, puissance, annee, id_modele) VALUES(?,?,?,?,?)";
	public static final String SQL_MODIFIER_VOITURES = "UPDATE voiture SET modele = ?, couleur = ?, puissance = ?, annee = ?, id_marque = ? WHERE id = ?";
	public static final String SQL_RAPPORTER_VOITURES = "SELECT * FROM voiture WHERE id = ?";
}
