package donnee;

public interface MarqueSQL {

	String SQL_LISTER_MARQUES = "SELECT * FROM marque";
	String SQL_AJOUTER_MARQUE = "INSERT INTO marque(nom, couleur_logo, slogan, date_creation) VALUES(?,?,?,?)";
	String SQL_MODIFIER_MARQUE = "UPDATE marque SET nom = ?, couleur_logo = ?, slogan = ?, date_creation = ? WHERE id_marque = ?";
	String SQL_RAPPORTER_MARQUE = "SELECT * FROM marque WHERE id_marque = ?";
}
