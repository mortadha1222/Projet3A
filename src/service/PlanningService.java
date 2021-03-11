/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import Entities.Planning;
import Interfaces.IPlanning;
import Utils.MyConnection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import Utils.MyConnection;
import java.sql.Connection;

/**
 *
 * @author administrater
 */
public  class PlanningService implements IPlanning<Planning>{

       Connection cnx;
   public PlanningService(){
   cnx = MyConnection.getInstance().getCnx();
   }
    
   public void ajouterPlanning(Planning t) {
        try {
            String req = "INSERT INTO planning(id_coach,course,startLesson,endLesson,maxNbr)"
                    + "VALUES(?,?,?,?,?)";
            PreparedStatement pst = MyConnection.getInstance().getCnx().prepareStatement(req);  
            pst.setInt(1, t.getId_coach());
            pst.setString(2,t.getCourse());
            pst.setString(3,t.getStartLesson());
            pst.setString(4,  t.getEndLesson());
            pst.setInt(5, t.getMaxNbr());
            pst.executeUpdate();
            System.out.println("Planning has been insert");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

    }

    @Override
    public void supprimerPlanning(Planning t) {
         
        try {
            String req = " DELETE FROM Planning WHERE id_planning=?";
            PreparedStatement pst = MyConnection.getInstance().getCnx().prepareStatement(req);
            pst.setInt(1, t.getId_planning());
            int rowsDeleted = pst.executeUpdate();
            if (rowsDeleted > 0) {
                System.out.println("Planning has been deleted");
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
        public void updatePlanning(Planning t) {
        try {
            String req = "UPDATE Planning SET  id_coach=?, course=?,StartLesson=?,EndLesson=?,MaxNbr=?  WHERE id_planning=?";
            PreparedStatement pst = MyConnection.getInstance().getCnx().prepareStatement(req);
            pst.setInt(1, t.getId_coach());
            pst.setString(2, t.getCourse());
            pst.setString (3,  t.getStartLesson());
            pst.setString (4,   t.getEndLesson());
            pst.setInt(5, t.getMaxNbr());
            
            
            int rowsUpdated = pst.executeUpdate();
            if (rowsUpdated > 0) {
                System.out.println("Planning updated");
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }


   @Override
    public List<Planning> displayPlannings() {

        List<Planning> planningList = new ArrayList<>();
        try {

            String req = "SELECT * FROM Planning";
            Statement st = MyConnection.getInstance().getCnx().createStatement();
            ResultSet rs = st.executeQuery(req);
            while (rs.next()) {
                Planning t = new Planning();
                t.setId_planning(rs.getInt("id_planning"));
                t.setId_coach(rs.getInt("id_coach"));
                t.setCourse(rs.getString("course"));
                t.setStartLesson(rs.getString ("startLesson"));
                t.setEndLesson(rs.getString("endLesson"));
                t.setMaxNbr(rs.getInt("maxNbr"));
                planningList.add(t);

            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return planningList;
    }
    
   
    public ObservableList<Planning> SearchPlanningList(Planning p) throws SQLException{
    ObservableList<Planning> SusersList= FXCollections.observableArrayList();
    Statement stm = cnx.createStatement();
    String query = "select * from `plaaning` where id_coach = '"+p.getId_coach()+"'";
    ResultSet rs;
    rs=stm.executeQuery(query);
    Planning users;
    while(rs.next())
    {
 users = new Planning (rs.getInt("id_plaaning"),rs.getInt("id_coach"),rs.getString("course"),rs.getString("startLesson"),rs.getString("endLesson"),rs.getInt("maxNbr"));  
System.out.println(users);
SusersList.add(users);

    }
    return SusersList;
}
}
