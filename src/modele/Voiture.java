package modele;

public class Voiture {

	protected int id_voiture;
	protected String modele;
	protected String couleur;
	protected String puissance;
	protected String annee;
	protected int id_marque;

	public Voiture() {
	}

	public Voiture(String modele, String couleur, String puissance, String annee) {
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
	public int getId_marque() {
		return id_marque;
	}
	public void setId_marque(int id_marque) {
		this.id_marque = id_marque;
	}
}
