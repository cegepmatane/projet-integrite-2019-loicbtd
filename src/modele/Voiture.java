package modele;

public class Voiture {

	public static final String CLE_ID_VOITURE = "id_voiture";
	public static final String CLE_MODELE = "modele";
	public static final String CLE_COULEUR = "couleur";
	public static final String CLE_PUISSANCE = "puissance";
	public static final String CLE_ANNEE = "annee";
	public static final String CLE_ID_MARQUE = "id_marque";

	protected int id_voiture;
	protected String modele;
	protected String couleur;
	protected int puissance;
	protected int annee;
	protected int id_marque;

	public Voiture() {
	}

	public Voiture(String modele, String couleur, int puissance, int annee) {
		super();
		this.modele = modele;
		this.couleur = couleur;
		this.puissance = puissance;
		this.annee = annee;
	}

	public int getId_voiture() {
		return id_voiture;
	}
	public void setId_voiture(int id_voiture) {
		this.id_voiture = id_voiture;
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
	public int getPuissance() {
		return puissance;
	}
	public void setPuissance(int puissance) {
		this.puissance = puissance;
	}
	public int getAnnee() {
		return annee;
	}
	public void setAnnee(int annee) {
		this.annee = annee;
	}
	public int getId_marque() {
		return id_marque;
	}
	public void setId_marque(int id_marque) {
		this.id_marque = id_marque;
	}
}
