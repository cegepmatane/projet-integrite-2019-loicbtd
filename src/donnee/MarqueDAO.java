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
		
	private Connection connection;
	
	public MarqueDAO() {
		this.connection = BaseDeDonnees.getInstance().getConnection();		
	}

	public List<Marque> listerMarques() {

		List<Marque> listeMarques = new ArrayList<>();
		Statement requeteListeVoitures;
		try {
			requeteListeVoitures = this.connection.createStatement();
			ResultSet curseurListeMarques = requeteListeVoitures.executeQuery(MarqueSQL.SQL_LISTER_MARQUES);

			while(curseurListeMarques.next()) {

				int id = curseurListeMarques.getInt(Marque.CLE_ID_MARQUE);
				String nom = curseurListeMarques.getString(Marque.CLE_NOM);
				String couleur_logo = curseurListeMarques.getString(Marque.CLE_COULEUR_LOGO);
				String slogan = curseurListeMarques.getString(Marque.CLE_SLOGAN);
				int date_creation = curseurListeMarques.getInt(Marque.CLE_DATE_CREATION);

				Marque marque = new Marque(
						nom,
						couleur_logo,
						slogan,
						date_creation
				);
				marque.setId_marque(id);
				listeMarques.add(marque);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listeMarques;
	}
	
	public void ajouterMarque(Marque marque) {
		try {
			PreparedStatement requeteAjouterMarque = connection.prepareStatement(SQL_AJOUTER_MARQUE);

			requeteAjouterMarque.setString(1, marque.getNom());
			requeteAjouterMarque.setString(2, marque.getCouleur_logo());
			requeteAjouterMarque.setString(3, marque.getSlogan());
			requeteAjouterMarque.setInt(4, marque.getDate_creation());

			requeteAjouterMarque.execute();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void modifierMarque(Marque marque) {
		try {
			PreparedStatement requeteModifierMarque = connection.prepareStatement(SQL_MODIFIER_MARQUE);

			requeteModifierMarque.setString(1, marque.getNom());
			requeteModifierMarque.setString(2, marque.getCouleur_logo());
			requeteModifierMarque.setString(3, marque.getSlogan());
			requeteModifierMarque.setInt(4, marque.getDate_creation());
			requeteModifierMarque.setInt(5, marque.getId_marque());
			
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

			ResultSet curseurMarque = requeteMarque.executeQuery();
			curseurMarque.next();

			int id = curseurMarque.getInt(Marque.CLE_ID_MARQUE);
			String nom = curseurMarque.getString(Marque.CLE_NOM);
			String couleur_logo = curseurMarque.getString(Marque.CLE_COULEUR_LOGO);
			String slogan = curseurMarque.getString(Marque.CLE_SLOGAN);
			int date_creation = curseurMarque.getInt(Marque.CLE_DATE_CREATION);

			Marque marque = new Marque(
					nom,
					couleur_logo,
					slogan,
					date_creation
			);
			marque.setId_marque(id);
			return marque;

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
}