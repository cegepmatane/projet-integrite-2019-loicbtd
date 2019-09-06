package action;

import java.util.List;

import donnee.MarqueDAO;
import donnee.VoitureDAO;
import modele.Marque;
import modele.Voiture;
import vue.NavigateurDesVues;
import vue.VueEditerMarque;
import vue.VueListeMarque;
import vue.VueMarque;

public class ControleurMarque {

	private static ControleurMarque instance;

	private MarqueDAO accesseurMarque;
	private VoitureDAO accesseurVoiture;

	private NavigateurDesVues navigateur;
	private VueListeMarque vueListeMarque;
	private VueMarque vueMarque;
	private VueEditerMarque vueEditerMarque;

	private int idMarque;

	public ControleurMarque() {
		this.accesseurMarque = new MarqueDAO();
		this.accesseurVoiture = new VoitureDAO();
		this.navigateur = NavigateurDesVues.getInstance();
		idMarque = 0;
	}

	public static ControleurMarque getInstance() {
		if(null == instance) instance = new ControleurMarque();
		return instance;
	}
	
	public void activerVues(NavigateurDesVues navigateur) {
		this.navigateur = navigateur;
		this.vueMarque = navigateur.getVueMarque();
		this.vueListeMarque = navigateur.getVueListeMarque();
		this.vueEditerMarque = navigateur.getVueEditerMarque();

		Marque marque = new Marque(
				"Ferrari",
				"jaune",
				"F1",
				"1800"
		);
		this.vueMarque.afficherMarque(marque);
		this.navigateur.naviguerVersVueMarque();

		List<Marque> listeMarquesTest = accesseurMarque.listerMarques();
		this.vueListeMarque.afficherListeMarque(listeMarquesTest);


		this.navigateur.naviguerVersVueListeMarque();
	}

	public void notifierEnregistrerNouvelleMarque() {
		Marque marque = this.navigateur.getVueAjouterMarque().demanderMarque();
		this.accesseurMarque.ajouterMarque(marque);
		this.vueListeMarque.afficherListeMarque(this.accesseurMarque.listerMarques()); // TODO optimiser
		this.navigateur.naviguerVersVueListeMarque();
	}

	public void notifierEnregistrerMarque() {
		Marque marque = this.navigateur.getVueEditerMarque().demanderMarque();
		this.accesseurMarque.modifierMarque(marque);
		this.vueListeMarque.afficherListeMarque(this.accesseurMarque.listerMarques()); // TODO optimiser
		this.navigateur.naviguerVersVueListeMarque();
	}

	public void notifierNaviguerAjouterMarque() {
		this.navigateur.naviguerVersVueAjouterMarque();
	}

	public void notifierNaviguerEditerMarque(int idMarque) {
		Marque marque = this.accesseurMarque.rapporterMarque(idMarque);
		this.vueEditerMarque.afficherMarque(marque);
		this.navigateur.naviguerVersVueEditerMarque();

		List<Voiture> listeVoitures = accesseurVoiture.listerVoituresParMarque(marque);
		this.vueEditerMarque.afficherListeVoiture(listeVoitures);
	}

	public void notifierNaviguerAjouterVoiture() {
		this.navigateur.naviguerVersVueAjouterVoiture();
	}

	public void notifierEnregistrerAjoutVoiture() {
		Voiture voiture = this.navigateur.getVueAjouterVoiture().demanderVoiture();

		VoitureDAO accesseurVoiture = new VoitureDAO();
		accesseurVoiture.ajouterVoiture(voiture);

		this.navigateur.naviguerVersVueEditerMarque();
	}
}
