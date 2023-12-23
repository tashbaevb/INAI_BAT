package com.example.inai_bat.controller.thirdMap;

import com.example.inai_bat.config.MusicPlayer;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.stage.Stage;

public class Introduction3Controller {

    @FXML
    private void handlePlayButton(ActionEvent event) {
        GameController3.startGame3();
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
        MusicPlayer.playMap3Music();
    }
}
