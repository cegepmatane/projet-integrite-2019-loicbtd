package vue;

import action.ControleurMarque;
import javafx.application.Application;
import javafx.stage.Stage;

public class NavigateurDesVues extends Application{
	
	private Stage stade;
	
	private VueListeMarque vueListeMarque = null;
	private VueMarque vueMarque = null;
	private VueAjouterMarque vueAjouterMarque = null;
	private VueEditerMarque vueEditerMarque = null;
	
	private ControleurMarque controleur = null;
	
	public NavigateurDesVues() 
	{		
		this.vueListeMarque = new VueListeMarque();
		this.vueMarque = new VueMarque();
		this.vueAjouterMarque = new VueAjouterMarque();
		this.vueEditerMarque = new VueEditerMarque();
	}

	@Override
	public void start(Stage stade) throws Exception {
		this.stade = stade;
		
		this.stade.setScene(null);
		this.stade.show();
	
		this.controleur = ControleurMarque.getInstance();
		this.controleur.activerVues(this);
		this.vueListeMarque.setControleur(controleur);
		this.vueMarque.setControleur(controleur);
		this.vueAjouterMarque.setControleur(controleur);
		this.vueEditerMarque.setControleur(controleur);
	}	
	
	public VueListeMarque getVueListeMarque() {
		return vueListeMarque;
	}

	public VueMarque getVueMarque() {
		return vueMarque;
	}
	
	public VueAjouterMarque getVueAjouterMarque() {
		return vueAjouterMarque;
	}

	public VueEditerMarque getVueEditerMarque(){
		return this.vueEditerMarque;
	}
	
	public void naviguerVersVueMarque() {
		stade.setScene(this.vueMarque);
		stade.show();
	}
	
	public void naviguerVersVueListeMarque()
	{
		stade.setScene(this.vueListeMarque);
		stade.show();		
	}
	
	public void naviguerVersVueAjouterMarque()
	{
		stade.setScene(this.vueAjouterMarque);
		stade.show();				
	}

	public void naviguerVersVueEditerMarque()
	{
		stade.setScene(this.vueEditerMarque);
		stade.show();				
	}
	
}
