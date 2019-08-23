package vue;
import java.util.List;

import action.ControleurVoiture;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import modele.Voiture;

public class VueListeVoiture extends Scene {

	protected GridPane grilleVoitures;
	
	private ControleurVoiture controleur = null;
	
	private Button actionNaviguerAjouterVoiture;
	public VueListeVoiture() {
		super(new GridPane(), 400,400);
		grilleVoitures = (GridPane) this.getRoot();
		this.actionNaviguerAjouterVoiture = new Button("Ajouter un voiture");
	}
	
	public void afficherListeVoiture(List<Voiture> listeVoitures)
	{
		this.grilleVoitures.getChildren().clear();
		
		int numero = 0;
		this.grilleVoitures.add(new Label("Modele"), 0, numero);
		this.grilleVoitures.add(new Label("Annee"), 1, numero);
		for(Voiture voiture : listeVoitures)
		{
			Button actionEditerVoiture = new Button("Editer");
			actionEditerVoiture.setOnAction(new EventHandler<ActionEvent>() {
				@Override
				public void handle(ActionEvent a) {
					controleur.notifierNaviguerEditerVoiture(voiture.getId()); // TODO ameliorer ceci pour respecter architecture cible = pas de parametre dans les notifications au controleur
				}});
			numero++;
			this.grilleVoitures.add(new Label(voiture.getModele()), 0, numero);
			this.grilleVoitures.add(new Label(voiture.getAnnee()), 1, numero);
			this.grilleVoitures.add(actionEditerVoiture, 2, numero);
		}
		
		this.actionNaviguerAjouterVoiture.setOnAction(new EventHandler<ActionEvent>()
		{
			@Override
			public void handle(ActionEvent arg0) {
				controleur.notifierNaviguerAjouterVoiture();
			}	
		});
		
		this.grilleVoitures.add(this.actionNaviguerAjouterVoiture, 1, ++numero);
	}

	public void setControleur(ControleurVoiture controleur) {
		this.controleur = controleur;
	}

}
