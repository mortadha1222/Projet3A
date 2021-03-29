/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestionprofil;

import entities.users;
import static gestionprofil.Gestionprofil.main;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import service.ServiceLogin;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.stage.Stage;


/**
 *
 * @author mortadha
 */
public class FXMLDocumentController implements Initializable {
    
    @FXML
    private Label label;
    @FXML
    private TextField tfusername;
    @FXML
    private TextField tfpassword;
    @FXML
    private ComboBox<?> cbrole;
    
    private void handleButtonAction(ActionEvent event) {
        System.out.println("You clicked me!");
        label.setText("Hello World!");
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void login(ActionEvent event) throws IOException {
        ServiceLogin sl= new ServiceLogin();
        //int i = Integer.parseInt(tfid_user.getText());
        
        String us = tfusername.getText();
        String pass = tfpassword.getText();
         users u = new users(us,pass);
           Alert a = new Alert(AlertType.WARNING);
         if ((sl.Connect(u)==true)) {
             a.setAlertType(AlertType.CONFIRMATION); 
             a.setTitle("Validation");
             a.setContentText("Connected");
             a.showAndWait();
             FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("FXML2.fxml"));
             Parent root = (Parent) fxmlLoader.load();
             Stage stage = new Stage();
             stage.setScene(new Scene(root));  
             stage.show();
             Gestionprofil.stg.close();
         }
         else {
             a.setAlertType(AlertType.ERROR);
             a.setTitle("Error");
             a.setContentText("Check your inputs");
             a.showAndWait();
         }}
    
}
