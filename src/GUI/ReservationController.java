/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Entities.Reservation;
import Services.ReservationService;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author administrater
 */
public class ReservationController implements Initializable {

    @FXML
    private TableView<Reservation> table;
    @FXML
    private TableColumn<Reservation, Integer> tplanning;
    @FXML
    private TableColumn<Reservation, Integer> tmembre;
    @FXML
    private TableColumn<Reservation, Integer> tcoach;
    ReservationService rs = new ReservationService();
    @FXML
    private Button dbtn;

    /**
     * Initializes the controller class.
     */
    @Override
   
           public void initialize(URL url, ResourceBundle rb) {
         ObservableList<Reservation> Reservation = FXCollections.observableArrayList();
         for(Reservation c: rs.displayReservations())
             Reservation.add(c);
         tplanning.setCellValueFactory(new PropertyValueFactory<>("id_planning"));
         tmembre.setCellValueFactory(new PropertyValueFactory<>("id_member"));
         tcoach.setCellValueFactory(new PropertyValueFactory<>("id_coach"));
   
         table.setItems(Reservation); 
  
    }    

           
    @FXML
    private void supprimerReservation(ActionEvent event) {
   if(!table.getSelectionModel().getSelectedItems().isEmpty()) {
           
           rs.supprimerReservation(table.getSelectionModel().getSelectedItems().get(0));
             try {
            javafx.scene.Parent tableview = FXMLLoader.load(getClass().getResource("Reservation.fxml"));
            Scene sceneview = new Scene(tableview);
            Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
            window.setScene(sceneview);
            window.show();
            
            
        }
        
        catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
        
        
       else{
           
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Information Dialog");
        alert.setHeaderText(null);
        alert.setContentText("aucun élément 'a ètè séléctionné");
        alert.showAndWait();

           
        
       }
    }
    
}
