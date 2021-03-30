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
import Entities.Reclamation;
import Services.ReclamationService;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
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
public class ReclamationDetailsController implements Initializable {

    @FXML
    private Label title;
    @FXML
    private Label description;
    @FXML
    private Label answer;
    
     private static int idd ;
     private Reclamation reclamation;

    ReclamationService sr= new ReclamationService();
    
        @FXML
    private Label traitement;
    @FXML
    private Label reponsetext;
    @FXML
    private Label date;
    /**
     * Initializes the controller class.
     * 
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
            reclamation=sr.readdetails(idd);
//          System.out.println(idd);
        } catch (SQLException ex) {
           Logger.getLogger(ReclamationDetailsController.class.getName()).log(Level.SEVERE, null, ex);
       }
                      
       title.setText(reclamation.getTitle());
       
           
       description.setText(reclamation.getDescription());
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        String strDate = formatter.format(reclamation.getDate()); 
        date.setText(strDate);
      
                  if(reclamation.getAnswer()==null){
            circle.setFill(rgb(255, 0, 0));
         
            traitement.setText("being processed");
                  answer.setText(reclamation.getAnswer());
      reponsetext.setText("");}
        else
        {
            circle.setFill(rgb(0, 204, 0));
            traitement.setText("treated");
        reponsetext.setText("Answer");
        answer.setText(reclamation.getAnswer());}
       
    } 


    @FXML
    private void archiver() {
         int  x=ReclamationDetailsController.getIdd(reclamation.getId());
         System.out.println(x);
         ReclamationService sr= new ReclamationService();
         Reclamation u = new Reclamation();

         
         u.setId(x);
         u.setArchive("archive");
         sr.archiverReclamation(u); 
         Alert a= new Alert(Alert.AlertType.WARNING);
         a.setTitle("reclamation archived");
         a.setContentText("a reclamation has been archived. you have to reload the reclamation list");
         a.setHeaderText(null);
         a.showAndWait();
          
        
    }

    @FXML
    private void createPDF() throws FileNotFoundException, DocumentException {
        
           try { 
            reclamation=sr.readdetails(idd);
//          System.out.println(idd);
        } catch (SQLException ex) {
           Logger.getLogger(ReclamationDetailsController.class.getName()).log(Level.SEVERE, null, ex);
       }
        
        
        
        
        Document document=new Document();
        
        PdfWriter.getInstance(document, new FileOutputStream("Reclamation.pdf"));
        
        document.open();
        Font f1= new Font(Font.FontFamily.UNDEFINED,30,Font.UNDERLINE,BaseColor.GREEN);
        Paragraph p1= new Paragraph("Work-IT",f1);
        p1.setLeading(50);
        p1.setAlignment(Element.ALIGN_CENTER);
       // p1.setIndentationRight(50);
       // p1.setFirstLineIndent(10);

        document.add(p1);
        Paragraph p2= new Paragraph("              ");
        document.add(p2);
  
        Font f9= new Font(Font.FontFamily.UNDEFINED,22,Font.ITALIC,BaseColor.BLACK);
        Paragraph p8= new Paragraph("title of reclamation : "+reclamation.getTitle(),f9);
        p8.setLeading(50);
        p8.setAlignment(Element.ALIGN_CENTER);
        document.add(p8);
        document.add(p2);
        
        
        Font f2= new Font(Font.FontFamily.UNDEFINED,20,Font.ITALIC,BaseColor.BLUE);
        Paragraph p3= new Paragraph("your reclamation",f2);
        p3.setAlignment(Element.ALIGN_LEFT);
        p3.setFirstLineIndent(10);
        p3.setIndentationRight(50);
        
        document.add(p3);
        document.add(p2);
        Font f3= new Font(Font.FontFamily.UNDEFINED,18,Font.NORMAL,BaseColor.BLACK);
        Paragraph p4= new Paragraph(reclamation.getDescription(),f3);
        p4.setAlignment(Element.ALIGN_LEFT);
        p4.setFirstLineIndent(10);
        p4.setIndentationLeft(40);

        document.add(p4);
        document.add(p2);
        document.add(p2);
        if(!"".equals(reclamation.getAnswer())){
                
        Font f4= new Font(Font.FontFamily.UNDEFINED,20,Font.ITALIC,BaseColor.BLUE);       
        Paragraph p5= new Paragraph("the answer of admin",f4);
        p5.setAlignment(Element.ALIGN_LEFT);
        p5.setFirstLineIndent(10);
        p5.setIndentationRight(50);

        document.add(p5);
        document.add(p2);
        Font f5= new Font(Font.FontFamily.UNDEFINED,18,Font.NORMAL,BaseColor.BLACK);        
        Paragraph p6= new Paragraph(reclamation.getAnswer(),f5);
        p6.setAlignment(Element.ALIGN_LEFT);
        p6.setFirstLineIndent(10);
        p6.setIndentationLeft(40);
        document.add(p6);
        

        };
                Font f6= new Font(Font.FontFamily.UNDEFINED,18,Font.NORMAL,BaseColor.GRAY);       
        Paragraph p7= new Paragraph("Posted : "+reclamation.getDate(),f6);
        p7.setAlignment(Element.ALIGN_RIGHT);

document.add(p2);
document.add(p2);
document.add(p2);
        document.add(p7);

        
        

        
        document.close();
        
        Alert a= new Alert(Alert.AlertType.INFORMATION);
         a.setTitle("PDF reclamation ");
         a.setContentText("a PDF reclamation has been saved successfully");
         a.setHeaderText(null);
         a.showAndWait();
        
        
        
    }


    
}
