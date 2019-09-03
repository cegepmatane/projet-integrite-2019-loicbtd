package donnee;

public interface MarqueSQL {
	
	public static final String SQL_LISTER_MARQUES = "SELECT * FROM marque";
	public static final String SQL_AJOUTER_MARQUE = "INSERT into marque(nom, couleur_logo, slogan, date_creation) VALUES(?,?,?,?)";
	public static final String SQL_MODIFIER_MARQUE = "UPDATE marque SET nom = ?, couleur_logo = ?, slogan = ?, date_creation = ? WHERE id = ?";
	public static final String SQL_RAPPORTER_MARQUE = "SELECT * FROM marque WHERE id = ?";
}
