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
import java.sql.SQLException;

/**
 *
 * @author rindrarolando
 */
public class Administrator {
    int idAdmin;
    String loginAdmin;
    String mdpAdmin;

    public Administrator(int idAdmin, String loginAdmin, String mdpAdmin) {
        this.idAdmin = idAdmin;
        this.loginAdmin = loginAdmin;
        this.mdpAdmin = mdpAdmin;
    }
    
    public Administrator(){
        
    }
    
    public int getIdAdmin() {
        return idAdmin;
    }

    public void setIdAdmin(int idadmin) {
        this.idAdmin = idadmin;
    }

    public String getLoginAdmin() {
        return loginAdmin;
    }

    public void setLoginAdmin(String loginadmin) {
        this.loginAdmin = loginadmin;
    }

    public String getMdpAdmin() {
        return mdpAdmin;
    }

    public void setMdpAdmin(String mdpadmin) {
        this.mdpAdmin = mdpadmin;
    }
    
    public Administrator checkAdmin(String login, String mdp) throws Exception{
            //Ouverture de la connexion avec la base Mysql.
            Class.forName("com.mysql.jdbc.Driver");
            Connection c = null;
            java.sql.Statement stmt = null;
            Administrator admin = null;
            
            String req ="SELECT * FROM administrator WHERE loginadmin='"+login+"' AND mdpadmin=sha1('"+mdp+"');" ;
            
        try{
            c = DriverManager.getConnection("jdbc:mysql://localhost:3306/cotisse","root","root");
            stmt = c.createStatement();
            ResultSet res = stmt.executeQuery(req);
            
            while(res.next()){
                int id = res.getInt("idadmin");
                String log = res.getString("loginadmin");
                String mdpss = res.getString("mdpadmin");
                
                admin = new Administrator(id, log, mdpss);
                
            }
            
            
        } catch (Exception e) {
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
        return admin;
    }
    
    public void supprimerDestination(Destination dest) throws Exception{
            //Ouverture connexion avec la base Mysql.
            Class.forName("com.mysql.jdbc.Driver");
            Connection c = null;
            PreparedStatement pst = null;
            String req = "DELETE FROM destination WHERE iddestination='"+dest.getIdDestination()+"';";
        
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
    
    public void ajouterDestination(String desc) throws Exception{
            //Ouverture connexion avec la base Mysql.
            Class.forName("com.mysql.jdbc.Driver");
            Connection c = null;
            PreparedStatement pst = null;
            
            String req = "INSERT INTO destination VALUES ('0','"+desc+"');";
            
        try {
            c = DriverManager.getConnection("jdbc:mysql://localhost:3306/cotisse","root","root");
            pst = c.prepareStatement(req);
            pst.executeUpdate();
            
        } catch (SQLException e) {
            c.rollback();
            throw e;
        }finally{
            if(c != null){
                c.close();
            }
            if(pst!=null){
                pst.close();
            }
        }
    }
    
    public void modifierDestination(Destination dest, String desc) throws Exception{
            //Ouverture connexion avec la base Mysql.
            Class.forName("com.mysql.jdbc.Driver");
            Connection c = null;
            PreparedStatement pst = null;
            
            String req = "UPDATE destination SET description='"+desc
                    +"' WHERE iddestination='"+dest.getIdDestination()+"';";
            
            try {
            c = DriverManager.getConnection("jdbc:mysql://localhost:3306/cotisse","root","root");
            pst = c.prepareStatement(req);
            pst.executeUpdate();
            
        } catch (SQLException e) {
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
    
}
