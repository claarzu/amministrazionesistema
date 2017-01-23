package SitoAmm.Classi;

import java.util.ArrayList;
/**
 *
 * @author claar
 */
public class Carrello extends Cliente
{
    protected ArrayList<Cliente> listaProdotti = new ArrayList<Cliente>();
    protected ArrayList<Carrello> listaCarrello = new ArrayList<Carrello>();
    private int id;
    private Prodotti tipo;
    private float prezzo;
    
    public Prodotti getTipo()
    {
        return tipo;
    }
    public void setTipo(Prodotti tipo)
    {
        this.tipo = tipo;
    }
    
    public ArrayList<Carrello> getListaCarrello()
    {
        return listaCarrello;
    }
    public void setListaCarrello (ArrayList<Carrello> listaCarrello)
    {
        this.listaCarrello = listaCarrello;
    }
    
    public ArrayList<Cliente> getListaMerce()
    {
        return listaProdotti;
    }
    public void setListaMerce (ArrayList<Cliente> listaProdotti)
    {
        this.listaProdotti = listaProdotti;
    }
    
    @Override
    public int getId()
    {
        return id;
    }
    @Override
    public void setId(int id)
    {
        this.id = id;
    }
    
    public float getPrezzo()
    {
        return prezzo;
    }
    public void setPrezzo(float prezzo)
    {
        this.prezzo = prezzo;
    }
    
}
