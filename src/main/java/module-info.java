module com.example.inai_bat {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;
    requires java.sql;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires net.synedra.validatorfx;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;

    opens com.example.inai_bat to javafx.fxml;
    exports com.example.inai_bat;
    exports com.example.inai_bat.controller;
    opens com.example.inai_bat.controller to javafx.fxml;
    exports com.example.inai_bat.controller.firstMap;
    opens com.example.inai_bat.controller.firstMap to javafx.fxml;
}