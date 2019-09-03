package donnee;

import modele.Marque;
import modele.Voiture;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class VoitureDAO implements VoitureSQL {
		
	private Connection connection = null;
	
	public VoitureDAO() {
		this.connection = BaseDeDonnees.getInstance().getConnection();
	}
	
	public List<Voiture> listerVoituresParMarque(Marque marque) {

		List<Voiture> listeVoitures =  new ArrayList<Voiture>();
		PreparedStatement requeteListeVoitures;
		try {
			requeteListeVoitures = connection.prepareStatement(VoitureSQL.SQL_LISTER_VOITURES_PAR_MARQUE);
			requeteListeVoitures.setInt(1, marque.getId());
			ResultSet curseurListeVoitures = requeteListeVoitures.executeQuery();

			while(curseurListeVoitures.next()) {
				int id = curseurListeVoitures.getInt("id");
				String modele = curseurListeVoitures.getString("modele");
				String couleur = curseurListeVoitures.getString("couleur");
				String puissance = curseurListeVoitures.getString("puissance");
				String annee = curseurListeVoitures.getString("annee");

				System.out.println(modele + couleur + " de " + annee + " avec une puissance de " + puissance + "ch ");
				Voiture voiture = new Voiture(modele, couleur, puissance, annee);
				voiture.setId(id);
				listeVoitures.add(voiture);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listeVoitures;
	}
	
	public void ajouterVoiture(Voiture voiture) {
		System.out.println("VoitureDAO.ajouterVoiture()");
		try {
			PreparedStatement requeteAjouterVoiture = connection.prepareStatement(SQL_AJOUTER_VOITURE);
			requeteAjouterVoiture.setString(1, voiture.getModele());
			requeteAjouterVoiture.setString(2, voiture.getCouleur());
			requeteAjouterVoiture.setString(3, voiture.getPuissance());
			requeteAjouterVoiture.setString(4, voiture.getAnnee());
			
			System.out.println("SQL : " + SQL_AJOUTER_VOITURE);
			requeteAjouterVoiture.execute();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void modifierVoiture(Voiture voiture)
	{
		System.out.println("VoitureDAO.modifierVoiture()");
		try {
			PreparedStatement requeteModifierVoiture = connection.prepareStatement(SQL_MODIFIER_VOITURE);
			requeteModifierVoiture.setString(1, voiture.getModele());
			requeteModifierVoiture.setString(2, voiture.getCouleur());
			requeteModifierVoiture.setString(3, voiture.getPuissance());
			requeteModifierVoiture.setString(4, voiture.getAnnee());
			requeteModifierVoiture.setInt(5, voiture.getId());
			
			System.out.println("SQL : " + SQL_MODIFIER_VOITURE);
			requeteModifierVoiture.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public Voiture rapporterVoiture(int idVoiture)
	{
		PreparedStatement requeteVoiture;
		try {
			requeteVoiture = connection.prepareStatement(SQL_RAPPORTER_VOITURE);
			requeteVoiture.setInt(1, idVoiture);
			System.out.println(SQL_RAPPORTER_VOITURE);
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
