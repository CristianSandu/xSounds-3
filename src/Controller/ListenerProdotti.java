package Controller;

import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.net.MalformedURLException;

import javax.swing.*;

import Model.ModelRicerca;
import View.DettaglioProdotto;
import View.ViewCatalogPanel;

public class ListenerProdotti implements MouseListener {

    private DettaglioProdotto frmDettaglioProdotto;

    public ListenerProdotti(DettaglioProdotto frmDettaglioProdotto) {
        this.frmDettaglioProdotto = frmDettaglioProdotto;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        // Se viene fatto un doppio click il cliente apre un elemento della lista
        if (e.getClickCount() == 2 && !e.isConsumed()) {
            e.consume();
            
            // Reset della quantità di acquisto
            frmDettaglioProdotto.setQuantitaAcquisto(1);
            
            // Recupero la posizione nel set di articoli
            int index = ViewCatalogPanel.getList().locationToIndex(e.getPoint());
            
            // Setto i campi della schermata Dettagli
            frmDettaglioProdotto.setArticolo(ModelRicerca.setArticoli.get(index));
            
            try {
                ImageIcon icon = new ImageIcon(new File(ModelRicerca.setArticoli.get(index).getCopertina()).toURI().toURL());
                Image image = icon.getImage(); // transform it 
                Image newimg = image.getScaledInstance(230, 280,  java.awt.Image.SCALE_SMOOTH);
                icon = new ImageIcon(newimg);
                frmDettaglioProdotto.setCopertina(icon);
            } catch (MalformedURLException ex) {
                // TODO Auto-generated catch block
                ex.printStackTrace();
            }
            frmDettaglioProdotto.setVisible(true);
        }

    }

    @Override
    public void mousePressed(MouseEvent e) {
        // TODO Auto-generated method stub
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        // TODO Auto-generated method stub
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        // TODO Auto-generated method stub
    }

    @Override
    public void mouseExited(MouseEvent e) {
        // TODO Auto-generated method stub
    }

}
