/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import Entities.Reclamation;
import Interfaces.IReclamation;
import Utils.MyConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author ASUS
 */
public class ReclamationService implements IReclamation<Reclamation>{

        Connection cnx;
     public ReclamationService() {
          
        cnx = MyConnection.getInstance().getCnx();

    }
         public List<Reclamation> read(int id_user) throws SQLException {
        List<Reclamation> lr = new ArrayList<Reclamation>();
        Statement st = cnx.createStatement();
        id_user=1;
        String req = "select * from reclamation where id_user="+id_user+" and archive IS NULL";
        ResultSet rs = st.executeQuery(req);

        while (rs.next()) {
            int id = rs.getInt("id");
            String title = rs.getString("title");
            String description = rs.getString("description");
            String answer = rs.getString("answer");
            Date date=rs.getDate("date");

            Reclamation p = new Reclamation(id,title,description,answer,id_user,date);
            lr.add(p);
        }
        return lr;
    }
                  public List<Reclamation> readarchive(int id_user) throws SQLException {
        List<Reclamation> lr = new ArrayList<Reclamation>();
        Statement st = cnx.createStatement();
        id_user=1;
        String req = "select * from reclamation where id_user="+id_user+" and archive = archive";
        ResultSet rs = st.executeQuery(req);
        

        while (rs.next()) {
            int id = rs.getInt("id");
            String title = rs.getString("title");
            String description = rs.getString("description");
            String answer = rs.getString("answer");
            Date date=rs.getDate("date");

            Reclamation p = new Reclamation(id,title,description,answer,id_user,date);
            lr.add(p);
        }
        return lr;
    }
         
             public Reclamation readdetails(int idr) throws SQLException {
        Reclamation p =null;
        Statement st = cnx.createStatement();
        String req = "select * from reclamation where id="+idr+"";
        ResultSet rs = st.executeQuery(req);

        while (rs.next()) {
            int id = rs.getInt("id");
            String title = rs.getString("title");
            String description = rs.getString("description");
            String answer = rs.getString("answer");
            int id_user = rs.getInt("id_user");
            Date date=rs.getDate("date");
             p = new Reclamation(id,title,description,answer,id_user,date);          
        }
      return p;
    }
             
      public int getId() throws SQLException {
        Statement st = cnx.createStatement();
        String req = "select id from reclamation" ;
        ResultSet rs = st.executeQuery(req);    
            int id = rs.getInt("id");    
        return id;
    }
         
         
    
    @Override 
    public void ajouterReclamation(Reclamation r) {
       
        String requete = "INSERT INTO `reclamation`(`title`, `description`, `id_user`,`date`) VALUES (?,?,?,?)";

        try {

          PreparedStatement pst = MyConnection.getInstance().getCnx().prepareStatement(requete);
      
          pst.setString(1, r.getTitle());
          pst.setString(2, r.getDescription());
       
          pst.setInt(3,r.getId_user());
          pst.setDate(4, new java.sql.Date(r.getDate().getTime()));
         
        
          pst.executeUpdate();
           System.out.println("Reclamation  ajouté");
         } catch (SQLException ex) {
            System.out.println(ex.getMessage());
         }
    }

    @Override
    public void supprimerReclamation(Reclamation r) {
                String req = "DELETE FROM reclamation WHERE id=? ";
         try {
            
            PreparedStatement pst = MyConnection.getInstance().getCnx().prepareStatement(req);
            pst.setInt(1, r.getId());
            pst.executeUpdate();
            
                System.out.println("Reclamation has been removed");
            
          } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            }
    }
        public void archiverReclamation(Reclamation r) {
                String req = "UPDATE `reclamation` SET `archive`=? WHERE id=? ";
         try {
            
            PreparedStatement pst = MyConnection.getInstance().getCnx().prepareStatement(req);
            pst.setString(1, r.getArchive());
            pst.setInt(2, r.getId());
            pst.executeUpdate();
            
                System.out.println("Reclamation has been archived");
            
          } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            }
    }

   


    @Override
    public List<Reclamation> displayReclamation() {
                 List<Reclamation> reclamationList = new ArrayList<>();
        try {

           String req = "SELECT * FROM reclamation " ;
                      
           Statement st = MyConnection.getInstance().getCnx().createStatement();
            
           ResultSet rs = st.executeQuery(req);
            while (rs.next()) {
                Reclamation ct = new Reclamation();
                
                ct.setId(rs.getInt("id"));
                ct.setTitle(rs.getString("title"));
                ct.setDescription(rs.getString("description"));
                ct.setAnswer(rs.getString("answer"));
                ct.setId_user(rs.getInt("id_user"));
                ct.setDate(rs.getDate("date"));
                reclamationList.add(ct);
           

            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return reclamationList;
    
}
    @Override
    public void updateReclamationAnswer(Reclamation r,int id) {
                try {
            String req = "UPDATE `reclamation` SET `answer`=? WHERE id='"+id+"'";
            PreparedStatement pst = MyConnection.getInstance().getCnx().prepareStatement(req);
          pst.setString(1, r.getAnswer());
            int rowsUpdated = pst.executeUpdate();
            if (rowsUpdated > 0) {
                System.out.println("answer ajouter");
            }
          } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }   
    }

    public void updateReclamation(Reclamation u, int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
