package vue;
import action.ControleurMarque;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import modele.Marque;

public class VueMarque extends Scene{

	protected Label valeurNom;
	protected Label valeurCouleurLogo;
	protected Label valeurSlogan;
	protected Label valeurDateCreation;
	
	@SuppressWarnings("unused")
	private ControleurMarque controleur = null;
	
	public VueMarque() {
		super(new GridPane(),400,400);
		GridPane grillMarque = (GridPane) this.getRoot();

		// https://docs.oracle.com/javase/8/javafx/api/javafx/scene/layout/GridPane.html
		valeurNom = new Label("");
		grillMarque.add(new Label("Nom : "), 0, 0);
		grillMarque.add(valeurNom, 1, 0);
		
		valeurCouleurLogo = new Label("");
		grillMarque.add(new Label("Couleur du logo : "), 0, 1);
		grillMarque.add(valeurCouleurLogo, 1, 1);

		valeurSlogan = new Label("");
		grillMarque.add(new Label("Slogan : "), 0, 2);
		grillMarque.add(valeurSlogan, 1, 2);

		valeurDateCreation = new Label("");
		grillMarque.add(new Label("Date de création : "), 0, 3);
		grillMarque.add(valeurDateCreation, 1, 3);
	}
	
	public void afficherMarque(Marque marque)
	{
		this.valeurNom.setText(marque.getNom());
		this.valeurCouleurLogo.setText(marque.getCouleurLogo());
		this.valeurSlogan.setText(marque.getSlogan());
		this.valeurDateCreation.setText(marque.getDateCreation());
	}
	
	
	public void setControleur(ControleurMarque controleur) {
		this.controleur = controleur;
	}

}
