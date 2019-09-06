package vue;

import action.ControleurMarque;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import modele.Voiture;


public class VueEditerVoiture extends Scene {

    protected GridPane grilleVoitures;

    protected TextField valeurModele;
    protected TextField valeurCouleur;
    protected TextField valeurPuissance;
    protected TextField valeurAnnee;

    protected Button actionEnregistrerVoiture;

    private ControleurMarque controleurMarque;

    private int idVoiture = 0;

    public VueEditerVoiture() {
        super(new VBox(), 400, 400);

        VBox panneau = (VBox)this.getRoot();
        GridPane grilleVoiture = new GridPane();

        this.grilleVoitures = new GridPane();

        this.actionEnregistrerVoiture = new Button("Enregistrer");
        this.actionEnregistrerVoiture.setOnAction(arg0 -> controleurMarque.notifierEnregistrerVoiture());

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

        // Todo : retirer les textes magiques
        panneau.getChildren().add(grilleVoiture);
        panneau.getChildren().add(this.actionEnregistrerVoiture);
    }

    public void setControleurMarque(ControleurMarque controleurMarque) {
        this.controleurMarque = controleurMarque;
    }

    public void afficherVoiture(Voiture voiture) {
        this.idVoiture = voiture.getId();
        this.valeurModele.setText(voiture.getModele());
        this.valeurCouleur.setText(voiture.getCouleur());
        this.valeurPuissance.setText(voiture.getPuissance());
        this.valeurAnnee.setText(voiture.getAnnee());
    }

    public Voiture demanderVoiture() {
        Voiture voiture = new Voiture(
                this.valeurModele.getText(),
                this.valeurCouleur.getText(),
                this.valeurPuissance.getText(),
                this.valeurAnnee.getText()
        );
        voiture.setId(idVoiture);
        return voiture;
    }
}

