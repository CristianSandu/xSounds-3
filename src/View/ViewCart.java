 package View;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import Controller.ListenerCarrello;
import Model.ArticoloInCarrello;
import Model.ModelCarrello;


@SuppressWarnings("serial")
public class ViewCart extends JComponent {
    public final ViewCart root = this;
    
    private JTextField txtCC;
    private JTextField txtNomeTitolareCartaCredito;
    private JTextField txtDataConsegnaCorriere;
    private JTextField txtDataConsegnaPosta;
    private JTextField txtDataConsegnaAerea;
    private JTextField txtSpeseAssicurazione;
    private JTextField txtNumeroCartaCredito;
    private JTextField txtDataScadenzaCarta;
    private JPasswordField txtCodiceDiSicurezza;
    private JTextField txtTotale;
    private JTextField txtSconto;
    private JTextField txtSubTotale;
    
    public JRadioButton rdbtnBB;
    public JRadioButton rdbtnCorriere;
    public JRadioButton rdbtnPostaOrdinaria;
    public JRadioButton rdbtnViaAerea;
    public JRadioButton rdbtnAssicura;
    
    private DefaultTableModel tableModel;
    private JTable table; 
    
    // Pattern Singleton
    private static ViewCart instance = null; 
    public static ViewCart getInstance() {
        if (instance == null) {
            instance = new ViewCart();
        }
        
        return instance;
    }
    
    private ListenerCarrello listenerCar = new ListenerCarrello(this);
    
