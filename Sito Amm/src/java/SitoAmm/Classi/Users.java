package SitoAmm.Classi;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author Claudio Arzu
 */
public class Users {
    
    private static Users istanza;
    String connessione = "jdbc:derby://localhost:1527/ammdb";
    
    /*garantisco che venga creata una e una sola istanza e fornisco un punto di accesso globale a tale istanza.*/
    public static Users getInstance(){
        if (istanza == null){            
            istanza = new Users();
        }
        return istanza;
    }
    
    // Costruttore
    private Users(){
        
    }
    
    
    
    public Utente getUtente(String username, String password)
    {
        try
        {
            Connection conn = DriverManager.getConnection(connessione, "Claudio", "Arzu");
            // SQL 
            String query = "select * from amministratore where "
                    + "password = ? and username = ?";
            PreparedStatement stat = conn.prepareStatement(query);
            // dati
            stat.setString(1, password);
            stat.setString(2, username);
            //
            ResultSet set = stat.executeQuery();
            
            if(set.next())
            {
                Amministratore admin = new Amministratore();
                admin.id = set.getInt("id");
                admin.nome = set.getString("nome");
                admin.cognome = set.getString("cognome");
                admin.username = set.getString("username");
                admin.password = set.getString("password");
                admin.prodotti = set.getString("prodotti");
                
                query = "select prodotti.id, prodotti.tipo * from prodotti"
                        + "where prodotti.idAmministratore="+admin.id;
                Statement st = conn.createStatement();
                ResultSet res2 = st.executeQuery(query);
                while(res2.next())
                {
                    Prodotti p = new Prodotti();
                    p.setId(res2.getInt("id"));
                    p.setTipo(res2.getString("tipo"));
                    admin.dispensaProdotti.add(p);
                }
                st.close();
                stat.close();
                conn.close();
                
                return admin;
            }
            
            //Clienti
            query = "select * from cliente where "
                    + "password = ? and username = ?";
            stat = conn.prepareStatement(query);
            // dati
            stat.setString(1, password);
            stat.setString(2, username);
            
            set = stat.executeQuery();
            
            if(set.next())
            {
                Cliente cliente = new Cliente();
                cliente.id = set.getInt("id");
                cliente.nome = set.getString("nome");
                cliente.cognome = set.getString("cognome");
                cliente.username = set.getString("username");
                cliente.password = set.getString("password");
                cliente.c_password = set.getString("c_password");
                cliente.merce = set.getString("merce"); 
                
                query = "select prodotti.id, prodotti.tipo * from prodotti"
                        + "join carrello"
                        + "on prodotti.id = carrello.idProdotto"
                        + "where carrello.clienteId="+cliente.id;
                Statement st2 = conn.createStatement();
                ResultSet res3 = st2.executeQuery(query);
                while(res3.next())
                {
                    Carrello c = new Carrello();
                    Prodotti p2 = new Prodotti();
                    c.setId(res3.getInt("id"));
                    p2.setTipo(res3.getString("tipo"));
                    cliente.listaProdotti.add(c);
                }
                st2.close();
                stat.close();
                conn.close();
                return cliente;
            }            
            stat.close();
            conn.close();
        }// chiude il try
        catch(SQLException e)
        {
            
        }
        return null;
    }
    
