/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Entities.Suggestion;
import Services.SuggestionService;
import GUI.SuggestionController;
import com.sun.prism.paint.Color;
import java.io.IOException;
import java.net.URL;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import java.util.Date;
import static javafx.scene.paint.Color.rgb;
import javafx.scene.shape.Circle;
import sun.plugin.dom.css.RGBColor;

/**
 * FXML Controller class
 *
 * @author ASUS
 */
public class ItemSuggestionController implements Initializable {

        @FXML
    private Label titleItem;
    @FXML
    private Label descriptionItem;
    @FXML
    private ImageView details;
    @FXML
    private Label traitement;
    
    private Suggestion suggestionn;
    @FXML
    private Label date;
    @FXML
    private Circle circle;
    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    public void setData(Suggestion suggestion){
        suggestionn= suggestion;
        titleItem.setText(suggestion.getTitle());
        descriptionItem.setText(suggestion.getDescription());
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        String strDate = formatter.format(suggestion.getDate()); 
        date.setText(strDate);
        if(suggestion.getAnswer()==null){
            circle.setFill(rgb(255, 0, 0));
         
            traitement.setText("being processed");}
        else
        {
            circle.setFill(rgb(0, 204, 0));
            traitement.setText("treated");}
    
      ReclamationDetailsController.getIdd(suggestionn.getId());
    }

    @FXML
            public void changeScreenButtonPushed( ) throws IOException{
                      int  x=SuggestionDetailsController.getIdd(suggestionn.getId());
                      
                    Parent root = FXMLLoader.load(getClass().getResource("SuggestionDetails.fxml"));
                  Stage mainStage = new Stage();
                 Scene scene = new Scene(root);
                   mainStage.setScene(scene);
                   mainStage.show();

  }
            
        @FXML
    private void delete() {
        int  x=ReclamationDetailsController.getIdd(suggestionn.getId());
         System.out.println(x);
         SuggestionService sr= new SuggestionService();
         Suggestion u = new Suggestion();

         u.setId(x);
         sr.supprimerSuggestion(suggestionn); 
         Alert a= new Alert(Alert.AlertType.WARNING);
         a.setTitle("suggestion deleted");
         a.setContentText("a suggestion has been deleted. you have to reload the suggestion list");
         a.setHeaderText(null);
         a.showAndWait();
        
         
    }
    
}