    private ViewCart() {
        rdbtnBB = new JRadioButton("Bonifico bancario");
        rdbtnBB.setBounds(17, 276, 141, 23);
        this.add(rdbtnBB);
        
        JSeparator separator_1 = new JSeparator();
        separator_1.setOrientation(SwingConstants.VERTICAL);
        separator_1.setBounds(454, 248, 12, 254);
        this.add(separator_1);
        
        JLabel lblSelezionaMetodoDi = new JLabel("Seleziona metodo di pagamento:");
        lblSelezionaMetodoDi.setBounds(6, 248, 214, 16);
        this.add(lblSelezionaMetodoDi);
        
        JLabel lblSelezionaMetodoDi_1 = new JLabel("Metodo di consegna:");
        lblSelezionaMetodoDi_1.setBounds(478, 248, 141, 16);
        this.add(lblSelezionaMetodoDi_1);
        
        JRadioButton rdbtnCC = new JRadioButton("Carta di Credito");
        rdbtnCC.setBounds(17, 341, 141, 23);
        this.add(rdbtnCC);
        
        txtCC = new JTextField();
        txtCC.setBounds(235, 303, 207, 26);
        this.add(txtCC);
        txtCC.setColumns(10);
        
        txtNomeTitolareCartaCredito = new JTextField();
        txtNomeTitolareCartaCredito.setBounds(235, 375, 207, 26);
        this.add(txtNomeTitolareCartaCredito);
        txtNomeTitolareCartaCredito.setColumns(10);
        
        rdbtnCorriere = new JRadioButton("Corriere");
        rdbtnCorriere.setBounds(478, 274, 141, 23);
        this.add(rdbtnCorriere);
        
        rdbtnPostaOrdinaria = new JRadioButton("Posta ordinaria");
        rdbtnPostaOrdinaria.setBounds(478, 309, 126, 23);
        this.add(rdbtnPostaOrdinaria);
        
        rdbtnViaAerea = new JRadioButton("via Aerea");
        rdbtnViaAerea.setBounds(478, 344, 141, 23);
        this.add(rdbtnViaAerea);
        
        JButton btnAcquista = new JButton("Acquista");
        btnAcquista.setBounds(665, 473, 117, 29);
        this.add(btnAcquista);
        
        // Raggruppo i radio buttons
        ButtonGroup groupPagamento = new ButtonGroup();
        groupPagamento.add(rdbtnBB);
        groupPagamento.add(rdbtnCC);
        
        // Raggruppo i radio buttons
        ///////////////////////////////
        ButtonGroup groupConsegna = new ButtonGroup();
        groupConsegna.add(rdbtnPostaOrdinaria);
        groupConsegna.add(rdbtnViaAerea);
        groupConsegna.add(rdbtnCorriere);
        /////////////////////////////////
        JLabel lblDataPrevistaDi = new JLabel("In consegna il:");
        lblDataPrevistaDi.setBounds(680, 248, 110, 16);
        this.add(lblDataPrevistaDi);
        
        DateFormat df = DateFormat.getDateInstance(DateFormat.SHORT, Locale.ITALY);
        
        txtDataConsegnaCorriere = new JDisabledTextField();
        txtDataConsegnaCorriere.setBounds(651, 275, 130, 26);
        this.add(txtDataConsegnaCorriere);
        txtDataConsegnaCorriere.setColumns(10);
        txtDataConsegnaCorriere.setText(df.format(new Date(new Date().getTime() + 4 * 24 * 3600 * 1000)));
        
        
        txtDataConsegnaPosta = new JDisabledTextField();
        txtDataConsegnaPosta.setBounds(651, 303, 130, 26);
        this.add(txtDataConsegnaPosta);
        txtDataConsegnaPosta.setColumns(10);
        txtDataConsegnaPosta.setText(df.format(new Date(new Date().getTime() + 20 * 24 * 3600 * 1000)));
        
        txtDataConsegnaAerea = new JDisabledTextField();
        txtDataConsegnaAerea.setBounds(651, 338, 130, 26);
        this.add(txtDataConsegnaAerea);
        txtDataConsegnaAerea.setColumns(10);
        txtDataConsegnaAerea.setText(df.format(new Date(new Date().getTime() + 10 * 24 * 3600 * 1000)));
        
        rdbtnAssicura = new JRadioButton("Assicura il pacco");
        rdbtnAssicura.setBounds(478, 424, 141, 23);
        this.add(rdbtnAssicura);
        
        JLabel lblVuoiAssicurareIl = new JLabel("Spese di assicurazione");
        lblVuoiAssicurareIl.setBounds(478, 396, 156, 16);
        this.add(lblVuoiAssicurareIl);
        
        txtSpeseAssicurazione = new JDisabledTextField();
        txtSpeseAssicurazione.setBounds(651, 423, 130, 26);
        this.add(txtSpeseAssicurazione);
        txtSpeseAssicurazione.setColumns(10);
        
        JLabel lblCoordinteIbanCc = new JLabel("Coordinte IBAN C/C");
        lblCoordinteIbanCc.setBounds(90, 308, 130, 16);
        this.add(lblCoordinteIbanCc);
        
        JLabel lblNomeECognome = new JLabel("Cognome e Nome del Titolare ");
        lblNomeECognome.setBounds(17, 380, 203, 16);
        this.add(lblNomeECognome);
        
        txtNumeroCartaCredito = new JTextField();
        txtNumeroCartaCredito.setColumns(10);
        txtNumeroCartaCredito.setBounds(235, 413, 207, 26);
        this.add(txtNumeroCartaCredito);
        
        JLabel lblNumeroDellaCarta = new JLabel("Numero della Carta di Credito");
        lblNumeroDellaCarta.setBounds(17, 422, 203, 16);
        this.add(lblNumeroDellaCarta);
        
        txtDataScadenzaCarta = new JTextField();
        txtDataScadenzaCarta.setColumns(10);
        txtDataScadenzaCarta.setBounds(337, 482, 105, 26);
        this.add(txtDataScadenzaCarta);
        
        JLabel lblDataScadenza = new JLabel("Data Scadenza");
        lblDataScadenza.setBounds(224, 487, 99, 16);
        this.add(lblDataScadenza);
        
        JLabel lblCodiceDiSicurezza = new JLabel("Codice di sicurezza");
        lblCodiceDiSicurezza.setBounds(193, 454, 130, 16);
        this.add(lblCodiceDiSicurezza);
        
        txtCodiceDiSicurezza = new JPasswordField();
        txtCodiceDiSicurezza.setBounds(337, 449, 105, 26);
        this.add(txtCodiceDiSicurezza);
        
        JSeparator separator_2 = new JSeparator();
        separator_2.setBounds(6, 333, 436, 12);
        this.add(separator_2);
        
        JSeparator separator_3 = new JSeparator();
        separator_3.setBounds(6, 264, 436, 12);
        this.add(separator_3);
        
        JSeparator separator_5 = new JSeparator();
        separator_5.setBounds(478, 264, 312, 12);
        this.add(separator_5);
        
        JSeparator separator_6 = new JSeparator();
        separator_6.setBounds(478, 413, 312, 12);
        this.add(separator_6);
        
        
        JLabel lblSconto = new JLabel("Sconto");
        lblSconto.setBounds(651, 17, 61, 16);
        this.add(lblSconto);
        
        txtSconto = new JDisabledTextField();
        txtSconto.setColumns(10);
        txtSconto.setBounds(651, 34, 130, 26);
        this.add(txtSconto);
        
        JLabel lblTotale = new JLabel("Totale");
        lblTotale.setBounds(464, 478, 51, 16);
        this.add(lblTotale);
        
        txtTotale = new JDisabledTextField();
        txtTotale.setColumns(10);
        txtTotale.setBounds(516, 473, 130, 26);
        this.add(txtTotale);
        
        JButton btnQuantità = new JButton("Modifica Q.tà");
        btnQuantità.setBounds(651, 176, 117, 29);
        btnQuantità.addActionListener(new ActionListener(){
            @Override public void actionPerformed(ActionEvent e){
                int[] selected = table.getSelectedRows();
                if(selected.length != 1){
                    JOptionPane.showMessageDialog(root, "Non puoi modificare " + selected.length + ((selected.length != 0)?" elementi contemporaneamente":"elementi"), null, JOptionPane.ERROR_MESSAGE);
                    return;
                }
                
            }
        });
        this.add(btnQuantità);
        
        JButton btnRemoveitem = new JButton("Rimuovi");
        btnRemoveitem.setBounds(651, 207, 117, 29);
        btnRemoveitem.addActionListener(new ActionListener(){
            @Override public void actionPerformed(ActionEvent e){
                int[] selected = table.getSelectedRows();
                if (selected.length == 0) return;
                
                String pl = (selected.length == 1)?"o":"i";
                
                int res = JOptionPane.showConfirmDialog(
                              root,
                              "Rimuovere quest" + pl + " element" + pl + "?",
                              null,
                              JOptionPane.YES_NO_OPTION
                          );
                if(res == JOptionPane.NO_OPTION || res == JOptionPane.CLOSED_OPTION) return;
                
                for(int i : selected){
                    ModelCarrello.carrello.remove(tableModel.getValueAt(i, 4));
                }
                
                disegnaCarrello();
            }
        });
        this.add(btnRemoveitem);
        
        JLabel lblSubTotale = new JLabel("SubTotale");
        lblSubTotale.setBounds(651, 61, 81, 16);
        this.add(lblSubTotale);
            
        txtSubTotale = new JDisabledTextField();
        txtSubTotale.setBounds(651, 89, 130, 26);
        this.add(txtSubTotale);

        tableModel   = new DefaultTableModel(){
            @Override public boolean isCellEditable(int u1, int u2){
                return false;
            }
        };
        table = new JTable(tableModel);
        table.setFillsViewportHeight(true);
        table.getTableHeader().setReorderingAllowed(false);
        
        JScrollPane scroll = new JScrollPane(table);
        scroll.setBounds(6, 6, 630, 230);
        add(scroll);
        
        // Registro i listener
        btnAcquista.addActionListener(listenerCar);
        rdbtnAssicura.addActionListener(new ListenerCalcoloPrezzo());

        disegnaCarrello();
    }
    
