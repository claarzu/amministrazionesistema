package SitoAmm.Classi;

import java.util.ArrayList;

/**
 *
 * @author claar
 */
public class Prodotti {
    private int id;
    private String tipo;
    private float prezzo;
    protected ArrayList<Prodotti> ListaProdotti = new ArrayList<Prodotti>();

    
    public int getId()
    {
        return id;
    }    
    public void setId(int id)
    {
        this.id = id;
    }

    public String getTipo()
    {
        return tipo;
    }    
    public void setTipo(String tipo)
    {
        this.tipo = tipo;
    }
    
    public float getPrezzo()
    {
        return prezzo;
    }    
    public void setPrezzo(float prezzo)
    {
        this.prezzo = prezzo;
    }
    
    public ArrayList<Prodotti> getListaProdotti()
    {
           return ListaProdotti;     
    }    
    public void setListaProdotti (ArrayList<Prodotti> ListaProdotti)
    {
        this.ListaProdotti = ListaProdotti;
    }
}
