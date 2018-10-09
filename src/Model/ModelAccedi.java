package Model;

import java.sql.*;

public class ModelAccedi {
    // Query per determinare se esisono le credenziali inserite dall'utente
    public static String qCliente = "SELECT * FROM Cliente "
                                  + "WHERE (nome_utente = ?) AND (password = ?);";
    
    private static boolean accessoEffettuato = false;
    
    // Metodo per il login di un cliente: ritorna l'oggetto Cliente
    public static Cliente login(String usr, String pw) {
        try (PreparedStatement pst = DBHelper.con.prepareStatement(qCliente)){
            // Setto i parametri della query
            pst.setString(1, usr);
            pst.setString(2,  pw);
            
            // Eseguo la query
            ResultSet rs = pst.executeQuery();
            
            // Controllo il risultato: se è vuoto il login è fallito
            if (!rs.isBeforeFirst()) {
                return null;
            }
            else {
                rs.next();                   // Sposto il cursore sul cliente trovato
                accessoEffettuato = true;    // Qui modifico lo stato dell'utente
                return new Cliente(rs);      // Ritorno le informazioni di profilo
            }
            
        } catch (SQLException e) {
            // Ritorno null che significa accesso fallito
            e.printStackTrace();
            return null;
        }
        
    }
    
    // Metodo per la disconnessione
    public static void logout() {
        accessoEffettuato = false;
    }
    
    // Metodo per il controllo sullo stato connesso/non connesso dell'utente
    public static boolean isLogged() {
        return accessoEffettuato;
    }
}
