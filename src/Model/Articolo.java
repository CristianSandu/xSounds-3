package Model;

import java.math.BigDecimal;
import java.sql.*;

/**
 * Classe degli articoli mostrati nel catalogo
 */
public class Articolo implements Comparable<Articolo> {
    private int id;
    private String titolo;
    private BigDecimal prezzo;
    private int quantitaMagazzino;
    private Date dataInNegozio;
    private String descrizione;
    private String tipoArticolo;    // CD o DVD
    private String copertina;       // Percorso per la copertina dell'articolo ("img/...")
    private String titolare;
    private String genere;
    
    public Articolo(int id, String titolo, BigDecimal prezzo, int quantitaMagazzino, Date dataInNegozio,
                    String descrizione, String tipoArticolo, String genere, String titolare,String copertina) {
        this.id = id;
        this.titolo = titolo;
        this.prezzo = prezzo;
        this.quantitaMagazzino = quantitaMagazzino;
        this.dataInNegozio = dataInNegozio;
        this.descrizione = descrizione;
        this.tipoArticolo = tipoArticolo;
        this.titolare = titolare;
        this.genere = genere;
        this.copertina = copertina;
    }
    
    // Oggetti creati durante la ricerca nel catalogo
    public Articolo(ResultSet rs) throws SQLException {
        id                = rs.getInt("id");
        titolo            = rs.getString("titolo");
        prezzo            = rs.getBigDecimal("prezzo");
        quantitaMagazzino = rs.getInt("quantita");
        dataInNegozio     = rs.getDate("data");
        descrizione       = rs.getString("descr");
        tipoArticolo      = rs.getString("tipo");
        titolare          = rs.getString("nome_arte");
        genere            = rs.getString("genere");
        copertina         = rs.getString("copertina");
    }
    
    // Per test
    @Override public String toString(){
        return "ID Articolo : " + id + "\n" + "Titolo  album :  " + titolo + "\n"+ "Prezzo : " + prezzo + "\n" 
             + "Quantità disponibile : " + quantitaMagazzino + "\n" + "Tipo articolo : " + tipoArticolo + "\n"
             + "Genere : " + genere + "\n" + "Titolare : " + titolare + "\n" + "\nDescrizione: " + descrizione + "\n"
             + "Path copertina: " + copertina;
    }
    
    // Metodi get e set
    public int getId() {
        return this.id;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    public String getTitolo(){
        return this.titolo;
    }
    public void setTitolo(String titolo){
        this.titolo=titolo;
    }
    public BigDecimal getPrezzo(){
        return this.prezzo;
    }
    public  int getQuantitaMagazzino(){
        return this.quantitaMagazzino;
    }
    public Date getDataInNegozio(){
        return this.dataInNegozio;
    }
    public String getDescrizione(){
        return this.descrizione;
    }
    public String getTipoArticolo(){
        return this.tipoArticolo;
    }
    public String getTitolare(){
        return this.titolare;
    }
    public String getGenere(){
        return this.genere;
    }
    public String getCopertina(){
        return this.copertina;
    }
    public void setData(Date data){
        this.dataInNegozio=data;
    }
    
    // Metodi per il confronto tra articoli
    @Override public boolean equals(Object other){
        if (other instanceof Articolo) {
            Articolo otherArt = (Articolo) other;
            return this.id == otherArt.id;
        }
        return false;
    }
    
    // Metodo per l'ordinamento di articoli
    @Override public int compareTo(Articolo other) {
        return this.id-other.id;
        
    }
    
}
