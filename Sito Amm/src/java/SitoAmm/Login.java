/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SitoAmm;

import SitoAmm.Classi.Amministratore;
import SitoAmm.Classi.Users;
import SitoAmm.Classi.Utente;
import SitoAmm.Classi.Cliente;
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

/**
 *
 * @author claar
 */
@WebServlet(name = "Login", urlPatterns = {"/Login"}, 
        loadOnStartup = 0)

public class Login extends HttpServlet {
    /*carico il driver "Embedded driver" del database, poichè il database è in locale*/
    private static final String JDBC_DRIVER = "org.apache.derby.jdbc.EmbeddedDriver"; //carico il driver del database
    private static final String DB_CLEAN_PATH = "../../web/WEB-INF/db/ammdb";
    private static final String DB_BUILD_PATH = "WEB-INF/db/ammdb";
    @Override 
    public void init(){
        String dbConnection = "jdbc:derby:" + this.getServletContext().getRealPath("//localhost:1527/ammdb") + DB_BUILD_PATH;
        try {
            Class.forName(JDBC_DRIVER);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Login.class.getName())
                    .log(Level.SEVERE, null, ex);
        }
        Users.getInstance().setConnectionString(dbConnection);
    }
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
         //Inizio sessione
        HttpSession session = request.getSession(true);
        
            if(request.getParameter("conferma") != null)
            {
                // recupero i dati presi dal form
                String username = request.getParameter("uname");
                String password = request.getParameter("psw");
            
                Utente u = Users.getInstance().getUtente(username, password);
                if(u != null)
                {
                    session.setAttribute("loggedIn", true);
                    session.setAttribute("id", u.getId());
                    
                    if(u instanceof Amministratore) 
                    {
                        request.setAttribute("amministratore", u);
                        request.setAttribute("listaClienti", Users.getInstance().getClienti());
                        request.setAttribute("ListaProdotti", Users.getInstance().getProdotti());
                        request.getRequestDispatcher("amministratore_autenticato.jsp").forward(request, response);
                    }
                    else
                    {
                        request.setAttribute("cliente", u);
                        request.setAttribute("listaCarrello", Users.getInstance().getCarrello());
                        request.getRequestDispatcher("cliente_autenticato.jsp").forward(request, response);  
                    }                    
                }
            }
            request.getRequestDispatcher("utenti.jsp").forward(request, response);
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
