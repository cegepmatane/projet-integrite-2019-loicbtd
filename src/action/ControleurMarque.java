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
	
	private NavigateurDesVues navigateur;
	private VueListeMarque vueListeMarque = null;
	private VueMarque vueMarque = null;
	private VueEditerMarque vueEditerMarque = null;
	private MarqueDAO marqueDAO = null;
	private VoitureDAO voitureDAO = null;
	
	private ControleurMarque() {
		System.out.println("Initialisation du controleur");	
		this.marqueDAO = new MarqueDAO();
		this.voitureDAO = new VoitureDAO();
	}
	
	public void activerVues(NavigateurDesVues navigateur) {
		this.navigateur = navigateur;
		this.vueMarque = navigateur.getVueMarque();
		this.vueListeMarque = navigateur.getVueListeMarque();
		this.vueEditerMarque = navigateur.getVueEditerMarque();

		//// TEST ////
//		Marque marque = new Marque("Bugatti", "noir, rouge", "Rien n'est trop beau, rien n'est trop cher", "1909");
//		this.vueMarque.afficherMarque(marque); // Appel de ma fonction avant de la programmer (pour tester � mesure)
//
//		this.navigateur.naviguerVersVueMarque();

		/// TEST ///
		List<Marque> listeMarqueTest = marqueDAO.listerMarques();
		this.vueListeMarque.afficherListeMarque(listeMarqueTest); // Appel de ma fonction avant de la programmer (pour tester � mesure)

		this.navigateur.naviguerVersVueListeMarque();

//		this.navigateur.naviguerVersVueAjouterMarque();
//
//		this.vueEditerMarque.afficherListeDistinction(this.distinctionDAO.listerDistinctions());

	}
	
	// SINGLETON DEBUT
	private static ControleurMarque instance = null;
	public static ControleurMarque getInstance()
	{
		if(null == instance) instance = new ControleurMarque();
		return instance;
	}
	// SINGLETON FINI

	
	
	
	
	
	
	//**********************************************************//
	//                                                          //
	//                   NOTIFICATIONS                          //
	//                                                          //
	//**********************************************************//
	
	// Les notifications peuvent �tre g�r�es par callback comme ici ou par �v�nement,
	// Mais dans les deux cas les op�rations sont divis�es dans des fonctions comme ici
	// Pas de code dans un switch - case
	
	public void notifierEnregistrerNouvelleMarque() {
		System.out.println("ControleurMarque.notifierEnregistrerNouvelleMarque()");
		Marque marque = this.navigateur.getVueAjouterMarque().demanderMarque();
		this.marqueDAO.ajouterMarque(marque);
		this.vueListeMarque.afficherListeMarque(this.marqueDAO.listerMarques()); // TODO optimiser
		this.navigateur.naviguerVersVueListeMarque();
	}

	public void notifierEnregistrerMarque() {
		System.out.println("ControleurMarque.notifierEnregistrerMarque()");
		Marque marque = this.navigateur.getVueEditerMarque().demanderMarque();
		this.marqueDAO.modifierMarque(marque);
		this.vueListeMarque.afficherListeMarque(this.marqueDAO.listerMarques()); // TODO optimiser
		this.navigateur.naviguerVersVueListeMarque();
	}

	public void notifierNaviguerAjouterMarque() {
		System.out.println("ControleurMarque.notifierNaviguerAjouterMarque()");
		this.navigateur.naviguerVersVueAjouterMarque();
	}

	public void notifierNaviguerEditerMarque(int idMarque) {

		System.out.println("ControleurMarque.notifierEditerMarque("+idMarque+")");
		// savoir par la vue liste quel numero de marque a ete clique
		Marque marque = this.marqueDAO.rapporterMarque(idMarque);
		this.vueEditerMarque.afficherMarque(marque);
		this.navigateur.naviguerVersVueEditerMarque();

		List<Voiture> listeVoitures = voitureDAO.listerVoituresParMarque(marque);
		this.vueEditerMarque.afficherListeVoiture(listeVoitures);
	}
}
