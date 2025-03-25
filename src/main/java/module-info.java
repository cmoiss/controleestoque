module com.cmoiss.controleestoque {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;
    requires jakarta.persistence;
    requires static lombok;
    requires com.h2database;

    exports com.cmoiss.controleestoque;
    exports com.cmoiss.controleestoque.model;
    exports com.cmoiss.controleestoque.control;
    exports com.cmoiss.controleestoque.dao;

    opens com.cmoiss.controleestoque to javafx.fxml;
    opens com.cmoiss.controleestoque.model;
    opens com.cmoiss.controleestoque.control to javafx.fxml;
}