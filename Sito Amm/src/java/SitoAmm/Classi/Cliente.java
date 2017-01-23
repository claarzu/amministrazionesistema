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
    protected String merce;
    protected ArrayList<Carrello> listaProdotti = new ArrayList<Carrello>();
    /*creo il costruttore*/
    public Cliente()
    {
        super();      
    }
    
    public String getMerce()
    {
        return merce;
    }
    public void setMerce(String merce)
    {
        this.merce = merce;
    }
    
    
    public ArrayList<Carrello> getListaProdotti()
    {
        return listaProdotti;
    }
    public void setListaProdotti (ArrayList<Carrello> listaProdotti)
    {
        this.listaProdotti = listaProdotti;
    }
    
   
}
