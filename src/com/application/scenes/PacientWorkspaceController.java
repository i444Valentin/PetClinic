package com.application.scenes;

import com.application.DataBaseHandler.DataBaseHandler;
import com.application.table_objects.WorkTable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.util.converter.IntegerStringConverter;

import java.sql.ResultSet;

public class PacientWorkspaceController {
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

    }


}
