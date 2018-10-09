package View;

import java.awt.Image;

import javax.swing.*;

import Model.Cliente;

@SuppressWarnings("serial")
public class ContactUs extends JPanel {

    private JTextField textField_1;
    
    private static JTextPane textUser;
    private static JTextPane textEMail;
    private static JTextPane textNome;
    private static JTextPane textCognome;
    private static JTextPane textIndirizzo;
    private static JTextPane textNTel;
    private static JTextPane textNCel;
    private static JTextPane textData;
    private static JPasswordField passwordField;
    
    public ContactUs(){
        
        this.setLayout(null);
        

        
        JLabel lblText = new JLabel("<html>Il centro assistenza è a tua disposizione per qualsiasi chiarimento al numero di telefono 0442/012598 con i seguenti orari: Dal Lunedì al Venerdì 09.00 - 12.00 15.00 - 19.00  Sabato 09.00 - 12.00  <html> ");
        lblText.setBounds(436, 49, 179, 157);
        this.add(lblText);
        lblText.setHorizontalAlignment(SwingConstants.LEFT);
        //lblText.setVerticalAlignment(SwingConstants.LEADING);
        
        JLabel lblPerInviareUna = new JLabel("Per inviare una mail compila i seguenti campi:");
        lblPerInviareUna.setBounds(436, 218, 298, 20);
        lblPerInviareUna.setHorizontalAlignment(SwingConstants.LEFT);
        //lblPerInviareUna.setVerticalAlignment(SwingConstants.LEADING);
        this.add(lblPerInviareUna);
        
        JTextArea textArea = new JTextArea();
        textArea.setBounds(530, 313, 235, 168);
        this.add(textArea);
        
        textField_1 = new JTextField();
        textField_1.setBounds(525, 272, 248, 29);
        this.add(textField_1);
        textField_1.setColumns(10);
        
        JLabel lblEMail = new JLabel("<html>Indirizzo E-mail<html>");
        lblEMail.setBounds(436, 272, 65, 35);
        this.add(lblEMail);
        
        JLabel lblDescrizioneDelProblema = new JLabel("<html> Descrizione del problema ( max. 15 righe) <html>");
        lblDescrizioneDelProblema.setBounds(436, 325, 85, 172);
        this.add(lblDescrizioneDelProblema);
        
        JButton btnInviaMail = new JButton("Invia mail");
        btnInviaMail.setBounds(652, 509, 117, 29);
        this.add(btnInviaMail);    
        
        JSeparator separator = new JSeparator();
        separator.setOrientation(SwingConstants.VERTICAL);
        separator.setBounds(400, 19, 12, 526);
        this.add(separator);
        
        JLabel lblIlTuoProfilo = new JLabel("Il tuo profilo");
        
        lblIlTuoProfilo.setBounds(37, 21, 85, 16);
        this.add(lblIlTuoProfilo);
        
        
        
        
        
        
        
        ImageIcon icon = PRGFrame.createImageIcon("img/Utente.png");
        Image image = icon.getImage(); // transform it 
        Image newimg = image.getScaledInstance(100, 100,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  
        icon = new ImageIcon(newimg);  // transform it back        
        JLabel lblNewLabel = new JLabel(" ");
        lblNewLabel.setIcon(icon);
        lblNewLabel.setBounds(37, 65, 108, 110);
        lblNewLabel.setVerticalAlignment(JLabel.CENTER);
        this.add(lblNewLabel);
        
        JButton btnImposta = new JButton("Imposta");
        btnImposta.setBounds(37, 177, 117, 29);
        this.add(btnImposta);
        
        JLabel lblImmagineDiProfilo = new JLabel("Immagine di profilo");
        lblImmagineDiProfilo.setBounds(37, 49, 132, 16);
        this.add(lblImmagineDiProfilo);
        
        JSeparator separator_1 = new JSeparator();
        separator_1.setOrientation(SwingConstants.VERTICAL);
        separator_1.setBounds(13, 19, 12, 519);
        this.add(separator_1);
        
        JLabel lblUsername = new JLabel("Username:");
        lblUsername.setBounds(37, 220, 85, 16);
        this.add(lblUsername);
        
        JLabel lblIndirizzoEmail = new JLabel("Indirizzo e-mail:");
        lblIndirizzoEmail.setBounds(37, 248, 108, 16);
        this.add(lblIndirizzoEmail);
        
        JLabel lblNome = new JLabel("Nome:");
        lblNome.setBounds(37, 276, 61, 16);
        this.add(lblNome);
        
        JLabel lblCognome = new JLabel("Cognome");
        lblCognome.setBounds(37, 304, 61, 16);
        this.add(lblCognome);
        
        JLabel lblNrDiTelefono = new JLabel("Nr di telefono:");
        lblNrDiTelefono.setBounds(37, 363, 108, 16);
        this.add(lblNrDiTelefono);
        
        JLabel lblNrDiCellulare = new JLabel("Nr di cellulare:");
        lblNrDiCellulare.setBounds(37, 391, 108, 16);
        this.add(lblNrDiCellulare);
        
        JLabel lblDataDiNascita = new JLabel("Data di nascita:");
        lblDataDiNascita.setBounds(37, 425, 108, 16);
        this.add(lblDataDiNascita);
        
        JLabel lblPassword = new JLabel("Password:");
        lblPassword.setBounds(37, 453, 71, 16);
        this.add(lblPassword);
        
        JLabel lblIndirizzo = new JLabel("Indirizzo:");
        lblIndirizzo.setBounds(37, 335, 71, 16);
        this.add(lblIndirizzo);
        
        textUser = new JTextPane();
        textUser.setEnabled(false);
        textUser.setEditable(false);
        
        textUser.setBounds(204, 218, 117, 16);
        this.add(textUser);
        
        JButton btnNewButton = new JButton("Modifica");
        btnNewButton.setBounds(271, 509, 117, 29);
        this.add(btnNewButton);
        
        ImageIcon iconCentro = PRGFrame.createImageIcon("img/teleassistenza.png");
        Image imageCentro = iconCentro.getImage(); // transform it 
        Image newImgCentro = imageCentro.getScaledInstance(115, 120,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  
        iconCentro = new ImageIcon(newImgCentro);  // transform it back        
        JLabel lblCentro = new JLabel(" ");
        lblCentro.setIcon(iconCentro);
        lblCentro.setBounds(627, 65, 107, 122);
        lblCentro.setVerticalAlignment(JLabel.CENTER);
        this.add(lblCentro);
        
        JLabel lblAssistenza = new JLabel("Assistenza");
        lblAssistenza.setBounds(424, 19, 77, 16);
        this.add(lblAssistenza);
        
        JSeparator separator_2 = new JSeparator();
        separator_2.setOrientation(SwingConstants.VERTICAL);
        separator_2.setBounds(782, 19, 12, 526);
        this.add(separator_2);
        
        textEMail = new JTextPane();
        textEMail.setEnabled(false);
        textEMail.setEditable(false);
        textEMail.setBounds(204, 248, 117, 16);
        this.add(textEMail);
        
        textNome = new JTextPane();
        textNome.setEnabled(false);
        textNome.setEditable(false);
        textNome.setBounds(204, 272, 117, 16);
        this.add(textNome);
        
        textCognome = new JTextPane();
        textCognome.setEnabled(false);
        textCognome.setEditable(false);
        textCognome.setBounds(204, 304, 117, 16);
        this.add(textCognome);
        
        textNTel = new JTextPane();
        textNTel.setEnabled(false);
        textNTel.setEditable(false);
        textNTel.setBounds(204, 363, 117, 16);
        this.add(textNTel);
        
        textNCel = new JTextPane();
        textNCel.setEnabled(false);
        textNCel.setEditable(false);
        textNCel.setBounds(204, 391, 117, 16);
        this.add(textNCel);
        
        textData = new JTextPane();
        textData.setEnabled(false);
        textData.setEditable(false);
        textData.setBounds(204, 419, 117, 16);
        this.add(textData);
        
        passwordField = new JPasswordField();
        passwordField.setEditable(false);
        passwordField.setBounds(204, 447, 117, 26);
        this.add(passwordField);
        
        textIndirizzo = new JTextPane();
        textIndirizzo.setEnabled(false);
        textIndirizzo.setEditable(false);
        textIndirizzo.setBounds(204, 335, 117, 16);
        this.add(textIndirizzo);
        
        JSeparator separator_3 = new JSeparator();
        separator_3.setBounds(424, 202, 341, 12);
        this.add(separator_3);
        
        
        
    }
    
    // Visualizza le informazioni sul cliente loggato
    public static void setInfoProfilo(Cliente c) {
        textUser.setText(c.getUsername());
        textEMail.setText(c.getEMail());
        textNome.setText(c.getNome());
        textCognome.setText(c.getCognome());
        textIndirizzo.setText(c.getCitta());
        textNTel.setText(c.getNTel());
        if (c.getNCel() != null) {
            textNCel.setText(c.getNCel());
        }
        if (c.getData() != null) {
            textData.setText(c.getData().toString());
        }
        else {
            textData.setText("");
        }
        passwordField.setText(c.getPassword());
    }
    
}
