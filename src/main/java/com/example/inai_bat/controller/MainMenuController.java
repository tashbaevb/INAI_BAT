package com.example.inai_bat.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.stage.Stage;

import java.io.IOException;

public class MainMenuController {
    @FXML
    private MenuButton menuButton;

    @FXML
    private Button exitButton;

    @FXML
    public void initialize() {
        addMenuItem("Karte 1", "/com/example/inai_bat/map1/introduction.fxml");
        addMenuItem("Karte 2", "/com/example/inai_bat/map2/introduction2.fxml");
        addMenuItem("Karte 3", "/com/example/inai_bat/map3/introduction3.fxml");
    }

    private void addMenuItem(String text, String resource) {
        MenuItem menuItem = new MenuItem(text);
        menuItem.setOnAction(event -> handlePlayButton(resource));
        menuButton.getItems().add(menuItem);
    }

    private void handlePlayButton(String resource) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(resource));
            Parent parent = fxmlLoader.load();
            showStage(parent);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void handleExitButton(ActionEvent event) {
        Stage stage = (Stage) exitButton.getScene().getWindow();
        stage.close();
    }

    @FXML
    public void handleKGButton() {
        showStage("/com/example/inai_bat/kgHome.fxml");
    }

    private void showStage(String resource) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(resource));
            Parent parent = fxmlLoader.load();
            showStage(parent);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showStage(Parent parent) {
        Stage stage = new Stage();
        stage.setScene(new Scene(parent));
        stage.show();
        Stage currentStage = (Stage) menuButton.getScene().getWindow();
        currentStage.close();
    }
}
