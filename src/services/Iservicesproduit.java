/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import entities.produit;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author LeNoVo
 */
public interface Iservicesproduit   {
    public void addproduit  (produit p);
    public List<produit> Afficherproduits   () throws SQLException;
    
    
}
