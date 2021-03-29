package controller;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import entities.Actualities;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import services.ActuService;

/**
 * FXML Controller class
 *
 * @author Administrator
 */
public class AfficherActController implements Initializable {

    @FXML
    private TableView<Actualities> tableauAct;
    @FXML
    private TableColumn<Actualities, String> titlecol;
    @FXML
    private TableColumn<Actualities, Integer> memidcolA;
    @FXML
    private TableColumn<Actualities, String> photocolA;
    @FXML
    private TableColumn<Actualities, String> datecolA;
    @FXML
    private TableColumn<Actualities, String> desccolA;
    
    ActuService see = new ActuService();
    

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            // TODO
            ObservableList<Actualities> listA = see.getActuList();
            titlecol.setCellValueFactory(new PropertyValueFactory<Actualities,String>("title_act"));
            memidcolA.setCellValueFactory(new PropertyValueFactory<Actualities,Integer>("id_member"));
            photocolA.setCellValueFactory(new PropertyValueFactory<Actualities,String>("photo_act"));
            datecolA.setCellValueFactory(new PropertyValueFactory<Actualities,String>("date_act"));
            desccolA.setCellValueFactory(new PropertyValueFactory<Actualities,String>("description_act"));

            tableauAct.setItems(listA);
        } catch (SQLException ex) {
            Logger.getLogger(AfficherActController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }    
    
}
