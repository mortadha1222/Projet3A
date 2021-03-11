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
public interface IUser <U> {
    
    public void ajouterUser(U u);
    public void supprimerUser(U u);
    public void updateUser(U u);
    public List<U> displayUser(); 
}
