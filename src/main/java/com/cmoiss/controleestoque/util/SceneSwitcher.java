package com.cmoiss.controleestoque.util;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;

public class SceneSwitcher {
    @FXML
    public static void switchScene(Stage stage, String fxmlPath) {
        URL path = SceneSwitcher.class.getResource(fxmlPath);
        Parent root;

        try {
            root = FXMLLoader.load(path);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        Scene scene = new Scene(root, 500, 500);
        stage.setScene(scene);
    }

    @FXML
    public static void switchScene(Stage stage, String fxmlPath, double width, double height) {
        URL path = SceneSwitcher.class.getResource(fxmlPath);
        Parent root;

        try {
            root = FXMLLoader.load(path);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        Scene scene = new Scene(root, width, height);
        stage.setScene(scene);
    }

    @FXML
    public static void switchScene(Stage stage, String fxmlPath, double width, double height, String stageTitle) {
        stage.setTitle(stageTitle);
        switchScene(stage, fxmlPath, width, height);
    }
}