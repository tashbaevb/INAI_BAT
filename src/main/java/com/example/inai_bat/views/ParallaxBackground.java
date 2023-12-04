package com.example.inai_bat.views;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

public class ParallaxBackground extends Pane {

    ImageView background;
    ImageView player;

    public ParallaxBackground(Image backgroundImage, ImageView player) {
        this.background = new ImageView(backgroundImage);
        this.player = player;
        background.setFitWidth(1920);
        background.setFitHeight(1080);

        getChildren().addAll(background, player);
    }

    public void update() {
        background.setTranslateX(player.getTranslateX() * -4);
        background.setTranslateY(player.getTranslateY() * -11);
    }
}
