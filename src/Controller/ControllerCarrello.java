package Controller;

import javax.swing.JOptionPane;

import Model.*;
import View.PRGFrame;

/**
 * Classe per il controllo dell'inserimento di articoli nel carrello
 */
public class ControllerCarrello {
    public static void aggiungiAlCarrello(int q, Articolo art){
        ArticoloInCarrello a = null;
        if (art.getQuantitaMagazzino() >= q) {
            a = new ArticoloInCarrello(q, art);
        } else {
            JOptionPane.showMessageDialog(PRGFrame.rootparent, 
                                          "Abbiamo solo " + art.getQuantitaMagazzino() + " copie di questo articolo",
                                          "Disponibilità articoli",
                                          JOptionPane.ERROR_MESSAGE);
            return;
        }
            
        if (!ModelCarrello.carrello.contains(a)) {
            ModelCarrello.carrello.add(a);
            JOptionPane.showMessageDialog(PRGFrame.rootparent, "Prodotto aggiunto al carrello", null, JOptionPane.INFORMATION_MESSAGE);
        } else {
            // Se già presente, ne modifico la quantità da acquistare
            for (ArticoloInCarrello aInC : ModelCarrello.carrello) {
                if (aInC.equals(a)){
                    if (art.getQuantitaMagazzino() >= q + aInC.getQuantita()) {
                        aInC.setQuantita(q + aInC.getQuantita());
                        JOptionPane.showMessageDialog(PRGFrame.rootparent, "Prodotto aggiunto al carrello", null, JOptionPane.INFORMATION_MESSAGE);
                        break;
                    } else {
                        JOptionPane.showMessageDialog(PRGFrame.rootparent, 
                                "Abbiamo solo " + art.getQuantitaMagazzino() + " copie di questo articolo",
                                "Disponibilità articoli",
                                JOptionPane.ERROR_MESSAGE);
                        return;
                    }
                }
            }
        }
        
        // Test
        for (ArticoloInCarrello t : ModelCarrello.carrello) {
            System.out.println(t);
        }
        System.out.println("----------------------------------------------------");
    }
    
    
}
