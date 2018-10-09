package View;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Image;
import java.io.File;
import java.net.MalformedURLException;

import javax.swing.*;

import Model.Articolo;

@SuppressWarnings("serial")
public class MyListCellRenderer extends RowPanel implements ListCellRenderer<Articolo> {
	Font font = new Font("Times", Font.BOLD, 18);

	@Override
	public Component getListCellRendererComponent(JList<? extends Articolo> list, Articolo a, int index,
			boolean isSelected, boolean cellHasFocus) {
		// Per la selezione di un elemento della lista
		if (isSelected) {
			setBackground(Color.LIGHT_GRAY);
			setForeground(Color.BLACK);
		}
		else {
			setBackground(Color.WHITE);
			setForeground(Color.BLACK);
		}

		// Id dell'articolo
	    String id = Integer.toString(a.getId());
		// Ricavo la copertina corrispondente
		ImageIcon copertina = null;
		try {
			copertina = new ImageIcon(new File("img/" + id + ".jpg").toURI().toURL());
			Image image = copertina.getImage(); // transform it 
			Image newimg = image.getScaledInstance(100, 100,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  
			copertina = new ImageIcon(newimg);  // transform it back
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	    // Creo la JLabel
		this.getImmagine().setIcon(copertina);
		this.getPrezzo().setText("€ " + a.getPrezzo().toString());
		this.getPrezzo().setHorizontalAlignment(SwingConstants.LEFT);
		this.getTesto().setText( a.getTitolare() + " - " + a.getTitolo());
		this.getTesto().setHorizontalAlignment(SwingConstants.LEFT);

		return this;
	}
}
