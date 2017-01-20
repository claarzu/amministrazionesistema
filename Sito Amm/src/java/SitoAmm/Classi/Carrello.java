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
public class Carrello {
    private Prodotti id;
    private Prodotti tipo;
    private Prodotti prezzo;
    
    public Prodotti getTipo()
    {
        return tipo;
    }
    public void setTipo(Prodotti tipo)
    {
        this.tipo = tipo;
    }
    
    public Prodotti getId()
    {
        return id;
    }
    public void setId(Prodotti id)
    {
        this.id = id;
    }
    
    public Prodotti getPrezzo()
    {
        return prezzo;
    }
    public void setPrezzo(Prodotti prezzo)
    {
        this.prezzo = prezzo;
    }
    
}
