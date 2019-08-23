package donnee;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import modele.Voiture;

public class VoitureDAO implements VoitureSQL {
		
	private Connection connection = null;
	
	public VoitureDAO()
	{
		this.connection = BaseDeDonnees.getInstance().getConnection();		
	}
	
	@SuppressWarnings("unused")
	private List<Voiture> simulerListerVoitures()
	{
		List<Voiture> listeVoituresTest = new ArrayList<Voiture>();
		listeVoituresTest.add(new Voiture("Bugatti Veyron", "Gris", "1001 ch", "2011"));
		listeVoituresTest.add(new Voiture("Bugatti Chiron", "Bleu", "1500 ch", "2015"));
		listeVoituresTest.add(new Voiture("Bugatti Vino", "Noir", "1600 ch", "2019"));
		listeVoituresTest.add(new Voiture("Ferrari F450", "Jaune", "490 ch", "2015"));
		return listeVoituresTest;
	}	
	
	public List<Voiture> listerVoitures()
	{

		List<Voiture> listeVoitures =  new ArrayList<Voiture>();
		Statement requeteListeVoitures;
		try {
			requeteListeVoitures = connection.createStatement();
			ResultSet curseurListeVoitures = requeteListeVoitures.executeQuery(VoitureSQL.SQL_LISTER_VOITURES);
			while(curseurListeVoitures.next())
			{
				int id = curseurListeVoitures.getInt("id");
				String modele = curseurListeVoitures.getString("modele");
				String couleur = curseurListeVoitures.getString("couleur");
				String puissance = curseurListeVoitures.getString("puissance");
				String annee = curseurListeVoitures.getString("annee");
				System.out.println("Voiture " + modele + " de " + annee + " : " + puissance + "ch " + couleur);
				Voiture voiture = new Voiture(modele, couleur, puissance, annee);
				voiture.setId(id);
				listeVoitures.add(voiture);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
				
		//return this.simulerListerVoitures();
		return listeVoitures;
	}
	
	public void ajouterVoiture(Voiture voiture)
	{
		System.out.println("VoitureDAO.ajouterVoiture()");
		try {
			PreparedStatement requeteAjouterVoiture = connection.prepareStatement(SQL_AJOUTER_VOITURES);
			requeteAjouterVoiture.setString(1, voiture.getModele());
			requeteAjouterVoiture.setString(2, voiture.getCouleur());
			requeteAjouterVoiture.setString(3, voiture.getPuissance());
			requeteAjouterVoiture.setString(4, voiture.getAnnee());
			
			System.out.println("SQL : " + SQL_AJOUTER_VOITURES);
			requeteAjouterVoiture.execute();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void modifierVoiture(Voiture voiture)
	{
		System.out.println("VoitureDAO.modifierVoiture()");
		try {
			PreparedStatement requeteModifierVoiture = connection.prepareStatement(SQL_MODIFIER_VOITURES);
			requeteModifierVoiture.setString(1, voiture.getModele());
			requeteModifierVoiture.setString(2, voiture.getCouleur());
			requeteModifierVoiture.setString(3, voiture.getPuissance());
			requeteModifierVoiture.setString(4, voiture.getAnnee());
			requeteModifierVoiture.setInt(5, voiture.getId());
			
			System.out.println("SQL : " + SQL_MODIFIER_VOITURES);
			requeteModifierVoiture.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public Voiture rapporterVoiture(int idMouton)
	{
		PreparedStatement requeteVoiture;
		try {
			requeteVoiture = connection.prepareStatement(SQL_RAPPORTER_VOITURES);
			requeteVoiture.setInt(1, idMouton);
			System.out.println(SQL_RAPPORTER_VOITURES);
			ResultSet curseurVoiture = requeteVoiture.executeQuery();
			curseurVoiture.next();
			int id = curseurVoiture.getInt("id");
			String modele = curseurVoiture.getString("modele");
			String couleur = curseurVoiture.getString("couleur");
			String puissance = curseurVoiture.getString("puissance");
			String annee = curseurVoiture.getString("annee");
			System.out.println("Voiture " + modele + " de " + annee + " : " + puissance + "ch " + couleur);
			Voiture voiture = new Voiture(modele, couleur, puissance, annee);
			voiture.setId(id);
			return voiture;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
}
