/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import java.util.ArrayList;
import objects.Reservation;

/**
 *
 * @author rindrarolando
 */
public class ReservationService {
    Reservation r = new Reservation();
    
    public Reservation getReservation(int idres) throws Exception{
        return r.getReservation(idres);
    }
    
    public ArrayList<Reservation> getReservations() throws Exception{
        return r.getReservations();
    }
}
