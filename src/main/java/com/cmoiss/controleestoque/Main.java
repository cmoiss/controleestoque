package com.cmoiss.controleestoque;

import com.cmoiss.controleestoque.util.FxmlPaths;
import com.cmoiss.controleestoque.util.ServerH2Local;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

import static com.cmoiss.controleestoque.util.FxmlPaths.PRODUTOS;

public class Main extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        String path = PRODUTOS.getPath();

        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource(path));
        Scene scene = new Scene(fxmlLoader.load());

        stage.setTitle("Sistema de estoque");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        ServerH2Local.startServer("8082");

        launch();
    }
}