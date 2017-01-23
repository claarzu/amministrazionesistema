package SitoAmm;

import SitoAmm.Classi.Prodotti;
import SitoAmm.Classi.Users;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
/**
 *
 * @author claar
 */

@WebServlet(name = "Product", urlPatterns = {"/Product"}, 
        loadOnStartup = 0)

public class Product extends HttpServlet {
    
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
         //Inizio sessione
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();


        try
        {
                /*carico il driver "Embedded driver" del database, poichè il database è in locale*/
                Class driver = Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
                Connection conn = DriverManager.getConnection("jdbc:derby://localhost:1527/ammdb");
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery("SELECT * FROM prodotti");
                ResultSetMetaData rsmd = rs.getMetaData();
                int numColonne = rsmd.getColumnCount();
                for (int i=1; i<=numColonne; i++)
                {
                    //stampo le colonne
                    System.out.print(rsmd.getColumnLabel(i)+"\t\t");
                }
                System.out.println("\n______________");
                
                while(rs.next())
                {
                    int id = rs.getInt(1);
                    String tipoProdotto =  rs.getString(2);
                    double prezzo =rs.getDouble(3);
                    System.out.println(id + "\t\t" + tipoProdotto + "\t\t" + prezzo);
                }
                rs.close();
                stmt.close();
                conn.close();
        }
        catch (Exception e )
        {
            e.printStackTrace();
        }

        
         request.getRequestDispatcher("birre.jsp").forward(request, response);
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
