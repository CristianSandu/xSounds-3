package Model;

import java.sql.*;

/**
 * Classe per l'interazione con il database
 * Usiamo l'API JDBC 
 */
public class DBHelper {
    // Dati per la connessione
    private static final String url  = "jdbc:postgresql://localhost:5432/db_xsounds";
    private static final String user = "xsounds";
    private static final String pw   = "xsounds";
    
    // La connessione
    public static Connection con = null;
    
    // Inizializza la connessione al database
    public static void inizializza() throws ClassNotFoundException {
        MyConnection mycon = new MyConnection(url, user, pw);
        con = mycon.getConnection();
    }
    
    // Chiude la connessione committando
    public static void chiudi() {
        try {
            con.commit();
            con.close();
        }
        catch (SQLException e) {
            // pass
        }
    }
    
}
