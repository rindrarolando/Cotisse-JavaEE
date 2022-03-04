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
public class Maladie {
    
    public int id;
    public String description;
    public int echelle;
    
    public Maladie(){}
    
    public Maladie(int id, String description, int echelle) {
        setId(id);
        setDescription(description);
        setEchelle(echelle);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getEchelle() {
        return echelle;
    }

    public void setEchelle(int echelle) {
        this.echelle = echelle;
    }
}
