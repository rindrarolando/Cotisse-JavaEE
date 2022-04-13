/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.ArrayList;
import objects.Destination;

/**
 *
 * @author rindrarolando
 */
public class RechercheService {
    
    public ArrayList<Destination> recherche(String search) throws Exception{
        //Ouverture de la connexion avec la base Mysql.
            Class.forName("com.mysql.jdbc.Driver");
            Connection c = null;
            java.sql.Statement stmt = null;
            ArrayList<Destination> destinations = new ArrayList<Destination>();
            
            String req ="SELECT * FROM destination WHERE description LIKE '%"+search+"%';";
            
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
    
}
