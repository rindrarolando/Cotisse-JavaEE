/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import objects.Administrator;
import objects.Destination;

/**
 *
 * @author rindrarolando
 */
public class AdministratorService {
    Administrator a = new Administrator();
    
    public Administrator checkAdmin(String login, String mdp) throws Exception{
        return a.checkAdmin(login, mdp);
    }
    
    public void supprimerDestination(Destination dest) throws Exception{
        a.supprimerDestination(dest);
    }
    
    public void ajouterDestination(String desc) throws Exception{
        a.ajouterDestination(desc);
    }
    
    public void modifierDestination(Destination dest, String desc) throws Exception{
        a.modifierDestination(dest, desc);
    }
    
}
