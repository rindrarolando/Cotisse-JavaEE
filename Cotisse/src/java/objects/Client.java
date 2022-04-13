/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package objects;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author rindr
 */
public class Client {
    int idClient;
    String nom;
    String email;
    String mdp;

    public Client(int idClient, String nom, String email, String mdp) {
        this.idClient = idClient;
        this.nom = nom;
        this.email = email;
        this.mdp = mdp;
    }
    
    public Client(String nom, String email, String mdp) {
        this.nom = nom;
        this.email = email;
        this.mdp = mdp;
    }
    
    public Client(){
        
    }

    public void setIdClient(int id){
        this.idClient = id;
    }
    
    public int getIdClient(){
        return this.idClient;
    }
    
    public String getNom() {
        return this.nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }
    
    public void setEmail(String email){
        this.email = email;
    }
    
    public String getEmail(){
        return this.email;
    }
    
    public void setPassword(String pass){
        this.mdp = pass;
    }
    
    public String getPassword(){
        return this.mdp;
    }
    
    public void inscrire(Client client) throws Exception{
            //Ouverture connexion avec la base Mysql.
            Class.forName("com.mysql.jdbc.Driver");
            Connection c = null;
            PreparedStatement pst = null;
        
            String req = "INSERT INTO client VALUES ('0','"+client.getNom()+"','"+client.getEmail()+"',sha1('"+client.getPassword()+"'));";
        
        try{
            c = DriverManager.getConnection("jdbc:mysql://localhost:3306/cotisse","root","root");
            pst = c.prepareStatement(req);
            pst.executeUpdate();
            
        }catch(Exception e ){
            c.rollback();
            throw e;
        }finally{
            if(c != null){
                c.close();
            }
            if(pst != null){
                pst.close();
            }
        }
    }
    
    public Client checkClient(String email,String mdp) throws Exception{
            //Ouverture de la connexion avec la base Mysql.
            Class.forName("com.mysql.jdbc.Driver");
            Connection c = null;
            java.sql.Statement stmt = null;
            Client client = null;
        
            String req ="SELECT * FROM client WHERE email='"+email+"' and mdp=sha1('"+mdp+"');" ;
        
        try{
            c = DriverManager.getConnection("jdbc:mysql://localhost:3306/cotisse","root","root");
            stmt = c.createStatement();
            ResultSet res = stmt.executeQuery(req);
            
            while(res.next()){
                int id = res.getInt("idclient");
                String nom = res.getString("nom");
                String mail = res.getString("email");
                String mot = res.getString("mdp");
                client = new Client(id, nom, mail, mot);
                
            }
            
            
        }catch (Exception e) {
            c.rollback();
            return null;
        }finally{
            if(c != null){
                c.close();
            }
            if(stmt!=null){
                stmt.close();
            }
        }
        return client;
    }
    
    public Client getClient(int idcli) throws Exception{
            //Ouverture de la connexion avec la base Mysql.
            Class.forName("com.mysql.jdbc.Driver");
            Connection c = null;
            java.sql.Statement stmt = null;
            Client client = null;

            String req = "SELECT * FROM client WHERE idclient='"+idcli+"';";
            
        try {
            c = DriverManager.getConnection("jdbc:mysql://localhost:3306/cotisse","root","root");
            stmt = c.createStatement();
            ResultSet res = stmt.executeQuery(req);
            
            while (res.next()) {
                int id = res.getInt("idclient");
                String nom = res.getString("nom");
                String mail = res.getString("email");
                String mot = res.getString("mdp");
                client = new Client(id, nom, mail, mot);
            }
            
            
        } catch (Exception e) {
            return null;
        }finally{
            if(c != null){
                c.close();
            }
            if(stmt!=null){
                stmt.close();
            }
        }
        return client;
    }
    
    public void reserver(Client client, Destination dest,int places,String date) throws Exception{
            //Ouverture connexion avec la base Mysql.
            Class.forName("com.mysql.jdbc.Driver");
            Connection c = null;
            PreparedStatement pst = null;
            
            /*DateFormat formatter = new SimpleDateFormat("yyyy-mm-dd");
            java.util.Date daty = formatter.parse(date);
            java.sql.Date sqlDate = new java.sql.Date(daty.getDate());*/
            
            String req = "INSERT INTO reservation VALUES ('0','"
                    +client.getIdClient()+"','"+dest.getIdDestination()+"','"+places+"','"+date+"',TRUE);";
            
        try{
            c = DriverManager.getConnection("jdbc:mysql://localhost:3306/cotisse","root","root");
            pst = c.prepareStatement(req);
            pst.executeUpdate();
            
        }catch(Exception e ){
            c.rollback();
            throw e;
        }finally{
            if(c != null){
                c.close();
            }
            if(pst != null){
                pst.close();
            }
        }
    }
    
