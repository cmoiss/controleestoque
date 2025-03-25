package com.cmoiss.controleestoque;

import com.cmoiss.controleestoque.util.ServerH2Local;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("view/fxml/main-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 320, 240);
        stage.setTitle("Sistema de estoque");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        ServerH2Local.startServer();

        launch();
    }
}