    /*ricerca dell'utente amministratore per ID, nel caso in cui l'ID cercato non esista
    verrà restituito null*/    
    public Utente getAmministratore(int id)
    {
        try {
            Connection conn = DriverManager.getConnection(connessione, "Claudio", "Arzu");
            String query = "select * from amministratore" 
                    + "where id = ?";
            PreparedStatement stat = conn.prepareStatement(query);
            //adesso associo i valori
            stat.setInt(1, id);
            //eseguo la query
            ResultSet ris = stat.executeQuery();
            
            //ora controllo quante sono le righe presenti nel db AMMINISTRATORE
            if (ris.next()) 
            {
                Amministratore admin = new Amministratore();
                admin.setId(ris.getInt("id"));
                admin.setNome(ris.getString("nome"));
                admin.setCognome(ris.getString("cognome"));
                admin.setUsername(ris.getString("username"));
                admin.setPassword(ris.getString("password"));
                admin.setProdotti("prodotti");
                
                query = "select prodotti.id, prodotti.tipo * from prodotti"
                        + "join amministratore"
                        + "on prodotti.id = prodotti.idAmministratore"
                        + "where prodotti.idAmministratore="+admin.id;
                Statement st = conn.createStatement();
                ResultSet ris2 = st.executeQuery(query);
                while(ris2.next())
                {
                    Prodotti p = new Prodotti();
                    p.setId(ris2.getInt("id"));
                    p.setTipo(ris2.getString("tipo"));
                    admin.dispensaProdotti.add(p);
                }
                st.close();
                stat.close();
                conn.close();
                return admin;                
            }
            stat.close();
            conn.close();
            
        }catch (SQLException e)
        {
            e.printStackTrace();
        }
        return null;
    }
    // Lista amministratori
    public ArrayList<Amministratore> getAmministratori()
    {
        ArrayList<Amministratore> listaAdmin = new ArrayList<Amministratore>();
        try 
        {
            Connection conn = DriverManager.getConnection(connessione, "Claudio", "Arzu");
            Statement stat = conn.createStatement();
            String query = "select * from amministratore";
            
            ResultSet set = stat.executeQuery(query);
            
            //righe restitute dal ciclo
            while(set.next()) 
            {
                Amministratore admin = new Amministratore();
                admin.setId(set.getInt("id"));
                admin.setNome(set.getString("nome"));
                admin.setCognome(set.getString("cognome"));
                admin.setUsername(set.getString("username"));
                admin.setPassword(set.getString("password"));
                admin.setProdotti(set.getString("prodotti"));
                listaAdmin.add(admin);
            } 
            
            stat.close();
            conn.close();
        } 
        catch (SQLException e) 
        {
            e.printStackTrace();
        }
        return listaAdmin;
    }
    
    
    // Lista clienti
    public ArrayList<Cliente> getClienti()
    {
        ArrayList<Cliente> listaClienti = new ArrayList<Cliente>();
        try 
        {
            Connection conn = DriverManager.getConnection(connessione, "Claudio", "Arzu");
            Statement stat = conn.createStatement();
            String query = "select * from cliente";
            ResultSet set = stat.executeQuery(query);
            
             // ciclo sulle righe restituite
            while(set.next()) 
            {
                Cliente cliente = new Cliente();
                cliente.setId(set.getInt("id"));
                cliente.setNome(set.getString("nome"));
                cliente.setCognome(set.getString("cognome"));
                cliente.setUsername(set.getString("username"));
                cliente.setPassword(set.getString("password"));
                listaClienti.add(cliente);
            }     
            
            stat.close();
            conn.close();
        } 
        catch (SQLException e) 
        {
            e.printStackTrace();
        }
        return listaClienti;
    }
    
