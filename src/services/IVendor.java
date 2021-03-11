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
public interface IVendor  <V> {
    
    public void ajouterPanier(V v);
    public void supprimerPanier(V v);
    public void updatePanier(V v);
    public List<V> displayPanier();

}
