package View;


import javax.swing.*;

import com.toedter.calendar.JDateChooser;
import com.toedter.calendar.JTextFieldDateEditor;

import Controller.ListenerRegistrati;

import java.util.Date;
import java.util.Locale;

@SuppressWarnings("serial")
public class Registrati extends JDialog {
    private static JTextField textNome;
    private static JTextField textCognome;
    private static JTextField textCodFis;
    private static JTextField textIndirizzo;
    private static JTextField textEMail;
    private static JTextField textUser;
    private static JTextField textNTel;
    private static JTextField textNCel;
    private static JPasswordField passwordField;
    private static JDateChooser chooser;
    
    private JRadioButton rdbtnHoLettoEd;
    private JRadioButton rdbtnDatiPersonali;
    private JRadioButton rdbtnAutorizzo;
    
    private ListenerRegistrati listener = new ListenerRegistrati(this);
    
    public Registrati(){
        super(PRGFrame.rootparent, true);
        
        setTitle("Registrati");
        
        this.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        
        JLabel lblInserisciIDati = new JLabel("Inserisci i dati:");
        lblInserisciIDati.setBounds(48, 20, 100, 16);
        this.add(lblInserisciIDati);
        
        JLabel lblNome = new JLabel("Nome");
        lblNome.setBounds(48, 59, 61, 16);
        this.add(lblNome);
        
        JLabel lblCognome = new JLabel("Cognome");
        lblCognome.setBounds(48, 89, 61, 16);
        this.add(lblCognome);
        
        JLabel lblIndirizzo = new JLabel("Indirizzo");
        lblIndirizzo.setBounds(48, 174, 61, 16);
        this.add(lblIndirizzo);
        
        JLabel lblNewLabel = new JLabel("Indirizzo e-mail");
        lblNewLabel.setBounds(48, 202, 114, 16);
        this.add(lblNewLabel);
        
        JLabel lblUsername = new JLabel("Username");
        lblUsername.setBounds(48, 230, 77, 16);
        this.add(lblUsername);
        
        JLabel lblPassword = new JLabel("Password");
        lblPassword.setBounds(48, 258, 61, 16);
        this.add(lblPassword);
        
        textNome = new JTextField();
        textNome.setBounds(161, 54, 130, 26);
        this.add(textNome);
        textNome.setColumns(10);
        ///// OK
        textIndirizzo = new JTextField();
        textIndirizzo.setBounds(161, 169, 130, 26);
        this.add(textIndirizzo);
        textIndirizzo.setColumns(10);
        //// OK
        textEMail = new JTextField();
        textEMail.setBounds(161, 197, 130, 26);
        this.add(textEMail);
        textEMail.setColumns(10);
        
        textCognome = new JTextField();
        textCognome.setBounds(161, 84, 130, 26);
        this.add(textCognome);
        textCognome.setColumns(10);
        //// OK
        textUser = new JTextField();
        textUser.setBounds(161, 225, 130, 26);
        this.add(textUser);
        textUser.setColumns(10);
        
        JLabel lblNrDiTelefono = new JLabel("Nr. di telefono");
        lblNrDiTelefono.setBounds(48, 286, 100, 16);
        this.add(lblNrDiTelefono);
        
        JLabel lblNrDiCellulare = new JLabel("Nr di cellulare");
        lblNrDiCellulare.setBounds(48, 322, 100, 16);
        this.add(lblNrDiCellulare);
        /// OK
        textNTel = new JTextField();
        textNTel.setBounds(161, 284, 130, 26);
        this.add(textNTel);
        textNTel.setColumns(10);
        /// OK
        textNCel = new JTextField();
        textNCel.setBounds(161, 317, 130, 26);
        this.add(textNCel);
        textNCel.setColumns(10);
        
        JLabel lblDataDiNascita = new JLabel("Data di nascita");
        lblDataDiNascita.setBounds(48, 118, 100, 16);
        this.add(lblDataDiNascita);
        
        chooser = new JDateChooser();
        chooser.setLocale(Locale.US);
        chooser.setBounds(161, 113, 130, 26);
        // la casella di testo deve essere disabilitata
        JTextFieldDateEditor editor = (JTextFieldDateEditor) chooser.getDateEditor();
        editor.setEditable(false);
        this.add(chooser);
        
        JLabel lblCodiceFiscale = new JLabel("Codice Fiscale");
        lblCodiceFiscale.setBounds(48, 145, 100, 16);
        this.add(lblCodiceFiscale);
        
        textCodFis = new JTextField();
        textCodFis.setBounds(161, 140, 130, 26);
        this.add(textCodFis);
        textCodFis.setColumns(10);
        
        JButton btnProcedi = new JButton("Procedi");
        btnProcedi.setBounds(48, 364, 117, 29);
        this.add(btnProcedi);
        
        JButton btnIndietro = new JButton("Indietro");
        btnIndietro.setBounds(174, 364, 117, 29);
        this.add(btnIndietro);
        
        passwordField = new JPasswordField();
        passwordField.setBounds(161, 253, 130, 26);
        this.add(passwordField);
        
        JLabel lblInseritiIDati = new JLabel("<html>Inseriti i dati verifica la tua casella di posta elettronica. Riceverai una mail di conferma di attivazione del tuo account . Quindi esegui il login con le tue credenziali per il completo accesso.<html>");
        lblInseritiIDati.setBounds(311, 44, 234, 131);
        this.add(lblInseritiIDati);
        
        JLabel lblLeInformazioniDa = new JLabel("<html>Le informazioni da te fornite saranno trattate solo dalla Xsounds.srl a scopo di migliorare il servizio offerto.Per poter proseguire devi Accettare i termini e le condizioni contrattuali e prestare il tuo consenso al trattamento dei dati personali ex art.13 del D.Lgs 196/2013<html> ");
        lblLeInformazioniDa.setBounds(312, 198, 233, 182);
        this.add(lblLeInformazioniDa);
        
        JSeparator separator = new JSeparator();
        separator.setBounds(303, 195, 234, 14);
        getContentPane().add(separator);
        
        JSeparator separator_1 = new JSeparator();
        separator_1.setBounds(48, 35, 489, 12);
        getContentPane().add(separator_1);
        
        JButton btnNonRicevo = new JButton("Non ricevo la mail");
        btnNonRicevo.setBounds(303, 160, 234, 29);
        getContentPane().add(btnNonRicevo);
        
        JSeparator separator_2 = new JSeparator();
        separator_2.setBounds(48, 397, 497, 12);
        getContentPane().add(separator_2);
        
        rdbtnHoLettoEd = new JRadioButton("Dichiaro di aver letto e di accettare i termini e le condizioni esposte.");
        rdbtnHoLettoEd.setBounds(48, 421, 497, 23);
        getContentPane().add(rdbtnHoLettoEd);
        
        rdbtnDatiPersonali = new JRadioButton("<html>Autorizzo il trattamento dei miei dati personali ai sensi del Decreto Legislativo 30 giugno 2003, n. 196 Codice del Consumo.<html>");
        rdbtnDatiPersonali.setBounds(48, 456, 489, 45);
        getContentPane().add(rdbtnDatiPersonali);
        
        rdbtnAutorizzo = new JRadioButton("<html>In riferimento alla legge 196/2003 autorizzo espressamente l’utilizzo dei dati personali riportati.<html>");
        rdbtnAutorizzo.setBounds(48, 513, 471, 45);
        getContentPane().add(rdbtnAutorizzo);
        
        JButton btnStampaInfo = new JButton("Stampa Informativa");
        btnStampaInfo.setBounds(311, 364, 233, 29);
        getContentPane().add(btnStampaInfo);
        
        // Registro il listener sui bottoni Procedi e Indietro
        btnProcedi.addActionListener(listener);
        btnIndietro.addActionListener(listener);
        
        // e sui bottoni restanti
        btnNonRicevo.addActionListener(listener);
        btnStampaInfo.addActionListener(listener);
        
        this.setLayout(null);

        //Display the window.
        this.pack();
        
        this.setSize(600, 600);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        //frame.setVisible(true);
    }
    
    
    // Metodi get e "clean" per interagire con il listener
    @SuppressWarnings("static-access")
    public String getNome() {
        return this.textNome.getText();
    }
    @SuppressWarnings("static-access")
    public void cleanNome() {
        this.textNome.setText("");
    }
    @SuppressWarnings("static-access")
    public String getCognome() {
        return this.textCognome.getText();
    }
    @SuppressWarnings("static-access")
    public void cleanCognome() {
        this.textCognome.setText("");
    }
    @SuppressWarnings("static-access")
    public Date getData() {
        return this.chooser.getDate();
    }
    @SuppressWarnings("static-access")
    public void cleanData() {
        this.chooser.setDate(null);
    }
    @SuppressWarnings("static-access")
    public String getCodFis() {
        return this.textCodFis.getText();
    }
    @SuppressWarnings("static-access")
    public void cleanCodFis() {
        this.textCodFis.setText("");
    }
    @SuppressWarnings("static-access")
    public String getIndirizzo() {
        return this.textIndirizzo.getText();
    }
    @SuppressWarnings("static-access")
    public void cleanIndirizzo() {
        this.textIndirizzo.setText("");
    }
    @SuppressWarnings("static-access")
    public String getEMail() {
        return this.textEMail.getText();
    }
    @SuppressWarnings("static-access")
    public void cleanEMail() {
        this.textEMail.setText("");
    }
    @SuppressWarnings("static-access")
    public String getUser() {
        return this.textUser.getText();
    }
    @SuppressWarnings("static-access")
    public void cleanUser() {
        this.textUser.setText("");
    }
    @SuppressWarnings("static-access")
    public String getNTel() {
        return this.textNTel.getText();
    }
    @SuppressWarnings("static-access")
    public void cleanNTel() {
        this.textNTel.setText("");
    }
    @SuppressWarnings("static-access")
    public String getNCel() {
        return this.textNCel.getText();
    }
    @SuppressWarnings("static-access")
    public void cleanNCel() {
        this.textNCel.setText("");
    }
    @SuppressWarnings({ "deprecation", "static-access" })
    public String getPassword() {
        return this.passwordField.getText();
    }
    @SuppressWarnings("static-access")
    public void cleanPassword() {
        this.passwordField.setText("");
    }
    
    // Metodi per il passaggio dei JRadioButton al listener
    public JRadioButton getRBhoLetto() {
        return this.rdbtnHoLettoEd;
    }
    public JRadioButton getRBdatiPersonali() {
        return this.rdbtnDatiPersonali;
    }
    public JRadioButton getRBautorizzo() {
        return this.rdbtnAutorizzo;
    }
    
    // Metodo per ripulire i campi del frame Registrati
    public void pulisciCampi() {
        // Richiamo i metodi "cleaner"
        this.cleanNome();
        this.cleanCognome();
        this.cleanCodFis();
        this.cleanData();
        this.cleanIndirizzo();
        this.cleanEMail();
        this.cleanUser();
        this.cleanPassword();
        this.cleanNTel();
        this.cleanNCel();
        
        // Deseleziono i JRadioButton
        this.rdbtnHoLettoEd.setSelected(false);
        this.rdbtnDatiPersonali.setSelected(false);
        this.rdbtnAutorizzo.setSelected(false);
    }


}