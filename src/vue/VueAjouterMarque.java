package vue;
import action.ControleurMarque;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import modele.Marque;

public class VueAjouterMarque extends Scene {

	protected TextField valeurNom;
	protected TextField valeurCouleurLogo;
	protected TextField valeurSlogan;
	protected TextField valeurDateCreation;
	
	private ControleurMarque controleur = null;
	protected Button actionEnregistrerMarque = null;
	
	public VueAjouterMarque()  {
		super(new VBox(), 400, 400);
		VBox panneau = (VBox) this.getRoot();
		GridPane grilleMarque = new GridPane();
		this.actionEnregistrerMarque = new Button("Enregistrer");
		
		this.actionEnregistrerMarque.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent arg0) {
				
				controleur.notifierEnregistrerNouvelleMarque();
				
			}});
		
		// https://docs.oracle.com/javase/8/javafx/api/javafx/scene/layout/GridPane.html
		valeurNom = new TextField();
		grilleMarque.add(new Label("Nom : "), 0, 0);
		grilleMarque.add(valeurNom, 1, 0);
		
		valeurCouleurLogo = new TextField("");
		grilleMarque.add(new Label("Couleur logo : "), 0, 1);
		grilleMarque.add(valeurCouleurLogo, 1, 1);

		valeurSlogan = new TextField("");
		grilleMarque.add(new Label("Slogan : "), 0, 2);
		grilleMarque.add(valeurSlogan, 1, 2);

		valeurDateCreation = new TextField("");
		grilleMarque.add(new Label("Date de création : "), 0, 3);
		grilleMarque.add(valeurDateCreation, 1, 3);
			
		// Todo : retirer les textes magiques
		panneau.getChildren().add(new Label("Ajouter une marque")); // Todo : cr�er un sous-type de Label ou Text pour les titres
		panneau.getChildren().add(grilleMarque);
		panneau.getChildren().add(this.actionEnregistrerMarque);
	}
	
	public Marque demanderMarque()
	{
		Marque marque = new Marque(this.valeurNom.getText(),
								this.valeurCouleurLogo.getText(),
								this.valeurSlogan.getText(),
								this.valeurDateCreation.getText());
		return marque;
	}
	
	public void setControleur(ControleurMarque controleur) {
		this.controleur = controleur;
	}
	

}
