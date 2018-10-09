package View;

import java.awt.BorderLayout;


import javax.swing.*;

@SuppressWarnings("serial")
public class RowPanel extends JPanel{

	private JLabel immagine;
	private JLabel testo;
	private JLabel prezzo;

	
	public RowPanel(){ 
	
		this.setLayout(new BorderLayout(0, 0));

		immagine = new JLabel("");
		testo = new JLabel("");
		prezzo = new JLabel("");

		this.add(immagine, BorderLayout.WEST);
		this.add(testo, BorderLayout.CENTER);
		this.add(prezzo, BorderLayout.EAST);

		

	}


	public JLabel getImmagine() {
		return immagine;
	}


	public void setImmagine(JLabel immagine) {
		this.immagine = immagine;
	}


	public JLabel getTesto() {
		return testo;
	}


	public void setTesto(JLabel testo) {
		this.testo = testo;
	}


	public JLabel getPrezzo() {
		return prezzo;
	}


	public void setPrezzo(JLabel prezzo) {
		this.prezzo = prezzo;
	}
}
