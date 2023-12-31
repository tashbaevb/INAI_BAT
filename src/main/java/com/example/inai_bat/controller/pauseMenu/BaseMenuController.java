package com.example.inai_bat.controller.pauseMenu;

import com.example.inai_bat.MainApplication;
import com.example.inai_bat.config.MusicPlayer;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public abstract class BaseMenuController {

    protected abstract void startGame();

    @FXML
    void play(ActionEvent event) {
        startGame();
        closeCurrentWindow(event);
    }

    private void closeCurrentWindow(ActionEvent event) {
        Node source = (Node) event.getSource();
        Stage stage = (Stage) source.getScene().getWindow();
        stage.close();
    }

    @FXML
    private void exitToMenu(ActionEvent event) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(MainApplication.class.getResource("home.fxml"));
            Parent root = fxmlLoader.load();
            Scene scene = new Scene(root);
            Stage homeStage = new Stage();
            homeStage.setTitle("Home");
            homeStage.setScene(scene);
            homeStage.show();
            MusicPlayer.stopMusic();
            MusicPlayer.playDefaultMusic();

            Stage currentMenu = (Stage) ((Node) event.getSource()).getScene().getWindow();
            currentMenu.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

