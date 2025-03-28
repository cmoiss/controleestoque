package com.cmoiss.controleestoque.control;

import com.cmoiss.controleestoque.util.FxmlPaths;
import com.cmoiss.controleestoque.util.SceneSwitcher;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;

public class CategoriasController {

    @FXML
    private ListView<String> categoryListView;

    @FXML
    private ObservableList<String> categories;

    @FXML
    public void initialize() {
        categories = FXCollections.observableArrayList("Categoria 1", "Categoria 2", "Categoria 3");
        categoryListView.setItems(categories);
    }

    @FXML
    private void buttonAdicionar() {
        SceneSwitcher.addPopUp(FxmlPaths.ADICIONAR_CATEGORIAS, 300, 200);
    }

    public void addCategory(String category) {
        categories.add(category);
    }

    public void removeCategory(String category) {
        categories.remove(category);
    }
}