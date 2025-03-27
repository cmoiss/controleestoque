package com.cmoiss.controleestoque.util;

public enum FxmlPaths {
    MAIN_VIEW("view/fxml/main-view.fxml"),
    CATEGORIAS("view/fxml/categorias.fxml");

    private final String path;

    FxmlPaths(String path) {
        this.path = path;
    }

    public String getPath() {
        return path;
    }
}