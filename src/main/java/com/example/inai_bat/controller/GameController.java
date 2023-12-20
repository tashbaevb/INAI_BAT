package com.example.inai_bat.controller;

import com.example.inai_bat.entity.Player;
import com.example.inai_bat.views.ParallaxBackground;
import javafx.animation.AnimationTimer;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class GameController {
    private Player player;
    private ParallaxBackground parallaxBackground;
    private Stage stage;

    public GameController(Stage stage) {
        this.stage = stage;
        Image backgroundImage = new Image(getClass().getResourceAsStream("/player/map_winter.png"));
        Image upStand = new Image(getClass().getResourceAsStream("/player/static.png"));
        Image upLeft = new Image(getClass().getResourceAsStream("/player/up_left.png"));
        Image upRight = new Image(getClass().getResourceAsStream("/player/up_right.png"));
        Image downLeft = new Image(getClass().getResourceAsStream("/player/down_left.png"));
        Image downRight = new Image(getClass().getResourceAsStream("/player/down_right.png"));
        Image rightLeft = new Image(getClass().getResourceAsStream("/player/right_left.png"));
        Image rightRight = new Image(getClass().getResourceAsStream("/player/right_right.png"));
        Image leftLeft = new Image(getClass().getResourceAsStream("/player/left_left.png"));
        Image leftRight = new Image(getClass().getResourceAsStream("/player/left_right.png"));

        player = new Player(20, 20, upStand, upLeft, upRight, downLeft, downRight, rightLeft, rightRight, leftRight, leftLeft, 650, 450);
        parallaxBackground = new ParallaxBackground(backgroundImage, player);

        Pane pane = new Pane();
        pane.getChildren().add(parallaxBackground);

        Scene scene = new Scene(pane, 1437, 785);

        scene.setOnKeyPressed(e -> player.handleKeyPress(e.getCode()));
        scene.setOnKeyReleased(e -> player.handleKeyRelease(e.getCode()));

        stage.setScene(scene);
        stage.show();

        new AnimationTimer() {
            @Override
            public void handle(long now) {
                update();
            }
        }.start();
    }

    public static void startGame() {
        Stage gameStage = new Stage();
        GameController gameController = new GameController(gameStage);
    }

    private void update() {
        player.move();
//        parallaxBackground.update();
    }
}
