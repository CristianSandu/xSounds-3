package Model;

import java.sql.*;

/** 
 * Classe per la connessione al db
 */
public class MyConnection {
    private Connection con;
    
    public MyConnection(String url, String user, String pw) throws ClassNotFoundException {
        try {
            Connection con = DriverManager.getConnection(url, user, pw);
            this.con = con;
        }
        catch (SQLException e) {
            System.out.println("Problema durante l'accesso: " + e.getMessage());
        }
    }
    
    public Connection getConnection() {
        return this.con;
    }
}
