package com.application.scenes;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;

public class SceneLoader {
    public static void load(String window, boolean isModality){
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(SceneLoader.class.getResource(window));

        try {
            loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }

        Parent root = loader.getRoot();
        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.setResizable(false);
        if (isModality){
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.showAndWait();
        }else{
            stage.show();
        }


    }
}
