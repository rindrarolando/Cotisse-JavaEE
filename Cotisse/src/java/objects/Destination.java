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
/**
 *
 * @author rindr
 */
public class Destination {
    int idDestination;
    String description;

    public Destination(int idDestination, String description) {
        this.idDestination = idDestination;
        this.description = description;
    }
    
    public Destination(){
        
    }
    
    public int getIdDestination() {
        return idDestination;
    }

    public void setIdDestination(int iddestination) {
        this.idDestination = iddestination;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    
    public Destination getDestination(int id) throws Exception{
            //Ouverture de la connexion avec la base Mysql.
            Class.forName("com.mysql.jdbc.Driver");
            Connection c = null;
            java.sql.Statement stmt = null;
            
            Destination destination = null;
            
            String req ="SELECT * FROM destination WHERE iddestination='"+id+"';";
            
        try{
            c = DriverManager.getConnection("jdbc:mysql://localhost:3306/cotisse","root","root");
            stmt = c.createStatement();
            ResultSet res = stmt.executeQuery(req);
            while(res.next()){
                int iddest = res.getInt("iddestination");
                String desc = res.getString("description");
                
                destination = new Destination(iddest, desc);    
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
        return destination ;
    }
    
    public ArrayList<Destination> getDestinations()throws Exception{
            //Ouverture de la connexion avec la base Mysql.
            Class.forName("com.mysql.jdbc.Driver");
            Connection c = null;
            java.sql.Statement stmt = null;
            ArrayList<Destination> destinations = new ArrayList<Destination>();
            
            String req ="SELECT * FROM destination;";
            
        try{
            c= DriverManager.getConnection("jdbc:mysql://localhost:3306/cotisse","root","root");
            stmt = c.createStatement();
            ResultSet res = stmt.executeQuery(req);
            while(res.next()){
                
                int iddest = res.getInt("iddestination");
                String desc = res.getString("description");
                
                Destination destination = new Destination(iddest, desc);
                destinations.add(destination);
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            if(c!=null){
                c.close();
            }
            if(stmt!=null){
                stmt.close();
            }
        }
        return destinations ;
    }
    
    public int nbEnregistrement() throws Exception{
        Class.forName("com.mysql.jdbc.Driver");
        Connection c = null;
        java.sql.Statement stmt = null;
        
        int compteur = 0;
            
        String req ="SELECT count(*) as nb FROM destination;";
            
        try{
            c= DriverManager.getConnection("jdbc:mysql://localhost:3306/cotisse","root","root");
            stmt = c.createStatement();
            ResultSet res = stmt.executeQuery(req);
            if(res.next()){
                compteur = res.getInt("nb");
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            if(c!=null){
                c.close();
            }
            if(stmt!=null){
                stmt.close();
            }
        }
        return compteur;
    }
}
