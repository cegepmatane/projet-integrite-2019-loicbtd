package modele;

public class Marque {

	public static final String CLE_ID_MARQUE = "id_marque";
	public static final String CLE_NOM = "nom";
	public static final String CLE_COULEUR_LOGO = "couleur_logo";
	public static final String CLE_SLOGAN = "slogan";
	public static final String CLE_DATE_CREATION = "date_creation";

	protected int id_marque;
	protected String nom;
	protected String couleur_logo;
	protected String slogan;
	protected int date_creation;

	public Marque(String nom, String couleur_logo, String slogan, int date_creation) {
		this.nom = nom;
		this.couleur_logo = couleur_logo;
		this.slogan = slogan;
		this.date_creation = date_creation;
	}

	public int getId_marque() {
		return id_marque;
	}
	public void setId_marque(int id_marque) {
		this.id_marque = id_marque;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getCouleur_logo() {
		return couleur_logo;
	}
	public void setCouleur_logo(String couleur_logo) {
		this.couleur_logo = couleur_logo;
	}
	public String getSlogan() {
		return slogan;
	}
	public void setSlogan(String slogan) {
		this.slogan = slogan;
	}
	public int getDate_creation() {
		return date_creation;
	}
	public void setDate_creation(int date_creation) {
		this.date_creation = date_creation;
	}
}
