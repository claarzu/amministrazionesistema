/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SitoAmm;

import SitoAmm.Classi.Users;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
@WebServlet(name = "Registrazione", urlPatterns = {"/Registrazione"})
public class Registrazione extends HttpServlet {

  
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        HttpSession session = request.getSession();
        
        int id = Integer.parseInt(request.getParameter("clienteId"));
        request.setAttribute("cliente", Users.getInstance().getCliente(id));
        request.setAttribute("amministratore", Users.getInstance()
                .getAmministratore((int)session.getAttribute("id")));
        
        if (request.getParameter("conferma")!= null) {
            //prelevo i dati del form della pagina utenti.jsp
            int clienteId = Integer.parseInt(request.getParameter("clienteId"));            
            String nome = request.getParameter("name");
            String cognome = request.getParameter("sname");
            String indirizzo = request.getParameter("address");
            String cap = request.getParameter("cap");
            String citta = request.getParameter("city");
            String email = request.getParameter("e-mail");
            String username = request.getParameter("u_name");
            String password = request.getParameter("psw");
            String c_password = request.getParameter("conferma_psw");
        }
        try 
        {
            Users.getInstance().registraCliente(clienteId, nomeCliente, cognomeCliente, indirizzoCliente, capCliente, 
                    cittaCliente, emailCliente, usernameCliente, passwordCliente, c_passwordCliente); 
        } catch (SQLException e)
        {
        }
    }
    
    request.getRequestDispatcher("utenti.jsp").foward(request, response);

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
