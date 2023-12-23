package com.example.inai_bat.kgController.pauseMenu;

import com.example.inai_bat.config.MusicPlayer;
import com.example.inai_bat.kgController.secondMap.KgGameController2;

public class SecondMenuController extends BaseMenuController {

    @Override
    protected void startGame() {
        KgGameController2.startGame2();
        MusicPlayer.playMap1Music();
    }
}
