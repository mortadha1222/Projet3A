/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestionprofil;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.List;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import entities.users;
import java.awt.Desktop;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Arrays;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.FileChooser;
import javafx.stage.Window;
import service.ServiceUser;

/**
 * FXML Controller class
 *
 * @author mortadha
 */
public class FXML2Controller implements Initializable {

    @FXML
    private TextField tfusername;
    @FXML
    private TextField tfpassword;
    @FXML
    private TextField tfname;
    @FXML
    private TextField tflname;
    @FXML
    private TextField tfadresse;
    @FXML
    private TextField tftelephone;
private Desktop desktop = Desktop.getDesktop();
    @FXML
    private TextField tfemail;
    @FXML
    private TableView<users> tbusers;
    @FXML
    private TableColumn<users, Integer> colid;
    @FXML
    private TableColumn<users, String> coluser;
    @FXML
    private TableColumn<users, String> colpass;
    @FXML
    private TableColumn<users, String> colfname;
    @FXML
    private TableColumn<users, String> colname;
    @FXML
    private TableColumn<users, String> colad;
    @FXML
    private TableColumn<users, Integer> coltel;
    @FXML
    private TableColumn<users, String> cole;
    @FXML
    private TextField tfid;
    @FXML
    private TextField tfchercher;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        try {
            // TODO
            ServiceUser su = new ServiceUser();
            ObservableList<users> list= su.getUsersList();
            colid.setCellValueFactory(new PropertyValueFactory<users,Integer>("id_user"));
            coluser.setCellValueFactory(new PropertyValueFactory<users,String>("username"));
            colpass.setCellValueFactory(new PropertyValueFactory<users,String>("password"));
            colfname.setCellValueFactory(new PropertyValueFactory<users,String>("fname"));
            colname.setCellValueFactory(new PropertyValueFactory<users,String>("lname"));
            colad.setCellValueFactory(new PropertyValueFactory<users,String>("adress"));
            coltel.setCellValueFactory(new PropertyValueFactory<users,Integer>("tel"));
            cole.setCellValueFactory(new PropertyValueFactory<users,String>("email"));
            tbusers.setItems(list);
            
        } catch (SQLException ex) {
            Logger.getLogger(FXML2Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
   
        
    }    

    @FXML
    private void AjouterUser(ActionEvent event) {
        try {
            ServiceUser su= new ServiceUser();
            int i = Integer.parseInt(tftelephone.getText());
            
            users u = new users(i,tfusername.getText(),tfpassword.getText(),tfname.getText(),tflname.getText(),tfadresse.getText(),tfemail.getText());
            su.AddUser(u);
//ServiceUser su = new ServiceUser();
ObservableList<users> list= su.getUsersList();
colid.setCellValueFactory(new PropertyValueFactory<users,Integer>("id_user"));
coluser.setCellValueFactory(new PropertyValueFactory<users,String>("username"));
colpass.setCellValueFactory(new PropertyValueFactory<users,String>("password"));
colfname.setCellValueFactory(new PropertyValueFactory<users,String>("fname"));
colname.setCellValueFactory(new PropertyValueFactory<users,String>("lname"));
colad.setCellValueFactory(new PropertyValueFactory<users,String>("adress"));
coltel.setCellValueFactory(new PropertyValueFactory<users,Integer>("tel"));
cole.setCellValueFactory(new PropertyValueFactory<users,String>("email"));
tbusers.setItems(list);        
        } catch (SQLException ex) {
            Logger.getLogger(FXML2Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
/*public void ShowUsers() throws SQLException{
ServiceUser su = new ServiceUser();
    ObservableList<users> list= su.getUsersList();
    colid.setCellValueFactory(new PropertyValueFactory<users,Integer>("id_user"));
    coluser.setCellValueFactory(new PropertyValueFactory<users,String>("username"));
    colpass.setCellValueFactory(new PropertyValueFactory<users,String>("password"));
    colfname.setCellValueFactory(new PropertyValueFactory<users,String>("first_name"));
    colname.setCellValueFactory(new PropertyValueFactory<users,String>("last_name"));
    colad.setCellValueFactory(new PropertyValueFactory<users,String>("adresse"));
    coltel.setCellValueFactory(new PropertyValueFactory<users,Integer>("telephone"));
    cole.setCellValueFactory(new PropertyValueFactory<users,String>("email"));
    tbusers.setItems(list);
    System.out.println(list);
}*/
   /* @FXML
    private void AfficherUser(ActionEvent event) {
        ServiceUser su = new ServiceUser();
        try {
            lbuser.setText(su.AfficherUser().toString());
            
        } catch (SQLException ex) {
            Logger.getLogger(FXML2Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
    }*/

    @FXML
    private void SupprimerUser(ActionEvent event) {
       
        try {
            ServiceUser su= new ServiceUser();
            users u= new users();
            int id=Integer.parseInt(tfid.getText());
            u.setId_user(id);
            System.out.println(id);
            su.DelUser(u);
            ObservableList<users> list= su.getUsersList();
            colid.setCellValueFactory(new PropertyValueFactory<users,Integer>("id_user"));
            coluser.setCellValueFactory(new PropertyValueFactory<users,String>("username"));
            colpass.setCellValueFactory(new PropertyValueFactory<users,String>("password"));
            colfname.setCellValueFactory(new PropertyValueFactory<users,String>("fname"));
            colname.setCellValueFactory(new PropertyValueFactory<users,String>("lname"));
            colad.setCellValueFactory(new PropertyValueFactory<users,String>("adress"));
            coltel.setCellValueFactory(new PropertyValueFactory<users,Integer>("tel"));
            cole.setCellValueFactory(new PropertyValueFactory<users,String>("email"));  
            tbusers.setItems(list);
        } catch (SQLException ex) {
            Logger.getLogger(FXML2Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void selectdl(MouseEvent event) {
        users evt = tbusers.getSelectionModel().getSelectedItem();
        tfusername.setText(evt.getUsername());
        tfpassword.setText(evt.getPassword());
        tfname.setText(evt.getFname());
        tflname.setText(evt.getLname());
        tfemail.setText(evt.getEmail());
        String a = Integer.toString(evt.getId_user());
        tfid.setText(a);
        String b = Integer.toString(evt.getTel());
        tftelephone.setText(b);
    }

    @FXML
    private void ModifierUser(ActionEvent event) {
        try {
            ServiceUser tc = new ServiceUser();
            users u = new users();
            int id = Integer.parseInt(tfid.getText());
            u.setId_user(id);
            u.setUsername(tfusername.getText());
            u.setPassword(tfpassword.getText());
            u.setFname(tfname.getText());
            u.setLname(tflname.getText());
            int i =Integer.parseInt(tftelephone.getText());
            u.setTel(i);
            u.setEmail(tfemail.getText());
            tc.ModUser(u);
            ObservableList<users> list= tc.getUsersList();
            colid.setCellValueFactory(new PropertyValueFactory<users,Integer>("id_user"));
            coluser.setCellValueFactory(new PropertyValueFactory<users,String>("username"));
            colpass.setCellValueFactory(new PropertyValueFactory<users,String>("password"));
            colfname.setCellValueFactory(new PropertyValueFactory<users,String>("fname"));
            colname.setCellValueFactory(new PropertyValueFactory<users,String>("lname"));
            colad.setCellValueFactory(new PropertyValueFactory<users,String>("adress"));
            coltel.setCellValueFactory(new PropertyValueFactory<users,Integer>("tel"));
            cole.setCellValueFactory(new PropertyValueFactory<users,String>("email"));  
            tbusers.setItems(list);
        } catch (SQLException ex) {
            Logger.getLogger(FXML2Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void chercheruser(ActionEvent event) {
         try {
 ServiceUser tc = new ServiceUser();
            users u = new users();
            u.setFname(tfchercher.getText());
            ObservableList<users> list= tc.SearchUsersList(u);
            colid.setCellValueFactory(new PropertyValueFactory<users,Integer>("id_user"));
            coluser.setCellValueFactory(new PropertyValueFactory<users,String>("username"));
            colpass.setCellValueFactory(new PropertyValueFactory<users,String>("password"));
            colfname.setCellValueFactory(new PropertyValueFactory<users,String>("fname"));
            colname.setCellValueFactory(new PropertyValueFactory<users,String>("lname"));
            colad.setCellValueFactory(new PropertyValueFactory<users,String>("adress"));
            coltel.setCellValueFactory(new PropertyValueFactory<users,Integer>("tel"));
            cole.setCellValueFactory(new PropertyValueFactory<users,String>("email"));  
            tbusers.setItems(list);
        } catch (SQLException ex) {
            Logger.getLogger(FXML2Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
        }

    @FXML
    private void UpUser(ActionEvent event) {
                 try {
 ServiceUser tc = new ServiceUser();
            ObservableList<users> list= tc.UpUsersList();
            colid.setCellValueFactory(new PropertyValueFactory<users,Integer>("id_user"));
            coluser.setCellValueFactory(new PropertyValueFactory<users,String>("username"));
            colpass.setCellValueFactory(new PropertyValueFactory<users,String>("password"));
            colfname.setCellValueFactory(new PropertyValueFactory<users,String>("fname"));
            colname.setCellValueFactory(new PropertyValueFactory<users,String>("lname"));
            colad.setCellValueFactory(new PropertyValueFactory<users,String>("adress"));
            coltel.setCellValueFactory(new PropertyValueFactory<users,Integer>("tel"));
            cole.setCellValueFactory(new PropertyValueFactory<users,String>("email"));  
            tbusers.setItems(list);
        } catch (SQLException ex) {
            Logger.getLogger(FXML2Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void DownUser(ActionEvent event) {
                 try {
 ServiceUser tc = new ServiceUser();
                  ObservableList<users> list= tc.DownUsersList();
            colid.setCellValueFactory(new PropertyValueFactory<users,Integer>("id_user"));
            coluser.setCellValueFactory(new PropertyValueFactory<users,String>("username"));
            colpass.setCellValueFactory(new PropertyValueFactory<users,String>("password"));
            colfname.setCellValueFactory(new PropertyValueFactory<users,String>("fname"));
            colname.setCellValueFactory(new PropertyValueFactory<users,String>("lname"));
            colad.setCellValueFactory(new PropertyValueFactory<users,String>("adress"));
            coltel.setCellValueFactory(new PropertyValueFactory<users,Integer>("tel"));
            cole.setCellValueFactory(new PropertyValueFactory<users,String>("email"));  
            tbusers.setItems(list);
        } catch (SQLException ex) {
            Logger.getLogger(FXML2Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    private void openFile(File file) {
        try {
            this.desktop.open(file);
        } catch (IOException ex) {
            Logger.getLogger(FXML2Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void PrintUser(ActionEvent event) throws DocumentException, FileNotFoundException {

       String path="C:\\Users\\mortadha\\Desktop\\JAVA\\gestionprofil\\users.pdf";
         Document doc  =new Document(); 
            PdfWriter.getInstance(doc, new FileOutputStream(path));
         ServiceUser e =new ServiceUser();
        doc.open();
         PdfPTable table1=new PdfPTable(8);
       table1.setWidthPercentage(100);
       table1.getDefaultCell().setBorder(2);
       table1.addCell("id_user");
       table1.addCell("username");
       table1.addCell("password");
       table1.addCell("first_name");
       table1.addCell("last_name");
       table1.addCell("adresse");
       table1.addCell("telephone");
       table1.addCell("email");
       
        com.itextpdf.text.Paragraph p = new com.itextpdf.text.Paragraph();
            p.add(" Users List ");
            p.setAlignment(com.itextpdf.text.Element.ALIGN_CENTER);
            doc.add(p);
         
      // Paragraph para2 =new Paragraph("le nom de l equipment est ");

          for (int i = 0; i < tbusers.getItems().size(); i++) 
     { 
           try {
               String r=tbusers.getItems().get(i).getUsername().toString();
                table1.addCell(r);
               table1.addCell(e.getUsersList().get(i).getPassword());
               
               table1.addCell(e.getUsersList().get(i).getFname());
               table1.addCell(e.getUsersList().get(i).getLname());
               table1.addCell(e.getUsersList().get(i).getAdress());
               int a =e.getUsersList().get(i).getTel();
               String s=String.valueOf(a);
               table1.addCell(s);
               table1.addCell(e.getUsersList().get(i).getEmail());
               
               /* Paragraph para2 =new Paragraph("le nom de l equipment est "
               + ""+e.indexAction().get(i).getNomEquipment()+" la quantite "+
               e.indexAction().get(i).getNb_equipment()+" son etat"+
               e.indexAction().get(i).getEtatEquipment()+" il apartient a la categorie"
               
               +e.indexAction().get(i).getNomCategorie()
               
               );  */
               
               //     doc.add(para2);
               doc.add(table1);
               
               
               
               
               
               System.out.println("finish");
           } catch (SQLException ex) {
               Logger.getLogger(FXML2Controller.class.getName()).log(Level.SEVERE, null, ex);
           }

  }
          
          doc.close();
            Alert a = new Alert(Alert.AlertType.INFORMATION);
        a.setTitle("Génération du PDF");
        a.setHeaderText("Liste des users exportée");
        a.setContentText("Chemin du fichier : "+path);
        a.showAndWait();
                   TextArea textArea = new TextArea();
        textArea.setMinHeight(70);
        final FileChooser fileChooser = new FileChooser();
           textArea.clear();
        Window stage = null;
           
                File file = fileChooser.showOpenDialog(stage);
                 System.out.println(file);
//                 path=file.getAbsolutePath();
                if (file != null) {
                    
                    openFile(file);
                    //List<File> files = Arrays.asList(file);
                   // printLog(textArea, files);
               
                
                 fileChooser.setTitle("Select Some Files");
 
        // Set Initial Directory
           fileChooser.setInitialDirectory(new File(System.getProperty("user")));
            
        
       
     

       
        
       
     

       
            }
    }
    }
    

