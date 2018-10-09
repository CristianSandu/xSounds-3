package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Properties;

import javax.swing.JButton;
import javax.swing.JOptionPane;

import Email.ConfigUtility;
import Email.EmailUtility;
import Model.Cliente;
import Model.ModelRegistrati;
import View.Registrati;

public class ListenerRegistrati implements ActionListener {
    // Frame da gestire
    private Registrati frmRegistrati;
    
    private ConfigUtility configUtil = new ConfigUtility();
    
    public ListenerRegistrati(Registrati frmRegistrati) {
        this.frmRegistrati = frmRegistrati;
    }
    
    
    @Override
    public void actionPerformed(ActionEvent e) {
        // Bottone che ha generato l'evento
        JButton b = (JButton) e.getSource();
        
        boolean datiValidi;
        boolean clienteRegistrato;
        
        if (b.getText().equals("Procedi")) {
            // Controlli sui dati inseriti
            datiValidi = controllaDati();
            
            // Se i dati sono validi creiamo l'oggetto Cliente da inserire nel database
            if (datiValidi) {
                Cliente c = new Cliente();
                c.setCodFis(frmRegistrati.getCodFis());
                c.setNome(frmRegistrati.getNome());
                c.setCognome(frmRegistrati.getCognome());
                c.setCitta(frmRegistrati.getIndirizzo());
                c.setData(new java.sql.Date(frmRegistrati.getData().getTime()));  // "cast" da java.util.Date a java.sql.Date
                c.setEMail(frmRegistrati.getEMail());
                c.setNTel(frmRegistrati.getNTel());
                c.setNCel(frmRegistrati.getNCel());
                c.setUsername(frmRegistrati.getUser());
                c.setPassword(frmRegistrati.getPassword());
                
                // Inserimento nel db
                clienteRegistrato = ModelRegistrati.registraCliente(c);
                
                if (clienteRegistrato) {
                    frmRegistrati.pulisciCampi();
                }
                
                try {
					Properties smtpProperties = configUtil.loadProperties();
					EmailUtility.sendEmail(smtpProperties, frmRegistrati.getEMail(), "Welcome Message.", "Welcome to XSounds!", null);

					System.out.println("The e-mail has been sent successfully!");

				} catch (Exception ex) {
					System.out.println("Error while sending the e-mail: "); 
				}
                
            }
            else {
                // Dati non validi
                JOptionPane.showMessageDialog(null, "Errore: i dati per la registrazione non sono validi",
                                              "Registrazione fallita", JOptionPane.ERROR_MESSAGE); 
            }
        }
        
        
        // Bottone Indietro
        if (b.getText().equals("Indietro")) {
            // Nascondo il frame
            frmRegistrati.setVisible(false);
        }
        
        
        // Bottone Stampa Informativa
        if (b.getText().equals("Stampa Informativa")) {
            JOptionPane.showMessageDialog(null, "(inserire qui un'informativa)",
                                          "Informativa", JOptionPane.INFORMATION_MESSAGE);
        }
        
        
        // Bottone Non ricevo la mail
        if (b.getText().equals("Non ricevo la mail")) {
            // Nascondo il frame e informo l'utente sull'esistenza del tab 'Assistenza clienti'
            frmRegistrati.setVisible(false);
            JOptionPane.showMessageDialog(null, "Riferisci il problema nella sezione 'Assistenza clienti'.");
        }
    }
    
    // Metodo per il controllo dei dati inseriti nei campi di testo
    private boolean controllaDati() {
        // Controllo che l'utente abbia accettato quello che deve accettare
        if (!(
            frmRegistrati.getRBhoLetto().isSelected() &&
            frmRegistrati.getRBdatiPersonali().isSelected() &&    
            frmRegistrati.getRBautorizzo().isSelected()
           )) {
            return false;
        }
        
        // Campi obbligatori
        if (frmRegistrati.getNome().equals("") || 
            frmRegistrati.getCognome().equals("") || 
            (frmRegistrati.getData() == null) || 
            frmRegistrati.getCodFis().equals("") || 
            frmRegistrati.getIndirizzo().equals("") || 
            frmRegistrati.getEMail().equals("") || 
            frmRegistrati.getUser().equals("") ||
            frmRegistrati.getNTel().equals("") ||
            frmRegistrati.getPassword().equals("") ) {
            return false;
        }
        
        // Il codice fiscale deve avere 16 cifre
        if (frmRegistrati.getCodFis().length() != 16) return false;
        
        // Altri controlli (numeri di tel, password, email)
        // ....
        
        return true;
    }
    
}
