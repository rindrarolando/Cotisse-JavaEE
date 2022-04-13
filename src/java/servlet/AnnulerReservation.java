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
import objects.Client;
import objects.Reservation;
import services.ClientService;
import services.ReservationService;

/**
 *
 * @author rindrarolando
 */
@WebServlet(name = "AnnulerReservation", urlPatterns = {"/AnnulerReservation"})
public class AnnulerReservation extends HttpServlet {

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
        
        String idd = request.getParameter("id");
        int id = new Integer(idd);
        
        String messageAnnulation = null;
        HttpSession session = request.getSession();
        Client cli = (Client)session.getAttribute("session");
        ClientService srv = new ClientService();
        ReservationService srvres= new ReservationService();
        
        try{
            Reservation res = srvres.getReservation(id);
            srv.annuler(cli, res);
            messageAnnulation = "Annulation réussie.";
            request.setAttribute("messageAnnulation", messageAnnulation);
            this.getServletContext().getRequestDispatcher("/listeVoyageClient.jsp").forward(request,response);
        }catch(Exception e){
            e.printStackTrace();
            messageAnnulation = "Une erreur s'est produite.";
            request.setAttribute("messageAnnulation", messageAnnulation);
            this.getServletContext().getRequestDispatcher("/listeVoyageClient.jsp").forward(request,response);
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
