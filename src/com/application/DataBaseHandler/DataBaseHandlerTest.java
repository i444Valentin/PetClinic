package com.application.DataBaseHandler;

import com.application.objects.User;

import java.sql.Date;

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
    void registerUser() throws Exception{
        User user = new User("Иванов","Иван","Иванович", Date.valueOf("2000-01-01"), 9545633469651231L,"г. Москва, ул.Садовая 11",true,"ivanov123","12345");
        DataBaseHandler dataBaseHandler = DataBaseHandler.getInstance();
        boolean res = dataBaseHandler.userRegister(user);
        assertTrue(res);
    }
}