package Model;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.JOptionPane;

/**
 * Classe per la registrazione del cliente
 */
public class ModelRegistrati {
    // Metodo per registrare nel database un nuovo cliente
    public static boolean registraCliente(Cliente c) {
        try (PreparedStatement pst = DBHelper.con.prepareStatement(
                "INSERT INTO Cliente (cod_fis, nome_utente, nome, cognome, citta, email, password, n_tel, n_cel, data)"
              + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?);"
            )) {
            
            // Setto i parametri del comando INSERT con i dati del cliente
            pst.setString(1, c.getCodFis());
            pst.setString(2, c.getUsername());
            pst.setString(3, c.getNome());
            pst.setString(4, c.getCognome());
            pst.setString(5, c.getCitta());
            pst.setString(6, c.getEMail());
            pst.setString(7, c.getPassword());
            pst.setString(8, c.getNTel());
            pst.setString(9, c.getNCel());
            pst.setDate(10, c.getData());
            
            // Eseguo il comando
            pst.executeUpdate();
            
            // Messaggio di registrazione effettuata
            JOptionPane.showMessageDialog(null, "Registrazione riuscita! Ora puoi accedere e acquistare i prodotti", 
                                          "Registrazione", JOptionPane.INFORMATION_MESSAGE);
            return true;
        } 
        catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Problema durante registrazione" + e.getMessage(), 
                                          "Registrazione", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        
    }
}
