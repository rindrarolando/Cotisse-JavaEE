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
import objects.Destination;
import services.AdministratorService;
import services.DestinationService;

/**
 *
 * @author rindrarolando
 */
@WebServlet(name = "ModifierVoyage", urlPatterns = {"/ModifierVoyage"})
public class ModifierVoyage extends HttpServlet {

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
        
        AdministratorService serviceA = new AdministratorService();
        DestinationService serviceD = new DestinationService();
        Destination dest = new Destination();
        
        String message;
        String idd = request.getParameter("id");
        int id = new Integer(idd);
        String depart = request.getParameter("depart");
        String arrivee = request.getParameter("arrivee");
        String desc = depart+"-"+arrivee;
        
        try{
            dest = serviceD.getDestination(id);
            serviceA.modifierDestination(dest, desc);
            message = "Modification terminée.";
            request.setAttribute("messageModification", message);
            this.getServletContext().getRequestDispatcher("/listeVoyageAdmin.jsp").forward(request, response);
            
        }catch(Exception e){
            message = "Une erreur s'est produite.";
            request.setAttribute("messageModification", message);
            this.getServletContext().getRequestDispatcher("/listeVoyageAdmin.jsp").forward(request, response);
        }
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
