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
    String connessione;
    
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
            String query = "select * from AMMINISTRATORE where "
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
                
                query = "select UTENTI.ID, UTENTI.NOME, UTENTI.COGNOME * from UTENTI"
                        + "join AMMINISTRATORE"
                        + "on UTENTI.ID = AMMINISTRATORE.ID"
                        + "where AMMINISTRATORE.ID"=+admin.id;
                
                st.close();
                stat.close();
                conn.close();
                
                return admin;
            }
            
            //Utente (il cliente)
            query = "select * from UTENTI where "
                    + "password = ? and username = ?";
            stat = conn.prepareStatement(query);
            // dati
            stat.setString(1, password);
            stat.setString(2, username);
            
            set = stat.executeQuery();
            
            if(set.next())
            {
                Utente user = new Utente();
                user.id = set.getInt("id");
                user.nome = set.getString("nome");
                user.cognome = set.getString("cognome");
                user.username = set.getString("username");
                user.password = set.getString("password");
                user.c_password = set.getString("c_password");
                        
                stat.close();
                conn.close();
                return user;
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
            String query = "select * from AMMINISTRATORE" + "where ID = ?";
            PreparedStatement stat = conn.prepareStatement(query);
            //adesso associo i valori
            stat.setInt(1, id);
            ResultSet ris = stat.executeQuery();
            
            //ora controllo quante sono le righe presenti nel db AMMINISTRATORE
            if (ris.next()) 
            {
                Amministratore admin = new Amministratore();
                admin.setIdad(ris.getInt("ID"));
                admin.setNomead(ris.getString("NOME"));
                admin.setCognomead(ris.getString("COGNOME"));
                admin.setUsernamead(ris.getString("USERNAME"));
                admin.setPasswordad(ris.getString("PASSWORD"));
                
                query = "select UTENTE.ID, UTENTE.NOME, UTENTE.COGNOME * from UTENTI"
                        + "join AMMINISTRATORE"
                        + "on UTENTI.ID = AMMINISTRATORE.ID"
                        + "where AMMINISTRATORE.ID"=+admin.id;
                Statement st = conn.createStatement();
                ResultSet ris2 = st.executeQuery(query);
                while(ris2.next())
                {
                    Utente user = new Utente();
                    user.setId(ris2.getInt("ID"));
                    user.setNome(ris2.getString("NOME"));
                    admin.Utente.add(user);
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
            String query = "select * from "
            + "AMMINISTRATORE";
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
            String query = "select * from CLIENTE";
            ResultSet set = stat.executeQuery(query);
            
             // ciclo sulle righe restituite
            while(set.next()) 
            {
                Cliente cl_nte = new Cliente();
                cl_nte.setIdcl(set.getInt("id"));
                cl_nte.setNomecl(set.getString("nome"));
                cl_nte.setCognomecl(set.getString("cognome"));
                cl_nte.setUsernamecl(set.getString("username"));
                cl_nte.setPasswordcl(set.getString("password"));
                listaClienti.add(cl_nte);
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
    
    // Dato un id restituisce il relativo studente (se esiste uno studente con quell'id, altrimenti
    // restituisce null).
    public Cliente getCliente(int id)
    {
        try 
        {
            Connection conn = DriverManager.getConnection(connessione, "Claudio", "Arzu");
            String query = "select * from CLIENTE "
            + "where ID = ?";
            // Prepared Statement
            PreparedStatement stat = conn.prepareStatement(query);
            // Si associano i valori
            stat.setInt(1, id);
            // Esecuzione query
            ResultSet ris = stat.executeQuery();
           
             // ciclo sulle righe restituite
            if(ris.next()) 
            {
                Cliente cl_nte = new Cliente();
                cl_nte.setIdcl(ris.getInt("id"));
                cl_nte.setNomecl(ris.getString("nome"));
                cl_nte.setCognomecl(ris.getString("cognome"));
                cl_nte.setUsernamecl(ris.getString("username"));
                cl_nte.setPasswordcl(ris.getString("password"));
                cl_nte.setCPasswordcl(ris.getString("c_password"));
                
                stat.close();
                conn.close();
                return cl_nte;
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
        
        PreparedStatement aggiornaClienti = null;
        PreparedStatement aggiornaClien_ti = null;
        
        // Sql 
        String eliminaCliente = "delete from CLIENTE "
                + "join UTENTI"
                + "on CLIENTE"
                + "where idCliente = ? "
                + "and ID = ?";
        String insertCliente = "insert into CLIENTE + UTENTI "
                + "(idCliente, nomeCliente, cognomeCliente, indirizzoCliente, \n" +
                "capCliente, cittaCliente,  emailCliente, usernameCliente, passwordCliente, c_passwordCliente) "
                + "values (?,?,?,?,?,?,?,?,?,?)";
        
        try
        {
           conn.setAutoCommit(false);
           aggiornaClienti = conn.prepareStatement(eliminaCliente);
           aggiornaClien_ti = conn.prepareStatement(insertCliente);
           
           // elimino da UTENTI
           aggiornaClienti.setInt(1, idCliente);
           aggiornaClienti.setInt(1, id);
           // aggiorno CLIENTI
           aggiornaClien_ti.setInt(1, idCliente);
           aggiornaClien_ti.setString(2, nomeCliente);
           aggiornaClien_ti.setString(3, cognomeCliente);
           aggiornaClien_ti.setString(4, indirizzoCliente);
           aggiornaClien_ti.setInt(5, capCliente);
           aggiornaClien_ti.setString(6, cittaCliente);
           aggiornaClien_ti.setString(7, emailCliente);
           aggiornaClien_ti.setString(8, usernameCliente);
           aggiornaClien_ti.setString(9, passwordCliente);
           aggiornaClien_ti.setString(10, c_passwordCliente);
           
           
           int c1 = aggiornaClienti.executeUpdate();
           int c2 = aggiornaClien_ti.executeUpdate();
           
           if(c1 != 1 || c2 != 1)
               conn.rollback();
           
           conn.commit();           
        }catch(SQLException e)
        {
            try
            {
                conn.rollback();
            }catch(SQLException e2)
            {
                
            }
        }
        finally
        {
            if(aggiornaClienti != null)
                aggiornaClienti.close();
            if(aggiornaClien_ti != null)
                aggiornaClien_ti.close();
            
            conn.setAutoCommit(true);
            conn.close();
        }    
    }
    
    // ConnectionString
    public void setConnectionString(String s){
	this.connessione = s;
    }
    public String getConnectionString(){
	return this.connessione;
    }    
}
