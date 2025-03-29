package com.cmoiss.controleestoque.control;

import com.cmoiss.controleestoque.util.FxmlPaths;
import com.cmoiss.controleestoque.util.SceneSwitcher;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.stage.Stage;

import static com.cmoiss.controleestoque.util.FxmlPaths.MAIN_VIEW;
import static com.cmoiss.controleestoque.util.SceneSwitcher.*;
import static javafx.scene.control.Alert.AlertType.CONFIRMATION;

public class ProdutosController {
    @FXML
    public ListView productsListView;

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
    public void initialize() {
        volumeToggleGroup = new ToggleGroup();
        radioButton1.setToggleGroup(volumeToggleGroup);
        radioButton2.setToggleGroup(volumeToggleGroup);
        radioButton3.setToggleGroup(volumeToggleGroup);

        unitsPerPackToggleGroup = new ToggleGroup();
        buttonUnitPerPack1.setToggleGroup(unitsPerPackToggleGroup);
        buttonUnitPerPack2.setToggleGroup(unitsPerPackToggleGroup);
        buttonUnitPerPack3.setToggleGroup(unitsPerPackToggleGroup);
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
}
