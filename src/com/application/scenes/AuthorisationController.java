package com.application.scenes;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;

public class AuthorisationController {

    @FXML
    private RadioButton asPacientToggleButton;

    @FXML
    private ToggleGroup singInAs;

    @FXML
    private RadioButton asDoctorToggleButton;

    @FXML
    private RadioButton asAdminToggleButton;

    @FXML
    private Button loginButton;

    @FXML
    private TextField loginTextBox;

    @FXML
    private PasswordField passTextBox;

    @FXML
    private Button registerButton;

    @FXML
    void loginButtonClick(ActionEvent event) {



    }

    @FXML
    void registerButtonClick(ActionEvent event) {
        SceneLoader.load("registration.fxml",true);



    }

}

