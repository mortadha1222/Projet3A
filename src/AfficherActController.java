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

    private TableColumn<Actualities, String> titlecol;
    private TableColumn<Actualities, Integer> memidcolA;
    private TableColumn<Actualities, String> photocolA;
    private TableColumn<Actualities, String> datecolA;
    private TableColumn<Actualities, String> desccolA;
    private TableView<Actualities> tableauAct;

    /**
     * Initializes the controller class.
     */
    
        ActuService see = new ActuService();
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        
        try {
            
            
            ObservableList<Actualities> listA = see.getActuList();
            try {
                listA = see.getActuList();
            } catch (SQLException ex) {
                Logger.getLogger(AfficherActController.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            titlecol.setCellValueFactory(new PropertyValueFactory<Actualities,String>("title_act"));
            memidcolA.setCellValueFactory(new PropertyValueFactory<Actualities,Integer>("id_member"));
            photocolA.setCellValueFactory(new PropertyValueFactory<Actualities,String>("photo_act"));
            datecolA.setCellValueFactory(new PropertyValueFactory<Actualities,String>("date_act"));
            desccolA.setCellValueFactory(new PropertyValueFactory<Actualities,String>("description_act"));

            tableauAct.setItems(listA);
            // TODO
        } catch (SQLException ex) {
            Logger.getLogger(AfficherActController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }    
    
}
