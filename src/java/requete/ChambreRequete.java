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

public class ChambreRequete {
    /*Liste des chambres*/
    public ArrayList<Chambre> ListeChambre() throws SQLException, Exception {
        String request = "SELECT * FROM Chambre";
        Connexion connexion = new Connexion(request);
        ResultSet rs = connexion.getResultSet();
        ArrayList<Chambre> ar = new ArrayList<Chambre>();
        while(rs.next()) {
            String id = rs.getString(1);
            String categorie = rs.getString(2);
            int capacite = rs.getInt(3);
            float prixparjour = rs.getFloat(4);
            Chambre chambre = new Chambre(id,categorie,capacite,prixparjour);
            ar.add(chambre);
        }
        connexion.getConnection().close();
        return ar;
    }
    
    /*Prix chambre par categorie*/
    public float PrixChambre(String categorie) throws SQLException, Exception {
        String request = "SELECT prixparjour FROM Chambre WHERE categorie='"+categorie+"'";
        Connexion connexion = new Connexion(request);
        ResultSet rs = connexion.getResultSet();
        float prix = 0;
        while(rs.next()) {
            prix = rs.getFloat(1);
        }
        connexion.getConnection().close();
        return prix;
    }
}
