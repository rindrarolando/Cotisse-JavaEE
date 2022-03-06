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

public class MedecinRequete {
    public ArrayList<Medecin> ListeMedecin() throws SQLException, Exception {
        String request = "SELECT * FROM Medecin";
        Connexion connexion = new Connexion(request);
        ResultSet rs = connexion.getResultSet();
        ArrayList<Medecin> ar = new ArrayList<Medecin>();
        while(rs.next()) {
            int id = rs.getInt(1);
            String nom = rs.getString(2);
            String dtn = rs.getString(3);
            String statut = rs.getString(4);
            float salaire = rs.getFloat(5);
            float prime = rs.getFloat(6);
            Medecin medecin = new Medecin();
            if(prime == 0.0) {
                medecin = new Medecin(id,nom,dtn,statut,salaire);
            }
            else{
                medecin = new Medecin(id,nom,dtn,statut,salaire,prime);
            }
            ar.add(medecin);
        }
        connexion.getConnection().close();
        return ar;
    }
}
