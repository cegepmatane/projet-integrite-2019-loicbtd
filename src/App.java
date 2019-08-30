import donnee.MarqueDAO;
import donnee.VoitureDAO;
import modele.Marque;
import modele.Voiture;
import vue.NavigateurDesVues;

import java.util.List;

public class App {

	public static void main(String[] parametres) {

		MarqueDAO accesseurMarque = new MarqueDAO();
		List<Marque> listeMarque = accesseurMarque.listerMarques();
		for(Marque marque : listeMarque) {
			System.out.println(marque.getNom());
		}

		VoitureDAO accesseurVoiture = new VoitureDAO();
		List<Voiture> listeVoiture = accesseurVoiture.listerVoitures();
		for(Voiture voiture : listeVoiture) {
			System.out.println(voiture.getModele());
		}

		NavigateurDesVues.launch(NavigateurDesVues.class, parametres);
	}
}