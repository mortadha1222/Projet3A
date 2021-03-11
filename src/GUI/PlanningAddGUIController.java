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
public class PlanningAddGUIController implements Initializable {

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
    private Button badd;
    @FXML
    private Button bdelete;
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
    private TextField tsaerch;
    @FXML
    private Button Bsaerch;
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

    @FXML
    private void ajouterPlanning(ActionEvent event) {
        //int plan = (Integer) Integer.parseInt(txplanning.getText())+0;
        int coach = (Integer) Integer.parseInt(txcoach.getText())+0;
         String course = txcourse.getText();
        String start = txstart.getText();
        String end = txend.getText();
                int max = (Integer) Integer.parseInt(txmax.getText())+0;

       
        Planning p= new Planning(coach,course,start,end,max );
            PlanningService ps = new PlanningService();
            ps.ajouterPlanning(p);
    }


    @FXML
    private void supprimerPlanning(ActionEvent event) {
         if(!table.getSelectionModel().getSelectedItems().isEmpty()) {
           
           ps.supprimerPlanning(table.getSelectionModel().getSelectedItems().get(0));
             try {
            javafx.scene.Parent tableview = FXMLLoader.load(getClass().getResource("PlanningAddGUI.fxml"));
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
    
    

    @FXML
    private void next(ActionEvent event) {
   
         try {
        javafx.scene.Parent tableview = FXMLLoader.load(getClass().getResource("UpdatePlanning.fxml"));
        Scene sceneview = new Scene(tableview);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(sceneview);
        window.show();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @FXML
    private void chercherPlanning(ActionEvent event) {
         try {
 PlanningService tc = new PlanningService();
            Planning u = new Planning();
            u.setId_planning(Integer.parseInt(tsaerch.getText()));
            ObservableList<Planning> list= tc.SearchPlanningList(u);
            tplanning.setCellValueFactory(new PropertyValueFactory<Planning,Integer>("id_plaaning"));
            tcoach.setCellValueFactory(new PropertyValueFactory<Planning,Integer>("id_coach"));
            tcourse.setCellValueFactory(new PropertyValueFactory<Planning,String>("course"));
            tstart.setCellValueFactory(new PropertyValueFactory<Planning,String>("startLesson"));
            tend.setCellValueFactory(new PropertyValueFactory<Planning,String>("endLesson"));
            tmax.setCellValueFactory(new PropertyValueFactory<Planning,Integer>("maxNbr"));
            table.setItems(list);
        } catch (SQLException ex) {
            Logger.getLogger(PlanningAddGUIController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    }
    
