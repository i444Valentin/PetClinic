package com.application.DataBaseHandler;

import com.application.table_objects.WorkTable;

import static org.junit.jupiter.api.Assertions.*;

class DataBaseHandlerTest {

    @org.junit.jupiter.api.Test
    void initConnection() {
        DataBaseHandler dataBaseHandler = new DataBaseHandler();
        assertTrue(dataBaseHandler.initConnection());

    }

    @org.junit.jupiter.api.Test
    void getData() {

    }

    @org.junit.jupiter.api.Test
    void insertTestData() throws Exception{
        WorkTable workTable = new WorkTable(3,"2020-10-10","Иванов Иван Иванович", "Свячка", "Кошка", "мужской", "Алексеев Алексей Алексеевич","Ветеринар");
        DataBaseHandler dataBaseHandler =  DataBaseHandler.getInstance();
        dataBaseHandler.insertData(workTable);
    }
}