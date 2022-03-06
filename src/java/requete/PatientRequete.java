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

public class PatientRequete {
    /*CRUD*/
    public void InsererPatient(Patient p) throws SQLException, Exception {
        if(p.getDate_sortie() == null) {
            String request = "INSERT INTO Patient(nom,dtn,idmaladie,statut,date_entree) VALUES('"+p.getNom()+"',DATE '"+p.getDtn()+"', "+p.getIdmaladie()+",'"+p.getStatut()+"',  DATE '"+p.getDate_entree()+"')";
            Connexion connexion = new Connexion(request);
            connexion.getConnection().close();
        }
        else{
            String request = "INSERT INTO Patient(nom,dtn,idmaladie,statut,date_entree,date_sortie) VALUES('"+p.getNom()+"',DATE '"+p.getDtn()+"', "+p.getIdmaladie()+",'"+p.getStatut()+"',  DATE '"+p.getDate_entree()+"', DATE '"+p.getDate_sortie()+"')";
            Connexion connexion = new Connexion(request);
            connexion.getConnection().close();
        }
    }
    public void AttribuerChambre(Patient p,String id) throws SQLException, Exception {
        String request = "INSERT INTO hebergement(idchambre,idpatient) VALUES("+p.getId()+",'"+id+"')";
        Connexion connexion = new Connexion(request);
        connexion.getConnection().close();
    }
    public void ChagementStatut (Patient p) throws SQLException, Exception{
        String request = "UPDATE Patient SET statut='Gueri' WHERE nom='"+p.getNom()+"'";
        Connexion connexion = new Connexion(request);
        connexion.getConnection().close();
    }
    public void SortiePatient (Patient p,String sortie) throws SQLException, Exception{
        p.setDate_sortie(sortie);
        String request = "UPDATE Patient SET date_sortie=DATE '"+p.getDate_sortie()+"' WHERE nom='"+p.getNom()+"'";
        Connexion connexion = new Connexion(request);
        connexion.getConnection().close();
    }
    
    
    
    /*Avoir l'ID d'un patient grâce à son nom*/
    public int getID(String nom) throws SQLException, Exception {
        String request = "SELECT ID FROM Patient WHERE Nom='"+nom+"'";
        Connexion connexion = new Connexion(request);
        ResultSet rs = connexion.getResultSet();
        int ID = 0;
        while(rs.next()) {
            ID = rs.getInt(1);
        }
        return ID;
    }
    /*Liste patients*/
    public ArrayList<Patient> ListePatient() throws SQLException, Exception {
        String request = "SELECT * FROM Patient";
        Connexion connexion = new Connexion(request);
        ResultSet rs = connexion.getResultSet();
        ArrayList<Patient> ar = new ArrayList<Patient>();
        while(rs.next()) {
            int id = rs.getInt(1);
            String nom = rs.getString(2);
            String dtn = rs.getString(3);
            int idmaladie = rs.getInt(4);
            String statut = rs.getString(5);
            String date_entree = rs.getString(6);
            String date_sortie = rs.getString(7);
            Patient patient = new Patient();
            if(date_sortie == null) {
                patient = new Patient(id,nom,dtn,idmaladie,statut,date_entree);
            }
            else{
                patient = new Patient(id,nom,dtn,idmaladie,statut,date_entree,date_sortie);
            }
            ar.add(patient);
        }
        connexion.getConnection().close();
        return ar;
    } 
    /*Patient + sa maladie*/
    public ArrayList<Object> MaladiePatient(String nom) throws SQLException, Exception {
        String request = "SELECT p.nom, m.description as maladie, m.echelle, p.statut FROM Patient p INNER JOIN Maladie m ON p.idmaladie=m.id WHERE p.nom='"+nom+"'";
        Connexion connexion = new Connexion(request);
        ResultSet rs = connexion.getResultSet();
        ArrayList<Object> ar = new ArrayList<Object>();
        while(rs.next()) {
            ar.add(rs.getString(1));
            ar.add(rs.getString(2));
            ar.add(rs.getInt(3));
            ar.add(rs.getString(4));
        }
        connexion.getConnection().close();
        return ar;
    }
}
