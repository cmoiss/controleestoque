package com.cmoiss.controleestoque.control;

import static com.cmoiss.controleestoque.util.FxmlPaths.PRODUTOS;
import static com.cmoiss.controleestoque.util.SceneSwitcher.getCurrentStage;
import static com.cmoiss.controleestoque.util.SceneSwitcher.switchScene;

import com.cmoiss.controleestoque.util.FxmlPaths;
import com.cmoiss.controleestoque.util.SceneSwitcher;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.stage.Stage;

public class MainController {
    @FXML
    protected void onProductButtonClick(ActionEvent event) {
        switchScene(getCurrentStage(event), PRODUTOS.getPath());
    }

    @FXML
    protected void onCategoryButtonClick(ActionEvent event) {
        Node currentNode = (Node) event.getSource();
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        SceneSwitcher.switchScene(stage, "/com/cmoiss/controleestoque/view/fxml/categorias.fxml");
    }
}