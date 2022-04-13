/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import java.io.IOException;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import objects.Client;
import objects.Destination;
import services.ClientService;

/**
 *
 * @author rindrarolando
 */
@WebServlet(name = "ReserverClient", urlPatterns = {"/ReserverClient"})
public class ReserverClient extends HttpServlet {

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
        String message = null;
        ClientService service = new ClientService();
        
        HttpSession session = request.getSession();
        Client client = (Client)session.getAttribute("session");
        
        
        ServletContext context = this.getServletContext();
        Destination dest = (Destination)context.getAttribute("destinationSouhaite");
        
        //Destination dest = (Destination)session.getAttribute("destinationSouhaitee");
        
        String places = request.getParameter("place");
        int place = new Integer(places);
        
        String jour = request.getParameter("jour");
        String mois = request.getParameter("mois");
        String annee = request.getParameter("annee");
        String daty = annee+"-"+mois+"-"+jour;
        
        try{
            if(service.checkIfAlreadyExist(client, daty)==false){
                service.reserver(client, dest, place, daty);
                message = "Vous venez de reserver un voyage, Merci!";
                request.setAttribute("message", message);
                this.getServletContext().getRequestDispatcher("/PaginationServlet").forward(request, response);
            }else{
                message = "Vous avez déjà une reservation prévue à cette date, Désolé!";
                request.setAttribute("message", message);
                this.getServletContext().getRequestDispatcher("/PaginationServlet").forward(request, response);
            }
            
        }catch(Exception e){
            e.printStackTrace();
            message = "Une erreur s'est produite."+e.getMessage();
            request.setAttribute("message", message);
            this.getServletContext().getRequestDispatcher("/PaginationServlet").forward(request, response);
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
