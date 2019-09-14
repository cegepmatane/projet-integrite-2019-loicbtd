package vue;

import action.ControleurMarque;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import modele.Marque;
import modele.Voiture;

import java.util.List;

public class VueEditerMarque extends Scene {

	protected GridPane grilleVoitures;

	protected TextField valeurNom;
	protected TextField valeurCouleurLogo;
	protected TextField valeurSlogan;
	protected TextField valeurDateCreation;

	protected Button actionEnregistrerMarque;
	protected Button actionNaviguerAjouterVoiture;

	private ControleurMarque controleurMarque;

	private int idMarque = 0;

	public VueEditerMarque() {
		super(new VBox(), 400, 400);

		VBox panneau = (VBox)this.getRoot();
		GridPane grilleMarque = new GridPane();

		this.grilleVoitures = new GridPane();

		this.actionEnregistrerMarque = new Button("Enregistrer");
		this.actionEnregistrerMarque.setOnAction(arg0 -> controleurMarque.notifierEnregistrerMarque());

		this.actionNaviguerAjouterVoiture = new Button("Ajouter une voiture");
		this.actionNaviguerAjouterVoiture.setOnAction(arg0 -> controleurMarque.notifierNaviguerAjouterVoiture());
		
		valeurNom = new TextField();
		grilleMarque.add(new Label("Nom : "), 0, 0);
		grilleMarque.add(valeurNom, 1, 0);
		
		valeurCouleurLogo = new TextField("");
		grilleMarque.add(new Label("Couleur du logo : "), 0, 1);
		grilleMarque.add(valeurCouleurLogo, 1, 1);

		valeurSlogan = new TextField("");
		grilleMarque.add(new Label("Slogan : "), 0, 2);
		grilleMarque.add(valeurSlogan, 1, 2);

		valeurDateCreation = new TextField("");
		grilleMarque.add(new Label("Date de création : "), 0, 3);
		grilleMarque.add(valeurDateCreation, 1, 3);

		// Todo : retirer les textes magiques
		panneau.getChildren().add(new Label("Editer une marque")); // Todo : cr�er un sous-type de Label ou Text pour les titres
		panneau.getChildren().add(grilleMarque);
		panneau.getChildren().add(this.actionEnregistrerMarque);
		panneau.getChildren().add(this.actionNaviguerAjouterVoiture);
		panneau.getChildren().add(grilleVoitures);
	}

	public void setControleurMarque(ControleurMarque controleurMarque) {
		this.controleurMarque = controleurMarque;
	}

	public void afficherMarque(Marque marque) {
		this.idMarque = marque.getId_marque();
		this.valeurNom.setText(marque.getNom());
		this.valeurCouleurLogo.setText(marque.getCouleur_logo());
		this.valeurSlogan.setText(marque.getSlogan());
		this.valeurDateCreation.setText(marque.getDate_creation());
	}
		
	public Marque demanderMarque() {
		Marque marque = new Marque(
				this.valeurNom.getText(),
				this.valeurCouleurLogo.getText(),
				this.valeurSlogan.getText(),
				this.valeurDateCreation.getText()
		);
		marque.setId_marque(idMarque);
		return marque;
	}
	

	public void afficherListeVoiture(List<Voiture> listeVoitures) {

		this.grilleVoitures.getChildren().clear();
		int rangee = 0;
		for(Voiture voiture : listeVoitures) {
			this.grilleVoitures.add(new Label(voiture.getModele()), 0, rangee);
			this.grilleVoitures.add(new Label(voiture.getCouleur()), 1, rangee);
			this.grilleVoitures.add(new Label(voiture.getAnnee()), 2, rangee);

			Button actionEditerVoiture = new Button("Editer");
			actionEditerVoiture.setOnAction(
					arg0 -> controleurMarque.notifierNaviguerEditerVoiture(voiture.getId_voiture()));
			this.grilleVoitures.add(actionEditerVoiture, 2, rangee);
			rangee++;
		}
	}
}
