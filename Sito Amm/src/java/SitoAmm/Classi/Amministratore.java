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


public class Amministratore extends Utente {
    
    /*creo il costruttore*/
    public Amministratore()
    {
        super();
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
    
    
    public int getIdad()
    {
        return id;
    }
    
   
    public void setIdad(int id)
    {
        this.id = id;
    }
    
    
    public String getNomead()
    {
        return nome;
    }
    
    
    public void setNomead(String nome)
    {
        this.nome = nome;
    }
    

    public String getCognomead()
    {
        return cognome;
    }
    
    
    public void setCognomead(String cognome)
    {
        this.cognome = cognome;
    }
    
    
    public String getIndirizzoad()
    {
        return indirizzo;
    }
    
    
    public void setIndirizzoad(String indirizzo)
    {
        this.indirizzo = indirizzo;
    }
    
    
     public int getCapad()
    {
        return cap;
    }
    
    public void setCapad(int cap)
    {
        this.cap = cap;
    }
    
    public String getCittaad()
    {
        return citta;
    }
    
    public void setCittaad(String citta)
    {
        this.citta = citta;
    }
    
    public String getEmailad()
    {
        return email;
    }
    
    public void setEmailad(String email)
    {
        this.email = email;
    }
    
    public String getUsernamead()
    {
        return username;
    }
    
    public void setUsernamead(String username)
    {
        this.username = username;
    }
    
    public String getPasswordad()
    {
        return password;
    }
    
    public void setPasswordad(String password)
    {
        this.password = password;
    }
    
    public String getCPasswordad()
    {
        return c_password;
    }
    
    public void setCPasswordad(String c_password)
    {
        this.c_password = c_password;
    }
    
    
}
