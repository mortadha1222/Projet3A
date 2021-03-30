/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Entities.Reclamation;
import Services.ReclamationService;
import com.jfoenix.controls.JFXTextField;
import java.net.URL; 
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.Date;
import java.util.Optional;
import java.util.Properties;
import java.util.ResourceBundle;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javax.mail.Message;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

/**
 * FXML Controller class
 *
 * @author ASUS
 */
public class ReclamationAddController implements Initializable {

    @FXML
    private TextField title;
    @FXML
    private TextArea description;
    
    private Reclamation reclamationn;
    
    int id_user=1;
    @FXML
    private JFXTextField email;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

        
    }    

    @FXML
    private void save() {
        
         ReclamationService sr= new ReclamationService();
         Reclamation u = new Reclamation();
         
         u.setTitle(title.getText());
         u.setDescription(description.getText());
         u.setId_user(id_user);
         
       LocalDateTime localDateTime = LocalDateTime.now();
        LocalDate localDate = localDateTime.toLocalDate();
        LocalTime localTime = localDateTime.toLocalTime();
        Date date = Date.from(localDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
        u.setDate(date);
        System.out.println(u);
        
         
         if(validateEmail()){
         sr.ajouterReclamation(u);
         Alert a= new Alert(Alert.AlertType.INFORMATION);
         a.setTitle("reclamation added successfully");
         a.setContentText("a reclamation has been added successfully . you have to reload the reclamation list");
         a.setHeaderText(null);
         a.showAndWait();
         
         sendEmail();}

         
         
    }
    
         public void sendEmail(){
     try{
            String host ="smtp.gmail.com" ;
            String user = "workit.noreplay2021@gmail.com";
            String pass = "workit.noreplay2021@gmail.com w";
            String to = email.getText();
            String from = "workit.noreplay2021@gmail.com";
            String subject = "Work-It - Reclamation effectué";
            boolean sessionDebug = false;

            Properties props = System.getProperties();

            props.put("mail.smtp.starttls.enable", "true");
            props.put("mail.smtp.host", host);
            props.put("mail.smtp.port", "587");
            props.put("mail.smtp.auth", "true");
            props.put("mail.smtp.starttls.required", "true");

            java.security.Security.addProvider(new com.sun.net.ssl.internal.ssl.Provider());
            Session mailSession = Session.getDefaultInstance(props, null);
            mailSession.setDebug(sessionDebug);
            Message msg = new MimeMessage(mailSession);
            msg.setFrom(new InternetAddress(from));
            InternetAddress[] address = {new InternetAddress(to)};
           
            msg.setRecipients(Message.RecipientType.TO, address);
            msg.setSubject(subject); msg.setSentDate(new Date());
                
            
            MimeBodyPart messageBodyPart = new MimeBodyPart();
            Multipart multipart = new MimeMultipart();
        
     
            messageBodyPart = new MimeBodyPart();   
    
            messageBodyPart.setText("Bonjour Mme/Mr "+" "+", Votre reclamation a été passée avec succées . nous vous répondrons au plus tôt a votre reclamation! Merci pour votre fedelité ");
            multipart.addBodyPart(messageBodyPart);
    
        
            msg.setContent(multipart);

       
           Transport transport=mailSession.getTransport("smtp");
           transport.connect(host, user, pass);
           transport.sendMessage(msg, msg.getAllRecipients());
           transport.close();
                   System.out.println("Email envoyé");

        }catch(Exception ex)
        {
            System.out.println(ex);
        }
}
         private boolean validateEmail() {
        Pattern p = Pattern.compile("[a-zA-Z0-9][a-zA-Z0-9._]*@[a-zA-Z0-9]+([.][a-zA-Z]+)+");
        Matcher m = p.matcher(email.getText());
        if (m.find() && m.group().equals(email.getText())) {
            return true;
        } else {
            Alert alert = new Alert(AlertType.WARNING);
            alert.setTitle("validate email");
            alert.setHeaderText(null);
            alert.setContentText("please enter valid email");
            alert.showAndWait();
            email.setText("");
            return false;
        }
    }
    
}
