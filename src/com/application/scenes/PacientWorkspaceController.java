package com.application.scenes;

import com.application.DataBaseHandler.DataBaseHandler;
import com.application.table_objects.ListDoctors;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.sql.ResultSet;

public class PacientWorkspaceController {
    @FXML
    private TableView<ListDoctors> workTable;

    @FXML
    private TableColumn<ListDoctors, Integer> idColumn;
    @FXML
    private TableColumn<ListDoctors, String> dateColumn;

    @FXML
    private TableColumn<ListDoctors, String> FIOPacient;

    @FXML
    private TableColumn<ListDoctors, String> petName;

    @FXML
    private TableColumn<ListDoctors, String> petBreed;

    @FXML
    private TableColumn<ListDoctors, String> petGender;

    @FXML
    private TableColumn<ListDoctors, String> FIODoctor;

    @FXML
    private TableColumn<ListDoctors, String> employeeDoctor;


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
    void initialize() {
        wTable = FXCollections.observableArrayList();
        dataBaseHandler = DataBaseHandler.getInstance();
        loadData();
//        initializeColumns();
//

    }


    /**
     * Производит начальную загрузку всех значении из базы данных
     *
     *
     */
    private void loadData() {

        try {
            ResultSet resultSet = dataBaseHandler.getData();
            boolean isMovedCursor = false;
            int i = 0;
            while (resultSet.next()) {

                ObservableList<ListDoctors> row = FXCollections.observableArrayList();

                wTable.add(row.get(i));
                i++;
                isMovedCursor = true;
            }
            if (isMovedCursor){
                workTable.setItems(wTable);
            }else {
//                wTable.add(new ListDoctors());
                workTable.setItems(wTable);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    /**
     * Использяется для инитиализации столбцов редактируемыми
     *
     *
     */
    private void initializeColumns() {
        idColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
        dateColumn.setCellValueFactory(new PropertyValueFactory<>("dateColumn"));
        FIOPacient.setCellValueFactory(new PropertyValueFactory<>("FIOPacient"));
        petName.setCellValueFactory(new PropertyValueFactory<>("petName"));
        petBreed.setCellValueFactory(new PropertyValueFactory<>("petBreed"));
        petGender.setCellValueFactory(new PropertyValueFactory<>("petGender"));
        FIODoctor.setCellValueFactory(new PropertyValueFactory<>("FIODoctor"));
        employeeDoctor.setCellValueFactory(new PropertyValueFactory<>("employeeDoctor"));

    }


}
