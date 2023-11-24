package metodos;


import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBManager {

	private static final String DB_DRIVER = "org.h2.Driver";
	private static final String DB_BASE_URL = "C:\\Julian\\Eclipse\\Turnera_VTVDe1\\lib";
	private static final String DB_NAME = "VTV";
	private static final String DB_USERNAME = "sa";
	private static final String DB_PASSWORD = "";

	public static Connection connect() {
	    Connection c = null;
	    try {
	        Class.forName(DB_DRIVER);
	    } catch (ClassNotFoundException e) {
	        e.printStackTrace();
	        System.exit(0);
	    }
	    try { 
	        String url = "jdbc:h2:" + DB_BASE_URL + "/" + DB_NAME;
	        System.out.println("Ubicación de la base de datos en la URL de conexión: " + url);
	        c = DriverManager.getConnection(url, DB_USERNAME, DB_PASSWORD);
	        c.setAutoCommit(false);
	    } catch (SQLException e) {
	        e.printStackTrace();
	        System.exit(0);
	    }

	    return c;
	}

	public static String obtenerUbicacionBase() {
	    String url = "jdbc:h2:tcp://localhost/" + DB_BASE_URL;
	    System.out.println("Ubicación de la base de datos en la URL de conexión: " + url);
	    return url;
	}

}
