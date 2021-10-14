package com.application.Controllers;

import com.application.DataBaseHandler.DataBaseHandler;
import com.application.table_objects.ListDoctors;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

import java.awt.*;
import java.util.EventListener;

public class ControllerGetToDoctor {

    @FXML
    private Button getDoctorButton;

    @FXML
    private ComboBox<String> receptionStatusComboBox;

    @FXML
    private TableView<ListDoctors> doctorsTable;

    @FXML
    private TableColumn<ListDoctors, String> doctorColumn;

    @FXML
    private TableColumn<ListDoctors, String> specializationColumn;

    @FXML
    private DatePicker receptionDatePicker;

    @FXML
    private TextField petTextBox;

    private ObservableList<ListDoctors> DBDoctor = FXCollections.observableArrayList();

    @FXML
    void initialize(){
        doctorsTable();

    }

    public void doctorsTable(){
        doctorColumn.setCellValueFactory(new PropertyValueFactory<>("doctor"));
        specializationColumn.setCellValueFactory(new PropertyValueFactory<>("specilization"));
        DataBaseHandler DBHandler = new DataBaseHandler();
        DBDoctor = DBHandler.getDoctors();
        doctorsTable.setItems(DBDoctor);
    }


}
