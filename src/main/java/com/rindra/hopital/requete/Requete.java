package com.rindra.hopital.requete;
import com.rindra.hopital.connexion.*;
import com.rindra.hopital.models.*;

import java.sql.*;
import java.util.ArrayList;
import java.util.Vector;

public class Requete {
    //avoir les maladies
    public ArrayList<Maladie> getmaladie() throws SQLException, Exception {
        String request = "SELECT * FROM maladie";
        Connexion connexion = new Connexion(request);
        ResultSet resultset = connexion.getResultSet();
        Vector id = new Vector();
        Vector description = new Vector();
        Vector echelle = new Vector();
        int count = 0;
        while(resultset.next()) {
            id.add(resultset.getInt(1));
            description.add(resultset.getString(2));
            echelle.add(resultset.getInt(3));
            count++;
        }
        Object[] ID = id.toArray();
        Object[] Descri = description.toArray();
        Object[] Echelle = echelle.toArray();
        Maladie[] maladie = new Maladie[count];
        ArrayList<Maladie> ar = new ArrayList<Maladie>();
        for(int i = 0 ; i < count ; i++) {
            maladie[i] = new Maladie((int)ID[i], String.valueOf(Descri[i]),(int)Echelle[i]);
            ar.add(maladie[i]);
        }
        if(connexion.getConnection() != null && connexion.getStatement() != null && connexion.getResultSet() != null) {
            connexion.getResultSet().close();
            connexion.getStatement().close();
            connexion.getConnection().close();
        }
        return ar;
    }
    //insérer un nouveau patient
    public void InsererPatient(Patient p) throws SQLException, Exception {
        if(p.getDate_sortie() == null) {
            String request = "INSERT INTO Patient(nom,dtn,idmaladie,statut,date_entree) VALUES('"+p.getNom()+"',DATE '"+p.getDtn()+"', "+p.getIdmaladie()+",'"+p.getStatut()+"', DATE '"+p.getDate_entree()+"')";
            Connexion connexion = new Connexion(request);
            System.out.println(request);
        }
        else{
            String request = "INSERT INTO Patient(nom,dtn,idmaladie,statut,date_entree,date_sortie) VALUES('"+p.getNom()+"',DATE '"+p.getDtn()+"', "+p.getIdmaladie()+",'"+p.getStatut()+"', DATE '"+p.getDate_entree()+"', DATE '"+p.getDate_sortie()+"')";
            Connexion connexion = new Connexion(request);
            System.out.println(request);
        }
    }

}
