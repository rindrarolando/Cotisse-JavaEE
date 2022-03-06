/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package requete;

import models.*;
import connexion.*;

import java.sql.*;
import java.util.ArrayList;

public class MaladieRequete {
    
    public ArrayList<Maladie> getmaladie() throws SQLException, Exception {
        String request = "SELECT * FROM maladie";
        Connexion connexion = new Connexion(request);
        ResultSet rs = connexion.getResultSet();
        ArrayList<Maladie> ar = new ArrayList<Maladie>();
        while(rs.next()) {
            int id = rs.getInt(1);
            String description = rs.getString(2);
            int echelle = rs.getInt(3);
            Maladie maladie = new Maladie(id,description,echelle);
            ar.add(maladie);
        }
        connexion.getConnection().close();
        return ar;
    }
}
