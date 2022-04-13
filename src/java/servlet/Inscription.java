/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import objects.Client;
import services.ClientService;

/**
 *
 * @author rindrarolando
 */
@WebServlet(name = "Inscription", urlPatterns = {"/Inscription"})
public class Inscription extends HttpServlet {

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
        String message = null;
        String nom = request.getParameter("nom");
        String email = request.getParameter("email");
        String mdp = request.getParameter("mdp");
        
        ClientService service = new ClientService();
        Client client = null;
        
        try{
            if(service.checkClient(email, mdp) == null){
                client = new Client(nom,email,mdp);
                service.inscrire(client);
                message = "Inscription réussite!";
                request.setAttribute("message",message);
                this.getServletContext().getRequestDispatcher("/index.jsp").forward(request,response);
            }else{
                message = "Utilisateur déjà existant.";
                request.setAttribute("message", message);
                this.getServletContext().getRequestDispatcher("/index.jsp").forward(request,response);
            }
        }catch(Exception e){
            message = "Une erreur s'est produite.";
            request.setAttribute("message", message);
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
