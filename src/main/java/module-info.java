module com.cmoiss.controleestoque {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;
    requires jakarta.persistence;
    requires static lombok;

    exports com.cmoiss.controleestoque;
    exports com.cmoiss.controleestoque.control;

    opens com.cmoiss.controleestoque to javafx.fxml;
    exports com.cmoiss.controleestoque;
}