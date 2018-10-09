package View;

import java.awt.Color;
import java.awt.Image;
import java.awt.Toolkit;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;

import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JTabbedPane;
import javax.swing.UIManager;

@SuppressWarnings("serial")
public class PRGFrame extends JFrame {
    
    public static JFrame rootparent;
    
    public PRGFrame() throws IOException {
        super("xSounds");
        
        rootparent = this;
    
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        UIManager.put("TabbedPane.selected", Color.GRAY);
        JTabbedPane tabbedPane = new JTabbedPane();
        
        ImageIcon catalogo = createImageIconAndScale("catalogo.png");
        JComponent panel1 = new ViewCatalogPanel();
        tabbedPane.addTab("Visualizza Catalogo", catalogo, panel1);
        
        ImageIcon login = createImageIconAndScale("login.png");
        JComponent panel2 = new Accedi();
        tabbedPane.addTab("Accedi\\Registrati", login, panel2);

        ImageIcon carrello = createImageIconAndScale("carrello.png");
        JComponent panel3 = ViewCart.getInstance();
        tabbedPane.addTab("Visualizza carrello", carrello, panel3);

        ImageIcon assistenza = createImageIconAndScale("assistenza.png");
        JComponent panel4 = new ContactUs();
        tabbedPane.addTab("Assistenza clienti", assistenza, panel4);

        tabbedPane.setTabLayoutPolicy(JTabbedPane.SCROLL_TAB_LAYOUT);
        tabbedPane.setBackgroundAt(1, Color.BLACK);
        tabbedPane.setBackgroundAt(2, Color.BLACK);
        tabbedPane.setBackgroundAt(3, Color.BLACK);
        tabbedPane.setBackgroundAt(0, Color.BLACK);
        
        this.add(tabbedPane);

        this.pack();

        this.setSize(800,600);

        this.setLocationRelativeTo(null);

        this.setResizable(false);

        Image icon = Toolkit.getDefaultToolkit().getImage("x.png");  
        this.setIconImage(icon);  

        this.setVisible(true);
    }

    // Ritorna un'ImageIcon oppure null se il path non è valido
    public static ImageIcon createImageIcon(String path) {
        java.net.URI imgURI = null;
        java.net.URL imgURL = null;
        try {
            imgURI = new File(path).toURI(); 
            imgURL = imgURI.toURL();
        } catch(MalformedURLException exc){
            // pass
        }
        if (imgURL != null) {
            return new ImageIcon(imgURL);
        } else {
            System.err.println("Couldn't find file: " + path);
            return null;
        }
    }
    
    // Metodo per il caricamento delle icone
    public static ImageIcon createImageIconAndScale(String path) {
        ImageIcon icon = null;
        java.net.URI imgURI = null;
        java.net.URL imgURL = null;
        try {
            imgURI = new File("img/" + path).toURI();
            imgURL = imgURI.toURL();
        } catch (MalformedURLException e) {
            // pass
        }
        if (imgURL != null) {
            icon = new ImageIcon(imgURL); 
            Image image = icon.getImage(); // transform it 
            Image newimg = image.getScaledInstance(15, 15,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  
            icon = new ImageIcon(newimg);  // transform it back
        }
        return icon;
    }
    
    public JFrame getFrame(){
        return this;
    }
}
