package Model;

/**
 * Classe per gli articoli inseriti nel carrello
 */
public class ArticoloInCarrello extends Articolo {
    
    // Campi aggiunti
    private int quantitaAcquisto;
    
    public ArticoloInCarrello(int q, Articolo a) {
        super(a.getId(),
              a.getTitolo(),
              a.getPrezzo(),
              a.getQuantitaMagazzino(),
              a.getDataInNegozio(),
              a.getDescrizione(),
              a.getTipoArticolo(),
              a.getGenere(),
              a.getTitolare(),
              a.getCopertina()
            );
            this.quantitaAcquisto = q;
    }
    
    // Metodi get e set per modificare la quantità nel carrello
    public int getQuantita() {
        return this.quantitaAcquisto;
    }
    public void setQuantita(int q) {
        this.quantitaAcquisto = q;
    }
    
    @Override public String toString() {
        float prezzo = getPrezzo().floatValue() * quantitaAcquisto;
        return "- num. " + quantitaAcquisto + " " + getTipoArticolo() + " \"" + 
               getTitolo() + "\" - " + getTitolare() + " - Prezzo: " + prezzo;
    }
}
