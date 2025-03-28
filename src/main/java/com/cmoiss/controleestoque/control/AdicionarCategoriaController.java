package com.cmoiss.controleestoque.control;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class AdicionarCategoriaController {

    @FXML
    private TextField categoryTextField;

    @FXML
    private void adicionarCategoria() {
        String category = categoryTextField.getText();
        // Adicione a lógica para adicionar a categoria aqui
        Stage stage = (Stage) categoryTextField.getScene().getWindow();
        stage.close();
    }
}