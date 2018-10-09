package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;

import javax.swing.JButton;
import javax.swing.JOptionPane;

import Model.ModelRicerca;
import View.ViewCatalogPanel;

public class ListenerRicerca implements ActionListener {
    
    private ViewCatalogPanel pnlCatalogo;
    
    public ListenerRicerca(ViewCatalogPanel pnl) {
        this.pnlCatalogo = pnl;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        // Bottone che ha generato l'evento
        JButton b = (JButton) e.getSource();
        
        boolean ricercaCorretta;
        
        // Bottone Cerca
        if (b.getText().equals("Cerca")) {
            ricercaCorretta = !(pnlCatalogo.getParamRicerca().equals(""));
            
            if (ricercaCorretta) {
                // Consegno la ricerca da fare al Model
                if (pnlCatalogo.getRBartista().isSelected()) {
                    ModelRicerca.ricercaPerArtista(pnlCatalogo.getParamRicerca());
                }
                else if (pnlCatalogo.getRBmusPart().isSelected()) {
                    ModelRicerca.ricercaPerPartecipante(pnlCatalogo.getParamRicerca());
                }
                else if (pnlCatalogo.getRBprezzo().isSelected()) {
                    try {
                        int prezzo = Integer.parseInt(pnlCatalogo.getParamRicerca());
                        ModelRicerca.ricercaPerPrezzo(new BigDecimal(prezzo), pnlCatalogo.getOperatore());
                    } catch (NumberFormatException ex) {
                        JOptionPane.showMessageDialog(null, "Inserisci un numero intero per il prezzo", "Ricerca fallita", JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
            else {
                JOptionPane.showMessageDialog(null, "Inserisci un elemento da ricercare", "Ricerca fallita", JOptionPane.ERROR_MESSAGE);
            }
            
            // Aggiorna la lista
            if (ricercaCorretta) {
                pnlCatalogo.disegnaCatalogo();
            }
            
        }
        
        
        // Bottone Pulisci
        if (b.getText().equals("Pulisci")) {
            pnlCatalogo.getRBartista().setSelected(true);
            pnlCatalogo.getRBmusPart().setSelected(false);
            pnlCatalogo.getRBprezzo().setSelected(false);
            pnlCatalogo.getTextRicerca().setText("");
            
            // Ricarico la lista iniziale
            ModelRicerca.leggiCatalogo();
            pnlCatalogo.disegnaCatalogo();
        }
        
    }
    
    
}
