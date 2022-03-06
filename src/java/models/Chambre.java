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
public class Chambre {
    private String id;
    public String categorie;
    private int capacite;
    public float prixparjour;

    public Chambre() {}

    public Chambre(String id, String categorie, int capacite, float prixparjour) {
        setId(id);
        setCategorie(categorie);
        setCapacite(capacite);
        setPrixparjour(prixparjour);
    }

    public Chambre(String categorie, int capacite, float prixparjour) {
        setCategorie(categorie);
        setCapacite(capacite);
        setPrixparjour(prixparjour);
    }
    public Chambre(String id) {
        setId(id);
    }

    
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getCategorie() {
        return categorie;
    }
    public void setCategorie(String categorie) {
        this.categorie = categorie;
    }
    public int getCapacite() {
        return capacite;
    }
    public void setCapacite(int capacite) {
        this.capacite = capacite;
    }

    public float getPrixparjour() {
        return prixparjour;
    }

    public void setPrixparjour(float prixparjour) {
        this.prixparjour = prixparjour;
    }
    
    
}
