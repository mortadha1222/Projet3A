package controller;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import entities.Actualities;
import javafx.scene.image.Image;
import entities.Events;
import services.ActuService;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import static java.sql.DriverManager.println;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.FileChooser;
import services.EventService;
import test.main;
import java.io.File;

import java.io.FileOutputStream;

import java.io.OutputStream;

/**
 *
 * @author Administrator
 */
public class GestionController implements Initializable {

    @FXML
    private Label label;
    @FXML
    private TextField name;
    private TextField memberid;
    @FXML
    private DatePicker date;
    @FXML
    private TextField description;

    @FXML
    private Button browse;
    @FXML
    private TableView<Events> tableau;
    String pathimage1 = null;
    String pathimage = null;
    @FXML
    private TableColumn<Events, String> namecol;
    @FXML
    private TableColumn<Events, Integer> memidcol;
    @FXML
    private TableColumn<Events, String> piccol;
    @FXML
    private TableColumn<Events, String> datecol;
    @FXML
    private TextField pickUpPathField;

    //public ListData listdata;
    @FXML
    private TableColumn<Events, String> desccol;
    @FXML
    private Tab events;
    @FXML
    private AnchorPane menu;
    @FXML
    private Tab actualities;
    private TextField memberid_Act;
    @FXML
    private TextField description_Act;
    @FXML
    private Button browse1;
    @FXML
    private TextField pickUpPathField1;
    @FXML
    private Button add_Act;
    @FXML
    private Button update_Act;
    @FXML
    private Button delete_Act;
    @FXML
    private TextField title;
    @FXML
    private TableView<Actualities> tableauAct;
    @FXML
    private ComboBox<String> select;
    @FXML
    private ComboBox<String> select2;
    @FXML
    private Button pdfevent;

    private ObservableList<Events> list;
    @FXML
    private TableColumn<Actualities, String> actTitle;
    @FXML
    private TableColumn<Actualities, String> actMemId;
    @FXML
    private TableColumn<Actualities, String> actPhoto;
    @FXML
    private TableColumn<Actualities, String> actDate;
    @FXML
    private TableColumn<Actualities, Integer> actDescription;

    public GestionController() throws SQLException {

    }
    EventService se = new EventService();
    Integer id, iddd;
    ActuService see = new ActuService();

