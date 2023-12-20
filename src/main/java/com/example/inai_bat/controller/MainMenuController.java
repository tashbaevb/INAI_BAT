package com.example.inai_bat.controller;

import com.example.inai_bat.controller.firstMap.GameController;
import com.example.inai_bat.controller.secondMap.GameController2;
import com.example.inai_bat.controller.thirdMap.GameController3;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.stage.Stage;

public class MainMenuController {

    @FXML
    private MenuButton menuButton; // Предполагается, что это бургер-меню

    @FXML
    public void initialize() {
        MenuItem map1 = new MenuItem("Карта 1");
        map1.setOnAction(this::handlePlayButton);

        MenuItem map2 = new MenuItem("Карта 2");
        map2.setOnAction(this::handlePlayButton2);

        MenuItem map3 = new MenuItem("Карта 3");
        map3.setOnAction(this::handlePlayButton3);

        menuButton.getItems().addAll(map1, map2, map3);
    }

    @FXML
    private void handlePlayButton(ActionEvent event) {
        GameController.startGame();
        closeCurrentWindow(menuButton);
    }

    @FXML
    private void handlePlayButton2(ActionEvent event) {
        GameController2.startGame2();
        closeCurrentWindow(menuButton);
    }

    @FXML
    private void handlePlayButton3(ActionEvent event) {
        GameController3.startGame3();
        closeCurrentWindow(menuButton);
    }

    private void closeCurrentWindow(Node source) {
        Stage stage = (Stage) source.getScene().getWindow();
        stage.close();
    }
}
