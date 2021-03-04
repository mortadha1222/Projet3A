/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestionproduits;

import entities.produit;
import helpers.Maconnexion;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author LeNoVo
 */
public class AddprodvController implements Initializable {

    static void setUpdate(boolean b) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    static void setTextField(int id_product, int stock, String description_prod, int id_vendor, String photo_prod, String title) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @FXML
    private TextField tftitle2;
    @FXML
    private TextField tfdesc2;
    @FXML
    private TextField tfprice2;
    @FXML
    private TextField tfstock2;
    @FXML
    private TextField tfimg2;
    @FXML
    private TextField tfidvend2;
    
    Connection cnx;
    String query=null;
    PreparedStatement PS = null;
    ResultSet RS = null;
    produit produit = null;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void butsave(ActionEvent event) {
        cnx = Maconnexion.getInstance().getConnection();
        String title = tftitle2.getText();
        String description = tfdesc2.getText();
        String price = tfprice2.getText();
        String stock = tfstock2.getText();
        String img = tfimg2.getText();
        String idven = tfidvend2.getText();
        
        getquery();
        insert();
        
        
        
    }

    @FXML
    private void butclean(ActionEvent event) {
    }

    private void getquery() {
        query="INSERT INTO `produits`(`title` , `description_prod`, `price`, `photo_prod`, `stock`, `id_vendor`) VALUES (?,?,?,?,?,?)";
    }

    private void insert() {
        
        
        try {
            PS = cnx.prepareStatement(query);
            PS.setString(1,tftitle2.getText() );
            PS.setString(2,tfdesc2.getText() );
            PS.setString(3,tfprice2.getText() );
            PS.setString(4,tfstock2.getText() );
            PS.setString(5,tfimg2.getText() );
            PS.setString(6,tfidvend2.getText() );
        } catch (SQLException ex) {
            Logger.getLogger(AddprodvController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }
    
}
