package View;

import java.awt.*;
import java.io.File;
import java.net.MalformedURLException;
import java.util.HashMap;
import java.util.Map;

import javax.swing.*;

import Controller.ListenerProdotti;
import Controller.ListenerRicerca;
import Model.Articolo;
import Model.ModelRicerca;

@SuppressWarnings("serial")
public class ViewCatalogPanel extends JPanel {

    // Lista dei prodotti da visualizzare
    private static JList<Articolo> list;
    private JScrollPane scroll;
    
    // Listener sui bottoni
    private ListenerRicerca listenerRicerca = new ListenerRicerca(this);
    // Listener sulla lista dei prodotto
    private ListenerProdotti listenerProd;
    
    private JButton btnCerca;
    private JButton btnPulisci;
    
    // Tipi di ricerca
    private JRadioButton rdbtnMusicistaPartecipante;
    private JRadioButton rdbtnArtista;
    private JRadioButton rdbtnPrezzo;
    
    // Per i parametri di ricerca
    private JTextField textRicerca;
    
    private JComboBox<String> comboBox;
    private final String[] operatori = {"Minore o uguale a", "Uguale a", "Maggiore o uguale a"};
    
    public ViewCatalogPanel(){
        listenerProd = new ListenerProdotti(new DettaglioProdotto());
        
        // Lettura iniziale del catalogo
        ModelRicerca.leggiCatalogo();
        
        //questa view è AbsoluteLayout
        this.setLayout(null);
        
        //Aggiunge pulsanti label e altri elementi minori
        addMinorElements();
        
        // Ricerca di default è per artista
        rdbtnArtista.setSelected(true);
        
        // Aggiunge il catalogo iniziale
        disegnaCatalogo();
    }

    public void disegnaCatalogo() {
        if (scroll != null) {
            this.remove(scroll);
        }
        list = new JList<>(ModelRicerca.modelList());

        // background colors
        list.setBackground(Color.LIGHT_GRAY);
        list.setSelectionBackground(Color.black);
        
        // add scrolling pane on right
        scroll = new JScrollPane(list);
        
        
        scroll.setPreferredSize(new Dimension(500, 500));
        scroll.setBounds(6, 26, 599, 550);
        this.add(scroll);
        list.setCellRenderer(new MyListCellRenderer());
        
        list.addMouseListener(listenerProd);

    }

    // Metodo per aggiungere i componenti grafici attorno alla lista dei prodotti
    private void addMinorElements() {
        JLabel lblProdotti = new JLabel("Prodotti");
        lblProdotti.setBounds(283, 6, 61, 16);
        this.add(lblProdotti);

        JLabel lblRicerca = new JLabel("Ricerca");
        lblRicerca.setBounds(652, 43, 61, 16);
        this.add(lblRicerca);

        textRicerca = new JTextField();
        textRicerca.setBounds(652, 89, 130, 26);
        this.add(textRicerca);
        textRicerca.setColumns(10);

        btnCerca = new JButton("Cerca");
        btnCerca.setBounds(662, 127, 117, 29);
        this.add(btnCerca);

        btnPulisci = new JButton("Pulisci");
        btnPulisci.setBounds(665, 159, 117, 29);
        this.add(btnPulisci);
        
        
        // Aggiunta dei filtri
        rdbtnArtista = new JRadioButton("Artista");
        rdbtnArtista.setBounds(641, 288, 141, 16);
        this.add(rdbtnArtista);

        rdbtnMusicistaPartecipante = new JRadioButton("Musicista Partecipante");
        rdbtnMusicistaPartecipante.setBounds(641, 316, 141, 23);
        this.add(rdbtnMusicistaPartecipante);

        rdbtnPrezzo = new JRadioButton("Prezzo");
        rdbtnPrezzo.setBounds(641, 351, 141, 23);
        this.add(rdbtnPrezzo);

        // Raggruppo i radio buttons
        ButtonGroup group = new ButtonGroup();
        group.add(rdbtnArtista);
        group.add(rdbtnMusicistaPartecipante);
        group.add(rdbtnPrezzo);
        
        
        JLabel lblFiltriDiRicerca = new JLabel("Filtri Ricerca");
        lblFiltriDiRicerca.setBounds(641, 242, 94, 16);
        this.add(lblFiltriDiRicerca);
        
        JSeparator separator = new JSeparator();
        separator.setBounds(641, 260, 141, 16);
        this.add(separator);
        
        // Gli operatori di confronto per la ricerca per prezzo sono in un menu a tendina
        comboBox = new JComboBox<String>(operatori);
        comboBox.setBounds(641, 386, 138, 27);
        this.add(comboBox);
        
        JSeparator separator_1 = new JSeparator();
        separator_1.setBounds(641, 59, 141, 16);
        this.add(separator_1);
        
        // Registro il listener sui bottoni
        btnCerca.addActionListener(listenerRicerca);
        btnPulisci.addActionListener(listenerRicerca);
        
        // Registro il mouse listener sul campo di ricerca
        textRicerca.addMouseListener(listenerProd);
        
        //textRicerca.addKeyListener(listenerTyp);
        
    }
    
    @SuppressWarnings("deprecation")
    public static Map<String, ImageIcon> createImageMap(String[] list){
        Map<String, ImageIcon> map = new HashMap<>();        
        
        for (String s : list) {
            try {
                ImageIcon icona = new ImageIcon(new File("img/" + s + ".jpg").toURL()); //getClass().getResource("/img/"+ s + ".jpg"));
                Image image = icona.getImage(); // transform it 
                Image newimg = image.getScaledInstance(100, 100,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  
                icona = new ImageIcon(newimg);  // transform it back
                map.put(s, icona);
            } catch(MalformedURLException exc){
                System.err.println("Errore nel caricare le immagini jpg");
            }
        }
        return map;
    }
    
    // Metodi get per passare al listener i parametri di ricerca
    // La ricerca da eseguire
    public JRadioButton getRBartista() {
        return this.rdbtnArtista;
    }
    public JRadioButton getRBmusPart() {
        return this.rdbtnMusicistaPartecipante;
    }
    public JRadioButton getRBprezzo() {
        return this.rdbtnPrezzo;
    }
    // Parametro da ricercare
    public String getParamRicerca() {
        return this.textRicerca.getText();
    }
    
    public JTextField getTextRicerca() {
        return this.textRicerca;
    }
    
    
    // l'operatore in caso la ricerca sia sul prezzo
    public String getOperatore() {
        return (String) this.comboBox.getSelectedItem();
    }
    
    // Ritorna la lista degli articoli visualizzata attualmente
    public static JList<Articolo> getList() {
        return list;
    }
}

