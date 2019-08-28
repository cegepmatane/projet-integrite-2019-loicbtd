package modele;

public class Voiture {

	protected int id;
	protected String modele;
	protected String couleur;
	protected String puissance;
	protected String annee;
	protected int idMarque;

	public Voiture(String modele) {
		super();
		this.modele = modele;
	}
	public Voiture(String modele, String couleur) {
		super();
		this.modele = modele;
		this.couleur = couleur;
	}
	public Voiture(String modele, String couleur, String puissance) {
		super();
		this.modele = modele;
		this.couleur = couleur;
		this.puissance = puissance;
	}
	public Voiture(String modele, String couleur, String puissance, String annee) {
		super();
		this.modele = modele;
		this.couleur = couleur;
		this.puissance = puissance;
		this.annee = annee;
	}

	public Voiture(String modele, String couleur, String puissance, String annee, int idMarque) {
		super();
		this.modele = modele;
		this.couleur = couleur;
		this.puissance = puissance;
		this.annee = annee;
		this.idMarque = idMarque;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getModele() {
		return modele;
	}

	public void setModele(String modele) {
		this.modele = modele;
	}

	public String getCouleur() {
		return couleur;
	}

	public void setCouleur(String couleur) {
		this.couleur = couleur;
	}

	public String getPuissance() {
		return puissance;
	}

	public void setPuissance(String puissance) {
		this.puissance = puissance;
	}

	public String getAnnee() {
		return annee;
	}

	public void setAnnee(String annee) {
		this.annee = annee;
	}

	public int getIdMarque() {
		return idMarque;
	}

	public void setIdMarque(int idMarque) {
		this.idMarque = idMarque;
	}
}
