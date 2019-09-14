package vue;
import action.ControleurMarque;
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

	protected Button actionEnregistrerMarque;

	private ControleurMarque controleurMarque;

	public VueAjouterMarque()  {
		super(new VBox(), 400, 400);
		VBox panneau = (VBox) this.getRoot();
		GridPane grilleMarque = new GridPane();
		this.actionEnregistrerMarque = new Button("Enregistrer");
		
		this.actionEnregistrerMarque.setOnAction(arg0 -> controleurMarque.notifierEnregistrerNouvelleMarque());
		
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
			
		panneau.getChildren().add(new Label("Ajouter une marque")); // Todo : cr�er un sous-type de Label ou Text pour les titres
		panneau.getChildren().add(grilleMarque);
		panneau.getChildren().add(this.actionEnregistrerMarque);
	}
	
	public Marque demanderMarque() {
		Marque marque = new Marque(
				this.valeurNom.getText(),
				this.valeurCouleurLogo.getText(),
				this.valeurSlogan.getText(),
				Integer.valueOf(this.valeurDateCreation.getText())
		);
		return marque;
	}
	
	public void setControleurMarque(ControleurMarque controleurMarque) {
		this.controleurMarque = controleurMarque;
	}
}
