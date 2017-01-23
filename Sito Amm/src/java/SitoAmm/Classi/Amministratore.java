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


public class Amministratore extends Utente {
    
    protected String prodotti;
    protected ArrayList<Prodotti> dispensaProdotti = new ArrayList<Prodotti>();
    
    /*creo il costruttore*/
    public Amministratore()
    {
        super();
      
    }
    
    public String getProdotti()
    {
        return prodotti;
    }
    public void setProdotti(String prodotti)
    {
        this.prodotti = prodotti;
    }
    
    public ArrayList<Prodotti> getDispensaProdotti()
    {
        return dispensaProdotti;
    }
    public void setDispensaProdotti (ArrayList<Prodotti> dispensaProdotti)
    {
        this.dispensaProdotti = dispensaProdotti;
    }
    
 }