    public ArrayList<Reservation> getReservationsOfThis(Client cli) throws Exception{
            //Ouverture de la connexion avec la base Mysql.
            Class.forName("com.mysql.jdbc.Driver");
            Connection c = null;
            java.sql.Statement stmt = null;
            Client client = null;
            
            ArrayList<Reservation> reservations = null;
            
            String req ="SELECT * FROM reservation WHERE idclient='"+cli.getIdClient()+"';";
            
        try {
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
            
            
            
        } catch (Exception e) {
            return null;
        }finally{
            if(c != null){
                c.close();
            }
            if(stmt!=null){
                stmt.close();
            }
        }
        return reservations ;
    }
    
    public void annuler(Client cli ,Reservation reservation) throws Exception{
            //Ouverture connexion avec la base Mysql.
            Class.forName("com.mysql.jdbc.Driver");
            Connection c = null;
            PreparedStatement pst = null;
        
            String req = "UPDATE reservation SET statut=FALSE WHERE idclient='"+cli.getIdClient()+"' AND idreservation='"+reservation.getIdReservation()+"';";
            
        try {
            c = DriverManager.getConnection("jdbc:mysql://localhost:3306/cotisse","root","root");
            pst = c.prepareStatement(req);
            pst.executeUpdate();
            
        } catch (Exception e) {
            c.rollback();
            throw e;
        }finally{
            if(c != null){
                c.close();
            }
            if(pst != null){
                pst.close();
            }
        }
    }
        
    public void modifierNbPlaces(Client cli ,Reservation reservation ,int place) throws Exception{
            //Ouverture connexion avec la base Mysql.
            Class.forName("com.mysql.jdbc.Driver");
            Connection c = null;
            PreparedStatement pst = null;
            
            String req = "UPDATE reservation SET places='"+place
                    +"' WHERE idclient='"+cli.getIdClient()+"' AND idreservation='"+reservation.getIdReservation()+"';";
            
            try {
            c = DriverManager.getConnection("jdbc:mysql://localhost:3306/cotisse","root","root");
            pst = c.prepareStatement(req);
            pst.executeUpdate();
        
        } catch (Exception e) {
            c.rollback();
        }finally{
            if(c != null){
                c.close();
            }
            if(pst != null){
                pst.close();
            }
        }
    }
    
    public void modifierDate(Client cli,Reservation reservation ,String newDate) throws Exception{
            //Ouverture connexion avec la base Mysql.
            Class.forName("com.mysql.jdbc.Driver");
            Connection c = null;
            PreparedStatement pst = null;
            
            String req = "UPDATE reservation SET datereservation='"+newDate+"' WHERE idclient='"+cli.getIdClient()+"' AND idreservation='"+reservation.getIdReservation()+"';";
            
            try {
            c = DriverManager.getConnection("jdbc:mysql://localhost:3306/cotisse","root","root");
            pst = c.prepareStatement(req);
            pst.executeUpdate();
        
        } catch (Exception e) {
            c.rollback();
        }finally{
            if(c != null){
                c.close();
            }
            if(pst!=null){
                pst.close();
            }
        }
    }
    
    public boolean checkIfAlreadyExist(Client cli,String date) throws Exception{
        //Ouverture de la connexion avec la base Mysql.
            Class.forName("com.mysql.jdbc.Driver");
            Connection c = null;
            java.sql.Statement stmt = null;
            
        
            String req ="SELECT * FROM reservation WHERE idclient='"+cli.getIdClient()+"' and datereservation='"+date+"';" ;
        
        try{
            c = DriverManager.getConnection("jdbc:mysql://localhost:3306/cotisse","root","root");
            stmt = c.createStatement();
            ResultSet res = stmt.executeQuery(req);
            
            if(res.next()){
                return true;
            }else{
                return false;
            }
            
            
        }catch (Exception e) {
            return true;
        }finally{
            if(c != null){
                c.close();
            }
            if(stmt!=null){
                stmt.close();
            }
        }
        
    }
}
