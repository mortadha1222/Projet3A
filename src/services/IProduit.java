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
public interface IProduit <P> {
    
    public void ajouterPanier(P p);
    public void supprimerPanier(P p);
    public void updatePanier(P p);
    public List<P> displayPanier();

}
