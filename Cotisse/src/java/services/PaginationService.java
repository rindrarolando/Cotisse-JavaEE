/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import objects.Destination;

/**
 *
 * @author rindrarolando
 */
public class PaginationService {
    
    public int nbPage() {
        Destination dest = new Destination();
	int nbEnr = 0;
	int Total = 0;
		
	try {
		nbEnr = dest.nbEnregistrement();
		Total = nbEnr/3;
		/*if(nbEnr%3!= 0) {
                    Total = (nbEnr/3)+1;
                }*/
			
	} catch (Exception e) {
	// TODO Auto-generated catch block
		e.printStackTrace();
	}
		
	return Total;
	}
    
    public int getPageId(String spageid) {
		
	int pageid=new Integer(spageid);  
	int total=3;  
	if(pageid==1){}  
            else{  
		pageid=pageid-1;  
                pageid=pageid*total+1;  
            }  
		
	return pageid;
    }
    
    public ArrayList<Destination> getRecords(int start,int total) throws Exception{
		//Chargement du driver
		
	Class.forName("com.mysql.jdbc.Driver");
        PreparedStatement ps=null;
		
	Connection con = null;
		
	ArrayList<Destination> list=new ArrayList<Destination>();  
	try{
		con = DriverManager.getConnection("jdbc:mysql://localhost:3306/cotisse", "root", "root");
		ps=con.prepareStatement("SELECT * FROM destination LIMIT "+(start-1)+","+total+";");  
	        ResultSet rs=ps.executeQuery();

	        while(rs.next()){ 
                    int id = rs.getInt("iddestination"); 
	            String desc = rs.getString("description"); 
	            
	            Destination destination = new Destination(id,desc);
	                  
	            list.add(destination);
	        }
	          
	}catch (Exception e1) {
            e1.printStackTrace();
		throw e1;
	}finally {
            if(con != null) {
		con.close();
            }
            if(ps!= null){
                ps.close();
            }
        }	 
	return list;
	}
    
    
}
