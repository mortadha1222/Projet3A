/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import Entities.Suggestion;
import Interfaces.ISuggestion;
import Utils.MyConnection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author ASUS
 */
public class SuggestionService implements ISuggestion<Suggestion>{

    @Override
    public void ajouterSuggestion(Suggestion s) {
       
        String requete = "INSERT INTO `suggestion`(`title`, `description`, `id_user`) VALUES (?,?,?)";

        try {

          PreparedStatement pst = MyConnection.getInstance().getCnx().prepareStatement(requete);
      
          pst.setString(1, s.getTitle());
          pst.setString(2, s.getDescription());
       
          pst.setString(3,String.valueOf("1"));
         
        
          pst.executeUpdate();
           System.out.println("Suggestion  ajouté");
         } catch (SQLException ex) {
            System.out.println(ex.getMessage());
         }
    }

    @Override
    public void supprimerSuggestion(Suggestion s) {
                String req = "DELETE FROM suggestion WHERE id=? ";
         try {
            
            PreparedStatement pst = MyConnection.getInstance().getCnx().prepareStatement(req);
            pst.setInt(1, s.getId());
            pst.executeUpdate();
            
                System.out.println("Suggestion has been removed");
            
          } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            }
    }

    @Override
    public void updateSuggestion(Suggestion s,int id) {
                try {
            String req = "UPDATE `suggestion` SET `title`=?,`description`=?,`id_user`=? WHERE id='"+id+"'";
            PreparedStatement pst = MyConnection.getInstance().getCnx().prepareStatement(req);
          pst.setString(1, s.getTitle());
          pst.setString(2, s.getDescription());
       
          pst.setString(3,String.valueOf("1"));
            int rowsUpdated = pst.executeUpdate();
            if (rowsUpdated > 0) {
                System.out.println("Suggestion modifié");
            }
          } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }   
    }

    @Override
    public List<Suggestion> displaySuggestion() {
                 List<Suggestion> suggestionList = new ArrayList<>();
        try {

           String req = "SELECT * FROM suggestion " ;
                      
           Statement st = MyConnection.getInstance().getCnx().createStatement();
            
           ResultSet rs = st.executeQuery(req);
            while (rs.next()) {
                Suggestion ct = new Suggestion();
                
                ct.setId(rs.getInt("id"));
                ct.setTitle(rs.getString("title"));
                ct.setDescription(rs.getString("description"));
                ct.setAnswer(rs.getString("answer"));
                ct.setId_user(rs.getInt("id_user"));
                suggestionList.add(ct);
           

            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return suggestionList;
    
}
    @Override
    public void updateSuggestionAnswer(Suggestion s,int id) {
                try {
            String req = "UPDATE `suggestion` SET `answer`=? WHERE id='"+id+"'";
            PreparedStatement pst = MyConnection.getInstance().getCnx().prepareStatement(req);
          pst.setString(1, s.getAnswer());
            int rowsUpdated = pst.executeUpdate();
            if (rowsUpdated > 0) {
                System.out.println("Answer ajouter");
            }
          } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }   
    }
}
