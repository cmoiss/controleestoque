package com.cmoiss.controleestoque.util;

import javafx.scene.control.TextField;

public final class NumericFieldValidator {
    
    // Construtor privado para evitar instanciação
    private NumericFieldValidator() {
        throw new AssertionError("Não é possível instanciar esta classe utilitária");
    }
    
    /**
     * Configura um TextField para aceitar apenas números inteiros
     * @param field Campo de texto a ser validado
     */
    public static void configureForInteger(TextField field) {
        field.textProperty().addListener((observable, oldValue, newValue) -> {
            if (!newValue.matches("\\d*")) {
                field.setText(oldValue);
            }
        });
    }
    
    /**
     * Configura um TextField para aceitar números decimais
     * @param field Campo de texto a ser validado
     * @param decimalPlaces Número de casas decimais permitidas
     */
    public static void configureForDecimal(TextField field, int decimalPlaces) {
        String decimalPattern = "\\d*(\\.\\d{0," + decimalPlaces + "})?";
        field.textProperty().addListener((observable, oldValue, newValue) -> {
            if (!newValue.matches(decimalPattern)) {
                field.setText(oldValue);
            }
        });
    }
    
    /**
     * Configura um TextField para aceitar valores monetários (2 casas decimais)
     * @param field Campo de texto a ser validado
     */
    public static void configureForCurrency(TextField field) {
        configureForDecimal(field, 2);
    }
}