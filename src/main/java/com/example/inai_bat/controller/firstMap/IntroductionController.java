package com.example.inai_bat.controller.firstMap;

import com.example.inai_bat.config.MusicPlayer;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class IntroductionController {
    @FXML
    private Button playButton;
    @FXML
    private void handlePlayButton(ActionEvent event) {
        GameController.startGame();
        closeCurrentWindow(event);
    }

    private void closeCurrentWindow(ActionEvent event) {
        Node source = (Node) event.getSource();
        Stage stage = (Stage) source.getScene().getWindow();
        stage.close();
    }

    @FXML
    public void initialize() {
        MusicPlayer.stopMusic();
        MusicPlayer.playMap1Music();
    }
}
