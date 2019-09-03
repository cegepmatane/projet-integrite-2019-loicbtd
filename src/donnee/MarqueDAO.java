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
		listeMarquesTest.add(new Marque("Ferrari", "jaune, noir", "slogan2", "1980"));
		listeMarquesTest.add(new Marque("Peugeot", "gris", "slogan3", "1980"));
		listeMarquesTest.add(new Marque("Renault", "gris", "slogan4", "1980"));
		return listeMarquesTest;
	}

	
	public List<Marque> listerMarques() {

		List<Marque> listeMarques =  new ArrayList<Marque>();
		Statement requeteListeVoitures;
		try {
			requeteListeVoitures = this.connection.createStatement();
			ResultSet curseurListeMarques = requeteListeVoitures.executeQuery(MarqueSQL.SQL_LISTER_MARQUES);

			while(curseurListeMarques.next()) {

				int id = curseurListeMarques.getInt("id");
				String nom = curseurListeMarques.getString("nom");
				String couleur_logo = curseurListeMarques.getString("couleur_logo");
				String slogan = curseurListeMarques.getString("slogan");
				String date_creation = curseurListeMarques.getString("date_creation");
				System.out.println("Marque " + nom + ", fondée en " + date_creation +", slogan: " + slogan);
				Marque marque = new Marque(nom, couleur_logo, slogan, date_creation);
				marque.setId(id);
				listeMarques.add(marque);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listeMarques;
	}
	
	public void ajouterMarque(Marque marque) {
		System.out.println("MarqueDAO.ajouterMarque()");
		try {
			PreparedStatement requeteAjouterMarque = connection.prepareStatement(SQL_AJOUTER_MARQUE);
			requeteAjouterMarque.setString(1, marque.getNom());
			requeteAjouterMarque.setString(2, marque.getCouleur_logo());
			requeteAjouterMarque.setString(3, marque.getSlogan());
			requeteAjouterMarque.setString(4, marque.getDate_creation());
			
			System.out.println("SQL : " + SQL_AJOUTER_MARQUE);
			requeteAjouterMarque.execute();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void modifierMarque(Marque marque) {
		System.out.println("MarqueDAO.modifierMarque()");
		try {
			PreparedStatement requeteModifierMarque = connection.prepareStatement(SQL_MODIFIER_MARQUE);
			requeteModifierMarque.setString(1, marque.getNom());
			requeteModifierMarque.setString(2, marque.getCouleur_logo());
			requeteModifierMarque.setString(3, marque.getSlogan());
			requeteModifierMarque.setString(4, marque.getDate_creation());
			requeteModifierMarque.setInt(5, marque.getId());
			
			System.out.println("SQL : " + SQL_MODIFIER_MARQUE);
			requeteModifierMarque.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public Marque rapporterMarque(int idMarque) {
		PreparedStatement requeteMarque;
		try {
			requeteMarque = connection.prepareStatement(SQL_RAPPORTER_MARQUE);
			requeteMarque.setInt(1, idMarque);
			System.out.println(SQL_RAPPORTER_MARQUE);
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