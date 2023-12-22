package com.example.inai_bat.controller.pauseMenu;

import com.example.inai_bat.config.MusicPlayer;
import com.example.inai_bat.controller.firstMap.GameController;
import javafx.fxml.FXML;

public class FirstMenuController extends BaseMenuController {

    @Override
    protected void startGame() {
        GameController.startGame();
        MusicPlayer.playMap1Music();
    }
}
