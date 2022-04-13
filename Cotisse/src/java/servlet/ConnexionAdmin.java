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
import javax.servlet.http.HttpSession;
import objects.Administrator;
import services.AdministratorService;

/**
 *
 * @author rindrarolando
 */
@WebServlet(name = "ConnexionAdmin", urlPatterns = {"/ConnexionAdmin"})
public class ConnexionAdmin extends HttpServlet {

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
        String login = request.getParameter("login");
        String mdp = request.getParameter("mdp");
        String message;
        
        AdministratorService service = new AdministratorService();
        try{
            if(service.checkAdmin(login, mdp) != null){
                Administrator admin = new Administrator();
                admin = service.checkAdmin(login,mdp);
                HttpSession session = request.getSession(true);
                session.setAttribute("sessionAdmin", admin);
                message="Vous êtes maintenant connecté.";
                request.setAttribute("messageAdmin",message);
                this.getServletContext().getRequestDispatcher("/acceuilAdmin.jsp").forward(request,response);
            }
        }catch(Exception e){
            message = "Une erreur s'est produite. Veuillez réessayer.";
            request.setAttribute("messageAdmin",message);
            this.getServletContext().getRequestDispatcher("/loginAdmin.jsp").forward(request,response);
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
