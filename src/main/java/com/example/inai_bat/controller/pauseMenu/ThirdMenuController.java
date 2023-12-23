package com.example.inai_bat.controller.pauseMenu;

import com.example.inai_bat.config.MusicPlayer;
import com.example.inai_bat.controller.thirdMap.GameController3;

public class ThirdMenuController extends BaseMenuController {

    @Override
    protected void startGame() {
        GameController3.startGame3();
        MusicPlayer.playMap3Music();
    }
}
