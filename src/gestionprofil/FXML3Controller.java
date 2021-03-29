/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestionprofil;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author mortadha
 */
public class FXML3Controller implements Initializable {

    @FXML
    private ImageView iv1;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }    

    @FXML
    private void picup(ActionEvent event) throws IOException {
       FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("FXML3.fxml"));
             Parent root = (Parent) fxmlLoader.load();
             Stage stage = new Stage();
             stage.setScene(new Scene(root));  
     FileChooser fileChooser = new FileChooser();
 fileChooser.setTitle("Open Resource File");
 fileChooser.getExtensionFilters().addAll(new ExtensionFilter("Image Files", "*.png", "*.jpg", "*.gif"));
 File selectedFile = fileChooser.showOpenDialog(stage);
 Image iv = new Image(selectedFile.toURI().toString());  
 iv1.setImage(iv);
 
    }
}

