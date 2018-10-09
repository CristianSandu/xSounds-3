package Model;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Classe per rappresentare un cliente nell'applicazione 
 */
public class Cliente {
    private String cod_fis;
    private String nome_utente;
    private String nome;
    private String cognome;
    private String citta;
    private String email;
    private String password;
    private String n_tel;
    private String n_cel;
    private Date dataNascita;
    
    // Cliente "vuoto"
    public Cliente() {
        this.cod_fis = "";
        this.nome_utente = "";
        this.nome = "";
        this.cognome = "";
        this.citta = "";
        this.email = "";
        this.password = "";
        this.n_tel = "";
        this.n_cel = "";
        this.password = "";
        this.dataNascita = null;
    }
    
    // Cliente caricato dal database
    public Cliente(ResultSet rs) throws SQLException {
        cod_fis     = rs.getString("cod_fis");
        nome_utente = rs.getString("nome_utente");
        nome        = rs.getString("nome");
        cognome     = rs.getString("cognome");
        citta       = rs.getString("citta");
        email       = rs.getString("email");
        password    = rs.getString("password");
        n_tel       = rs.getString("n_tel");
        n_cel       = rs.getString("n_cel");
        dataNascita = rs.getDate("data");
    }
    
    // Metodi get e set
    // Codice fiscale
    public String getCodFis(){
        return cod_fis;
    }
    public void setCodFis(String codf){
        this.cod_fis = codf;
    }
    // Username
    public void setUsername(String nome_utente){
        this.nome_utente = nome_utente;
    }
    public String getUsername(){
        return nome_utente;
    }
    // Nome
    public void setNome(String nome){
        this.nome = nome;
    }
    public String getNome(){
        return nome;
    }
    // Cognome
    public void setCognome(String cognome){
        this.cognome=cognome;
    }
    public String getCognome(){
        return cognome;
    }
    // Città
    public String getCitta() {
        return citta;
    }
    public void setCitta(String citta) {
        this.citta = citta;
    }
    // Email
    public String getEMail() {
        return email;
    }
    public void setEMail(String email) {
        this.email = email;
    }
    // Password
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    // N telefono
    public String getNTel() {
        return n_tel;
    }
    public void setNTel(String n_tel) {
        this.n_tel = n_tel;
    }
    // N Cellulare
    public String getNCel() {
        return n_cel;
    }
    public void setNCel(String n_cel) {
        this.n_cel = n_cel;
    }
    // Data di nascita
    public Date getData() {
        return this.dataNascita;
    }
    public void setData(Date d) {
        this.dataNascita = d;
    }
    
    // Per test
    public String toString() {
        return "CodF: " + cod_fis + '\n' +
               "Username: " + nome_utente + '\n' +
               "Nome: " + nome + '\n' +
               "Cognome: " + cognome + '\n' +
               "Città: " + citta + '\n' +
               "EMail: " + email + '\n' +
               "Password: " + password + '\n' +
               "NTel: " + n_tel + '\n' +
               "Data: " + dataNascita; 
    }
}
