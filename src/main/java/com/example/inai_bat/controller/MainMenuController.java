package com.example.inai_bat.controller;

import com.example.inai_bat.controller.firstMap.GameController;
import com.example.inai_bat.controller.secondMap.GameController2;
import com.example.inai_bat.controller.thirdMap.GameController3;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.stage.Stage;

public class MainMenuController {

    @FXML
    private MenuButton menuButton;

    @FXML
    private Button exitButton;

    @FXML
    public void initialize() {
        MenuItem map1 = new MenuItem("Karte 1");
        map1.setOnAction(this::handlePlayButton);

        MenuItem map2 = new MenuItem("Karte 2");
        map2.setOnAction(this::handlePlayButton2);

        MenuItem map3 = new MenuItem("Karte 3");
        map3.setOnAction(this::handlePlayButton3);

        menuButton.getItems().addAll(map1, map2, map3);
    }

    @FXML
    private void handlePlayButton(ActionEvent event) {

        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/com/example/inai_bat/firstMap/introduction.fxml"));
            Parent parent = (Parent) fxmlLoader.load();
            Stage stage = new Stage();

            stage.setScene(new Scene(parent));
            stage.show();

            Stage currentStage = (Stage) menuButton.getScene().getWindow();
            currentStage.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void handlePlayButton2(ActionEvent event) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/com/example/inai_bat/secondMap/introduction2.fxml"));
            Parent parent = (Parent) fxmlLoader.load();
            Stage stage = new Stage();

            stage.setScene(new Scene(parent));
            stage.show();

            Stage currentStage = (Stage) menuButton.getScene().getWindow();
            currentStage.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void handlePlayButton3(ActionEvent event) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/com/example/inai_bat/thirdMap/introduction3.fxml"));
            Parent parent = (Parent) fxmlLoader.load();
            Stage stage = new Stage();

            stage.setScene(new Scene(parent));
            stage.show();

            Stage currentStage = (Stage) menuButton.getScene().getWindow();
            currentStage.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    @FXML
    private void handleExitButton(ActionEvent event) {
        Stage stage = (Stage) exitButton.getScene().getWindow();
        stage.close();
    }

    public void handleKGButton() {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/com/example/inai_bat/kgHome.fxml"));
            Parent parent = (Parent) fxmlLoader.load();
            Stage stage = new Stage();

            stage.setScene(new Scene(parent));
            stage.show();

            Stage currentStage = (Stage) menuButton.getScene().getWindow();
            currentStage.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
