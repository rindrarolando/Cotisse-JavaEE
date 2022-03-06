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
public class Medecin {
    private int id;
    public String nom;
    private String dtn;
    public String statut;
    private float salaire_base;
    private float prime;

    public Medecin() {
    }

    public Medecin(int id, String nom, String dtn, String statut, float salaire_base, float prime) {
        setId(id);
        setNom(nom);
        setDtn(dtn);
        setStatut(statut);
        setSalaire_base(salaire_base);
        setPrime(prime);
    }

    public Medecin(int id, String nom, String dtn, String statut, float salaire_base) {
        setId(id);
        setNom(nom);
        setDtn(dtn);
        setStatut(statut);
        setSalaire_base(salaire_base);
    }
    
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

    public String getStatut() {
        return statut;
    }

    public void setStatut(String statut) {
        this.statut = statut;
    }

    public float getSalaire_base() {
        return salaire_base;
    }

    public void setSalaire_base(float salaire_base) {
        this.salaire_base = salaire_base;
    }

    public float getPrime() {
        return prime;
    }

    public void setPrime(float prime) {
        this.prime = prime;
    }
    
    
}
