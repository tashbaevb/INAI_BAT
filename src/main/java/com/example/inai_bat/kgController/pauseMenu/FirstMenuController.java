package com.example.inai_bat.kgController.pauseMenu;

import com.example.inai_bat.config.MusicPlayer;
import com.example.inai_bat.kgController.firstMap.KgGameController;

public class FirstMenuController extends BaseMenuController {

    @Override
    protected void startGame() {
        KgGameController.startGame();
        MusicPlayer.playMap1Music();
    }
}
