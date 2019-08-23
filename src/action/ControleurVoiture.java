package action;

import java.util.List;

import donnee.VoitureDAO;
import modele.Voiture;
import vue.NavigateurDesVues;
import vue.VueEditerVoiture;
import vue.VueListeVoiture;
import vue.VueVoiture;

public class ControleurVoiture {
	
	private NavigateurDesVues navigateur;
	private VueListeVoiture vueListeVoiture = null;
	private VueVoiture vueVoiture = null;
	//private VueAjouterVoiture vueAjouterVoiture = null;
	private VueEditerVoiture vueEditerVoiture = null;
	private VoitureDAO voitureDAO = null;
	
	private ControleurVoiture()
	{
		System.out.println("Initialisation du controleur");	
		this.voitureDAO = new VoitureDAO();
	}
	
	public void activerVues(NavigateurDesVues navigateur)
	{
		this.navigateur = navigateur;
		//this.vueAjouterVoiture = navigateur.getVueAjouterVoiture();
		this.vueVoiture = navigateur.getVueVoiture();
		this.vueListeVoiture = navigateur.getVueListeVoiture();
		this.vueEditerVoiture = navigateur.getVueEditerVoiture();
						
		//// TEST ////
		Voiture voiture = new Voiture("Dolly", "Grise", "20 kg", "5 juin 2015");
		this.vueVoiture.afficherMouton(voiture); // Appel de ma fonction avant de la programmer (pour tester � mesure)
		
		this.navigateur.naviguerVersVueVoiture();
		
		/// TEST ///
		List<Voiture> listeVoituresTest = voitureDAO.listerVoitures();
		this.vueListeVoiture.afficherListeVoiture(listeVoituresTest); // Appel de ma fonction avant de la programmer (pour tester � mesure)
		
		this.navigateur.naviguerVersVueListeVoiture();
				
		//this.navigateur.naviguerVersVueAjouterVoiture();
		
		//this.vueEditerVoiture.afficherListeDistinction(this.distinctionDAO.listerDistinctions());
		
	}
	
	// SINGLETON DEBUT
	private static ControleurVoiture instance = null;
	public static ControleurVoiture getInstance()
	{
		if(null == instance) instance = new ControleurVoiture();
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
	
	public void notifierEnregistrerNouvelleVoiture()
	{
		System.out.println("ControleurVoiture.notifierEnregistrerNouvelleVoiture()");
		Voiture voiture = this.navigateur.getVueAjouterVoiture().demanderVoiture();
		this.voitureDAO.ajouterVoiture(voiture);
		this.vueListeVoiture.afficherListeVoiture(this.voitureDAO.listerVoitures()); // TODO optimiser
		this.navigateur.naviguerVersVueListeVoiture();
	}
	
	public void notifierEnregistrerVoiture()
	{
		System.out.println("ControleurVoiture.notifierEnregistrerVoiture()");
		Voiture voiture = this.navigateur.getVueEditerVoiture().demanderVoiture();
		this.voitureDAO.modifierVoiture(voiture);
		this.vueListeVoiture.afficherListeVoiture(this.voitureDAO.listerVoitures()); // TODO optimiser
		this.navigateur.naviguerVersVueListeVoiture();
	}
	
	public void notifierNaviguerAjouterVoiture()
	{
		System.out.println("ControleurVoiture.notifierNaviguerAjouterVoiture()");
		this.navigateur.naviguerVersVueAjouterVoiture();
	}
	
	public void notifierNaviguerEditerVoiture(int idVoiture)
	{
		System.out.println("ControleurVoiture.notifierEditerVoiture("+idVoiture+")");
		// savoir par la vue liste quel numero de voiture a ete clique
		this.vueEditerVoiture.afficherVoiture(this.voitureDAO.rapporterVoiture(idVoiture));
		this.navigateur.naviguerVersVueEditerVoiture();
		
	}
	
	
}
