/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

import java.util.List;

/**
 *
 * @author moham
 */
public interface ICommande <C> {
    
    public void ajouterCommande(C c);
    public void supprimerCommande(C c);
    public void updateCommande(C c);
    public List<C> displayCommande();
}
