package com.application.scenes;

import com.application.DataBaseHandler.DataBaseHandler;
import com.application.table_objects.WorkTable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.util.converter.IntegerStringConverter;

import java.sql.ResultSet;

public class DoctorWorkspaceController {

    @FXML
    private TableView<WorkTable> workTable;

    @FXML
    private TableColumn<WorkTable, Integer> idColumn;
    @FXML
    private TableColumn<WorkTable, String> dateColumn;

    @FXML
    private TableColumn<WorkTable, String> FIOPacient;

    @FXML
    private TableColumn<WorkTable, String> petName;

    @FXML
    private TableColumn<WorkTable, String> petBreed;

    @FXML
    private TableColumn<WorkTable, String> petGender;

    @FXML
    private TableColumn<WorkTable, String> FIODoctor;

    @FXML
    private TableColumn<WorkTable, String> employeeDoctor;

    @FXML
    private Button writeButton;

    private ObservableList<WorkTable> wTable;
    private DataBaseHandler dataBaseHandler;

    /**
     * Основной метод программ JavaFX, выполняется всегда, когда запускается сцена этого контроллера
     */
    @FXML
    void initialize() {
        wTable = FXCollections.observableArrayList();
        dataBaseHandler = DataBaseHandler.getInstance();
        loadData();
        initializeColumns();


        writeButton.setOnAction(event -> {
            saveData();

        });

    }

    private void saveData() {
        int i = 0;
        try {
            for (i=0; i < wTable.size();i++){
                dataBaseHandler.updateData(wTable.get(i),wTable.get(i).getId());
            }
        }catch (Exception e){
            e.printStackTrace();
            System.out.print(i);
            System.out.println("Error occurred");


        }
        try {
            for (int x = i;x< wTable.size();x++){
                dataBaseHandler.insertData(wTable.get(x));
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error occurred");
        }
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

                ObservableList<WorkTable> row = FXCollections.observableArrayList();

                row.add(new WorkTable(resultSet.getInt(1),resultSet.getString(2), resultSet.getString(3), resultSet.getString(4),
                        resultSet.getString(5), resultSet.getString(6), resultSet.getString(7),
                        resultSet.getString(8)));
                wTable.add(row.get(i));
                i++;
                isMovedCursor = true;
            }
            if (isMovedCursor){
                workTable.setItems(wTable);
            }else {
                wTable.add(new WorkTable());
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

        setEditableColumns();


        workTable.setRowFactory(param -> {
            TableRow<WorkTable> row = new TableRow<>();
            row.setOnMouseClicked(event -> {
                if ((event.getClickCount() == 1)) {
                    //create a new Item and initialize it ...
                    if (!wTable.get(wTable.size() - 1).isNullFields()) {
                        workTable.getItems().add(new WorkTable());
                    }
                }
            });

            return row;
        });

    }

    /**
     * Этот метод используется для задания столбцов таблицы редактирования
     *
     * Здесь задается каждый столбец редактируемым отдельно
     */
    private void setEditableColumns() {
        idColumn.setCellFactory(TextFieldTableCell.forTableColumn(new IntegerStringConverter()));

        idColumn.setOnEditCommit(e -> {
            e.getTableView().getItems().get(e.getTablePosition().getRow()).setId(e.getNewValue());
        });

        dateColumn.setCellFactory(TextFieldTableCell.forTableColumn());

        dateColumn.setOnEditCommit(e -> {
            e.getTableView().getItems().get(e.getTablePosition().getRow()).setDate(e.getNewValue());
        });

        FIOPacient.setCellFactory(TextFieldTableCell.forTableColumn());

        FIOPacient.setOnEditCommit(e -> {
            e.getTableView().getItems().get(e.getTablePosition().getRow()).setFIOPacient(e.getNewValue());
        });

        petName.setCellFactory(TextFieldTableCell.forTableColumn());

        petName.setOnEditCommit(e -> {
            e.getTableView().getItems().get(e.getTablePosition().getRow()).setPetName(e.getNewValue());
        });

        petBreed.setCellFactory(TextFieldTableCell.forTableColumn());

        petBreed.setOnEditCommit(e -> {
            e.getTableView().getItems().get(e.getTablePosition().getRow()).setPetBreed(e.getNewValue());
        });

        petGender.setCellFactory(TextFieldTableCell.forTableColumn());

        petGender.setOnEditCommit(e -> {
            e.getTableView().getItems().get(e.getTablePosition().getRow()).setPetGender(e.getNewValue());
        });

        FIODoctor.setCellFactory(TextFieldTableCell.forTableColumn());

        FIODoctor.setOnEditCommit(e -> {
            e.getTableView().getItems().get(e.getTablePosition().getRow()).setFIODoctor(e.getNewValue());
        });

        employeeDoctor.setCellFactory(TextFieldTableCell.forTableColumn());

        employeeDoctor.setOnEditCommit(e -> {
            e.getTableView().getItems().get(e.getTablePosition().getRow()).setEmployeeDoctor(e.getNewValue());
        });


    }

}

