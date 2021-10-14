package com.application.DataBaseHandler;

import com.application.objects.User;
import com.application.scenes.LoggerCreating;
import com.application.table_objects.ListDoctors;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.io.FileInputStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.LogManager;
import java.util.logging.Logger;


/**
 * Главный класс для взаимодействия с базой данных
 */
public class DataBaseHandler extends Configs {

    private static volatile DataBaseHandler instance;
    private static Logger logger;

    static {
        try (FileInputStream configFile = new FileInputStream("src\\com\\application\\logconfigs\\logger.config")) {
            LogManager.getLogManager().readConfiguration(configFile);
            logger = Logger.getLogger(LoggerCreating.class.getName());
        } catch (Exception ignore) {
            ignore.printStackTrace();
        }
    }

    /**
     * Создает единый экземпляр объекта DataBaseHandler
     * @return - экземпляр DataBaseHandler
     */
    public static DataBaseHandler getInstance() {
        DataBaseHandler localInstance = instance;
        if (localInstance == null) {
            synchronized (DataBaseHandler.class) {
                localInstance = instance;
                if (localInstance == null) {
                    instance = localInstance = new DataBaseHandler();
                }
            }
        }
        return localInstance;
    }

    /**
     * Метод для получения подключения к базе данных
     * @return - Connection
     * @throws ClassNotFoundException - выбрасывается, если не удается найти класс
     * @throws SQLException - выбрасывается, если произошло исключение при работе с базой данных
     */
    public Connection getDBConnection() throws ClassNotFoundException, SQLException {
        String connectionString = "jdbc:mysql://" + dbHost + ":" +
                dbPort + "/" + dbName + "?" + dbParameters;
//        Class.forName("com.mysql.jdbc.Driver");
        return DriverManager.getConnection(connectionString, dbUser, dbPass);
    }


