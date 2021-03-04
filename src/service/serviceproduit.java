/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import entities.produit;
import helpers.Maconnexion;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import services.Iservicesproduit;

/**
 *
 * @author LeNoVo
 */
public class serviceproduit implements Iservicesproduit{
    
    Connection cnx;
    public serviceproduit(){
    cnx =Maconnexion.getInstance().getConnection();
    }
    @Override
    public void addproduit(produit p) {
        try {
            Statement stm =cnx.createStatement();
   
            String query ="INSERT INTO `produits`(`title` , `description_prod`, `price`, `photo_prod`, `stock`, `id_vendor`) VALUES ('"+p.getTitle()+"','"+p.getDescription_prod()+"','"+p.getPrice()+"','"+p.getPhoto_prod()+"','"+p.getStock()+"','"+p.getId_vendor()+"')";
            stm.executeUpdate(query);
        } catch (SQLException ex) {
            Logger.getLogger(serviceproduit.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
        

    @Override
    @SuppressWarnings("empty-statement")
    public List<produit> Afficherproduits() throws SQLException {
       
            Statement stm = cnx.createStatement();
            String query ="select * from produits";
            ResultSet rst = stm.executeQuery(query);
            List<produit>produits = new ArrayList<>();
            while(rst.next())
            {
                produit p = new produit();
                p.setId_product(rst.getInt("id_product"));
                p.setTitle(rst.getString("title"));
                p.setDescription_prod(rst.getString("description_prod"));
                p.setPrice(rst.getFloat("price"));
                p.setPhoto_prod(rst.getString("photo_prod"));
                p.setStock(rst.getInt("stock"));
                p.setId_vendor(rst.getInt("id_vendor"));
                produits.add(p);
                
            }
            
        
           return produits;  
        }
        
}
