package com.example.inai_bat.kgController.firstMap;

import com.example.inai_bat.config.MusicPlayer;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.stage.Stage;

public class IntroductionController {

    @FXML
    private void handlePlayButton(ActionEvent event) {
        KgGameController.startGame();
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
