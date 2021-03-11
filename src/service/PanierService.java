/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import Entities.Panier;
import Entities.Produit;
import Entities.User;
import Interfaces.IPanier;
import java.util.List;
import Utils.MyConnection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;


/**
 *
 * @author moham
 */
public class PanierService implements IPanier<Panier>{

    @Override
    public void ajouterPanier(Panier p) {
        String requete = "INSERT INTO panier(id_product,id_user,quantity,total) VALUES (?,?,?,?)";

        try {

          PreparedStatement pst = MyConnection.getInstance().getCnx().prepareStatement(requete);
              
          pst.setInt(1, p.getId_product());
          pst.setInt(2, p.getId_user());
          pst.setInt(3, p.getQuantity());
          pst.setInt(4, p.getTotal());
          
        //  pst.setInt(4, p.getProduit().getPrice()*p.getQuantity());
          pst.executeUpdate();
           System.out.println("Panier  ajouté");
         } catch (SQLException ex) {
            System.out.println(ex.getMessage());
         }
    }

    @Override
    public void supprimerPanier(Panier p) {
         String req = "DELETE FROM panier WHERE id_panier=? ";
         try {
            
            PreparedStatement pst = MyConnection.getInstance().getCnx().prepareStatement(req);
            pst.setInt(1, p.getId_panier());
            pst.executeUpdate();
            
                System.out.println("Product has been removed");
            
          } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            }
    }

    @Override
    public void updatePanier(Panier p) {
          try {
            String req = "UPDATE panier SET quantity=?,total=?"
                       + "WHERE id_panier=?";
            PreparedStatement pst = MyConnection.getInstance().getCnx().prepareStatement(req);
            
            pst.setInt(3, p.getQuantity());  
            pst.setInt(4, p.getProduit().getPrice()*p.getQuantity());
            pst.setInt(5, p.getId_panier());
            int rowsUpdated = pst.executeUpdate();
            if (rowsUpdated > 0) {
                System.out.println("Panier modifié");
            }
          } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        } 
    }

//    @Override
//    public List<Panier> displayPanier() {
// List<Panier> panierList = new ArrayList<>();
//        try {
//
//         //  String req = "SELECT * FROM panier " ;
//        String req = " " ;   
//                      
//           Statement st = MyConnection.getInstance().getCnx().createStatement();
//            
//           ResultSet rs = st.executeQuery(req);
//            while (rs.next()) {
//                Panier p = new Panier();
//                Produit pt = new Produit();
//                User us = new User();
//                //p.setId_product(rs.getInt("id_product"));
//                pt.setId_product(rs.getInt("id_product"));
//                
//                //p.setUser(rs.getInt("id_user"));
//                us.setId_user(rs.getInt("id_user"));
//               
//                
//                p.setQuantity(rs.getInt("quantity"));
//                p.setTotal(rs.getInt("total"));
//                panierList.add(p);
//           
//
//            }
//        } catch (SQLException ex) {
//            System.out.println(ex.getMessage());
//        }
//        return panierList;    }
//    
//    
  
     public ObservableList<Panier> DisplayPanier() throws SQLException {
         

        ObservableList<Panier> Panier = FXCollections.observableArrayList();
            String req = "select p.id_panier, p.quantity,p.total,c.title,c.price,c.stock from panier p join produits c on p.id_product=c.id_product";
            Statement st = MyConnection.getInstance().getCnx().createStatement();
            ResultSet result = st.executeQuery(req);
            while (result.next()) {
                Panier p  = new Panier(
              
              
                result.getInt("id_panier"),
                result.getInt("quantity"),
                result.getInt("total"),
                result.getString("title"));

                Panier.add(p);

            }


        return Panier;
 }

//    @Override
//    public List<Panier> displayPanier() {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }

    @Override
    public List<Panier> displayPanier() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