    // Dato un id restituisce il relativo cliente, se ne esiste uno, altrimenti restituisce null
    public Cliente getCliente(int id)
    {
        try 
        {
            Connection conn = DriverManager.getConnection(connessione, "Claudio", "Arzu");
            String query = "select * from cliente "
            + "where id = ?";
            // Prepared Statement
            PreparedStatement stat = conn.prepareStatement(query);
            // Si associano i valori
            stat.setInt(1, id);
            // Esecuzione query
            ResultSet ris = stat.executeQuery();
           
             // ciclo sulle righe restituite
            if(ris.next()) 
            {
                Cliente cliente = new Cliente();
                cliente.setId(ris.getInt("id"));
                cliente.setNome(ris.getString("nome"));
                cliente.setCognome(ris.getString("cognome"));
                cliente.setUsername(ris.getString("username"));
                cliente.setPassword(ris.getString("password"));
                cliente.setCPassword(ris.getString("c_password"));
                
                query = "select prodotti.id, prodotti.tipo, prodotti.prezzo from prodotti"
                    + "join carrello"
                    + "on prodotti.id=carrello.idProdotto"
                    + "where carrello.idCliente="+cliente.getId();
                Statement st = conn.createStatement();
                ResultSet ris2 = st.executeQuery(query);
                while(ris2.next())
                {
                    Carrello c = new Carrello();
                    Prodotti c2 = new Prodotti();
                    c.setId(ris2.getInt("id"));
                    c2.setTipo(ris2.getString("tipo"));
                    cliente.listaProdotti.add(c);
                }
                st.close();
                stat.close();
                conn.close();
                return cliente;
            }
            
            stat.close();
            conn.close();
        } 
        catch (SQLException e) 
        {
            e.printStackTrace();
        }
        return null;
    }
    
    
    public ArrayList<Prodotti> getProdotti()
    {
        ArrayList<Prodotti> lista = new ArrayList<Prodotti>();
        
        try 
        {
            Connection conn = DriverManager.getConnection(connessione, "Claudio", "Arzu");
            Statement stat = conn.createStatement();
            String query = "select * from prodotti";
            ResultSet set = stat.executeQuery(query);
            
             // ciclo sulle righe restituite
            while(set.next()) 
            {
                Prodotti p = new Prodotti();
                p.setId(set.getInt("id"));
                p.setTipo(set.getString("tipo"));
                p.setPrezzo(set.getFloat("prezzo"));                
                lista.add(p);
            }     
            
            stat.close();
            conn.close();
        } 
        catch (SQLException e) 
        {
            e.printStackTrace();
        }
        return lista;
    }
    public Prodotti getProdotti(String tipo)
    {
        try 
        {
            Connection conn = DriverManager.getConnection(connessione, "Claudio", "Arzu");
            String query = "select * from prodotti "
            + "where id = ?";
            // Prepared Statement
            PreparedStatement stat = conn.prepareStatement(query);
            // Si associano i valori
            stat.setString(1, tipo);
            // Esecuzione query
            ResultSet ris = stat.executeQuery();
           
             // ciclo sulle righe restituite
            if(ris.next()) 
            {
                Prodotti p = new Prodotti();
                p.setId(ris.getInt("id"));
                p.setTipo(ris.getString("tipo"));
                p.setPrezzo(ris.getFloat("prezzo"));                
                
                stat.close();
                conn.close();
                return p;
            }
            
            stat.close();
            conn.close();
        } 
        catch (SQLException e) 
        {
            e.printStackTrace();
        }
        return null;
    }
    
    
    public ArrayList<Carrello> getCarrello()
    {
        ArrayList<Carrello> listaMerce = new ArrayList<Carrello>();
        try 
        {
            Connection conn = DriverManager.getConnection(connessione, "Claudio", "Arzu");
            Statement stat = conn.createStatement();
            String query = "select * from "
            + "carrello";
            ResultSet set = stat.executeQuery(query);
            
            //righe restitute dal ciclo
            while(set.next()) 
            {
                Carrello c = new Carrello();
                Prodotti p = new Prodotti();
                c.setId(set.getInt("id"));
                p.setTipo(set.getString("tipo"));
                c.setPrezzo(set.getFloat("prezzo"));                
                listaMerce.add(c);
                
            } 
            
            stat.close();
            conn.close();
        } 
        catch (SQLException e) 
        {
            e.printStackTrace();
        }
        return listaMerce;
    }
    public Carrello getCarrello(String tipo)
    {
         try 
        {
            Connection conn = DriverManager.getConnection(connessione, "Claudio", "Arzu");
            String query = "select * from carrello "
            + "where id = ?";
            // Prepared Statement
            PreparedStatement stat = conn.prepareStatement(query);
            // Si associano i valori
            stat.setString(1, tipo);
            // Esecuzione query
            ResultSet ris = stat.executeQuery();
           
             // ciclo sulle righe restituite
            if(ris.next()) 
            {
                Carrello cliente = new Carrello();
                Prodotti p = new Prodotti();               
                p.setTipo(ris.getString("tipo"));
                cliente.setId(ris.getInt("id"));                
                cliente.setPrezzo(ris.getFloat("prezzo"));
                
                
                query = "select prodotti.id, prodotti.tipo, prodotti.prezzo from prodotti"
                    + "join carrello"
                    + "on prodotti.id=carrello.idProdotto"
                    + "where carrello.idCliente="+cliente.getId();
                Statement st = conn.createStatement();
                ResultSet ris2 = st.executeQuery(query);
                while(ris2.next())
                {
                    Carrello c = new Carrello();
                    Prodotti c2 = new Prodotti();
                    c.setId(ris2.getInt("id"));
                    c2.setTipo(ris2.getString("tipo"));
                    cliente.listaProdotti.add(c);
                }
                st.close();
                stat.close();
                conn.close();
                return cliente;
            }
            
            stat.close();
            conn.close();
        } 
        catch (SQLException e) 
        {
            e.printStackTrace();
        }
        return null;
    }
    
    
 
    
    public void registraCliente(int idCliente, String nomeCliente, String cognomeCliente, String indirizzoCliente, 
            int capCliente, String cittaCliente, String emailCliente, String usernameCliente, String passwordCliente, String c_passwordCliente) 
            throws SQLException
    {
        Connection conn = DriverManager.getConnection(
                Users.getInstance().getConnectionString(),
                "Claudio",
                "Arzu");
        
        PreparedStatement aggiornaClienti=null;
                     
        // Sql 
        String insertCliente = "insert into clienti"
                + "(idCliente, nomeCliente, cognomeCliente, indirizzoCliente, \n" +
                "capCliente, cittaCliente,  emailCliente, usernameCliente, passwordCliente, c_passwordCliente) "
                + "values (?,?,?,?,?,?,?,?,?,?)";
        
        try
        {
            conn.setAutoCommit(false);
            aggiornaClienti = conn.prepareStatement(insertCliente);
            
            aggiornaClienti.setInt(1, idCliente);
            aggiornaClienti.setString(2, nomeCliente);
            aggiornaClienti.setString(3, cognomeCliente);
            aggiornaClienti.setString(4, indirizzoCliente);
            aggiornaClienti.setInt(5, capCliente);
            aggiornaClienti.setString(6, cittaCliente);
            aggiornaClienti.setString(7, emailCliente);
            aggiornaClienti.setString(8, usernameCliente);
            aggiornaClienti.setString(9, passwordCliente);
            aggiornaClienti.setString(10, c_passwordCliente);
            
            int a = aggiornaClienti.executeUpdate();
            
            if (a != 1)
            {
                conn.rollback();
            }
        } catch(SQLException e)
          {
              try
              {
                  conn.rollback();
              }catch(SQLException e2)
               {                
               }    
            }finally 
            {
                if(aggiornaClienti != null)
                {
                    aggiornaClienti.close();
                    conn.setAutoCommit(true);
                    conn.close();
                }
            }

    }
    
