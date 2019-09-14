package modele;

public class Marque {

	protected int id_marque;
	protected String nom;
	protected String couleur_logo;
	protected String slogan;
	protected String date_creation;

	public Marque(String nom) {
		super();
		this.nom = nom;
	}
	public Marque(String nom, String couleur_logo) {
		super();
		this.nom = nom;
		this.couleur_logo = couleur_logo;
	}
	public Marque(String nom, String couleur_logo, String slogan) {
		super();
		this.nom = nom;
		this.couleur_logo = couleur_logo;
		this.slogan = slogan;
	}
	public Marque(String nom, String couleur_logo, String slogan, String date_creation) {
		super();
		this.nom = nom;
		this.couleur_logo = couleur_logo;
		this.slogan = slogan;
		this.date_creation = date_creation;
	}

	public Marque(int id_marque, String nom, String couleur_logo, String slogan, String date_creation) {
		this.id_marque = id_marque;
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
	public String getDate_creation() {
		return date_creation;
	}
	public void setDate_creation(String date_creation) {
		this.date_creation = date_creation;
	}
	public String getSlogan() {
		return slogan;
	}
	public void setSlogan(String slogan) {
		this.slogan = slogan;
	}
}
