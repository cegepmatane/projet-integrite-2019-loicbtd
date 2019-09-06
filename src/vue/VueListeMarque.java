package vue;
import java.util.List;

import action.ControleurMarque;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import modele.Marque;

public class VueListeMarque extends Scene {

	private ControleurMarque controleur;

	private GridPane grilleMarques;

	private Button actionNaviguerAjouterMarque;

	public VueListeMarque() {
		super(new GridPane(), 400,400);
		grilleMarques = (GridPane) this.getRoot();
		this.actionNaviguerAjouterMarque = new Button("Ajouter une marque");
	}

	public void afficherListeMarque(List<Marque> listeMarques) {
		this.grilleMarques.getChildren().clear();

		int numero = 0;
		this.grilleMarques.add(new Label("Nom"), 0, numero);
		this.grilleMarques.add(new Label("Date de création"), 1, numero);

		for (Marque marque : listeMarques) {

			Button actionEditeMarque = new Button("Editer");
			// TODO ameliorer ceci pour respecter architecture cible = pas de parametre dans les notifications au controleur
			actionEditeMarque.setOnAction(arg0 -> controleur.notifierNaviguerEditerMarque(marque.getId()));
			numero++;
			this.grilleMarques.add(new Label(marque.getNom()), 0, numero);
			this.grilleMarques.add(new Label(marque.getDate_creation()), 1, numero);
			this.grilleMarques.add(actionEditeMarque, 2, numero);
		}

		this.actionNaviguerAjouterMarque.setOnAction(arg0 -> controleur.notifierNaviguerAjouterMarque());

		this.grilleMarques.add(this.actionNaviguerAjouterMarque, 1, ++numero);
	}

	public void setControleur(ControleurMarque controleur) {
		this.controleur = controleur;
	}
}
