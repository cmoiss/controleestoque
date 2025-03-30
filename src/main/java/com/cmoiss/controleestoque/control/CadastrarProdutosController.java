package com.cmoiss.controleestoque.control;

import com.cmoiss.controleestoque.service.ProductService;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import static com.cmoiss.controleestoque.util.NumericFieldValidator.configureForCurrency;
import static com.cmoiss.controleestoque.util.NumericFieldValidator.configureForInteger;

public class CadastrarProdutosController {
    @FXML
    public TextField priceTextField;

    @FXML
    public TextField textFieldVolume;

    @FXML
    public TextField textFieldUnidadesPorPack;

    @FXML
    public TextField textFieldQuantidadeExterna;

    @FXML
    public TextField textFieldQuantidadeInterna;

    @FXML
    public ComboBox<String> unitComboBox;

    private void definirCamposNumericos() {
        configureForCurrency(priceTextField);
        configureForInteger(textFieldVolume);
        configureForInteger(textFieldUnidadesPorPack);
    }

    private void configureComboBoxListener() {
        unitComboBox.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue != null) {
                switch (newValue) {
                    case "mL":
                        textFieldVolume.setPromptText("ml");
                        break;
                    case "L":
                        textFieldVolume.setPromptText("L");
                        break;
                    default:
                        textFieldVolume.setPromptText("");
                        break;
                }
            }
        });
    }

    @FXML
    public void initialize() {
        definirCamposNumericos();
        configureComboBoxListener();
    }

    public void cadastrarProduto(ActionEvent event) {
        ProductService service = new ProductService();
    }

    @FXML
    public void buttonVoltar(ActionEvent event) {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.close();
    }
}
