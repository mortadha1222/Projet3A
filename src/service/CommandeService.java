/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;


import Entities.Commande;
import Interfaces.ICommande;
import Utils.MyConnection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author moham
 */
public class CommandeService implements ICommande<Commande>{

    @Override
    public void ajouterCommande(Commande c) {
        String requete = "INSERT INTO commande(id_vendor,id_user,adresse_livraison,totalf) VALUES (?,?,?,?)";

        try {

        PreparedStatement pst = MyConnection.getInstance().getCnx().prepareStatement(requete);
        
        pst.setString(1, c.getVendor_name().getUser().getUsername());
        
        pst.setString(2, c.getUser_name().getUsername());

        pst.setString(3, c.getAdresse_livraison());
        
        pst.setFloat(4, c.getTotal());
        pst.executeUpdate();
        System.out.println("commande passé");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public void supprimerCommande(Commande c) {
     String req = "DELETE FROM commande WHERE id_commande=? ";
         try {
            
            PreparedStatement pst = MyConnection.getInstance().getCnx().prepareStatement(req);
            pst.setInt(1, c.getId_commande());
            pst.executeUpdate();
            int rowsDeleted = pst.executeUpdate();
            if (rowsDeleted > 0) {
                System.out.println("Commande has been removed");
            }
          } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            }
    }

    @Override
    public void updateCommande(Commande c) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public List<Commande> displayCommande(Commande c) {
    
         List<Commande> commandeList = new ArrayList<>();
        try {

           String req = "SELECT * FROM commande "
                   + "WHERE id_user=?" ;
           
           PreparedStatement pst = MyConnection.getInstance().getCnx().prepareStatement(req);
           pst.setInt(1, c.getId_commande());           
           
           Statement st = MyConnection.getInstance().getCnx().createStatement();
            
           ResultSet rs = st.executeQuery(req);
            while (rs.next()) {
                Commande ct = new Commande();
                
          //      ct.setId_vendor(rs.getInt("id_vendor"));
            //    ct.setId_membre(rs.getInt("id_membre"));
              //  ct.setId_panier(rs.getInt("id_panier"));
                ct.setAdresse_livraison(rs.getString("adresse_livraison"));
                ct.setTotal(rs.getInt("total"));
                commandeList.add(ct);
           

            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return commandeList;
    }

    
    public List<Commande> displayCommande(int i) {
      List<Commande> commandeList = new ArrayList<>();
        try {

           String req = "SELECT * FROM commande Where id_user=?" ;
             
           PreparedStatement pst = MyConnection.getInstance().getCnx().prepareStatement(req);
              
            pst.setInt(1, i);      
           Statement st = MyConnection.getInstance().getCnx().createStatement();
           
           ResultSet rs = st.executeQuery(req);
            while (rs.next()) {
                Commande ct = new Commande();
                
                ct.setId_commande(rs.getInt("id_commande"));
                ct.setAdresse_livraison(rs.getString("adresse_livraison"));
                ct.setTotal(rs.getInt("total"));
                commandeList.add(ct);
           
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return commandeList;
    }

    @Override
    public List<Commande> displayCommande() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
