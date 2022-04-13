/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import objects.Client;
import objects.Reservation;
import services.ClientService;
import services.ReservationService;

/**
 *
 * @author rindrarolando
 */
@WebServlet(name = "ModifierReservationClient", urlPatterns = {"/ModifierReservationClient"})
public class ModifierReservationClient extends HttpServlet {

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
        String messageModif  = null;
        HttpSession session = request.getSession();
        Client cli = (Client)session.getAttribute("session");
        
        String idd = request.getParameter("id");
        int id = new Integer(idd);
        
        String nbb = request.getParameter("nbp");
        int nb = new Integer(nbb);
        
        String daty = request.getParameter("date");
        
        ClientService srv = new ClientService();
        ReservationService sr = new ReservationService();
        
        
        try{
            Reservation res = sr.getReservation(id);
            srv.modifierNbPlaces(cli, res, nb);
            srv.modifierDate(cli, res, daty);
            messageModif = "Modification réussie.";
            request.setAttribute("messageModification", messageModif);
            this.getServletContext().getRequestDispatcher("/listeVoyageClient.jsp").forward(request, response);
        }catch(Exception e){
            e.printStackTrace();
            messageModif = "Une erreur s'est produite.";
            request.setAttribute("messageModification", messageModif);
            this.getServletContext().getRequestDispatcher("/listeVoyageClient.jsp").forward(request, response);
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
        doGet(request,response);
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
