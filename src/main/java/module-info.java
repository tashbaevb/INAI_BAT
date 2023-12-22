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
    requires javafx.media;

    opens com.example.inai_bat to javafx.fxml;
    opens com.example.inai_bat.kgController.firstMap;
    opens com.example.inai_bat.kgController.pauseMenu;
    opens com.example.inai_bat.kgController.secondMap;
    exports com.example.inai_bat;
    exports com.example.inai_bat.controller;
    exports com.example.inai_bat.kgController.firstMap;
    opens com.example.inai_bat.controller to javafx.fxml;
    exports com.example.inai_bat.controller.firstMap;
    opens com.example.inai_bat.controller.firstMap to javafx.fxml;
    exports com.example.inai_bat.controller.secondMap;
    opens com.example.inai_bat.controller.secondMap to javafx.fxml;
    exports com.example.inai_bat.controller.thirdMap;
    opens com.example.inai_bat.controller.thirdMap to javafx.fxml;
    exports com.example.inai_bat.controller.pauseMenu;
    opens com.example.inai_bat.controller.pauseMenu to javafx.fxml;
    exports com.example.inai_bat.kgController;
    opens com.example.inai_bat.kgController to javafx.fxml;
}

