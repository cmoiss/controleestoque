package com.cmoiss.controleestoque.util;

public enum FxmlPaths {
    MAIN_VIEW("/com/cmoiss/controleestoque/view/fxml/main-view.fxml"),
    CATEGORIAS("/com/cmoiss/controleestoque/view/fxml/categorias.fxml"),
    ADICIONAR_CATEGORIAS("/com/cmoiss/controleestoque/view/fxml/adicionar-categoria.fxml");

    private final String path;

    FxmlPaths(String path) {
        this.path = path;
    }

    public String getPath() {
        return path;
    }
}