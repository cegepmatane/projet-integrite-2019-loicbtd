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
import modele.Voiture;

import java.util.List;

public class VueEditerMarque extends Scene {

	protected TextField valeurNom;
	protected TextField valeurCouleurLogo;
	protected TextField valeurSlogan;
	protected TextField valeurDateCreation;

	protected GridPane grilleVoitures;
	
	private ControleurMarque controleurMarque = null;

	protected Button actionEnregistrerMarque = null;
	protected Button actionNaviguerAjouterVoiture = null;
	
	private int idMarque = 0;
	
	public VueEditerMarque() {
		super(new VBox(), 400, 400);
		VBox panneau = (VBox) this.getRoot();
		GridPane grilleMarque = new GridPane();
				
		this.actionEnregistrerMarque = new Button("Enregistrer");
		this.actionNaviguerAjouterVoiture = new Button("Ajouter voiture");
		
		this.actionEnregistrerMarque.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent arg0) {
				controleurMarque.notifierEnregistrerMarque();
			}
		});
		
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

		grilleVoitures = new GridPane();
	
		// Todo : retirer les textes magiques
		panneau.getChildren().add(new Label("Editer une marque")); // Todo : cr�er un sous-type de Label ou Text pour les titres
		panneau.getChildren().add(grilleMarque);
		panneau.getChildren().add(this.actionEnregistrerMarque);
		panneau.getChildren().add(grilleVoitures);
	}
	
	public void afficherMarque(Marque marque) {
		this.idMarque = marque.getId();
		this.valeurNom.setText(marque.getNom());
		this.valeurCouleurLogo.setText(marque.getCouleur_logo());
		this.valeurSlogan.setText(marque.getSlogan());
		this.valeurDateCreation.setText(marque.getDate_creation());
	}
		
	public Marque demanderMarque() {
		Marque marque = new Marque(this.valeurNom.getText(),
								this.valeurCouleurLogo.getText(),
								this.valeurSlogan.getText(),
								this.valeurDateCreation.getText());
		marque.setId(idMarque);
		return marque;
	}
	
	public void setControleurMarque(ControleurMarque controleurMarque) {
		this.controleurMarque = controleurMarque;
	}

	public void afficherListeVoiture(List<Voiture> listeVoitures) {
		this.grilleVoitures.getChildren().clear();
		this.grilleVoitures.add(new Label("Liste des voitures"), 0, 0);
		int numero = 1;
		this.grilleVoitures.add(new Label("modele"), 0, numero);
		this.grilleVoitures.add(new Label("couleur"), 1, numero);

		for (Voiture voiture : listeVoitures) {

			Button actionEditerVoiture = new Button("Modifier");
			actionEditerVoiture.setOnAction(new EventHandler<ActionEvent>() {
				@Override
				public void handle(ActionEvent a) {
//					controleurVoiture.notifierNaviguerEditerVoiture(voiture.getId()); // TODO ameliorer ceci pour respecter architecture cible = pas de parametre dans les notifications au controleurMarque
				}
			});
			numero++;
			this.grilleVoitures.add(new Label(voiture.getModele()), 0, numero);
			this.grilleVoitures.add(new Label(voiture.getCouleur()), 1, numero);
			this.grilleVoitures.add(actionEditerVoiture, 2, numero);
		}

//		this.actionNaviguerAjouterVoiture.setOnAction(new EventHandler<ActionEvent>() {
//			@Override
//			public void handle(ActionEvent arg0) {
//				controleurMarque.notifierNaviguerAjouterMarque();
//			}
//		});

		this.grilleVoitures.add(this.actionNaviguerAjouterVoiture, 0, ++numero);
	}
}
