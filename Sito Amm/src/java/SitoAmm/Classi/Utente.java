/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SitoAmm.Classi;

/**
 *
 * @author claar
 */
public abstract class Utente {
    // creo gli attributi della classe
    protected int id;
    protected String nome;
    protected String cognome;
    protected String indirizzo;
    protected int cap;
    protected String citta;
    protected String email;
    protected String username;
    protected String password;
    protected String c_password;
    
    // creo il costruttore della classe
    public Utente()
    {
        id = 0;
        nome = "";
        cognome = "";
        indirizzo = "";
        cap = 0;
        citta = "";
        email = "";
        username = "";
        password = "";
        c_password = "";
        
    }
    
    public int getId()
    {
        return id;
    }
    
    public void setId(int id)
    {
        this.id = id;
    }
    
    public String getNome()
    {
        return nome;
    }
    
    public void setNome(String nome)
    {
        this.nome = nome;
    }
    
    public String getCognome()
    {
        return cognome;
    }
    
    public void setCognome(String cognome)
    {
        this.cognome = cognome;
    }
    
    public String getIndirizzo()
    {
        return indirizzo;
    }
    
    public void setIndirizzo(String indirizzo)
    {
        this.indirizzo = indirizzo;
    }
    
     public int getCap()
    {
        return cap;
    }
    
    public void setCap(int cap)
    {
        this.cap = cap;
    }
    
    public String getCitta()
    {
        return citta;
    }
    
    public void setCitta(String citta)
    {
        this.citta = citta;
    }
    
    public String getEmail()
    {
        return email;
    }
    
    public void setEmail(String email)
    {
        this.email = email;
    }
    
    public String getUsername()
    {
        return username;
    }
    
    public void setUsername(String username)
    {
        this.username = username;
    }
    
    public String getPassword()
    {
        return password;
    }
    
    public void setPassword(String password)
    {
        this.password = password;
    }
    
    public String getCPassword()
    {
        return c_password;
    }
    
    public void setCPassword(String c_password)
    {
        this.c_password = c_password;
    }
}
