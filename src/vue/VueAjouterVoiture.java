package vue;

import action.ControleurMarque;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import modele.Marque;

import javafx.scene.control.TextField;
import modele.Voiture;

public class VueAjouterVoiture extends Scene {

    protected TextField valeurModele;
    protected TextField valeurCouleur;
    protected TextField valeurPuissance;
    protected TextField valeurAnnee;

    protected Button actionEnregistrerVoiture;

    private ControleurMarque controleurMarque;

    public VueAjouterVoiture()  {
        super(new VBox(), 400, 400);
        VBox panneau = (VBox) this.getRoot();
        GridPane grilleVoiture = new GridPane();
        this.actionEnregistrerVoiture = new Button("Enregistrer");

        this.actionEnregistrerVoiture.setOnAction(arg0 -> controleurMarque.notifierEnregistrerNouvelleVoiture());

        valeurModele = new TextField();
        grilleVoiture.add(new Label("Modèle : "), 0, 0);
        grilleVoiture.add(valeurModele, 1, 0);

        valeurCouleur = new TextField("");
        grilleVoiture.add(new Label("Couleur : "), 0, 1);
        grilleVoiture.add(valeurCouleur, 1, 1);

        valeurPuissance = new TextField("");
        grilleVoiture.add(new Label("Puissance : "), 0, 2);
        grilleVoiture.add(valeurPuissance, 1, 2);

        valeurAnnee = new TextField("");
        grilleVoiture.add(new Label("Annee : "), 0, 3);
        grilleVoiture.add(valeurAnnee, 1, 3);

        panneau.getChildren().add(new Label("Ajouter une marque")); // Todo : cr�er un sous-type de Label ou Text pour les titres
        panneau.getChildren().add(grilleVoiture);
        panneau.getChildren().add(this.actionEnregistrerVoiture);
    }

    public Voiture demanderVoiture() {
        Voiture voiture = new Voiture(
                this.valeurModele.getText(),
                this.valeurCouleur.getText(),
                this.valeurPuissance.getText(),
                this.valeurAnnee.getText()
        );
        return voiture;
    }

    public void setControleurMarque(ControleurMarque controleurMarque) {
        this.controleurMarque = controleurMarque;
    }
}
