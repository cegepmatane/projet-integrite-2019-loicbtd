package vue;
import action.ControleurVoiture;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import modele.Voiture;

public class VueVoiture extends Scene{

	protected Label valeurModele;
	protected Label valeurCouleur;
	protected Label valeurPuissance;
	protected Label valeurAnnee;
	
	@SuppressWarnings("unused")
	private ControleurVoiture controleur = null;
	
	public VueVoiture() {
		super(new GridPane(),400,400);
		GridPane grilleVoiture = (GridPane) this.getRoot();

		// https://docs.oracle.com/javase/8/javafx/api/javafx/scene/layout/GridPane.html
		valeurModele = new Label("");
		grilleVoiture.add(new Label("Modele : "), 0, 0);
		grilleVoiture.add(valeurModele, 1, 0);
		
		valeurCouleur = new Label("");
		grilleVoiture.add(new Label("Couleur : "), 0, 1);
		grilleVoiture.add(valeurCouleur, 1, 1);

		valeurPuissance = new Label("");
		grilleVoiture.add(new Label("Puissance : "), 0, 2);
		grilleVoiture.add(valeurPuissance, 1, 2);

		valeurAnnee = new Label("");
		grilleVoiture.add(new Label("Annee : "), 0, 3);
		grilleVoiture.add(valeurAnnee, 1, 3);
	}
	
	public void afficherMouton(Voiture voiture)
	{
		this.valeurModele.setText(voiture.getModele());
		this.valeurCouleur.setText(voiture.getCouleur());
		this.valeurPuissance.setText(voiture.getPuissance());
		this.valeurAnnee.setText(voiture.getAnnee());
	}
	
	
	public void setControleur(ControleurVoiture controleur) {
		this.controleur = controleur;
	}

}
