/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package requete;

/**
 *
 * @author Bryan
 */
import models.*;
import connexion.*;

import java.sql.*;
import java.util.ArrayList;

public class Requete {
    //le nombre de ligne dans un table
    public int count(String table) throws SQLException, Exception {
        String request = "SELECT COUNT(*) FROM "+table;
        Connexion connexion = new Connexion(request);
        ResultSet rs = connexion.getResultSet();
        int count = 0;
        while(rs.next()) {
            count = rs.getInt(1);
        }
        return count;
    }
    /*Avoir les noms des colonnes d'une table*/
    public String[] getTitle(String table) throws SQLException, Exception {
        String request = "SELECT * FROM "+table;
        Connexion connexion = new Connexion(request);
        ResultSet rs = connexion.getResultSet();
        ResultSetMetaData rsmd = rs.getMetaData();
        int count = rsmd.getColumnCount();
        String[] title = new String[count];
        for(int i = 1 ; i < count+1 ; i++) {
            title[i-1] = rsmd.getColumnName(i);
        }
        return title;
    } 
}
