/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import entities.Events;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import controller.GestionController;
import entities.Actualities;
import static java.sql.DriverManager.println;
import java.sql.PreparedStatement;
import javafx.scene.control.Alert;
import utils.MyDB;

/**
 *
 * @author Administrator
 */
public class EventService {

    Connection cnx;
    Statement ste;
    ResultSet rs;

    public EventService() {
        try {
            cnx = MyDB.getInstance().getCnx();
            ste = (Statement) cnx.createStatement();
        } catch (SQLException ex) {
            Logger.getLogger(EventService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void insert(Events u) {
        String req = "insert events  (name_eve,date_eve,description_eve,photo_eve,id_member) values ('" + u.getName_eve() + "','" + u.getDate_eve() + "','" + u.getDescription_eve() + "','" + u.getPhoto_eve() + "','" + u.getId_member() + "')";
        try {
            ste.executeUpdate(req);
        } catch (SQLException ex) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("Member id non valid");
            alert.show();
        }
    }

    /*public ObservableList<Events> displayAll() {
        String req = "select name_eve,member_id,photo_eve,date_eve,description_eve from events";
        ObservableList<Events> list = FXCollections.observableArrayList();

        try {
            rs = ste.executeQuery(req);
            while (rs.next()) {
                Events p = new Events();
                p.setName_eve(rs.getString("nom"));
                list.add(p);
            }

        } catch (SQLException ex) {
            Logger.getLogger(EventService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }*/

    public List<Events> displayAllList() {
        String req = "select * from events";
        List<Events> list = new ArrayList<>();
        

        try {
            rs = ste.executeQuery(req);
            while (rs.next()) {
                Events p = new Events();
                p.setId_event(rs.getInt("id_event"));
                p.setName_eve(rs.getString("name_eve"));
                p.setDate_eve(rs.getString("date_eve"));
                p.setDescription_eve(rs.getString("description_eve"));
                p.setPhoto_eve(rs.getString("photo_eve"));
                p.setId_member(rs.getInt("id_member"));
                list.add(p);
                //p.setName_eve(rs.getString("nom"));
                //list.add(p);
                
                
            }
            
            

        } catch (SQLException ex) {
            Logger.getLogger(EventService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    public ObservableList<Events> getEventsList() throws SQLException {
        ObservableList<Events> eventsList = FXCollections.observableArrayList();
        List<String> idmem = new ArrayList<>();
        Statement stm = cnx.createStatement();
        String query = "select name_eve,date_eve,description_eve,photo_eve,id_member from events";
        //ResultSet rs;
        rs = stm.executeQuery(query);
        Events events;
        while (rs.next()) {
            events = new Events(rs.getString("name_eve"), rs.getString("date_eve"), rs.getString("description_eve"), rs.getString("photo_eve"), rs.getInt("id_member"));
            System.out.println(events);
            eventsList.add(events);

        }
        return eventsList;

    }
    public List<String> listmem() throws SQLException {
        List<Events> eventsList = FXCollections.observableArrayList();
        List<String> idmem = new ArrayList<>();
        Statement stm = cnx.createStatement();
        String query = "select distinct id_member from actualities";
        //ResultSet rs;
        rs = stm.executeQuery(query);
        
        while (rs.next()) {
            idmem.add(rs.getString("id_member"));
            System.out.println(idmem);
            
            

        }
        return idmem;
        
        

    }
    
     public List<String> listmemeve() throws SQLException {
        List<Events> eventsList = FXCollections.observableArrayList();
        List<String> idmem = new ArrayList<>();
        Statement stm = cnx.createStatement();
        String query = "select distinct id_member from events";
        //ResultSet rs;
        rs = stm.executeQuery(query);
        
        while (rs.next()) {
            idmem.add(rs.getString("id_member"));
            //System.out.println(idmem);
            
            

        }
        return idmem;
     }
 public void DelEve(int u) {
       try {
            Statement stm=cnx.createStatement();
            String query="delete from events where id_event = '"+u+"'";
           
            stm.executeUpdate(query);
            
       } catch (SQLException ex) {
           Logger.getLogger(EventService.class.getName()).log(Level.SEVERE, null, ex);
       }
    }
     public void updateEve (Integer id,String nom,String date,String description,String photo,int member_id){
         String requete="UPDATE events SET name_eve='"+nom+"', date_eve='"+date+"', description_eve='"+description+"',photo_eve='"+photo+"'  WHERE id_event='"+id+"'";
         
         
         try{
             ste = cnx.createStatement();
            ste.executeUpdate(requete);
            System.out.println("Event modifié");
        } catch (SQLException ex) {
            Logger.getLogger(MyDB.class.getName()).log(Level.SEVERE, null, ex);
        }
     }
 

    public void ModEve(Events u) {
          /*   try {
            String req = "UPDATE events SET date_eve=?,description_eve=?,photo_eve=?, id_member=?" 
                                                      + "WHERE name_eve=?";
            PreparedStatement pst = MyDB.getInstance().getCnx().prepareStatement(req);
            
            pst.setString(1, u.getName_eve());
            pst.setString(2, u.getDate_eve());
            pst.setString(3, u.getDescription_eve());  
            pst.setString(4, u.getPhoto_eve());
            pst.setString(5, u.getDescription_eve());
            pst.setInt(6, u.getId_member());
            
            int rowsUpdated = pst.executeUpdate();
            if (rowsUpdated > 0) {
                System.out.println("Commande modifié");
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }*/
}

    public void updateAct(Integer id, String name_Act, String date_Act, String description_Act, String photo_Act, int id_Member) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
 


}
