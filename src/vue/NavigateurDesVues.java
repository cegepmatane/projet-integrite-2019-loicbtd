package vue;

import action.ControleurVoiture;
import javafx.application.Application;
import javafx.stage.Stage;

public class NavigateurDesVues extends Application{
	
	private Stage stade;
	
	private VueListeVoiture vueListeVoiture = null;
	private VueVoiture vueVoiture = null;
	private VueAjouterVoiture vueAjouterVoiture = null;
	private VueEditerVoiture vueEditerVoiture = null;
	
	private ControleurVoiture controleur = null;
	
	public NavigateurDesVues() 
	{		
		this.vueListeVoiture = new VueListeVoiture();
		this.vueVoiture = new VueVoiture();
		this.vueAjouterVoiture = new VueAjouterVoiture();
		this.vueEditerVoiture = new VueEditerVoiture();
	}

	@Override
	public void start(Stage stade) throws Exception {
		this.stade = stade;
		
		this.stade.setScene(null);
		this.stade.show();
	
		this.controleur = ControleurVoiture.getInstance();
		this.controleur.activerVues(this);
		this.vueListeVoiture.setControleur(controleur);
		this.vueVoiture.setControleur(controleur);
		this.vueAjouterVoiture.setControleur(controleur);
		this.vueEditerVoiture.setControleur(controleur);
	}	
	
	public VueListeVoiture getVueListeVoiture() {
		return vueListeVoiture;
	}

	public VueVoiture getVueVoiture() {
		return vueVoiture;
	}
	
	public VueAjouterVoiture getVueAjouterVoiture() {
		return vueAjouterVoiture;
	}

	public VueEditerVoiture getVueEditerVoiture(){
		return this.vueEditerVoiture;
	}
	
	public void naviguerVersVueVoiture() {
		stade.setScene(this.vueVoiture);
		stade.show();
	}
	
	public void naviguerVersVueListeVoiture()
	{
		stade.setScene(this.vueListeVoiture);
		stade.show();		
	}
	
	public void naviguerVersVueAjouterVoiture()
	{
		stade.setScene(this.vueAjouterVoiture);
		stade.show();				
	}

	public void naviguerVersVueEditerVoiture()
	{
		stade.setScene(this.vueEditerVoiture);
		stade.show();				
	}
	
}
