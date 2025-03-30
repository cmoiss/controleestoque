package com.cmoiss.controleestoque.control;

import com.cmoiss.controleestoque.util.FxmlPaths;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import static com.cmoiss.controleestoque.util.FxmlPaths.MAIN_VIEW;
import static com.cmoiss.controleestoque.util.SceneSwitcher.*;
import static javafx.scene.control.Alert.AlertType.CONFIRMATION;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class ProdutosController {
    @FXML
    public ListView productsListView;

    @FXML
    ObservableList<String> products;

    @FXML
    public Button buttonRegister;

    @FXML
    public Button buttonDelete;

    @FXML
    private ToggleGroup volumeToggleGroup;

    @FXML
    private ToggleGroup unitsPerPackToggleGroup;

    @FXML
    private ToggleButton radioButton1;

    @FXML
    private ToggleButton radioButton2;

    @FXML
    private ToggleButton radioButton3;

    @FXML
    public ToggleButton buttonUnitPerPack1;

    @FXML
    public ToggleButton buttonUnitPerPack2;

    @FXML
    public ToggleButton buttonUnitPerPack3;


    @FXML
    private void unifyButtonGroups() {
        volumeToggleGroup = new ToggleGroup();
        radioButton1.setToggleGroup(volumeToggleGroup);
        radioButton2.setToggleGroup(volumeToggleGroup);
        radioButton3.setToggleGroup(volumeToggleGroup);

        unitsPerPackToggleGroup = new ToggleGroup();
        buttonUnitPerPack1.setToggleGroup(unitsPerPackToggleGroup);
        buttonUnitPerPack2.setToggleGroup(unitsPerPackToggleGroup);
        buttonUnitPerPack3.setToggleGroup(unitsPerPackToggleGroup);
    }

    public void initialize() {
        unifyButtonGroups();
        
        products = FXCollections.observableArrayList("Produto 1", "Produto 2", "Produto 3");
        productsListView.setItems(products);
    }


    @FXML
    private void handleDeleteButtonAction() {
        Alert confirmDialog = new Alert(CONFIRMATION);
        confirmDialog.setTitle("Confirmação");
        confirmDialog.setHeaderText("Deseja realmente excluir?");
        confirmDialog.setContentText("Esta ação não pode ser desfeita.");
        confirmDialog.showAndWait();
    }

    @FXML
    public void handleVoltarButtonAction(ActionEvent event) {
        switchScene(getCurrentStage(event), MAIN_VIEW.getPath());
    }

    @FXML
    public void handleRegisterButtonAction(ActionEvent event) {
        System.out.println("Cadastrado");
        addPopUp(FxmlPaths.CADASTRAR_PRODUTOS.getPath());
    }
}
