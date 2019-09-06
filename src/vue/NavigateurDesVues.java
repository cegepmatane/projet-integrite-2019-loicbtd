package vue;

import action.ControleurMarque;
import javafx.application.Application;
import javafx.stage.Stage;

import java.io.IOException;

public class NavigateurDesVues extends Application{

	static private NavigateurDesVues instance;

	private Stage stade;
	
	private VueListeMarque vueListeMarque;
	private VueMarque vueMarque;
	private VueAjouterMarque vueAjouterMarque;
	private VueEditerMarque vueEditerMarque;
	private VueAjouterVoiture vueAjouterVoiture;
	
	private ControleurMarque controleur = null;
	
	public NavigateurDesVues() {
		NavigateurDesVues.instance = this;
		this.vueListeMarque = new VueListeMarque();
		this.vueMarque = new VueMarque();
		this.vueAjouterMarque = new VueAjouterMarque();
		this.vueEditerMarque = new VueEditerMarque();
		this.vueAjouterVoiture = new VueAjouterVoiture();
	}

	public static NavigateurDesVues getInstance() {
		return instance;
	}

	@Override
	public void start(Stage stade) {
		this.stade = stade;

		this.stade.setScene(null);
		this.stade.show();

		this.controleur = ControleurMarque.getInstance();
		this.controleur.activerVues(this);
		this.vueListeMarque.setControleur(controleur);
		this.vueMarque.setControleurMarque(controleur);
		this.vueAjouterMarque.setControleurMarque(controleur);
		this.vueEditerMarque.setControleurMarque(controleur);
		this.vueAjouterVoiture.setControleurMarque(controleur);
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
	public VueAjouterVoiture getVueAjouterVoiture() {
		return vueAjouterVoiture;
	}
	
	public void naviguerVersVueMarque() {
		stade.setScene(this.vueMarque);
		stade.show();
	}
	
	public void naviguerVersVueListeMarque() {
		stade.setScene(this.vueListeMarque);
		stade.show();		
	}
	
	public void naviguerVersVueAjouterMarque() {
		stade.setScene(this.vueAjouterMarque);
		stade.show();				
	}

	public void naviguerVersVueEditerMarque() {
		stade.setScene(this.vueEditerMarque);
		stade.show();				
	}

	public void naviguerVersVueAjouterVoiture() {
		stade.setScene(this.vueAjouterVoiture);
		stade.show();
	}
}
