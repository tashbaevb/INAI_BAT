package com.example.inai_bat;

import com.example.inai_bat.controller.GameController;
import javafx.application.Application;
import javafx.stage.Stage;

public class MainApplication extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        GameController gameController = new GameController(stage);
    }

    public static void main(String[] args) {
        launch(args);
    }
}

