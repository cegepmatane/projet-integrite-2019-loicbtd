package modele;

public class Marque {

	protected int id;
	protected String nom;
	protected String couleurLogo;
	protected String slogan;
	protected String dateCreation;

	public Marque() {
	}

	public Marque(String nom) {
		super();
		this.nom = nom;
	}
	public Marque(String nom, String couleurLogo) {
		super();
		this.nom = nom;
		this.couleurLogo = couleurLogo;
	}
	public Marque(String nom, String couleurLogo, String slogan) {
		super();
		this.nom = nom;
		this.couleurLogo = couleurLogo;
		this.slogan = slogan;
	}
	public Marque(String nom, String couleurLogo, String slogan, String dateCreation) {
		super();
		this.nom = nom;
		this.couleurLogo = couleurLogo;
		this.slogan = slogan;
		this.dateCreation = dateCreation;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getCouleurLogo() {
		return couleurLogo;
	}
	public void setCouleurLogo(String couleurLogo) {
		this.couleurLogo = couleurLogo;
	}
	public String getDateCreation() {
		return dateCreation;
	}
	public void setDateCreation(String dateCreation) {
		this.dateCreation = dateCreation;
	}
	public String getSlogan() {
		return slogan;
	}
	public void setSlogan(String slogan) {
		this.slogan = slogan;
	}
	
}
