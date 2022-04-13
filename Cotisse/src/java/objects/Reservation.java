/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package objects;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;


/**
 *
 * @author rindr
 */
public class Reservation {
    int idReservation;
    int idClient;
    int idDestination;
    int places;
    Date dateReservation;
    boolean statut;

    public Reservation(int idReservation, int idClient, int idDestination, int places, Date dateReservation, boolean statut) {
        this.idReservation = idReservation;
        this.idClient = idClient;
        this.idDestination = idDestination;
        this.places = places;
        this.dateReservation = dateReservation;
        this.statut = statut;
    }
    
    public Reservation(){
        
    }
    
    public int getIdReservation() {
        return idReservation;
    }

    public void setIdReservation(int idReservation) {
        this.idReservation = idReservation;
    }

    public int getIdClient() {
        return idClient;
    }

    public void setIdClient(int idclient) {
        this.idClient = idclient;
    }

    public int getIdDestination() {
        return idDestination;
    }

    public void setIdDestination(int iddestination) {
        this.idDestination = iddestination;
    }

    public int getPlaces() {
        return places;
    }

    public void setPlaces(int places) {
        this.places = places;
    }

    public Date getDateReservation() {
        return dateReservation;
    }

    public void setDateReservation(Date datereservation) {
        this.dateReservation = datereservation;
    }

    public boolean isStatut() {
        return statut;
    }

    public void setStatut(boolean statut) {
        this.statut = statut;
    }
    
    public Reservation getReservation(int idres) throws Exception{
            //Ouverture de la connexion avec la base Mysql.
            Class.forName("com.mysql.jdbc.Driver");
            Connection c = null;
            java.sql.Statement stmt = null;
            
            Reservation reserve = null;
            
            String req ="SELECT * FROM reservation WHERE idreservation='"+idres+"';";
            
        try{
            c = DriverManager.getConnection("jdbc:mysql://localhost:3306/cotisse","root","root");
            stmt = c.createStatement();
            ResultSet res = stmt.executeQuery(req);
            while(res.next()){
                int idreserve = res.getInt("idreservation");
                int idcli = res.getInt("idclient");
                int iddest = res.getInt("iddestination");
                int place = res.getInt("places");
                Date daty = res.getDate("datereservation");
                boolean statut = res.getBoolean("statut");
                reserve = new Reservation(idreserve,idcli, iddest,place, daty, statut);    
            } 
            
        } catch (Exception e) {
            return null;
        }finally{
            if(c!=null){
                c.close();
            }
            if(stmt!=null){
                stmt.close();
            }
        }
        return reserve ;
    }
    
    public ArrayList<Reservation> getReservations() throws Exception{
            //Ouverture de la connexion avec la base Mysql.
            Class.forName("com.mysql.jdbc.Driver");
            Connection c = null;
            java.sql.Statement stmt = null;
            
            ArrayList<Reservation> reservations = new ArrayList<Reservation>();
            
            String req ="SELECT * FROM reservation;";
            
        try{
            c = DriverManager.getConnection("jdbc:mysql://localhost:3306/cotisse","root","root");
            stmt = c.createStatement();
            ResultSet res = stmt.executeQuery(req);
            while(res.next()){
                int idreserve = res.getInt("idreservation");
                int idcli = res.getInt("idclient");
                int iddest = res.getInt("iddestination");
                int place = res.getInt("places");
                Date daty = res.getDate("datereservation");
                boolean statut = res.getBoolean("statut");
                Reservation reserve = new Reservation(idreserve,idcli, iddest,place, daty, statut);
                reservations.add(reserve);
            } 
            c.close();
            
        } catch (Exception e) {
            return null;
        }finally{
            if(c!=null){
                c.close();
            }
            if(stmt!=null){
                stmt.close();
            }
        }
          return reservations ;
    }
        
}
