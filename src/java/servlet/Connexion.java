/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import objects.Client;
import services.ClientService;

/**
 *
 * @author rindrarolando
 */
@WebServlet(name = "Connexion", urlPatterns = {"/Connexion"})
public class Connexion extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    

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
        String email = request.getParameter("email");
        String mdp = request.getParameter("mdp");
        
        String message = null;
        
        ClientService service = new ClientService();
       // Client client = new Client();
        try{
            if(service.checkClient(email, mdp) != null){
                Client client = new Client();
                client = service.checkClient(email,mdp);
                HttpSession session = request.getSession(true);
                session.setAttribute("session", client);
                message="Vous êtes maintenant connecté.";
                request.setAttribute("message",message);
                this.getServletContext().getRequestDispatcher("/PaginationServlet").forward(request,response);
            }else{
                message = "Veuillez revérifier vos informations.";
                request.setAttribute("message",message);
                this.getServletContext().getRequestDispatcher("/index.jsp").forward(request,response);
            }
            
        }catch(Exception e){
            message = "Une erreur s'est produite. Veuillez réessayer.";
            request.setAttribute("message",message);
            this.getServletContext().getRequestDispatcher("/index.jsp").forward(request,response);
        }
        
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
