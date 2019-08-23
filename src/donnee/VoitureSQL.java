package donnee;

public interface VoitureSQL {
	
	public static final String SQL_LISTER_VOITURES = "SELECT * FROM garage";
	public static final String SQL_AJOUTER_VOITURES = "INSERT into garage(modele, couleur, puissance, annee) VALUES(?,?,?,?)";
	public static final String SQL_MODIFIER_VOITURES = "UPDATE garage SET modele = ?, couleur = ?, puissance = ?, annee = ? WHERE id = ?";
	public static final String SQL_RAPPORTER_VOITURES = "SELECT * FROM garage WHERE id = ?";
}
