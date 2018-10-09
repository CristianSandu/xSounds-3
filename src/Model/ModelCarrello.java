package Model;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Set;
import java.util.TreeSet;

import Controller.ListenerAccedi;

/**
 * Classe per la gestione dei dati del carrello e dell'acquisto
 */
public class ModelCarrello {
    // Lista degli articoli aggiunti al carrello
    public static Set<ArticoloInCarrello> carrello = new TreeSet<ArticoloInCarrello>();
    
    // Comando insert per inserire una vendita nel database
    public static String insertVendita = "INSERT INTO Vendita VALUES (DEFAULT, ?, ?, ?, ?, ?, ?, ?)";
    // Comando insert per associare una vendita a un articolo
    public static String insertArticoloInVendita = "INSERT INTO Prodotti_Acquistati VALUES (?, ?)";
    
    // Metodo per l'inserimento di una vendita
    public static void inserisciVendita(Vendita v) {
        try (PreparedStatement pst = DBHelper.con.prepareStatement(insertVendita)) {
            pst.clearParameters();
            pst.setBigDecimal(1, v.getPrezzoCompl());
            pst.setDate(2, new java.sql.Date(v.getData().getTime()));
            pst.setString(3, v.getModC());
            pst.setString(4, v.getModP());
            pst.setString(5, v.getCodP());
            pst.setString(6, v.getIP());
            pst.setString(7, ListenerAccedi.logged.getCodFis());    // Accesso alle info profilo
            
            pst.execute();
            
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
