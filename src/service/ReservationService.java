/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import Entities.Planning;
import Entities.Reservation;
import Interfaces.IReservation;
import Utils.MyConnection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


/**
 *
 * @author administrater
 */
public class ReservationService implements IReservation<Reservation>{

   public void ajouterReservation(Reservation t) {
        try {
            String req = "INSERT INTO reservations(id_planning,id_member,id_coach)"
                    + "VALUES(?,?,?)";
            PreparedStatement pst = MyConnection.getInstance().getCnx().prepareStatement(req);
            pst.setInt(1,t.getId_planning());
            pst.setInt(2,t.getId_member());
            pst.setInt(3,t.getId_coach());
           
            pst.executeUpdate();
            System.out.println("reservation done");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

    }

   
    public void supprimerReservation(Reservation t) {
         
        try {
            String req = " DELETE FROM Reservations WHERE id_planning=?";
            PreparedStatement pst = MyConnection.getInstance().getCnx().prepareStatement(req);
            pst.setInt(1, t.getId_reservation());
            int rowsDeleted = pst.executeUpdate();
            if (rowsDeleted > 0) {
                System.out.println("Reservation has been deleted");
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }


        public void updateReservation(Reservation t) {
        try {
            String req = "UPDATE Reservations SET id_planning=?,id_member=?,id_coach=? ";
            PreparedStatement pst = MyConnection.getInstance().getCnx().prepareStatement(req);
            pst.setInt(1, t.getId_planning());
            pst.setInt(2, t.getId_member());
            pst.setInt(3, t.getId_coach());
          
            
            
            int rowsUpdated = pst.executeUpdate();
            if (rowsUpdated > 0) {
                System.out.println("Reservation  modifed");
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }


    public List<Reservation> displayReservations() {

        List<Reservation> reservationList = new ArrayList<>();
        try {

            String req = "SELECT * FROM Reservations";
            Statement st = MyConnection.getInstance().getCnx().createStatement();
            ResultSet rs = st.executeQuery(req);
            while (rs.next()) {
                Reservation t = new Reservation();
                t.setId_reservation(rs.getInt("id"));
                t.setId_planning(rs.getInt("id"));
                t.setId_member(rs.getInt("id"));
                t.setId_coach(rs.getInt("id"));
                reservationList.add(t);

            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return reservationList;
    }
}