    /**
     * Инитиализирует подключение к базе данных, создавая новое
     * подключение. Если подключение к базе данных успешно,
     * возвращается <code>true</code>, иначе <code>false</code>.
     *
     * @return true - подключение установлено, false - подключение не установлено.
     */
    public boolean initConnection() {
        try {
            getDBConnection();
            logger.log(Level.INFO,"Connected to MySQL DataBase");

            return true;

        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * Метод возвращающий загруженные данные из базы данных
     * @return - даннные из базы данных
     * @throws Exception - исключение, если не удается обработать запрос
     */
    public ResultSet getData() throws Exception{
        String sql= "SELECT * FROM `Услуги`";
        return getDBConnection().createStatement().executeQuery(sql);
    }

    public ResultSet getUser(User user){
        String sql = "SELECT login,password FROM Pacient WHERE login=? AND password=?";
        ResultSet resultSet = null;

        PreparedStatement preparedStatement;
        try {
            preparedStatement = getDBConnection().prepareStatement(sql);

            preparedStatement.setString(1, user.getLogin());
            preparedStatement.setString(2, user.getPassword());

            resultSet = preparedStatement.executeQuery();
            return  resultSet;
        }catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * Метод, обновляющий данные в базе данных
     *
     * @param id - ид строки для обновления
     * @param workTable - объект, который содержит поля и к ним можно получить доступ через метод get
     * @return - статус выполнения операции,
     *  <code>true<code/> - успех, <code>false</code> - неудача
     *
     * @throws Exception - исключение, если что-то поидет не так
     */

//    public boolean updateData(ListDoctors workTable, int id) throws Exception{
//        String sql = "UPDATE `Услуги` SET idУслуги=?, Дата=?, ФИОПациента=?, ИмяПитомца=?, ПородаПитомца=?,ПолПитомца=?, ФИОВетеринара=?, ДолжностьВетеринара=? WHERE idУслуги=?";
//
//
//        PreparedStatement preparedStatement = getDBConnection().prepareStatement(sql);
//
//        preparedStatement.setInt(1, workTable.getId());
//        preparedStatement.setString(2, workTable.getDate());
//        preparedStatement.setString(3, workTable.getFIOPacient());
//        preparedStatement.setString(4, workTable.getPetName());
//        preparedStatement.setString(5, workTable.getPetBreed());
//        preparedStatement.setString(6, workTable.getPetGender());
//        preparedStatement.setString(7, workTable.getFIODoctor());
//        preparedStatement.setString(8, workTable.getEmployeeDoctor());
//        preparedStatement.setInt(9,id);
//
//        preparedStatement.executeUpdate();
//
//
//        return true;
//    }

    /**
     * Метод, добавляющий новые данные в таблицу
     *
     * @param workTable - объект, который содержит поля и к ним можно получить доступ через метод get
     * @return - статус выполнения операции,
     * <code>true<code/> - успех, <code>false</code> - неудача
     * @throws Exception
     */
//    public boolean insertData(ListDoctors workTable) throws Exception{
//        String sql = "INSERT INTO `Услуги` (idУслуги, Дата, ФИОПациента, ИмяПитомца, ПородаПитомца, ПолПитомца, ФИОВетеринара, ДолжностьВетеринара) VALUES (?,?,?,?,?,?,?,?)";
//
//        PreparedStatement preparedStatement = getDBConnection().prepareStatement(sql);
//
//        preparedStatement.setInt(1, workTable.getId());
//        preparedStatement.setString(2, workTable.getDate());
//        preparedStatement.setString(3, workTable.getFIOPacient());
//        preparedStatement.setString(4, workTable.getPetName());
//        preparedStatement.setString(5, workTable.getPetBreed());
//        preparedStatement.setString(6, workTable.getPetGender());
//        preparedStatement.setString(7, workTable.getFIODoctor());
//        preparedStatement.setString(8, workTable.getEmployeeDoctor());
//
//        preparedStatement.executeUpdate();
//        return true;
//    }

    public boolean userRegister(User user) {
        try{
            String sql= "INSERT INTO pacient VALUE(?,?,?,?,?,?,?,?,?,?)";
            PreparedStatement preparedStatement = getDBConnection().prepareStatement(sql);

            preparedStatement.setNull(1,0);
            preparedStatement.setString(2, user.getFirstname());
            preparedStatement.setString(3, user.getLastname());
            preparedStatement.setString(4, user.getPatronymic());
            preparedStatement.setDate(5, (Date) user.getBirthdate());
            preparedStatement.setBoolean(6, user.getGender());
            preparedStatement.setString(7, user.getResidence());
            preparedStatement.setLong(8, user.getPolis());
            preparedStatement.setString(9, user.getLogin());
            preparedStatement.setString(10, user.getPassword());

            preparedStatement.executeUpdate();
            logger.log(Level.WARNING,"Пользователь " + user.getLogin() + " добавлен в базу данных");

            return true;
        }catch (Exception e){
            StringWriter sw = new StringWriter();
            PrintWriter pw = new PrintWriter(sw);
            e.printStackTrace(pw);
            logger.log(Level.WARNING,"Не удалось выполнить операцию: регистрация нового пользователя. Стек: \n" + sw.toString());
            return false;
        }

    }

    public ObservableList<ListDoctors> getDoctors(){
        String sql = "SELECT concat(firstname,' ',lastname,' ',patronymic) AS doctor,specilization FROM doctor";
        try {
            PreparedStatement preparedStatement = getDBConnection().prepareStatement(sql);
            ResultSet rs = preparedStatement.executeQuery();
            ObservableList<ListDoctors> list= FXCollections.observableArrayList();
            while (rs.next()){
                ListDoctors listDoctors = new ListDoctors();
                listDoctors.setDoctor(rs.getString("doctor"));
                listDoctors.setSpecilization(rs.getString("specilization"));
                list.add(listDoctors);
            }
            return list;
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }
}
