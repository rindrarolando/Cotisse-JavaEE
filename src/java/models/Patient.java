/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

/**
 *
 * @author Bryan
 */
public class Patient {
    private int id;
    public String nom;
    public String dtn;
    private int idmaladie;
    public String statut;
    public String date_entree;
    public String date_sortie;
    
    public Patient() {}
    
    //Au cas où il y a une date de sortie
    public Patient(int id, String nom, String dtn, int idmaladie, String statut, String date_entree, String date_sortie) {
        setId(id);
        setNom(nom);
        setDtn(dtn);
        setIdmaladie(idmaladie);
        setStatut(statut);
        setDate_entree(date_entree);
        setDate_sortie(date_sortie);
    }
    //Au cas où il n'y a pas de date de sortie
    public Patient(int id, String nom, String dtn, int idmaladie, String statut, String date_entree) {
        setId(id);
        setNom(nom);
        setDtn(dtn);
        setIdmaladie(idmaladie);
        setStatut(statut);
        setDate_entree(date_entree);
    }
    //Patient + maladie + statut
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getDtn() {
        return dtn;
    }

    public void setDtn(String dtn) {
        this.dtn = dtn;
    }

    public int getIdmaladie() {
        return idmaladie;
    }

    public void setIdmaladie(int idmaladie) {
        this.idmaladie = idmaladie;
    }

    public String getStatut() {
        return statut;
    }

    public void setStatut(String statut) {
        this.statut = statut;
    }

    public String getDate_entree() {
        return date_entree;
    }

    public void setDate_entree(String date_entree) {
        this.date_entree = date_entree;
    }

    public String getDate_sortie() {
        return date_sortie;
    }

    public void setDate_sortie(String date_sortie) {
        this.date_sortie = date_sortie;
    }
}
