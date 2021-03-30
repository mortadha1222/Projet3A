/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Entities.Reclamation;
import Services.ReclamationService;
import com.jfoenix.controls.JFXTextField;
import java.io.IOException;


import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
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
 * FXML Controller class
 *
 * @author ASUS
 */
public class AdminReclamationController implements Initializable {

    @FXML
    private JFXTextField tfTitle;
    @FXML
    private TableView<Reclamation> tableReclamation;
    @FXML
    private TableColumn<Reclamation, String> tabTitle;
    @FXML
    private TableColumn<Reclamation, String> tabDescription;
    @FXML
    private TableColumn<Reclamation, String> tabAnswer;
    @FXML
    private TextArea tfAnswer;
    
    private static int id;
    @FXML
    private JFXTextField filterField;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
                 ObservableList<Reclamation> Reclamation = FXCollections.observableArrayList();
                 ReclamationService ps = new ReclamationService();
         for(Reclamation c: ps.displayReclamation())
             Reclamation.add(c);
         tabTitle.setCellValueFactory(new PropertyValueFactory<>("title"));
         tabDescription.setCellValueFactory(new PropertyValueFactory<>("description"));
         tabAnswer.setCellValueFactory(new PropertyValueFactory<>("answer"));
         
         
         FilteredList<Reclamation> filteredData = new FilteredList<>(Reclamation, b -> true);
         
         		// 2. Set the filter Predicate whenever the filter changes.
		filterField.textProperty().addListener((observable, oldValue, newValue) -> {
			filteredData.setPredicate(reclamationn -> {
				// If filter text is empty, display all persons.
								
				if (newValue == null || newValue.isEmpty()) {
					return true;
				}
				
				// Compare first name and last name of every person with filter text.
				String lowerCaseFilter = newValue.toLowerCase();
				
				if (reclamationn.getTitle().toLowerCase().indexOf(lowerCaseFilter) != -1 ) {
					return true; // Filter matches first title.
				} else if (reclamationn.getDescription().toLowerCase().indexOf(lowerCaseFilter) != -1) {
					return true; // Filter matches last Description.
				}

				     else  
				    	 return false; // Does not match.
			});
		});
                
                
		SortedList<Reclamation> sortedData = new SortedList<>(filteredData);
                
                
               sortedData.comparatorProperty().bind(tableReclamation.comparatorProperty());
                
        
         tableReclamation.setItems(sortedData); 
    }  
        public void loadData(){
                         ObservableList<Reclamation> Reclamation = FXCollections.observableArrayList();
                 ReclamationService ps = new ReclamationService();
         for(Reclamation c: ps.displayReclamation())
             Reclamation.add(c);
         tabTitle.setCellValueFactory(new PropertyValueFactory<>("title"));
         tabDescription.setCellValueFactory(new PropertyValueFactory<>("description"));
         tabAnswer.setCellValueFactory(new PropertyValueFactory<>("answer"));
         
         
         
                  
         FilteredList<Reclamation> filteredData = new FilteredList<>(Reclamation, b -> true);
         
         		// 2. Set the filter Predicate whenever the filter changes.
		filterField.textProperty().addListener((observable, oldValue, newValue) -> {
			filteredData.setPredicate(reclamationn -> {
				// If filter text is empty, display all persons.
								
				if (newValue == null || newValue.isEmpty()) {
					return true;
				}
				
				// Compare first name and last name of every person with filter text.
				String lowerCaseFilter = newValue.toLowerCase();
				
				if (reclamationn.getTitle().toLowerCase().indexOf(lowerCaseFilter) != -1 ) {
					return true; // Filter matches first title.
				} else if (reclamationn.getDescription().toLowerCase().indexOf(lowerCaseFilter) != -1) {
					return true; // Filter matches last Description.
				}

				     else  
				    	 return false; // Does not match.
			});
		});
                
                
		SortedList<Reclamation> sortedData = new SortedList<>(filteredData);
                
                
               sortedData.comparatorProperty().bind(tableReclamation.comparatorProperty());
         
        
         tableReclamation.setItems(sortedData); 
    
    }

    @FXML
    private void selected(MouseEvent event) {
        Reclamation r = tableReclamation.getSelectionModel().getSelectedItem();
        id=r.getId();
        tfTitle.setText(r.getTitle());
        tfAnswer.setText(r.getAnswer());

        
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
    private void addAnswer(ActionEvent event) {
        
            ReclamationService rs = new ReclamationService();
            Reclamation u = new Reclamation();
            u.setAnswer(tfAnswer.getText());
            rs.updateReclamationAnswer(u,id);

            
            loadData();
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
