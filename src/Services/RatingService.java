/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import Entities.Rating;
import Interfaces.IRating;
import Utils.MyConnection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author ASUS
 */
public class RatingService implements IRating<Rating>{

    @Override
    public void ajouterRating(Rating r) {
               String requete = "INSERT INTO `rating`(`value`, `id_user`) VALUES (?,?)";

        try {

          PreparedStatement pst = MyConnection.getInstance().getCnx().prepareStatement(requete);
 
          pst.setString(1,String.valueOf(r.getValue()));
       
          pst.setString(2,String.valueOf("1"));
         
        
          pst.executeUpdate();
           System.out.println("Rate  ajouté");
         } catch (SQLException ex) {
            System.out.println(ex.getMessage());
         }
    }

    @Override
    public void updateRating(Rating r, int id) {
                       try {
            String req = "UPDATE `rating` SET `value`=? WHERE id_user='"+id+"'";
            PreparedStatement pst = MyConnection.getInstance().getCnx().prepareStatement(req);
          pst.setString(1,String.valueOf(r.getValue()));
            int rowsUpdated = pst.executeUpdate();
            if (rowsUpdated > 0) {
                System.out.println("Rate modifié");
            }
          } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }  
    }

    @Override
    public String displayYourRate(int id_user) {


           //String req = "SELECT value FROM rating where id_user='"+id_user+"'";
        String re="" ;
 
        try {
                      
           Statement st;
          

            st = MyConnection.getInstance().getCnx().createStatement();
            ResultSet aveTemp = st.executeQuery("SELECT value FROM rating where id_user='"+id_user+"'"); 
if (aveTemp.next()) {
    re=Double.toString(aveTemp.getDouble(1)); 
}
            System.out.println("rate");
            
           
        } catch (SQLException ex) {
            Logger.getLogger(RatingService.class.getName()).log(Level.SEVERE, null, ex);
            
        }
        return re;
    }

    @Override
    public String displayRate() {
        String re="" ;
 
        try {
            //String req = "SELECT AVG(value) FROM rating";
                      
           Statement st;
          

            st = MyConnection.getInstance().getCnx().createStatement();
            ResultSet aveTemp = st.executeQuery("SELECT AVG(value) FROM rating"); 
if (aveTemp.next()) {
    re=Double.toString(aveTemp.getDouble(1)); 
}
            System.out.println("rate");
            
           
        } catch (SQLException ex) {
            Logger.getLogger(RatingService.class.getName()).log(Level.SEVERE, null, ex);
            
        }
        return re;
    }
    
    }
    

