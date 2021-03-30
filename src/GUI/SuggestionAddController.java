/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Entities.Suggestion;
import Services.SuggestionService;
import java.net.URL; 
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.Date;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author ASUS
 */
public class SuggestionAddController implements Initializable {

        @FXML
    private TextField title;
    @FXML
    private TextArea description;
    
    private Suggestion Suggestionn;
    
    int id_user=1;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    } 
        @FXML
    private void save() {
        
         SuggestionService sr= new SuggestionService();
         Suggestion u = new Suggestion();
         
         u.setTitle(title.getText());
         u.setDescription(description.getText());
         u.setId_user(id_user);
         
       LocalDateTime localDateTime = LocalDateTime.now();
        LocalDate localDate = localDateTime.toLocalDate();
        LocalTime localTime = localDateTime.toLocalTime();
        Date date = Date.from(localDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
        u.setDate(date);
        System.out.println(u);
        
         
         
         sr.ajouterSuggestion(u);
         
         Alert a= new Alert(Alert.AlertType.INFORMATION);
         a.setTitle("reclamation added successfully");
         a.setContentText("a reclamation has been added successfully . you have to reload the reclamation list");
         a.setHeaderText(null);
         a.showAndWait();
         
         
    }
    
}
