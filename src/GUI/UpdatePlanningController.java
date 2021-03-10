/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Entities.Planning;
import Services.PlanningService;
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
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author administrater
 */
public class UpdatePlanningController implements Initializable {

    @FXML
    private TextField txplanning;
    @FXML
    private TextField txcoach;
    @FXML
    private TextField txcourse;
    @FXML
    private TextField txstart;
    @FXML
    private TextField txend;
    @FXML
    private TextField txmax;
    @FXML
    private Button bupdate;
    @FXML
    private TableView<Planning> table;
    @FXML
    private TableColumn<Planning, Integer> tplanning;
    @FXML
    private TableColumn<Planning, Integer> tcoach;
    @FXML
    private TableColumn<Planning, String> tcourse;
    @FXML
    private TableColumn<Planning, String> tstart;
    @FXML
    private TableColumn<Planning, String> tend;
    @FXML
    private TableColumn<Planning, Integer> tmax;
PlanningService ps = new PlanningService();
    @FXML
    private Button back;
   
    /**
     * Initializes the controller class.
     */
  @Override
    public void initialize(URL url, ResourceBundle rb) {
         ObservableList<Planning> Planning = FXCollections.observableArrayList();
         for(Planning c: ps.displayPlannings())
             Planning.add(c);
         tplanning.setCellValueFactory(new PropertyValueFactory<>("id_planning"));
         tcoach.setCellValueFactory(new PropertyValueFactory<>("id_coach"));
         tcourse.setCellValueFactory(new PropertyValueFactory<>("course"));
         tstart.setCellValueFactory(new PropertyValueFactory<>("startLesson"));
         tend.setCellValueFactory(new PropertyValueFactory<>("endLesson"));
         tmax.setCellValueFactory(new PropertyValueFactory<>("maxNbr"));
         table.setItems(Planning); 
        
    }    
    
void select() {
     
        Planning selected = table.getSelectionModel().getSelectedItem();
          if (!table.getSelectionModel().getSelectedItems().isEmpty()) {
        
        
        tplanning.setText(String.valueOf(selected.getId_planning()));
        tcoach.setText(String.valueOf(selected.getId_coach()));  
         tcourse.setText(String.valueOf(selected.getCourse()));
        tstart.setText(String.valueOf(selected.getStartLesson()));
        tend.setText(String.valueOf(selected.getEndLesson()));
        tmax.setText(String.valueOf(selected.getMaxNbr()));
       
        
          } else {
              Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Information Dialog");
            alert.setHeaderText(null);
            alert.setContentText("aucun élément 'a ètè séléctionné");
            alert.showAndWait();
          }
    }
   
    
    @FXML
    private void updatePlanning(ActionEvent event) {
         PlanningService ps = new PlanningService();
        
       
            
            
            Planning c  = new Planning();
          Planning c2 = table.getSelectionModel().getSelectedItem();
            int id_plan = c2.getId_planning();
            
            Planning c3 = new Planning(id_plan, Integer.parseInt(tcoach.getText()),tcourse.getText(), tstart.getText(), tend.getText(), Integer.parseInt(tmax.getText()));
            ps.updatePlanning(c3);
           
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Information Dialog");
            alert.setHeaderText(null);
            alert.setContentText("cours modifié");
            alert.showAndWait();
            
        }

    @FXML
    private void back(ActionEvent event) {
         {
         try {
        javafx.scene.Parent tableview = FXMLLoader.load(getClass().getResource("/GUI/PlanningAddGUI.fxml"));
        Scene sceneview = new Scene(tableview);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(sceneview);
        window.show();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
    }
    }
    

