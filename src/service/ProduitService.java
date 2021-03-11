/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import Entities.Commande;
import Entities.Panier;
import Entities.Produit;
import Interfaces.IProduit;
import Utils.MyConnection;
import static Utils.MyConnection.getInstance;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author moham
 */
public class ProduitService implements IProduit<Produit>{

    @Override
    public void ajouterPanier(Produit p) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void supprimerPanier(Produit p) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void updatePanier(Produit p) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

     public ObservableList<Produit> FindAll() throws SQLException {
         

        ObservableList<Produit> Produit = FXCollections.observableArrayList();

       

            String req = "SELECT * FROM produits ORDER BY price DESC ";
                  
            Statement st = MyConnection.getInstance().getCnx().createStatement();
            ResultSet result = st.executeQuery(req);
            while (result.next()) {
                Produit c =new Produit(
                result.getInt("id_product"),
                result.getString("title"),
                result.getString("description_prod"),
                result.getInt("price"),
                result.getInt("stock")
              
               );
                
              
               Produit.add(c);

            }


        
     
           
           
            
           
           

         
        return Produit;
    }

    @Override
    public List<Produit> displayPanier() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

     }

  

   
    

