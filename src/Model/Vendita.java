package Model;

import java.math.BigDecimal;
import java.util.Date;

/**
 * Classe che rappresenta la vendita degli articoli nel carrello di un cliente
 */
public class Vendita {
    private float prezzo;
    private Date data;
    private String modConsegna;
    private String modPagamento;
    private String codPagamento;
    private String ip;
    
    public Vendita(float p, Date d, String mC, String mP, String cP, String ip) {
        this.prezzo = p;
        this.data = d;
        this.modConsegna = mC;
        this.modPagamento = mP;
        this.codPagamento = cP;
        this.ip = ip;
    }
    
    public BigDecimal getPrezzoCompl() {
        return new BigDecimal(prezzo);
    }
    public Date getData() {
        return data;
    }
    public String getModC() {
        return modConsegna;
    }
    public String getModP() {
        return modPagamento;
    }
    public String getCodP() {
        return codPagamento;
    }
    public String getIP() {
        return ip;
    }
}
