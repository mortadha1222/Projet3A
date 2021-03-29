/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

/**
 *
 * @author Bali
 *
 */
import entities.Actualities;
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
import static java.sql.DriverManager.println;
import java.sql.PreparedStatement;
import javafx.scene.control.Alert;
import utils.MyDB;

public class ActuService {

    Connection cnx;
    Statement ste;
    ResultSet rs;

    public ActuService() {
        try {
            cnx = MyDB.getInstance().getCnx();
            ste = (Statement) cnx.createStatement();
        } catch (SQLException ex) {
            Logger.getLogger(ActuService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void insertAct(Actualities u) {
        String req = "insert Actualities  (title_act,date_act,description_act,photo_act,id_member) values ('" + u.getName_Act() + "','" + u.getDate_act() + "','" + u.getDescription_act() + "','" + u.getPhoto_act() + "','" + u.getId_member() + "')";
        try {
            ste.executeUpdate(req);
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Added");
            alert.show();
        } catch (SQLException ex) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Failed to add actuality");
            alert.show();
        }

    }

    public ObservableList<Actualities> getActuList() throws SQLException {
        String req = "select  id_act,title_act, date_act, description_act , photo_act , id_member from actualities";
        ObservableList<Actualities> list = FXCollections.observableArrayList();

        try {
            rs = ste.executeQuery(req);
            while (rs.next()) {
                Actualities p = new Actualities();
                p.setId_act(rs.getInt("id_act"));
                p.setTitle_act(rs.getString("title_act"));
                p.setDate_act(rs.getString("date_act"));
                p.setDescription_act(rs.getString("description_act"));
                p.setPhoto_act(rs.getString("photo_act"));
                p.setId_member(rs.getInt("id_member"));
                list.add(p);

            }

        } catch (SQLException ex) {
            Logger.getLogger(ActuService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;

    }

    public void DelAct(int u) {
        try {
            Statement stm = cnx.createStatement();
            String query = "delete  from actualities where id_act = '" + u + "'";
            println(query);
            stm.executeUpdate(query);

        } catch (SQLException ex) {
            Logger.getLogger(ActuService.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public List<Actualities> displayAllLista() {
        String req = "select  id_act,title_act, date_act, description_act , photo_act , id_member from actualities";
        List<Actualities> list = new ArrayList<>();

        try {
            rs = ste.executeQuery(req);
            while (rs.next()) {
                Actualities p = new Actualities();
                p.setId_act(rs.getInt("id_act"));
                p.setTitle_act(rs.getString("title_act"));
                p.setDate_act(rs.getString("date_act"));
                p.setDescription_act(rs.getString("description_act"));
                p.setPhoto_act(rs.getString("photo_act"));
                p.setId_member(rs.getInt("id_member"));
                list.add(p);

            }

        } catch (SQLException ex) {
            Logger.getLogger(ActuService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    public void updateAct(Integer id, String nom, String description, String photo, int member_id) {
        String requete = "UPDATE actualities SET title_act='" + nom + "',  description_act='" + description + "',photo_act='" + photo + "', id_member='" + member_id + "'  WHERE id_act='" + id + "'";

        try {
            ste = cnx.createStatement();
            ste.executeUpdate(requete);
            System.out.println("actualite modifié");
        } catch (SQLException ex) {
            Logger.getLogger(MyDB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
