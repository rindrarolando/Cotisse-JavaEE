/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import java.util.ArrayList;
import java.util.Date;
import objects.Client;
import objects.Destination;
import objects.Reservation;

/**
 *
 * @author rindrarolando
 */
public class ClientService {
    Client c = new Client();
    
    public void inscrire(Client x) throws Exception{
        c.inscrire(x);
    }
    
    public Client checkClient(String email, String mdp) throws Exception{
        return c.checkClient(email, mdp);
    }
    
    public Client getClient(int idcli) throws Exception{
        return c.getClient(idcli);
    }
    
    public void reserver(Client client, Destination dest,int places,String date) throws Exception{
        c.reserver(client, dest, places, date);
    }
    
    public ArrayList<Reservation> getReservationsOfThis(Client cli) throws Exception{
        return c.getReservationsOfThis(cli);
    }
    
    public void annuler(Client cli ,Reservation reservation) throws Exception{
        c.annuler(cli, reservation);
    }
    
    public void modifierNbPlaces(Client cli ,Reservation reservation ,int place) throws Exception{
        c.modifierNbPlaces(cli, reservation, place);
    }
    
    public void modifierDate(Client cli,Reservation reservation ,String newDate) throws Exception{
        c.modifierDate(cli, reservation, newDate);
    }
    
    public boolean checkIfAlreadyExist(Client cli,String date) throws Exception{
        return c.checkIfAlreadyExist(cli,date);
    }
}
