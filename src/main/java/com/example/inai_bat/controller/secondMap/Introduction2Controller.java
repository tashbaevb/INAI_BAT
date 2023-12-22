package com.example.inai_bat.controller.secondMap;

import com.example.inai_bat.config.MusicPlayer;
import com.example.inai_bat.controller.firstMap.GameController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class Introduction2Controller {

    @FXML
    private Button playButton;

    @FXML
    private void handlePlayButton(ActionEvent event) {
        GameController2.startGame2();
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
        MusicPlayer.playMap2Music();
    }
}
