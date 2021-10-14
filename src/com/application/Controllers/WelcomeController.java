package com.application.Controllers;

import com.application.DataBaseHandler.DataBaseHandler;
import com.application.objects.User;
import com.application.LoggerCreating;
import com.application.scenes.SceneLoader;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.io.FileInputStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.LogManager;
import java.util.logging.Logger;

public class WelcomeController {


    @FXML
    private Button loginButton;

    @FXML
    private TextField loginTextBox;

    @FXML
    private PasswordField passTextBox;

    @FXML
    private Hyperlink registerLink;

    @FXML
    private Label loginWarningLabel;

    private static Logger logger;

    static {
        try (FileInputStream configFile = new FileInputStream("src\\com\\application\\logconfigs\\logger.config")) {
            LogManager.getLogManager().readConfiguration(configFile);
            logger = Logger.getLogger(LoggerCreating.class.getName());
        } catch (Exception ignore) {
            ignore.printStackTrace();
        }
    }

    @FXML
    void loginButtonClick(ActionEvent event) {

    }

    private void loginUser(String loginText, String passwordText) {
        try {
            DataBaseHandler dataBaseHandler = DataBaseHandler.getInstance();
            User user = new User();
            user.setLogin(loginText);
            user.setPassword(passwordText);
            ResultSet resultSet = dataBaseHandler.getUser(user);

            int counter = 0;

            while (true) {
                try {
                    if (!resultSet.next()) break;
                } catch (SQLException e) {
                    StringWriter sw = new StringWriter();
                    PrintWriter pw = new PrintWriter(sw);
                    e.printStackTrace(pw);
                    logger.log(Level.WARNING, sw.toString());
                }

            }
            counter++;


            if (counter >= 1) {
                loginWarningLabel.setVisible(false);
                loginButton.getScene().getWindow().hide();
                PacientWorkspaceController.sendUser(loginText, passwordText);
                SceneLoader.load("pacient_workspace.fxml", false);

            } else {
                loginWarningLabel.setVisible(true);
                logger.log(Level.INFO, "Вход не удался. Введенный логин: " + user.getLogin());
            }
        } catch (NullPointerException e) {

        }


    }

    @FXML
    void registerButtonClick(ActionEvent event) {
        SceneLoader.load("registration.fxml", true);


    }
}

