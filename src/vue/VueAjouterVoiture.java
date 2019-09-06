package vue;

import action.ControleurMarque;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import modele.Voiture;

import javafx.scene.control.TextField;
import java.io.IOException;

public class VueAjouterVoiture extends Scene {

    private ControleurMarque controleurMarque;

    public VueAjouterVoiture() throws IOException {
        super(FXMLLoader.load(VueAjouterVoiture.class.getResource("ajouter-voiture.fxml")));
    }

    public void setControleurMarque(ControleurMarque controleurMarque) {
        this.controleurMarque = controleurMarque;
    }

    public Voiture demanderVoiture() {
        Voiture voiture = new Voiture();
        voiture.setModele(((TextField)this.lookup("#champ-modele")).getText());
        voiture.setCouleur(((TextField)this.lookup("#champ-couleur")).getText());
        voiture.setPuissance(((TextField)this.lookup("#champ-puissance")).getText());
        voiture.setAnnee(((TextField)this.lookup("#champ-annee")).getText());
        return voiture;
    }
}