    public void aggiungiCarrello (int id, String tipo, double prezzo)
            throws SQLException
    {
        String query = "INSERT INTO carrello VALUES (?,?)";
        Connection conn = DriverManager.getConnection(
                Users.getInstance().getConnectionString(),
                "Claudio",
                "Arzu");
        PreparedStatement pstmt;
        pstmt = conn.prepareStatement(query);
        pstmt.setInt(1, id);
        pstmt.setString(2, tipo);
        pstmt.setDouble(3, prezzo);
        int entriesModificate = pstmt.executeUpdate();
        if(entriesModificate<0){
            
        }				
        pstmt.close();
    }
    
    public void visualCarrello (int idCliente, int idCarrello)
            throws SQLException
    {
        Connection conn = DriverManager.getConnection(
                Users.getInstance().getConnectionString(),
                "Claudio",
                "Arzu");
        String query = "SELECT idCliente FROM cliente"
                + "JOIN carrello"
                + "WHERE carrello.id=cliente.idCliente";
        PreparedStatement pstmt;
        pstmt= conn.prepareStatement(query);
        ResultSet rs = pstmt.executeQuery();
        while(rs.next()){
        int id = rs.getInt(1);
        String tipo = rs.getString(2);
        double prezzo = rs.getDouble(3);        
        }
        rs.close();
        pstmt.close();
    }
    
    public void deleteCarrello (int idCliente, int idCarrello)
            throws SQLException
    {
        Connection conn = DriverManager.getConnection(
                Users.getInstance().getConnectionString(),
                "Claudio",
                "Arzu");
        String query = "DELETE FROM carrello WHERE id=?";
        PreparedStatement pstmt;
        pstmt = conn.prepareStatement(query);
        /*pstmt.setInt(1, id);*/
        int recordCancellati = pstmt.executeUpdate();
        pstmt.close();
    
    }
    
    // ConnectionString
    public void setConnectionString(String s){
	this.connessione = s;
    }
    public String getConnectionString(){
	return this.connessione;
    }    
}
