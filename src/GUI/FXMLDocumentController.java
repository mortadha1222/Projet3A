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
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

/**
 *
 * @author ASUS
 */
public class FXMLDocumentController implements Initializable {
    
    private Label label;
    @FXML
    private TextField tfTitle;
    @FXML
    private TextArea tfDescription;
    @FXML
    private TableView<Reclamation> tableReclamation;
    @FXML
    private TableColumn<Reclamation, String> tabTitle;
    @FXML
    private TableColumn<Reclamation, String> tabDescription;
    @FXML
    private TableColumn<Reclamation, String> tabAnswer;
    private static int id;
    
    @FXML
    private Button admin;
    @FXML
    private Button suggestion;
    @FXML
    private Button rating;
    

    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
                 ObservableList<Reclamation> Reclamation = FXCollections.observableArrayList();
                 ReclamationService ps = new ReclamationService();
         for(Reclamation c: ps.displayReclamation())
             Reclamation.add(c);
         tabTitle.setCellValueFactory(new PropertyValueFactory<>("title"));
         tabDescription.setCellValueFactory(new PropertyValueFactory<>("description"));
         tabAnswer.setCellValueFactory(new PropertyValueFactory<>("answer"));
        
         tableReclamation.setItems(Reclamation); 
         
    }    
    
    public void loadData(){
                         ObservableList<Reclamation> Reclamation = FXCollections.observableArrayList();
                 ReclamationService ps = new ReclamationService();
         for(Reclamation c: ps.displayReclamation())
             Reclamation.add(c);
         tabTitle.setCellValueFactory(new PropertyValueFactory<>("title"));
         tabDescription.setCellValueFactory(new PropertyValueFactory<>("description"));
         tabAnswer.setCellValueFactory(new PropertyValueFactory<>("answer"));
        
         tableReclamation.setItems(Reclamation); 
    
    }
    

    @FXML
    private void addReclamation(ActionEvent event) {
        String title=tfTitle.getText();
        String description=tfDescription.getText();
        int id_user=1;   
        Reclamation r= new Reclamation(title,description,id_user);
            ReclamationService ps = new ReclamationService();
            ps.ajouterReclamation(r);
            
            loadData();
    }

    @FXML
    private void modifyReclamation(ActionEvent event) {

            ReclamationService rs = new ReclamationService();
            Reclamation u = new Reclamation();
            u.setTitle(tfTitle.getText());
            u.setDescription(tfDescription.getText());
            rs.updateReclamation(u,id);

            
            loadData();
    
    }

    

    @FXML
    private void deleteReclamation(ActionEvent event) {
        
        ReclamationService ps = new ReclamationService();
        
      if(!tableReclamation.getSelectionModel().getSelectedItems().isEmpty()) {
           
           ps.supprimerReclamation(tableReclamation.getSelectionModel().getSelectedItems().get(0));
            loadData();
    }
        
        
       else{
           
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Information Dialog");
        alert.setHeaderText(null);
        alert.setContentText("aucun élément 'a ètè séléctionné");
        alert.showAndWait();

           
        
       }
    }

    @FXML
    private void selected(MouseEvent event) {
        Reclamation r = tableReclamation.getSelectionModel().getSelectedItem();
        id=r.getId();
        tfTitle.setText(r.getTitle());
        tfDescription.setText(r.getDescription());

        
    }

    @FXML
    private void admin(ActionEvent event) throws IOException , SQLException {
        admin.getScene().getWindow().hide();
        Parent root = FXMLLoader.load(getClass().getResource("adminReclamation.fxml"));
        // Parent root = FXMLLoader.load(getClass().getResource("/profil/profil.fxml"));
        Stage mainStage = new Stage();
        Scene scene = new Scene(root);
        mainStage.setScene(scene);
        mainStage.show();
        
    }

    @FXML
    private void suggestion(ActionEvent event) throws IOException , SQLException {
        suggestion.getScene().getWindow().hide();
        Parent root = FXMLLoader.load(getClass().getResource("Suggestion.fxml"));
        // Parent root = FXMLLoader.load(getClass().getResource("/profil/profil.fxml"));
        Stage mainStage = new Stage();
        Scene scene = new Scene(root);
        mainStage.setScene(scene);
        mainStage.show();
        
    }

     @FXML
    private void rating(ActionEvent event) throws IOException , SQLException {
        rating.getScene().getWindow().hide();
        Parent root = FXMLLoader.load(getClass().getResource("Rating.fxml"));
        // Parent root = FXMLLoader.load(getClass().getResource("/profil/profil.fxml"));
        Stage mainStage = new Stage();
        Scene scene = new Scene(root);
        mainStage.setScene(scene);
        mainStage.show();
        
    }
    
}
