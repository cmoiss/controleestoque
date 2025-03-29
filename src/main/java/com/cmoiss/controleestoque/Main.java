package com.cmoiss.controleestoque;

import com.cmoiss.controleestoque.util.ServerH2Local;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.application.Platform;

import java.io.IOException;

import static com.cmoiss.controleestoque.util.FxmlPaths.CATEGORIAS;
import static com.cmoiss.controleestoque.util.FxmlPaths.PRODUTOS;
import static com.cmoiss.controleestoque.util.SceneSwitcher.switchScene;

public class Main extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        String path = PRODUTOS.getPath();

        stage.setTitle("Sistema de estoque");

        switchScene(stage, path);

        stage.setOnCloseRequest(event -> {
            Platform.exit();
            System.exit(0);
        });
        stage.show();
    }

    public static void main(String[] args) {
        ServerH2Local.startServer("8082");

        launch();
    }
}