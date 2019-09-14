package donnee;

import modele.Marque;
import modele.Voiture;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class VoitureDAO implements VoitureSQL {
		
	private Connection connection;
	
	public VoitureDAO() {
		this.connection = BaseDeDonnees.getInstance().getConnection();
	}
	
	public List<Voiture> listerVoituresParMarque(Marque marque) {

		List<Voiture> listeVoitures = new ArrayList<>();
		PreparedStatement requeteListeVoitures;

		try {
			requeteListeVoitures = connection.prepareStatement(SQL_LISTER_VOITURES_PAR_MARQUE);
			requeteListeVoitures.setInt(1, marque.getId_marque());

			ResultSet curseurListeVoitures = requeteListeVoitures.executeQuery();

			while(curseurListeVoitures.next()) {
				Voiture voiture = new Voiture();

				int id = curseurListeVoitures.getInt("id_voiture");
				String modele = curseurListeVoitures.getString("modele");
				String couleur = curseurListeVoitures.getString("couleur");
				String puissance = curseurListeVoitures.getString("puissance");
				String annee = curseurListeVoitures.getString("annee");
				int id_marque = curseurListeVoitures.getInt("id_marque");

				voiture.setId_voiture(id);
				voiture.setModele(modele);
				voiture.setCouleur(couleur);
				voiture.setPuissance(puissance);
				voiture.setAnnee(annee);
				voiture.setId_marque(id_marque);

				listeVoitures.add(voiture);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listeVoitures;
	}
	
	public void ajouterVoiture(Voiture voiture) {
		try {
			PreparedStatement requeteAjouterVoiture = connection.prepareStatement(SQL_AJOUTER_VOITURE);

			requeteAjouterVoiture.setString(1, voiture.getModele());
			requeteAjouterVoiture.setString(2, voiture.getCouleur());
			requeteAjouterVoiture.setString(3, voiture.getPuissance());
			requeteAjouterVoiture.setString(4, voiture.getAnnee());
			requeteAjouterVoiture.setInt(5, voiture.getId_marque());

			requeteAjouterVoiture.execute();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public Voiture rapporterVoiture(int idVoiture) {
		PreparedStatement requeteMarque;
		try {
			requeteMarque = connection.prepareStatement(SQL_RAPPORTER_VOITURE);
			requeteMarque.setInt(1, idVoiture);

			ResultSet curseurVoiture = requeteMarque.executeQuery();
			curseurVoiture.next();

			int id = curseurVoiture.getInt("id_voiture");
			String modele = curseurVoiture.getString("modele");
			String couleur = curseurVoiture.getString("couleur");
			String puissance = curseurVoiture.getString("puissance");
			String annee = curseurVoiture.getString("annee");

			Voiture voiture = new Voiture(
					modele,
					couleur,
					puissance,
					annee
			);
			voiture.setId_voiture(id);
			return voiture;

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public void modifierVoiture(Voiture voiture) {
		try {
			PreparedStatement requeteModifierVoiture = connection.prepareStatement(SQL_MODIFIER_VOITURE);

			requeteModifierVoiture.setString(1, voiture.getModele());
			requeteModifierVoiture.setString(2, voiture.getCouleur());
			requeteModifierVoiture.setString(3, voiture.getPuissance());
			requeteModifierVoiture.setString(4, voiture.getAnnee());
			requeteModifierVoiture.setInt(5, voiture.getId_voiture());

			System.out.println("SQL : " + SQL_MODIFIER_VOITURE);
			requeteModifierVoiture.execute();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
