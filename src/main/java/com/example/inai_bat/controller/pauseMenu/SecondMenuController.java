package com.example.inai_bat.controller.pauseMenu;

import com.example.inai_bat.config.MusicPlayer;
import com.example.inai_bat.controller.secondMap.GameController2;
import javafx.fxml.FXML;

public class SecondMenuController extends BaseMenuController {

    @Override
    protected void startGame() {
        GameController2.startGame2();
        MusicPlayer.playMap2Music();
    }
}
