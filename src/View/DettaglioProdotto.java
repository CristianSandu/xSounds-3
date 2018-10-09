package View;

import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.net.MalformedURLException;

import javax.swing.*;
import javax.swing.JSpinner.DefaultEditor;

import Controller.ControllerCarrello;
import Model.Articolo;

@SuppressWarnings("serial")
public class DettaglioProdotto extends JDialog {
	public final DettaglioProdotto root = this;

	// Istanza dell'articolo che sto visualizzando
	public Articolo articoloVisualizzato;

	private JTextPane textArtista;
	private JTextPane textTitolo;
	private JTextPane textPrezzo;
	private JTextPane textDescr;
	private JTextPane textDisponibilità;
	private JTextPane textDataInNegozio;
	private JTextPane textGenere;
	private JTextPane textTipo;

	private JLabel lblCopertina;

	// Componenti che generano eventi da gestire
	private JSpinner spinner;
	private JButton btnCarrello;
	private JButton btnEsci;
	private JButton btnProcedi;

	// Player ////
	private JButton buttonPlay = new JButton("Play");
	private JButton buttonPause = new JButton("Pause");
	private JLabel labelTimeCounter = new JLabel("00:00:00");
	private JSlider sliderTime = new JSlider();
    //////
	
	public ImageIcon iconPlay = createImageIcon("Play.gif");
	public ImageIcon iconStop = createImageIcon("Stop.gif");
	public ImageIcon iconPause = createImageIcon("Pause.png");
	
	
	public DettaglioProdotto() {
		super(PRGFrame.rootparent, true);

		this.setDefaultCloseOperation(HIDE_ON_CLOSE);
		this.setLayout(null);
		this.pack();
		this.setSize(600, 600);
		this.setLocationRelativeTo(null);
		lblCopertina = new JLabel("");
		lblCopertina.setBounds(20, 20, 250, 300);
		this.add(lblCopertina);

		JLabel lblArtista = new JLabel("Artista");
		lblArtista.setBounds(295, 90, 61, 16);
		this.add(lblArtista);

		textArtista = new JTextPane();
		textArtista.setText("Never mind");
		textArtista.setBounds(295, 118, 267, 16);
		this.add(textArtista);

		textTitolo = new JTextPane();
		textTitolo.setText("Never mind");
		textTitolo.setBounds(295, 174, 267, 16);
		this.add(textTitolo);

		JLabel lblTitolo = new JLabel("Titolo");
		lblTitolo.setBounds(295, 146, 61, 16);
		this.add(lblTitolo);

		JLabel lblPrezzo = new JLabel("Prezzo");
		lblPrezzo.setBounds(295, 202, 61, 16);
		this.add(lblPrezzo);

		textPrezzo = new JTextPane();
		textPrezzo.setBounds(295, 230, 45, 16);
		this.add(textPrezzo);

		JLabel lblDescrizione = new JLabel("Descrizione:");
		lblDescrizione.setBounds(20, 332, 86, 16);
		this.add(lblDescrizione);

		textDescr = new JTextPane();
		textDescr.setText("Never mind");
		textDescr.setBounds(20, 360, 542, 64);
		this.add(textDescr);

		btnEsci = new JButton("Indietro");
		btnEsci.setBounds(477, 543, 117, 29);
		this.add(btnEsci);

		btnProcedi = new JButton("Acquista");
		btnProcedi.setBounds(348, 543, 117, 29);
		this.add(btnProcedi);

		btnCarrello = new JButton("");
		ImageIcon icon = new ImageIcon("img/carrello.png");
		Image image = icon.getImage(); // transform it 
		Image newimg = image.getScaledInstance(50, 50,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  
		icon = new ImageIcon(newimg);  // transform it back    
		btnCarrello.setVerticalAlignment(SwingConstants.BOTTOM);
		btnCarrello.setBackground(Color.LIGHT_GRAY);
		btnCarrello.setOpaque(true);
		btnCarrello.setContentAreaFilled(false);
		btnCarrello.setFocusPainted(false);
		btnCarrello.setBorderPainted(false);
		btnCarrello.setIcon(icon);
		btnCarrello.setBounds(486, 17, 76, 62);
		this.add(btnCarrello);

		// Modello per lo spinner
		SpinnerModel sm = new SpinnerNumberModel(1, 1, 10, 1);

		spinner = new JSpinner(sm);
		spinner.setBounds(398, 39, 76, 26);
		JFormattedTextField tf = ((DefaultEditor) spinner.getEditor()).getTextField();
		tf.setEditable(false);
		spinner.setValue(new Integer(1));    // Valore di default iniziale
		this.add(spinner);

		JLabel lblSelezionaQuantit = new JLabel("Seleziona quantità:");
		lblSelezionaQuantit.setBounds(282, 44, 116, 16);
		this.add(lblSelezionaQuantit);

		JLabel lblAggiungiAlCarrello = new JLabel("Aggiungi");
		lblAggiungiAlCarrello.setBounds(496, 90, 66, 16);
		this.add(lblAggiungiAlCarrello);

		JLabel lblQuantitDisponibili = new JLabel("Disponibilità");
		lblQuantitDisponibili.setBounds(363, 202, 86, 16);
		this.add(lblQuantitDisponibili);

		textDisponibilità = new JTextPane();
		textDisponibilità.setBounds(363, 230, 86, 16);
		this.add(textDisponibilità);

		JLabel lblInNegozioDal = new JLabel("In negozio dal");
		lblInNegozioDal.setBounds(473, 436, 89, 16);
		this.add(lblInNegozioDal);

		textDataInNegozio = new JTextPane();
		textDataInNegozio.setBounds(473, 464, 89, 16);
		this.add(textDataInNegozio);

		JLabel lblGenere = new JLabel("Genere");
		lblGenere.setBounds(373, 258, 61, 16);
		this.add(lblGenere);

		textGenere = new JTextPane();
		textGenere.setBounds(363, 286, 89, 16);
		this.add(textGenere);

		JLabel lblTipo = new JLabel("Tipo");
		lblTipo.setBounds(295, 258, 36, 16);
		this.add(lblTipo);

		textTipo = new JTextPane();
		textTipo.setBounds(295, 286, 45, 16);
		this.add(textTipo);

		textArtista.setEditable(false);
		textTitolo.setEditable(false);
		textPrezzo.setEditable(false);
		textDataInNegozio.setEditable(false);
		textDescr.setEditable(false);
		textDisponibilità.setEditable(false);
		textGenere.setEditable(false);
		textTipo.setEditable(false);

		//////////////////////////Codice del Player//////////////////////////////
		buttonPlay.setIcon(iconPlay);
		buttonPlay.setEnabled(true);
		buttonPlay.setBounds(20, 500, 77, 29);
		this.add(buttonPlay);

		buttonPause.setIcon(iconPause);
		buttonPause.setEnabled(true);
		buttonPause.setBounds(100, 500, 77, 29);
		this.add(buttonPause);

		labelTimeCounter.setBounds(180, 500, 77, 29);
		this.add(labelTimeCounter);

		sliderTime.setBounds(20, 470, 200, 29);
		this.add(sliderTime);
		///////////////////////////////////////////////////////////////////////

		// Registro sul listener i bottoni
		ActionListener nextListener = new ActionListener(){
			@Override public void actionPerformed(ActionEvent e){
				int q = getQuantitaAcquisto();

				if (q <= 0){
					JOptionPane.showMessageDialog(root, "Inserisci il numero di copie che vuoi acquistare", null, JOptionPane.INFORMATION_MESSAGE);
					return;
				}

				ControllerCarrello.aggiungiAlCarrello(q, articoloVisualizzato);
				ViewCart.getInstance().disegnaCarrello();
			}
		};

		btnCarrello.addActionListener(nextListener);
		btnProcedi.addActionListener(nextListener);

		btnEsci.addActionListener(new ActionListener(){
			@Override public void actionPerformed(ActionEvent e){
				setVisible(false);
			}
		});

	}

	// Metodi set per riempire il frame dei dettagli con le informazioni sul prodotto
	public void setArticolo(Articolo a){
		articoloVisualizzato = a;

		textTitolo.setText(a.getTitolo());
		textPrezzo.setText(a.getPrezzo().toString());
		textArtista.setText(a.getTitolare());
		textDescr.setText(a.getDescrizione());
		textDisponibilità.setText("" + a.getQuantitaMagazzino());
		textDataInNegozio.setText(a.getDataInNegozio().toString());
		textGenere.setText(a.getGenere());
		textTipo.setText(a.getTipoArticolo());

		setTitle(a.getTitolare() + " - " + a.getTitolo());
	}

	public void setCopertina(ImageIcon copertina) {
		lblCopertina.setIcon(copertina);
	}

	// Metodi get per ottenere le informazioni sull'aggiunta in carrello
	public int getQuantitaAcquisto() {
		return (int)this.spinner.getValue();
	}
	public void setQuantitaAcquisto(int q) {
		this.spinner.setValue(q);
	}


	public static ImageIcon createImageIcon(String path) {
		ImageIcon icon = null;
		java.net.URI imgURI = null;
		java.net.URL imgURL = null;
		try {
			imgURI = new File("img/" + path).toURI();
			imgURL = imgURI.toURL();
		} catch (MalformedURLException e) {
			// pass
		}

		if (imgURL != null) 
			icon = new ImageIcon(imgURL);

		return icon;

	}


}
