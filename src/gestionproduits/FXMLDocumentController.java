/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestionproduits;

import de.jensd.fx.glyphs.fontawesome.FontAwesomeIcon;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIconView;
import entities.produit;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import service.serviceproduit;
import helpers.Maconnexion;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableCell;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Callback;

/**
 *
 * @author LeNoVo
 */
public class FXMLDocumentController implements Initializable {
    
    @FXML
    private Label label;
    @FXML
    private TextField tftitle;
    @FXML
    private TextField tfdesc;
    @FXML
    private TextField tfprice;
    @FXML
    private TextField tfstock;
    @FXML
    private TextField tfimg;
    @FXML
    private TextField tfidvend;
    private Label profaffiche;
    @FXML
    private TableView<produit> tableviewprod;
    @FXML
    private TableColumn<produit, String> idtv;
    @FXML
    private TableColumn<produit, String> titletv;
    @FXML
    private TableColumn<produit, String> pricetv;
    @FXML
    private TableColumn<produit, String> imgtv;
    @FXML
    private TableColumn<produit, String> idvendtv;
    @FXML
    private TableColumn<produit, String> desctv;
    @FXML
    private TableColumn<produit, String> stocktv;
    
    ObservableList<produit> listproduit = FXCollections.observableArrayList();
    
    Connection cnx;
    String query=null;
    PreparedStatement PS = null;
    ResultSet RS = null;
    produit produit = null;
    int product_id;
    private boolean update ;
    @FXML
    private TableColumn<produit, String> editCol;
    
    
    
    private void handleButtonAction(ActionEvent event) {
        System.out.println("You clicked me!");
        label.setText("Hello World!");
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            // TODO
            loadDate();
        } catch (SQLException ex) {
            Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }    

    @FXML
    private void ajouterproduit(ActionEvent event) {
        serviceproduit sp =new serviceproduit();
        produit p = new produit();
                p.setTitle(tftitle.getText());
                p.setDescription_prod(tfdesc.getText());
                p.setPrice(Integer.parseInt(tfprice.getText()));
                p.setPhoto_prod(tfimg.getText());
                p.setStock(Integer.parseInt(tfstock.getText()));                       
                p.setId_vendor(Integer.parseInt(tfidvend.getText()));
       sp.addproduit(p);
       
                        
               
        
        
        
    }

    @FXML
    private void afficherproduits(ActionEvent event) {
        serviceproduit sp =new serviceproduit();
        
        try {
            profaffiche.setText(sp.Afficherproduits().toString());
        } catch (SQLException ex) {
            Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }

    private void loadDate() throws SQLException {
        
        cnx =Maconnexion.getInstance().getConnection();
        refreshtable();
        
        idtv.setCellValueFactory(new PropertyValueFactory<>("id_product"));
        titletv.setCellValueFactory(new PropertyValueFactory<>("title"));
        pricetv.setCellValueFactory(new PropertyValueFactory<>("price"));
        imgtv.setCellValueFactory(new PropertyValueFactory<>("photo_prod"));
        idvendtv.setCellValueFactory(new PropertyValueFactory<>("id_vendor"));
        desctv.setCellValueFactory(new PropertyValueFactory<>("description_prod"));
        stocktv.setCellValueFactory(new PropertyValueFactory<>("stock"));
        
        //add cell of button edit 
         Callback<TableColumn<produit, String>, TableCell<produit, String>> cellFoctory = (TableColumn<produit, String> param) -> {
            // make cell containing buttons
            final TableCell<produit, String> cell = new TableCell<produit, String>() {
                @Override
                public void updateItem(String item, boolean empty) {
                    super.updateItem(item, empty);
                    //that cell created only on non-empty rows
                    if (empty) {
                        setGraphic(null);
                        setText(null);

                    } else {

                        FontAwesomeIconView deleteIcon = new FontAwesomeIconView(FontAwesomeIcon.TRASH);
                        FontAwesomeIconView editIcon = new FontAwesomeIconView(FontAwesomeIcon.PENCIL_SQUARE);

                        deleteIcon.setStyle(
                                " -fx-cursor: hand ;"
                                + "-glyph-size:28px;"
                                + "-fx-fill:#ff1744;"
                        );
                        editIcon.setStyle(
                                " -fx-cursor: hand ;"
                                + "-glyph-size:28px;"
                                + "-fx-fill:#00E676;"
                        );
                        deleteIcon.setOnMouseClicked((MouseEvent event) -> {
                            
                            try {
                                produit = tableviewprod.getSelectionModel().getSelectedItem();
                                query = "DELETE FROM `produits` WHERE id_product  ="+produit.getId_product();
                                cnx = Maconnexion.getInstance().getConnection();
                                PS = cnx.prepareStatement(query);
                                PS.execute();
                                refreshtable();
                                
                            } catch (SQLException ex) {
                                Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
                            }
                            
                           

                          

                        });
                        editIcon.setOnMouseClicked((MouseEvent event) -> {
                            
                            produit = tableviewprod.getSelectionModel().getSelectedItem();
                            FXMLLoader loader = new FXMLLoader ();
                            loader.setLocation(getClass().getResource("/gestionproduits/addprodv.fxml"));
                            try {
                                loader.load();
                            } catch (IOException ex) {
                                Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
                            }
                            
                            AddprodvController addStudentController = loader.getController();
                            AddprodvController.setUpdate(true);
                            AddprodvController.setTextField(produit.getId_product(),produit.getStock(), 
                                    produit.getDescription_prod(),produit.getId_vendor(), produit.getPhoto_prod(),produit.getTitle());
                            Parent parent = loader.getRoot();
                            Stage stage = new Stage();
                            stage.setScene(new Scene(parent));
                            stage.initStyle(StageStyle.UTILITY);
                            stage.show();
                            

                           

                        });

                        HBox managebtn = new HBox(editIcon, deleteIcon);
                        managebtn.setStyle("-fx-alignment:center");
                        HBox.setMargin(deleteIcon, new Insets(2, 2, 0, 3));
                        HBox.setMargin(editIcon, new Insets(2, 3, 0, 2));

                        setGraphic(managebtn);

                        setText(null);

                    }
                }

            };

            return cell;
        };
        editCol.setCellFactory(cellFoctory);
        tableviewprod.setItems(listproduit);
         
        
        
        
    }

    @FXML
    private void refreshtable() throws SQLException {
        listproduit.clear();
         query="SELECT * FROM `produits`";
         PS = cnx.prepareStatement(query);
         RS= PS.executeQuery();
         
         while(RS.next()){
             listproduit.add(new produit(
                                  RS.getInt("id_product"),
                                  RS.getInt("stock"),
                                  RS.getInt("id_vendor"),
                                  RS.getString("title"),
                                  RS.getString("description_prod"),
                                  RS.getString("photo_prod"),
                                  RS.getFloat("price")));
             tableviewprod.setItems(listproduit);
             
             
             
         }
         
        
        
    }

    @FXML
    private void addproduc(ActionEvent event)  {
        try {
            Parent parent = FXMLLoader.load(getClass().getResource("/gestionproduits/addprodv.fxml"));
            Scene scene = new Scene(parent);
            scene.setFill(Color.TRANSPARENT);
            Stage stage = new Stage();
            stage.initStyle(StageStyle.UTILITY);
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
}
