package com.application.Controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;

public class RegistrationController {

    @FXML
    private TextField firstnameTextBox;

    @FXML
    private TextField lastnameTextBox;

    @FXML
    private TextField patronimycTextBox;

    @FXML
    private TextField loginTextField;

    @FXML
    private PasswordField passTextBox;

    @FXML
    private PasswordField confirmPassTextBox;

    @FXML
    private TextField birthDatePickDate;

    @FXML
    private TextField polisTextBox;

    @FXML
    private TextField locationTextBox;

    @FXML
    private RadioButton femaleRadio;

    @FXML
    private ToggleGroup gender;

    @FXML
    private RadioButton maleRadio;

    @FXML
    private Button registerPacientButton;

    @FXML
    private Label registrationWarningLabel;

    @FXML
    void registerUser(ActionEvent event) {

    }

}

