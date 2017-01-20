/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SitoAmm.Classi;

import java.util.ArrayList;
/**
 *
 * @author claar
 */
public class Cliente extends Utente
{
    protected ArrayList<Carrello> listaProdotti = new ArrayList<Carrello>();
    /*creo il costruttore*/
    public Cliente()
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
    
    
    public int getIdcl()
    {
        return id;
    }
    
   
    public void setIdcl(int id)
    {
        this.id = id;
    }
    
    
    public String getNomecl()
    {
        return nome;
    }
    
    
    public void setNomecl(String nome)
    {
        this.nome = nome;
    }
    

    public String getCognomecl()
    {
        return cognome;
    }
    
    
    public void setCognomecl(String cognome)
    {
        this.cognome = cognome;
    }
    
    
    public String getIndirizzocl()
    {
        return indirizzo;
    }
    
    
    public void setIndirizzocl(String indirizzo)
    {
        this.indirizzo = indirizzo;
    }
    
    
     public int getCapcl()
    {
        return cap;
    }
    
    public void setCapcl(int cap)
    {
        this.cap = cap;
    }
    
    public String getCittacl()
    {
        return citta;
    }
    
    public void setCittacl(String citta)
    {
        this.citta = citta;
    }
    
    public String getEmailcl()
    {
        return email;
    }
    
    public void setEmailcl(String email)
    {
        this.email = email;
    }
    
    public String getUsernamecl()
    {
        return username;
    }
    
    public void setUsernamecl(String username)
    {
        this.username = username;
    }
    
    public String getPasswordcl()
    {
        return password;
    }
    
    public void setPasswordcl(String password)
    {
        this.password = password;
    }
    
    public String getCPasswordcl()
    {
        return c_password;
    }
    
    public void setCPasswordcl(String c_password)
    {
        this.c_password = c_password;
    }
    
    public ArrayList<Carrello> getProdotti()
    {
        return listaProdotti;
    }
    
}
