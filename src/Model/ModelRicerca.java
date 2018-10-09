package Model;

import java.math.BigDecimal;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;

import View.PRGFrame;

/**
 * Classe model per le ricerche nel database 
 */
public class ModelRicerca {
    // Lista di articoli nel catalogo: è sempre risultato di una delle query di ricerca
    public static List<Articolo> setArticoli = new ArrayList<Articolo>();

    // Query per le ricerche nel catalogo
    public static String qBase = "SELECT A.id, A.titolo, A.prezzo, A.quantita, A.data, A.descr, A.tipo, A.copertina, G.genere, M.nome_arte " 
                               + "FROM Articolo A "
                               + "JOIN Genere_appartenenza G ON A.id = G.id_articolo "
                               + "JOIN Musicista M ON A.titolare = M.id ";
    public static String qCatalogo = qBase + ";";
    public static String qTitolare = qBase
                                   + "WHERE M.nome_arte ILIKE ?;";
    public static String qPrezzoL = qBase 
                                  + "WHERE A.prezzo <= ?;";
    public static String qPrezzoG = qBase 
                                  + "WHERE A.prezzo >= ?;";
    public static String qPrezzoEq = qBase 
                                   + "WHERE A.prezzo = ?;";
    public static String qMusPart = "SELECT DISTINCT A.id, A.titolo, A.prezzo, A.quantita, A.data, A.descr, A.tipo, A.copertina, G.genere, M1.nome_arte "
                                  + "FROM Articolo A "
                                  + "JOIN Genere_appartenenza G ON A.id = G.id_articolo "
                                  + "JOIN Musicista M1 ON A.titolare = M1.id "
                                  + "JOIN Suonato_da S ON A.id = S.id_articolo "
                                  + "JOIN Musicista M2 ON S.musicista = M2.id "
                                  + "WHERE M2.nome_arte ILIKE ?";
    
