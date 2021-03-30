/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import java.util.ArrayList;
import java.util.List;
import Entities.Suggestion;
import Services.SuggestionService;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.control.Alert;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import static javafx.scene.paint.Color.rgb;
import javafx.scene.shape.Circle;

/**
 * FXML Controller class
 *
 * @author ASUS
 */
public class SuggestionDetailsController implements Initializable {

        @FXML
    private Label title;
    @FXML
    private Label description;
    @FXML
    private Label answer;
    
     private static int idd ;
     private Suggestion suggestion;

    SuggestionService ss= new SuggestionService();
    
        @FXML
    private Label traitement;
    @FXML
    private Label reponsetext;
    @FXML
    private Label date;
    /**
     * Initializes the controller class.
     */
        public static int getIdd(int id){
    idd=id;
    return idd;
}
    @FXML
    private Circle circle;
        
    @Override
    public void initialize(URL url, ResourceBundle rb) {
                  
   try { 
            suggestion=ss.readdetails(idd);
//          System.out.println(idd);
        } catch (SQLException ex) {
           Logger.getLogger(ReclamationDetailsController.class.getName()).log(Level.SEVERE, null, ex);
       }
                      
       title.setText(suggestion.getTitle());
       
           
       description.setText(suggestion.getDescription());
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        String strDate = formatter.format(suggestion.getDate()); 
        date.setText(strDate);
      if(suggestion.getAnswer()==null){            circle.setFill(rgb(255, 0, 0));
         
            traitement.setText("being processed");
                  answer.setText(suggestion.getAnswer());
      reponsetext.setText("");
      }
        else
        {circle.setFill(rgb(0, 204, 0));
            traitement.setText("treated");
        reponsetext.setText("Answer");
        answer.setText(suggestion.getAnswer());}
       
    }
    
}
