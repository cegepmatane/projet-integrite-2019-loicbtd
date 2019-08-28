package donnee;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import modele.Marque;

public class MarqueDAO implements MarqueSQL {
		
	private Connection connection = null;
	
	public MarqueDAO() {
		this.connection = BaseDeDonnees.getInstance().getConnection();		
	}
	
	@SuppressWarnings("unused")
	private List<Marque> simulerListerMarques() {
		List<Marque> listeMarquesTest = new ArrayList<Marque>();
		listeMarquesTest.add(new Marque("Bugatti", "noir, rouge", "slogan1", "1950"));
		listeMarquesTest.add(new Marque("Ferrari", "jaune, noir", "slogan3", "1980"));
		return listeMarquesTest;
	}	
	
	public List<Marque> listerMarques() {
		List<Marque> listeMarques =  new ArrayList<Marque>();
		Statement requeteListeVoitures;
		try {
			requeteListeVoitures = connection.createStatement();
			ResultSet curseurListeMarques = requeteListeVoitures.executeQuery(MarqueSQL.SQL_LISTER_MARQUES);
			while(curseurListeMarques.next()) {
				int id = curseurListeMarques.getInt("id");
				String nom = curseurListeMarques.getString("nom");
				String couleurLogo = curseurListeMarques.getString("couleur_logo");
				String slogan = curseurListeMarques.getString("slogan");
				String dateCreation = curseurListeMarques.getString("date_creation");
				System.out.println("Marque " + nom + " créée en " + dateCreation + " slogan: " + slogan + " couleur logo: " + couleurLogo);
				Marque marque = new Marque(nom, couleurLogo, slogan, dateCreation);
				marque.setId(id);
				listeMarques.add(marque);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
				
		//return this.simulerListerMarque();
		return listeMarques;
	}
	
	public void ajouterMarque(Marque marque) {
		System.out.println("MarqueDAO.ajouterMarque()");
		try {
			PreparedStatement requeteAjouterMarque = connection.prepareStatement(SQL_AJOUTER_MARQUES);
			requeteAjouterMarque.setString(1, marque.getNom());
			requeteAjouterMarque.setString(2, marque.getCouleurLogo());
			requeteAjouterMarque.setString(3, marque.getSlogan());
			requeteAjouterMarque.setString(4, marque.getDateCreation());
			
			System.out.println("SQL : " + SQL_AJOUTER_MARQUES);
			requeteAjouterMarque.execute();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void modifierMarque(Marque marque) {
		System.out.println("MarqueDAO.modifierMarque()");
		try {
			PreparedStatement requeteModifierMarque = connection.prepareStatement(SQL_MODIFIER_MARQUES);
			requeteModifierMarque.setString(1, marque.getNom());
			requeteModifierMarque.setString(2, marque.getCouleurLogo());
			requeteModifierMarque.setString(3, marque.getSlogan());
			requeteModifierMarque.setString(4, marque.getDateCreation());
			requeteModifierMarque.setInt(5, marque.getId());
			
			System.out.println("SQL : " + SQL_MODIFIER_MARQUES);
			requeteModifierMarque.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public Marque rapporterMarque(int idMouton) {
		PreparedStatement requeteMarque;
		try {
			requeteMarque = connection.prepareStatement(SQL_RAPPORTER_MARQUES);
			requeteMarque.setInt(1, idMouton);
			System.out.println(SQL_RAPPORTER_MARQUES);
			ResultSet curseurMarque = requeteMarque.executeQuery();
			curseurMarque.next();
			int id = curseurMarque.getInt("id");
			String nom = curseurMarque.getString("nom");
			String couleurLogo = curseurMarque.getString("couleur_logo");
			String slogan = curseurMarque.getString("slogan");
			String dateCreation = curseurMarque.getString("date_creation");
			System.out.println("Marque " + nom + " de " + dateCreation + " : " + slogan + "ch " + couleurLogo);
			Marque marque = new Marque(nom, couleurLogo, slogan, dateCreation);
			marque.setId(id);
			return marque;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
}