    public static Object[] columnNames = {"Autore", "Titolo", "Prezzo", "Quantità", "__objid"};
    
    public void disegnaCarrello() {
        Object[][] data = null;
        int i = 0;
        float subTotale = 0.0f;
        // Creo il modello per la tabella solo se ho articoli nel carrello
        if (ModelCarrello.carrello.size() != 0) {
            data = new Object [ModelCarrello.carrello.size()][];
            for (ArticoloInCarrello a : ModelCarrello.carrello) {
                Object[] v = new Object[5];
                v[0] = a.getTitolare();
                v[1] = a.getTitolo();
                v[2] = a.getPrezzo().toString();
                v[3] = (Integer.toString(a.getQuantita()));
                v[4] = a;
                data[i] = v;
                i++;
                subTotale = subTotale + (a.getPrezzo().floatValue() * a.getQuantita());
            }
        }
        tableModel.setDataVector(data, columnNames);
        table.removeColumn(table.getColumn("__objid"));
        
        // Aggiorno il prezzo subtotale e totale
        txtSubTotale.setText("" + subTotale);
        if (rdbtnAssicura.isSelected()) {
            txtTotale.setText("" + (3 + Float.valueOf(txtSubTotale.getText()))); 
        }
        else {
            txtTotale.setText("" + subTotale);
        }
    }
    
    public class JDisabledTextField extends JTextField {
        public JDisabledTextField(){
            super();
            setEnabled(false);
        }
    }
    
    public class ListenerCalcoloPrezzo implements ActionListener {
        // Listener sui JRadioButton, per completare il calcolo del prezzo
        @Override public void actionPerformed(ActionEvent e) {
            JRadioButton rb = (JRadioButton) e.getSource();

            if (rb.getText().equals("Assicura il pacco")) {
                if (rdbtnAssicura.isSelected()) {
                    txtSpeseAssicurazione.setText("+3.00");
                    txtTotale.setText("" + (3 + Float.valueOf(txtSubTotale.getText())));
                }
                else {
                    txtSpeseAssicurazione.setText("");
                    txtTotale.setText(txtSubTotale.getText());
                }
            }
            
        }
        
    }
    
    public String getTotale() {
        return this.txtTotale.getText();
    }
    public String getMod() {
        if (rdbtnCorriere.isSelected()) {
            return "Corriere";
        }
        else if (rdbtnPostaOrdinaria.isSelected()) {
            return "Posta";
        }
        else {
            return "Rapida";
        }
    }
    public String getCC() {
        return this.txtCC.getText();
    }
}
