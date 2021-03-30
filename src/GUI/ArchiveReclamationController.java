/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Entities.Reclamation;
import Services.ReclamationService;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;

/**
 * FXML Controller class
 *
 * @author ASUS
 */
public class ArchiveReclamationController implements Initializable {

    @FXML
    private ScrollPane scroll;
    @FXML
    private GridPane grid;

    int id_user=1;
    

       
      ReclamationService sr= new ReclamationService();

    @FXML
    private ImageView refresh;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        refresh();
    }    

    @FXML
    private void refresh() {
        
                Reclamation reclamation;
        
        List<Reclamation> reclamations = new ArrayList<>();
        List<Reclamation> r = new ArrayList<>();
        grid.getColumnConstraints().clear();
grid.getRowConstraints().clear();
grid.getChildren().clear();
        
        
        try {
            
         reclamations.addAll(sr.readarchive(id_user));
         

        } catch (SQLException ex) {
            
            Logger.getLogger(ArchiveReclamationController.class.getName()).log(Level.SEVERE, null, ex);
        }
     int column=0;
    int row=1;
   try { for(int i=0;i<reclamations.size();i++){
        FXMLLoader fxmlloader = new FXMLLoader();
        fxmlloader.setLocation(getClass().getResource("ItemArchive.fxml"));
         AnchorPane anchorPane =fxmlloader.load();
          
      
        ItemArchiveController itemArchiveController = fxmlloader.getController();
      itemArchiveController.setData(reclamations.get(i));
    if(column == 1){
        column=0;
         row++;
    }
        
grid.add(anchorPane, column++ , row);

       GridPane.setMargin(anchorPane, new Insets(35));}
       } catch (IOException ex) {
         ex.printStackTrace();
         }
    }

    @FXML
    private void affiche_produit(ActionEvent event) {
    }

    @FXML
    private void affiche_panier(ActionEvent event) {
    }

    @FXML
    private void affiche_commande(ActionEvent event) {
    }

    @FXML
    private void affiche_suggestion(MouseEvent event) {
    }
    
}
