package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

import javax.swing.JOptionPane;

import Model.*;
import View.ViewCart;

public class ListenerCarrello implements ActionListener  {
    
    private ViewCart pnlCart;
    
    public ListenerCarrello(ViewCart pnlCart) {
        this.pnlCart = pnlCart;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (ModelCarrello.carrello.size() == 0) {
        	JOptionPane.showMessageDialog(null, "Il carrello è vuoto!", "Acquisto", JOptionPane.ERROR_MESSAGE);  
        	return;
        }
        
        // L'acquisto è permesso solo se l'utente è loggato
        if (!ModelAccedi.isLogged()){
            JOptionPane.showMessageDialog(null, "Per acquistare i prodotti devi accedere", "Acquisto", JOptionPane.ERROR_MESSAGE);   
            return;
        }
        
        // L'utente deve avere selezionato un metodo di pagamento e uno di consegna
        if (!(pnlCart.rdbtnBB.isSelected() && 
            (pnlCart.rdbtnCorriere.isSelected() ||
             pnlCart.rdbtnPostaOrdinaria.isSelected() ||
             pnlCart.rdbtnViaAerea.isSelected()
            )
           )) {
            return;
        }
        
        int conferma = JOptionPane.showConfirmDialog(null, "Vuoi veramente acquistare questi articoli?", 
             "Acquisto", JOptionPane.YES_NO_OPTION);

        if (conferma != JOptionPane.YES_OPTION) {
            return;
        }
        
        // Instanzio la vendita e la mando al Model
        Vendita v = new Vendita(Float.valueOf(pnlCart.getTotale()),
                                new Date(),
                                pnlCart.getMod(),
                                "Bonifico",
                                pnlCart.getCC(),
                                "157.27.132.64"
                                );
        
        ModelCarrello.inserisciVendita(v);
        
    }
    
    
}