    // DatePicker datePicker = (DatePicker) getPrimaryStage().getScene().getRoot().lookup(".date-picker");
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            select.setItems(FXCollections.observableArrayList(se.listmem()));
            select2.setItems(FXCollections.observableArrayList(se.listmemeve()));
        } catch (SQLException ex) {
            Logger.getLogger(GestionController.class.getName()).log(Level.SEVERE, null, ex);
        }

        tableau.setOnMouseClicked((MouseEvent event) -> {

            id = se.displayAllList()
                    .get(tableau.getSelectionModel().getSelectedIndex())
                    .getId_event();

            name.setText(se.displayAllList()
                    .get(tableau.getSelectionModel().getSelectedIndex())
                    .getName_eve());

            select2.setValue(String.valueOf(se.displayAllList()
                    .get(tableau.getSelectionModel().getSelectedIndex())
                    .getId_member()));

            date.setValue(LocalDate.parse(se.displayAllList()
                    .get(tableau.getSelectionModel()
                            .getSelectedIndex())
                    .getDate_eve()));

            description.setText(se.displayAllList()
                    .get(tableau.getSelectionModel().getSelectedIndex())
                    .getDescription_eve());

        });

        tableauAct.setOnMouseClicked((MouseEvent event) -> {
            iddd = see.displayAllLista()
                    .get(tableauAct.getSelectionModel().getSelectedIndex())
                    .getId_act();
            System.out.println(iddd);
            title.setText(see.displayAllLista()
                    .get(tableauAct.getSelectionModel().getSelectedIndex())
                    .getName_Act());

            description_Act.setText(see.displayAllLista()
                    .get(tableauAct.getSelectionModel()
                            .getSelectedIndex())
                    .getDescription_act());
        });

        try {

            list = se.getEventsList();

            namecol.setCellValueFactory(new PropertyValueFactory<>("name_eve"));
            memidcol.setCellValueFactory(new PropertyValueFactory<>("id_member"));
            piccol.setCellValueFactory(new PropertyValueFactory<>("photo_eve"));
            datecol.setCellValueFactory(new PropertyValueFactory<>("date_eve"));
            desccol.setCellValueFactory(new PropertyValueFactory<>("description_eve"));

            tableau.setItems(list);
        } catch (SQLException ex) {
            Logger.getLogger(GestionController.class.getName()).log(Level.SEVERE, null, ex);
        }

        ObservableList<Actualities> listA;
        try {
            listA = see.getActuList();

            actTitle.setCellValueFactory(new PropertyValueFactory<>("name_Act"));
            actDate.setCellValueFactory(new PropertyValueFactory<>("date_act"));
            actDescription.setCellValueFactory(new PropertyValueFactory<>("description_act"));
            actPhoto.setCellValueFactory(new PropertyValueFactory<>("photo_act"));
            actMemId.setCellValueFactory(new PropertyValueFactory<>("id_member"));

            tableauAct.setItems(listA);

        } catch (SQLException ex) {
            Logger.getLogger(GestionController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @FXML
    private void add(ActionEvent event) throws SQLException {

        //System.out.println(e);
        if ((name.getText().isEmpty() || select2.getValue().isEmpty())) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.show();
            alert.setTitle(" empty fields!");
            alert.setContentText("mandatory fields to update!");
        } else {
            String memid = select2.getValue();
            int idd = Integer.parseInt(memid);
            System.out.println(idd);
            String datee = date.getValue().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));

            //Events e = new Events("aa", "pop", "aa", "pop",8 );
            Events e = new Events(name.getText(), datee, description.getText(), pickUpPathField.getText(), idd);
            EventService es = new EventService();
            try {
                es.insert(e);
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Done");
                alert.setContentText("Addeded!");
                alert.show();
                tableau.refresh();
            } catch (Exception ee) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error!");
                alert.show();
            }
            tableau.setItems(es.getEventsList());
        }

    }

    @FXML
    private void update(ActionEvent event) {

        if ((name.getText().isEmpty() || select2.getValue().isEmpty())) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.show();
            alert.setTitle(" empty fields!");
            alert.setContentText("mandatory fields to update!");
        } else {
            String datee = date.getValue().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));

            try {
                Events a = tableau.getSelectionModel().getSelectedItem();
                if (a != null) {
                    EventService sa = new EventService();
                    String memid = select2.getValue();
                    int idd = Integer.parseInt(memid);

                    //a.setCategorie_id(categorieA.getSelectionModel().getSelectedItem().getId());
                    // a.setNom(nomText.getText());
                    a.setDescription_eve(description.getText());
                    a.setDate_eve(datee);
                    a.setPhoto_eve(pathimage);
                    try {
                        se.updateEve(id, a.getName_eve(), a.getDate_eve(), a.getDescription_eve(), a.getPhoto_eve(), idd);
                        Alert alert = new Alert(Alert.AlertType.WARNING);
                        alert.show();
                        alert.setTitle("updated !");
                        alert.setContentText("updated succesfully");

                    } catch (Exception e) {
                        Alert alert = new Alert(Alert.AlertType.ERROR);
                        alert.show();
                        alert.setTitle("fail !");
                        alert.setContentText("failed succesfully");

                    }
                    tableau.setItems(sa.getEventsList());

                }

                println("aaaaaaaaaaaaaaaaaaaaaaaaaaa");
                ObservableList<Events> list = se.getEventsList();
                namecol.setCellValueFactory(new PropertyValueFactory<Events, String>("name_eve"));
                memidcol.setCellValueFactory(new PropertyValueFactory<Events, Integer>("id_member"));
                piccol.setCellValueFactory(new PropertyValueFactory<Events, String>("photo_eve"));
                datecol.setCellValueFactory(new PropertyValueFactory<Events, String>("date_eve"));
                desccol.setCellValueFactory(new PropertyValueFactory<Events, String>("description_eve"));

            } catch (SQLException ex) {
                ex.getCause().printStackTrace();
                Logger.getLogger(GestionController.class.getName()).log(Level.SEVERE, null, ex);
            }

        }

    }

    @FXML
    private void delete(ActionEvent event) {

        Alert alert2 = new Alert(Alert.AlertType.CONFIRMATION);
        alert2.setTitle("Confirmation");
        alert2.setHeaderText("Voulez vous vraiment supprimer cet utilisateur ?");
        Optional<ButtonType> result = alert2.showAndWait();
        if (result.get() == ButtonType.OK) {
            EventService su = new EventService();
            try {
                su.DelEve(id);
                //System.out.println(emaillabel.toString());
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Supprimé");
                alert.setHeaderText(null);
                alert.setContentText("Supprimé avec succés !");
                alert.show();
                tableau.setItems(su.getEventsList());
            } catch (SQLException e) {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Echec");
                alert.setHeaderText(null);
                alert.setContentText("Utilisateur non supprimé !");
            }

        } else {
            alert2.close();
        }

    }

    private String browsemouse(MouseEvent event) {
        FileChooser fc = new FileChooser();
        fc.getExtensionFilters().add(new FileChooser.ExtensionFilter("PNG Files", "*.png"));
        List<File> f = fc.showOpenMultipleDialog(null);

        for (File file : f) {
            //System.out.println(f);

        }
        return f.toString();

    }

    @FXML
    private void browse(ActionEvent event) throws FileNotFoundException {
        FileChooser fc = new FileChooser();
        fc.getExtensionFilters().add(new FileChooser.ExtensionFilter("image", "*.png"));
        List<File> f = fc.showOpenMultipleDialog(null);
        String x = "/";
        for (File file : f) {
            x = file.getAbsolutePath();
            pickUpPathField.setText(file.getPath());

        }
        Image image = new Image(new FileInputStream(f.get(0)));

        pathimage = x;

    }

    @FXML
    private void browseAct(ActionEvent event) throws FileNotFoundException {
        FileChooser fc = new FileChooser();
        fc.getExtensionFilters().add(new FileChooser.ExtensionFilter("image", "*.png"));
        List<File> f = fc.showOpenMultipleDialog(null);
        String x = "/";
        for (File file : f) {
            x = file.getAbsolutePath();
            pickUpPathField1.setText(file.getPath());

        }
        Image image = new Image(new FileInputStream(f.get(0)));

        pathimage1 = x;
    }

    @FXML
    private void addAct(ActionEvent event) throws SQLException {

        //System.out.println(e);
        if ((title.getText().isEmpty() || select.getValue().isEmpty())) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.show();
            alert.setTitle(" empty fields!");
            alert.setContentText("mandatory fields to update!");
        } else {
            String memid = select.getValue();
            int idd = Integer.parseInt(memid);
            String datee = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
            ObservableList<Actualities> listA = see.getActuList();

            //Events e = new Events("aa", "pop", "aa", "pop",8 );
            Actualities e = new Actualities(title.getText(), datee, description_Act.getText(), pickUpPathField1.getText(), idd);
            ActuService es = new ActuService();
            es.insertAct(e);
            tableauAct.setItems(es.getActuList());
        }

    }

    @FXML
    private void updateAct(ActionEvent event) throws SQLException {

        if ((title.getText().isEmpty() || select.getValue().isEmpty())) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.show();
            alert.setTitle(" empty fields!");
            alert.setContentText("mandatory fields to update!");
        } else {

            Actualities a = tableauAct.getSelectionModel().getSelectedItem();
            if (a != null) {
                a.setTitle_act(title.getText());
                String memid = select.getValue();
                int idd = Integer.parseInt(memid);

                a.setDescription_act(description_Act.getText());
                //a.setDate_eve(datee);
                a.setPhoto_act(pathimage1);
                ActuService ac = new ActuService();

                ac.updateAct(iddd, a.getName_Act(), a.getDescription_act(), a.getPhoto_act(), idd);
                tableauAct.setItems(ac.getActuList());

                // System.out.println("err");
            }
        }

    }

    @FXML
    private void deleteAct(ActionEvent event) {

        Alert alert2 = new Alert(Alert.AlertType.CONFIRMATION);
        alert2.setTitle("Confirmation");
        alert2.setHeaderText("Voulez vous vraiment supprimer cet utilisateur ?");
        Optional<ButtonType> result = alert2.showAndWait();
        if (result.get() == ButtonType.OK) {
            ActuService su = new ActuService();
            try {
                su.DelAct(iddd);
                //System.out.println(emaillabel.toString());
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Supprimé");
                alert.setHeaderText(null);
                alert.setContentText("Supprimé avec succés !");
                alert.show();
                tableauAct.setItems(su.getActuList());
            } catch (SQLException e) {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Echec");
                alert.setHeaderText(null);
                alert.setContentText("Utilisateur non supprimé !");
            }

        } else {
            alert2.close();
        }
    }

    @FXML
    private String browseAct(MouseEvent event) {
        FileChooser fc = new FileChooser();
        fc.getExtensionFilters().add(new FileChooser.ExtensionFilter("PNG Files", "*.png"));
        List<File> f = fc.showOpenMultipleDialog(null);

        for (Iterator<File> it = f.iterator(); it.hasNext();) {
            File file = it.next();
        } //System.out.println(f);
        return f.toString();
    }

    @FXML
    private void updateview(Event event) throws SQLException {

    }

    @FXML
    private void afficherAct(ActionEvent event) {

    }

    private void gofront(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("../views/FrontEventActu.fxml"));
        Scene scene = new Scene(root, main.stage.getScene().getWidth(), main.stage.getScene().getHeight());
        main.stage.setScene(scene);
    }

    @FXML
    private void printevent(ActionEvent event) throws SQLException {

        list = se.getEventsList();
        try {
            OutputStream file = new FileOutputStream(new File("D:\\export.pdf"));
            Document document = new Document();
            PdfWriter.getInstance(document, file);
            document.open();

            Font font = new Font(Font.FontFamily.HELVETICA, 24, Font.BOLD);
            Paragraph pdfTitle = new Paragraph("Events list", font);
            pdfTitle.setAlignment(Element.ALIGN_CENTER);

            document.add(pdfTitle);
            document.add(new Chunk("\n"));
            PdfPTable table = new PdfPTable(5);
            table.setHeaderRows(1);

            table.addCell("Name");
            table.addCell("Member ID");
            table.addCell("Photo Url");
            table.addCell("Date");
            table.addCell("Description");

            list.forEach((_item) -> {
                table.addCell(_item.getName_eve());
                table.addCell(String.valueOf(_item.getId_member()));
                table.addCell(_item.getPhoto_eve());
                table.addCell(_item.getDate_eve());
                table.addCell(_item.getDescription_eve());
            });

            document.add(table);

            document.close();

            file.close();
            
        } catch (DocumentException | IOException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setContentText("Cannot export data!");
            alert.show();
        }
    }
}
