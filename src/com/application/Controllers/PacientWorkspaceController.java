package com.application.Controllers;

import com.application.DataBaseHandler.DataBaseHandler;
import com.application.table_objects.HReception;
import com.application.table_objects.ListDoctors;
import com.application.table_objects.Reception;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class PacientWorkspaceController {
    @FXML
    private TableView<Reception> receptionTableView;

    @FXML
    private TableColumn<Reception, Date> dateColumn;

    @FXML
    private TableColumn<Reception, String> statusColumn;

    @FXML
    private TableColumn<Reception, String> petColumn;

    @FXML
    private TableColumn<Reception, String> doctorColumn;

    @FXML
    private TableColumn<Reception, String> specilizationColumn;

    @FXML
    private TableView<HReception> receptionHistoryTableView;

    @FXML
    private TableColumn<HReception, Date> hDateColumn;

    @FXML
    private TableColumn<HReception, String> hStatusColumn;

    @FXML
    private TableColumn<HReception, String> hPetColumn;

    @FXML
    private TableColumn<HReception, String> hDoctorColumn;

    @FXML
    private TableColumn<HReception, String> hSpecilizationColumn;

    @FXML
    private TableColumn<HReception, String> hDoneStatus;


    private ObservableList<ListDoctors> wTable;
    private DataBaseHandler dataBaseHandler;
    private String currentAccount;

    private static String usernameSing;
    private static String passwordSing;

    public static void sendUser(String username, String password) {
        usernameSing = username;
        passwordSing = password;
    }

    /**
     * Основной метод программ JavaFX, выполняется всегда, когда запускается сцена этого контроллера
     */
    @FXML
    void initialize() throws ParseException {
        wTable = FXCollections.observableArrayList();
        dataBaseHandler = DataBaseHandler.getInstance();
        initializeColumns();
        initializeReceptionsTable();
        initializeHReceptionsTable();
//

    }

    private void initializeHReceptionsTable() throws ParseException {
        hDateColumn.setCellValueFactory(new PropertyValueFactory<>("hDate"));
        hStatusColumn.setCellValueFactory(new PropertyValueFactory<>("hStatus"));
        hPetColumn.setCellValueFactory(new PropertyValueFactory<>("hPet"));
        hDoctorColumn.setCellValueFactory(new PropertyValueFactory<>("hDoctor"));
        hSpecilizationColumn.setCellValueFactory(new PropertyValueFactory<>("hSpecilization"));
        hDoneStatus.setCellValueFactory(new PropertyValueFactory<>("hDoneStatus"));

        ObservableList<HReception> hReception= FXCollections.observableArrayList();
        hReception.add(new HReception(new SimpleDateFormat("yyyy-MM-dd").parse("2021-11-16"),"Первичный","Собака","Василий Семенов Теодорович","терапевт-ветеринар","ожидается"));
        receptionHistoryTableView.setItems(hReception);
    }

    private void initializeReceptionsTable() throws ParseException {
        dateColumn.setCellValueFactory(new PropertyValueFactory<>("date"));
        statusColumn.setCellValueFactory(new PropertyValueFactory<>("status"));
        petColumn.setCellValueFactory(new PropertyValueFactory<>("pet"));
        doctorColumn.setCellValueFactory(new PropertyValueFactory<>("doctor"));
        specilizationColumn.setCellValueFactory(new PropertyValueFactory<>("specilization"));

        ObservableList<Reception> reception= FXCollections.observableArrayList();
        reception.add(new Reception(new SimpleDateFormat("yyyy-MM-dd").parse("2021-11-16"),"Первичный","Собака","Василий Семенов Теодорович","терапевт-ветеринар"));
        receptionTableView.setItems(reception);
    }


    /**
     * Производит начальную загрузку всех значении из базы данных
     *
     *
     */


    /**
     * Использяется для инитиализации столбцов редактируемыми
     *
     *
     */
    private void initializeColumns() {

    }


}