    // Lettura del catalogo per intero
    public static void leggiCatalogo() {
        // Svuoto il setArticoli attuale
        ModelRicerca.setArticoli.clear();
        
        // Creo un oggetto per l'invio di query statiche
        try (Statement stat = DBHelper.con.createStatement()) {
            // Invio la query per ottenere il catalogo
            ResultSet rsCatalogo = stat.executeQuery(qCatalogo); 
                    
            // Scandisco il risultato della query
            while (rsCatalogo.next()) {
                // Da ogni riga ottengo un articolo
                Articolo a = new Articolo(rsCatalogo);
                // Costruisco la lista di articoli
                setArticoli.add(a);
            }
        }
        catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Problema durante la lettura del catalogo", "Errore ricerca", JOptionPane.ERROR_MESSAGE);
            System.out.println("Problema durante la ricerca:" + e.getMessage());
        }
    }
    
    // Metodo che ricerca tutti gli articoli che hanno per titolare l'artista specificato (o una sottostringa contenuta)
    public static void ricercaPerArtista(String artista) {
        // Svuoto il setArticoli attuale
        ModelRicerca.setArticoli.clear();
        
        try (PreparedStatement pst = DBHelper.con.prepareStatement(qTitolare)) {
            // Inserimento di un campo vuoto
            if (artista == "") {
                JOptionPane.showMessageDialog(PRGFrame.rootparent, "Inserire un nome di artista!", "Errore ricerca", JOptionPane.INFORMATION_MESSAGE);
                return;
            }
            
            pst.clearParameters();
            
            // Setto il parametro della query con quello ricevuto dal metodo
            pst.setString(1, "%" + artista + "%");
            
            // Invio la query per la ricerca per artista
            ResultSet rsTitolare = pst.executeQuery();
            
            // Se il Result Set vuoto mostro questo messaggio
            if (!rsTitolare.isBeforeFirst()) {
                JOptionPane.showMessageDialog(null, "Nessun elemento trovato.", null, JOptionPane.INFORMATION_MESSAGE);
                leggiCatalogo();
            }
            
            // Scandisco il risultato della query
            while (rsTitolare.next()) {
                Articolo a = new Articolo(rsTitolare);
                setArticoli.add(a);
            }
        }
        catch(SQLException e) {
            JOptionPane.showMessageDialog(null, "Problema durante la lettura del catalogo", "Errore ricerca", JOptionPane.ERROR_MESSAGE);
            System.out.println("Problema durante la ricerca:" + e.getMessage());
        }
    }
    
    // Questo metodo esegue una query per ricercare gli articoli con prezzo <= a quello specificato
    public static void ricercaPerPrezzo(BigDecimal prezzo, String operatore) {
        // Svuoto il setArticoli attuale
        ModelRicerca.setArticoli.clear();
        
        try  {
            // Prendo la query con l'operatore ricevuto
            String qPrezzo = "";
            if (operatore.equals("Minore o uguale a")) {
                qPrezzo = qPrezzoL;
            }
            else if (operatore.equals("Uguale a")) {
                qPrezzo = qPrezzoEq;
            }
            else {
                qPrezzo = qPrezzoG;
            }
            PreparedStatement pst = DBHelper.con.prepareStatement(qPrezzo);
            pst.clearParameters();
            
            // Setto il parametro della query con quello ricevuto dal metodo
            pst.setBigDecimal(1, prezzo);
            
            // Invio la query per la ricerca per prezzo
            ResultSet rsPrezzo = pst.executeQuery();
            
            // Se il Result Set è vuoto mostro questo messaggio
            if (!rsPrezzo.isBeforeFirst()) {
                JOptionPane.showMessageDialog(null, "Nessun elemento trovato.", null, JOptionPane.INFORMATION_MESSAGE);
                leggiCatalogo();
            }
            
            // Scandisco il risultato della query
            while (rsPrezzo.next()) {
                Articolo a = new Articolo(rsPrezzo);
                setArticoli.add(a);
            }
            
        }
        catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Problema durante la lettura del catalogo", "Errore ricerca", JOptionPane.ERROR_MESSAGE);
            System.out.println("Problema durante la ricerca:" + e.getMessage());
        }
    }
    
    // Metodo che ricerca tutti gli articoli che hanno fra i partecipanti il musicista specificato (o una sottostringa)
    public static void ricercaPerPartecipante(String partecipante) {
        // Svuoto il setArticoli attuale
        ModelRicerca.setArticoli.clear();
        
        try (PreparedStatement pst = DBHelper.con.prepareStatement(qMusPart)) {
            if (partecipante == "") {
                JOptionPane.showMessageDialog(PRGFrame.rootparent, "Inserire un nome di artista!", "Errore ricerca", JOptionPane.INFORMATION_MESSAGE);
                return;
            }
            
            pst.clearParameters();
            
            // Setto il parametro della query con quello ricevuto dal metodo
            pst.setString(1, "%" + partecipante + "%");
            
            // Invio la query per la ricerca per musicista partecipante
            ResultSet rsMusPart = pst.executeQuery();
            
            // Se il Result Set è vuoto mostro questo messaggio
            if (!rsMusPart.isBeforeFirst()) {
                JOptionPane.showMessageDialog(null, "Nessun elemento trovato.", null, JOptionPane.INFORMATION_MESSAGE);
                leggiCatalogo();
            }
            
            // Scandisco il risultato della query
            while (rsMusPart.next()) {
                Articolo a = new Articolo(rsMusPart);
                setArticoli.add(a);
            }
        }
        catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Problema durante la lettura del catalogo", "Errore ricerca", JOptionPane.ERROR_MESSAGE);
            System.out.println("Problema durante la ricerca:" + e.getMessage());
        }
    }
    
    // Metodo per la creazione del model per la JList del catalogo
    public static DefaultListModel<Articolo> modelList() {
        DefaultListModel<Articolo> model = new DefaultListModel<Articolo>();
    
        for (Articolo a : setArticoli) {
            model.addElement(a);
        }
        
        return model;
    }
    
}
