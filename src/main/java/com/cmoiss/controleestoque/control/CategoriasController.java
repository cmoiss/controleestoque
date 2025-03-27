package com.cmoiss.controleestoque.control;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;

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

    public void addCategory(String category) {
        categories.add(category);
    }

    public void removeCategory(String category) {
        categories.remove(category);
    }
}