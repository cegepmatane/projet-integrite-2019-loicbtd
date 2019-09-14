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

				int id = curseurListeVoitures.getInt(Voiture.CLE_ID_VOITURE);
				String modele = curseurListeVoitures.getString(Voiture.CLE_MODELE);
				String couleur = curseurListeVoitures.getString(Voiture.CLE_COULEUR);
				int puissance = Integer.valueOf(curseurListeVoitures.getString(Voiture.CLE_PUISSANCE));
				int annee = Integer.valueOf(curseurListeVoitures.getString(Voiture.CLE_ANNEE));
				int id_marque = curseurListeVoitures.getInt(Voiture.CLE_ID_MARQUE);

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
			requeteAjouterVoiture.setInt(3, voiture.getPuissance());
			requeteAjouterVoiture.setInt(4, voiture.getAnnee());
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

			int id = curseurVoiture.getInt(Voiture.CLE_ID_VOITURE);
			String modele = curseurVoiture.getString(Voiture.CLE_MODELE);
			String couleur = curseurVoiture.getString(Voiture.CLE_COULEUR);
			int puissance = curseurVoiture.getInt(Voiture.CLE_PUISSANCE);
			int annee = curseurVoiture.getInt(Voiture.CLE_ANNEE);

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
			requeteModifierVoiture.setInt(3, voiture.getPuissance());
			requeteModifierVoiture.setInt(4, voiture.getAnnee());
			requeteModifierVoiture.setInt(5, voiture.getId_voiture());

			System.out.println("SQL : " + SQL_MODIFIER_VOITURE);
			requeteModifierVoiture.execute();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
