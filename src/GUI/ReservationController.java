/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Entities.Reservation;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

/**
 * FXML Controller class
 *
 * @author administrater
 */
public class ReservationController implements Initializable {

    @FXML
    private TableView<Reservation> table;
    @FXML
    private TableColumn<?, ?> tplanning;
    @FXML
    private TableColumn<?, ?> tmembre;
    @FXML
    private TableColumn<?, ?> tcoach;
    @FXML
    private Button dbtn;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void supprimerReservation(ActionEvent event) {
    }
    
}
