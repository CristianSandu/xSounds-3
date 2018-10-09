package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JOptionPane;

import Model.Cliente;
import Model.ModelAccedi;
import View.Accedi;
import View.ContactUs;
import View.Registrati;

public class ListenerAccedi implements ActionListener {
    // Frame che genera gli eventi da gestire
    private Accedi pnlAccedi;
    // Frame da instanziare, sarà reso visibile quando richiamato
    private Registrati pnlRegistrati;
    
    public ListenerAccedi() {}
    
    public ListenerAccedi(Accedi pnlAccedi, Registrati pnlRegistrati) {
        this.pnlAccedi = pnlAccedi;
        this.pnlRegistrati = pnlRegistrati;    // Pattern Singleton
    }
    
    public static Cliente logged = null;
    
    @Override
    public void actionPerformed(ActionEvent e) {
        // Bottone che ha generato l'evento
        JButton b = (JButton) e.getSource();
        
        // Pressione del pulsante Accedi
        if (b.getText().equals("Accedi")) {
            
            // Se l'utente è già connesso non può effettuare un altro accesso
            if (!(ModelAccedi.isLogged())) {
                // Prendo dal pannello il contenuto dei campi
                String usr = pnlAccedi.getUserFromTextField();
                String pw  = pnlAccedi.getPasswordFromTextField();
            
                // Login nel database
                logged = ModelAccedi.login(usr, pw);
            
                if (logged == null) {
                    // Errore durante il login
                    JOptionPane.showMessageDialog(null, "Username e/o password non validi",
                                                  "Login fallito", JOptionPane.ERROR_MESSAGE); 
                }
                else {
                    // Accesso riuscito
                    JOptionPane.showMessageDialog(null, "Accesso riuscito", "Login", JOptionPane.INFORMATION_MESSAGE);
                    ContactUs.setInfoProfilo(logged);
                }
            }
            else {
                JOptionPane.showMessageDialog(null, "Sei già connesso come " + logged.getUsername(), "Login", JOptionPane.INFORMATION_MESSAGE);
            }
            
        }
        
        
        // Bottone Registrati
        if (b.getText().equals("Registrati")) {
            // Ad ogni riavvio, i campi del frame Registrati vanno ripuliti
            pnlRegistrati.pulisciCampi();
            
            /* Per non riavviare ogni volta la schermata, decidiamo di
               renderla visibile quando l'utente la richiama */
            javax.swing.SwingUtilities.invokeLater(new Runnable() {
                public void run() {
                    pnlRegistrati.setVisible(true);
                }
            });
        }
        
        
        // Bottone Esci (logout)
        if (b.getText().equals("Esci")) {
            if (ModelAccedi.isLogged()) {
                // Disconnetto il cliente
                ModelAccedi.logout();
                JOptionPane.showMessageDialog(null, "Logout effettuato", "Logout", JOptionPane.INFORMATION_MESSAGE);
                
                // Ripulisco i campi del profilo (uso un cliente vuoto per settarli)
                ContactUs.setInfoProfilo(new Cliente());
            }
            else {
                JOptionPane.showMessageDialog(null, "Nessun utente connesso", "Logout", JOptionPane.INFORMATION_MESSAGE);
            }
        }
        
        // Ad ogni evento ripulisco i campi inseriti
        pnlAccedi.setUserTextField("");
        pnlAccedi.setPasswordTextField("");
    }
        
        
        
}

    

