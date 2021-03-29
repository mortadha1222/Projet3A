/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import entities.Actualities;
import entities.Events;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Tab;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.InputMethodEvent;
import javafx.scene.input.KeyEvent;
import services.ActuService;
import services.EventService;

/**
 * FXML Controller class
 *
 * @author Administrator
 */
public class FrontEventActuController implements Initializable {

    @FXML
    private Tab printevent;
    @FXML
    private Button printactu;

    /**
     * Initializes the controller class.
     */
    EventService se = new EventService();
    Integer id, iddd;
    ActuService see = new ActuService();
    @FXML
    private TableColumn<Events, String> name_event;
    @FXML
    private TableColumn<Events, String> date_event;
    @FXML
    private TableView<Events> tableau_eve;
    @FXML
    private Tab printact;
    @FXML
    private Button printevent1;
    @FXML
    private Label desclabeve;
    @FXML
    private Label desclabact;
    @FXML
    private TextField filterField;
    // public ListData listdata;
    @FXML
    private TableView<Actualities> actTable;
    @FXML
    private TableColumn<Actualities, String> actName;
    @FXML
    private TableColumn<Actualities, String> actDate;
    @FXML
    private TextField filterFieldAct;

    @Override
    public void initialize(URL url, ResourceBundle rb) {

        tableau_eve.setOnMouseClicked(((event) -> {

            desclabeve.setText("Description : " + se.displayAllList()
                    .get(tableau_eve.getSelectionModel().getSelectedIndex())
                    .getDescription_eve());

        }));

        actTable.setOnMouseClicked(((event) -> {

            desclabact.setText("Description : " + see.displayAllLista()
                    .get(actTable.getSelectionModel().getSelectedIndex())
                    .getDescription_act());

        }));

        ObservableList<Actualities> listA = null;
        ObservableList<Events> list = null;
        try {
            listA = see.getActuList();
            list = se.getEventsList();
        } catch (SQLException ex) {
            Logger.getLogger(FrontEventActuController.class.getName()).log(Level.SEVERE, null, ex);
        }

        actName.setCellValueFactory(new PropertyValueFactory<>("name_Act"));
        actDate.setCellValueFactory(new PropertyValueFactory<>("date_act"));

        name_event.setCellValueFactory(new PropertyValueFactory<>("name_eve"));
        date_event.setCellValueFactory(new PropertyValueFactory<>("date_eve"));

        FilteredList<Events> filteredData = new FilteredList<>(list, b -> true);
        filterField.textProperty().addListener((observable, oldValue, newValue) -> {
            filteredData.setPredicate(event -> {
                if (newValue == null || newValue.isEmpty()) {
                    return true;
                }
                String lowerCaseFilter = newValue.toLowerCase();
                if (event.getName_eve().toLowerCase().contains(lowerCaseFilter)) {
                    return true; // Filter matches first name.
                } else if (event.getDate_eve().toLowerCase().contains(lowerCaseFilter)) {
                    return true; // Filter matches last name.
                } else {
                    return false; // Does not match.
                }
            });
        });
        SortedList<Events> sortedData = new SortedList<>(filteredData);
        sortedData.comparatorProperty().bind(tableau_eve.comparatorProperty());
        tableau_eve.setItems(sortedData);

        FilteredList<Actualities> filteredDataAct = new FilteredList<>(listA, b -> true);
        filterFieldAct.textProperty().addListener((observable, oldValue, newValue) -> {
            filteredDataAct.setPredicate(actu -> {
                if (newValue == null || newValue.isEmpty()) {
                    return true;
                }
                String lowerCaseFilter = newValue.toLowerCase();
                if (actu.getName_Act().toLowerCase().contains(lowerCaseFilter)) {
                    return true; // Filter matches first name.
                } else if (actu.getDate_act().toLowerCase().contains(lowerCaseFilter)) {
                    return true; // Filter matches last name.
                } else {
                    return false; // Does not match.
                }
            });
        });
        SortedList<Actualities> sortedDataActu = new SortedList<>(filteredDataAct);
        sortedDataActu.comparatorProperty().bind(actTable.comparatorProperty());
        actTable.setItems(sortedDataActu);
    }

    @FXML
    private void RefreshEve(ActionEvent event) {
        /*
        ObservableList<Actualities> listA = null;
        try {
            listA = see.getActuList();
        } catch (SQLException ex) {
            Logger.getLogger(FrontEventActuController.class.getName()).log(Level.SEVERE, null, ex);
        }

        ObservableList<Events> list = null;
        try {
            list = se.getEventsList();
        } catch (SQLException ex) {
            Logger.getLogger(FrontEventActuController.class.getName()).log(Level.SEVERE, null, ex);
        }

        
        actName.setCellValueFactory(new PropertyValueFactory<>("title_act"));

        actDate.setCellValueFactory(new PropertyValueFactory<>("date_act"));

        name_event.setCellValueFactory(new PropertyValueFactory<Events, String>("name_eve"));

        date_event.setCellValueFactory(new PropertyValueFactory<Events, String>("date_eve"));

        // Label desclabelact = new Label (e.getLabel());
        actTable.setItems(listA);
        tableau_eve.setItems(list);
         */
    }

    @FXML
    private void RefreshAct(ActionEvent event) {
        /*
        ObservableList<Actualities> listA = null;
        ObservableList<Events> dataList = null;
        try {
            dataList = se.getEventsList();
        } catch (SQLException ex) {
            Logger.getLogger(FrontEventActuController.class.getName()).log(Level.SEVERE, null, ex);
        }

        FilteredList<Events> filteredData = new FilteredList<>(dataList, b -> true);

        try {
            listA = see.getActuList();
            filterField.textProperty().addListener((observable, oldValue, newValue) -> {
                filteredData.setPredicate(Events -> {
                    // If filter text is empty, display all persons.

                    if (newValue == null || newValue.isEmpty()) {
                        return true;
                    }

                    // Compare first name and last name of every person with filter text.
                    String lowerCaseFilter = newValue.toLowerCase();

                    if (Events.getName_eve().toLowerCase().indexOf(lowerCaseFilter) != -1) {
                        return true; // Filter matches first name.
                    };
                    return false;
                });
            });
        } catch (SQLException ex) {
            Logger.getLogger(FrontEventActuController.class.getName()).log(Level.SEVERE, null, ex);
        }

        ObservableList<Events> list = null;
        try {
            list = se.getEventsList();
        } catch (SQLException ex) {
            Logger.getLogger(FrontEventActuController.class.getName()).log(Level.SEVERE, null, ex);
        }

        actName.setCellValueFactory(new PropertyValueFactory<Actualities,String>("name_actu"));

        actDate.setCellValueFactory(new PropertyValueFactory<>("date_actu"));

        name_event.setCellValueFactory(new PropertyValueFactory<Events, String>("name_eve"));

        date_event.setCellValueFactory(new PropertyValueFactory<Events, String>("date_eve"));

        // Label desclabelact = new Label (e.getLabel());
        actTable.setItems(listA);
        tableau_eve.setItems(list);
         */
    }
}
