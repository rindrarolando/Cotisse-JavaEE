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
            count++;
        }
        return count;
    }
    //Liste des maladies
    public ArrayList<Maladie> getmaladie() throws SQLException, Exception {
        String request = "SELECT * FROM maladie";
        Connexion connexion = new Connexion(request);
        ResultSet rs = connexion.getResultSet();
        ArrayList<Maladie> list = new ArrayList<Maladie>();
        while(rs.next()) {
            int id = rs.getInt(1);
            String description = rs.getString(2);
            int echelle = rs.getInt(3);
            Maladie maladie = new Maladie(id,description,echelle);
            list.add(maladie);
        }
        return list;
    }
    //inserer un nouveau patient
    public void InsererPatient(Patient p) throws SQLException, Exception {
        if(p.getDate_sortie() == null) {
            String request = "INSERT INTO Patient(nom,dtn,idmaladie,statut,date_entree) VALUES('"+p.getNom()+"',DATE '"+p.getDtn()+"', "+p.getIdmaladie()+",'"+p.getStatut()+"',  DATE '"+p.getDate_entree()+"')";
            Connexion connexion = new Connexion(request);
        }
        else{
            String request = "INSERT INTO Patient(nom,dtn,idmaladie,statut,date_entree,date_sortie) VALUES('"+p.getNom()+"',DATE '"+p.getDtn()+"', "+p.getIdmaladie()+",'"+p.getStatut()+"',  DATE '"+p.getDate_entree()+"', DATE '"+p.getDate_sortie()+"')";
            Connexion connexion = new Connexion(request);
        }
    }
}
