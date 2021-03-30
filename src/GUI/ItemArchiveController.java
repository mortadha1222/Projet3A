/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Entities.Reclamation;
import Services.ReclamationService;
import GUI.ReclamationController;
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
public class ItemArchiveController implements Initializable {

    @FXML
    private Label titleItem;
    @FXML
    private Label descriptionItem;
    @FXML
    private Label traitement;
    @FXML
    private Label date;
    @FXML
    private Label answerTXT;
    @FXML
    private Label answer;
    
    private Reclamation reclamationn;
    @FXML
    private Circle circle;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    } 
        public void setData(Reclamation reclamation){
        reclamationn= reclamation;
        titleItem.setText(reclamation.getTitle());
        descriptionItem.setText(reclamation.getDescription());
        answer.setText(reclamation.getTitle());
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        String strDate = formatter.format(reclamation.getDate()); 
        date.setText(strDate);
        if(reclamation.getAnswer()==null){
            circle.setFill(rgb(255, 0, 0));
            answerTXT.setText("");
         
            traitement.setText("being processed");}
        else
        {
            circle.setFill(rgb(0, 204, 0));
            traitement.setText("treated");}
    
      ReclamationDetailsController.getIdd(reclamationn.getId());
    }

    @FXML
    private void delete() {
        
        int  x=ReclamationDetailsController.getIdd(reclamationn.getId());
         System.out.println(x);
         ReclamationService sr= new ReclamationService();
         Reclamation u = new Reclamation();

         u.setId(x);
         sr.supprimerReclamation(reclamationn); 
         Alert a= new Alert(Alert.AlertType.WARNING);
         a.setTitle("reclamation deleted");
         a.setContentText("a reclamation has been deleted. you have to reload the archived list");
         a.setHeaderText(null);
         a.showAndWait();
    }
    
}
