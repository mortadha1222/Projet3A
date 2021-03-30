/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

import java.util.List;

/**
 *
 * @author ASUS
 */
public interface IReclamation <R>{
    
        public void ajouterReclamation(R r);
    public void supprimerReclamation(R r);
    public void updateReclamationAnswer(R r , int id);
    public List<R> displayReclamation();
    
}
