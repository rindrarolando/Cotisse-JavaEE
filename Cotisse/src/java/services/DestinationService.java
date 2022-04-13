/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import java.util.ArrayList;
import objects.Destination;

/**
 *
 * @author rindrarolando
 */
public class DestinationService {
    Destination d = new Destination();
    
    public Destination getDestination(int id) throws Exception{
        return d.getDestination(id);
    }
    
    public ArrayList<Destination> getDestinations()throws Exception{
        return d.getDestinations();
    }
}
