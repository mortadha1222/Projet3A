/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Entities.Rating;
import Services.RatingService;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;

/**
 * FXML Controller class
 *
 * @author ASUS
 */
public class RatingController implements Initializable {

    @FXML
    private Slider slider;
    @FXML
    private Label rate;
    @FXML
    private Button btn;
    
     int id_user=1;


    @Override
    public void initialize(URL url, ResourceBundle rb) {
       RatingService ps = new RatingService();
       rate.setText("rating average       =   "+ps.displayRate());

       if(ps.displayYourRate(id_user).equals(""))
       {slider.setValue(0);
       btn.setText("add rate");
       }
       else{
          slider.setValue(Double.parseDouble(ps.displayYourRate(id_user)));
          btn.setText("update your rate");
       };
       
    }    

    @FXML
    private void btn(ActionEvent event) {
        
       RatingService ps = new RatingService();
       
       if(ps.displayYourRate(id_user).equals(""))
       { Double rate=slider.getValue();
        Rating r= new Rating(rate,id_user);
            ps.ajouterRating(r);
            
            loadData();
       }
       else{
        Double rate=slider.getValue();
        Rating r= new Rating(rate,id_user);
            ps.updateRating(r,id_user);
            
            loadData();

       }; 
    }
    
    
    
    
    
    
        public void loadData(){
               RatingService ps = new RatingService();
       rate.setText("rating average       =   "+ps.displayRate());

       if(ps.displayYourRate(id_user).equals(""))
       {slider.setValue(0);
       btn.setText("add rate");
       }
       else{
          slider.setValue(Double.parseDouble(ps.displayYourRate(id_user)));
          btn.setText("update your rate");
       };
        }
    
}
