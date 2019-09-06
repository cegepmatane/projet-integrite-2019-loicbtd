package donnee;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class BaseDeDonnees {

	private static BaseDeDonnees instance;

	private Connection connection;
	
	private BaseDeDonnees() {
		try {
			Class.forName(Acces.BASEDEDONNEES_DRIVER);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		try {
			connection = DriverManager.getConnection(
					Acces.BASEDEDONNEES_URL,
					Acces.BASEDEDONNEES_USAGER,
					Acces.BASEDEDONNEES_MOTDEPASSE
			);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static BaseDeDonnees getInstance() {
		if(null == instance) {
			instance = new BaseDeDonnees();
		}
		return instance;
	}

	public Connection getConnection() {
		return this.connection;
	}
	
}
