/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestionprofil;

import entities.users;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import service.ServiceUser;

/**
 * FXML Controller class
 *
 * @author mortadha
 */
public class FXML2Controller implements Initializable {

    @FXML
    private TextField tfusername;
    @FXML
    private TextField tfpassword;
    @FXML
    private TextField tfname;
    @FXML
    private TextField tflname;
    @FXML
    private TextField tfadresse;
    @FXML
    private TextField tftelephone;

    @FXML
    private TextField tfemail;
    @FXML
    private TableView<users> tbusers;
    @FXML
    private TableColumn<users, Integer> colid;
    @FXML
    private TableColumn<users, String> coluser;
    @FXML
    private TableColumn<users, String> colpass;
    @FXML
    private TableColumn<users, String> colfname;
    @FXML
    private TableColumn<users, String> colname;
    @FXML
    private TableColumn<users, String> colad;
    @FXML
    private TableColumn<users, Integer> coltel;
    @FXML
    private TableColumn<users, String> cole;
    @FXML
    private TextField tfid;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        try {
            // TODO
            ServiceUser su = new ServiceUser();
            ObservableList<users> list= su.getUsersList();
            colid.setCellValueFactory(new PropertyValueFactory<users,Integer>("id_user"));
            coluser.setCellValueFactory(new PropertyValueFactory<users,String>("username"));
            colpass.setCellValueFactory(new PropertyValueFactory<users,String>("password"));
            colfname.setCellValueFactory(new PropertyValueFactory<users,String>("fname"));
            colname.setCellValueFactory(new PropertyValueFactory<users,String>("lname"));
            colad.setCellValueFactory(new PropertyValueFactory<users,String>("adress"));
            coltel.setCellValueFactory(new PropertyValueFactory<users,Integer>("tel"));
            cole.setCellValueFactory(new PropertyValueFactory<users,String>("email"));
            tbusers.setItems(list);
            
        } catch (SQLException ex) {
            Logger.getLogger(FXML2Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
   
        
    }    

    @FXML
    private void AjouterUser(ActionEvent event) {
        try {
            ServiceUser su= new ServiceUser();
            int i = Integer.parseInt(tftelephone.getText());
            
            users u = new users(i,tfusername.getText(),tfpassword.getText(),tfname.getText(),tflname.getText(),tfadresse.getText(),tfemail.getText());
            su.AddUser(u);
//ServiceUser su = new ServiceUser();
ObservableList<users> list= su.getUsersList();
colid.setCellValueFactory(new PropertyValueFactory<users,Integer>("id_user"));
coluser.setCellValueFactory(new PropertyValueFactory<users,String>("username"));
colpass.setCellValueFactory(new PropertyValueFactory<users,String>("password"));
colfname.setCellValueFactory(new PropertyValueFactory<users,String>("fname"));
colname.setCellValueFactory(new PropertyValueFactory<users,String>("lname"));
colad.setCellValueFactory(new PropertyValueFactory<users,String>("adress"));
coltel.setCellValueFactory(new PropertyValueFactory<users,Integer>("tel"));
cole.setCellValueFactory(new PropertyValueFactory<users,String>("email"));
tbusers.setItems(list);        
        } catch (SQLException ex) {
            Logger.getLogger(FXML2Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
/*public void ShowUsers() throws SQLException{
ServiceUser su = new ServiceUser();
    ObservableList<users> list= su.getUsersList();
    colid.setCellValueFactory(new PropertyValueFactory<users,Integer>("id_user"));
    coluser.setCellValueFactory(new PropertyValueFactory<users,String>("username"));
    colpass.setCellValueFactory(new PropertyValueFactory<users,String>("password"));
    colfname.setCellValueFactory(new PropertyValueFactory<users,String>("first_name"));
    colname.setCellValueFactory(new PropertyValueFactory<users,String>("last_name"));
    colad.setCellValueFactory(new PropertyValueFactory<users,String>("adresse"));
    coltel.setCellValueFactory(new PropertyValueFactory<users,Integer>("telephone"));
    cole.setCellValueFactory(new PropertyValueFactory<users,String>("email"));
    tbusers.setItems(list);
    System.out.println(list);
}*/
   /* @FXML
    private void AfficherUser(ActionEvent event) {
        ServiceUser su = new ServiceUser();
        try {
            lbuser.setText(su.AfficherUser().toString());
            
        } catch (SQLException ex) {
            Logger.getLogger(FXML2Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
    }*/

    @FXML
    private void SupprimerUser(ActionEvent event) {
       
        try {
            ServiceUser su= new ServiceUser();
            users u= new users();
            int id=Integer.parseInt(tfid.getText());
            u.setId_user(id);
            System.out.println(id);
            su.DelUser(u);
            ObservableList<users> list= su.getUsersList();
            colid.setCellValueFactory(new PropertyValueFactory<users,Integer>("id_user"));
            coluser.setCellValueFactory(new PropertyValueFactory<users,String>("username"));
            colpass.setCellValueFactory(new PropertyValueFactory<users,String>("password"));
            colfname.setCellValueFactory(new PropertyValueFactory<users,String>("fname"));
            colname.setCellValueFactory(new PropertyValueFactory<users,String>("lname"));
            colad.setCellValueFactory(new PropertyValueFactory<users,String>("adress"));
            coltel.setCellValueFactory(new PropertyValueFactory<users,Integer>("tel"));
            cole.setCellValueFactory(new PropertyValueFactory<users,String>("email"));  
            tbusers.setItems(list);
        } catch (SQLException ex) {
            Logger.getLogger(FXML2Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void selectdl(MouseEvent event) {
        users evt = tbusers.getSelectionModel().getSelectedItem();
        tfusername.setText(evt.getUsername());
        tfpassword.setText(evt.getPassword());
        tfname.setText(evt.getFname());
        tflname.setText(evt.getLname());
        tfemail.setText(evt.getEmail());
        String a = Integer.toString(evt.getId_user());
        tfid.setText(a);
        String b = Integer.toString(evt.getTel());
        tftelephone.setText(b);
    }

    @FXML
    private void ModifierUser(ActionEvent event) {
        try {
            ServiceUser tc = new ServiceUser();
            users u = new users();
            int id = Integer.parseInt(tfid.getText());
            u.setId_user(id);
            u.setUsername(tfusername.getText());
            u.setPassword(tfpassword.getText());
            u.setFname(tfname.getText());
            u.setLname(tflname.getText());
            int i =Integer.parseInt(tftelephone.getText());
            u.setTel(i);
            u.setEmail(tfemail.getText());
            tc.ModUser(u);
            ObservableList<users> list= tc.getUsersList();
            colid.setCellValueFactory(new PropertyValueFactory<users,Integer>("id_user"));
            coluser.setCellValueFactory(new PropertyValueFactory<users,String>("username"));
            colpass.setCellValueFactory(new PropertyValueFactory<users,String>("password"));
            colfname.setCellValueFactory(new PropertyValueFactory<users,String>("fname"));
            colname.setCellValueFactory(new PropertyValueFactory<users,String>("lname"));
            colad.setCellValueFactory(new PropertyValueFactory<users,String>("adress"));
            coltel.setCellValueFactory(new PropertyValueFactory<users,Integer>("tel"));
            cole.setCellValueFactory(new PropertyValueFactory<users,String>("email"));  
            tbusers.setItems(list);
        } catch (SQLException ex) {
            Logger.getLogger(FXML2Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
