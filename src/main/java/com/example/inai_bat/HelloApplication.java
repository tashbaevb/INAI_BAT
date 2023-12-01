package com.example.inai_bat;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import javafx.scene.input.KeyCode;

public class HelloApplication extends Application {

    Image backgroundImage = new Image(getClass().getResourceAsStream("/player/map.png"));
    Image image = new Image(getClass().getResourceAsStream("/player/play.png"));
    Player player = new Player(20, 20, image);
    Pane pane;

    private void update() {
        player.move();
    }

    @Override
    public void start(Stage stage) throws Exception {
        BackgroundImage backgroundImage1 = new BackgroundImage(backgroundImage, BackgroundRepeat.REPEAT, BackgroundRepeat.REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);
        Background background = new Background(backgroundImage1);

        pane = new Pane();
        pane.setBackground(background);

        pane.getChildren().add(player);

        Scene scene = new Scene(pane, 650, 450);

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

    public static void main(String[] args) {
        launch(args);
    }

    class Player extends ImageView {
        boolean up, down, left, right;

        Player(int x, int y, Image image) {
            super(image);
            setTranslateX(x);
            setTranslateY(y);
        }

        void handleKeyPress(KeyCode code) {
            if (code == KeyCode.UP) up = true;
            else if (code == KeyCode.DOWN) down = true;
            else if (code == KeyCode.LEFT) left = true;
            else if (code == KeyCode.RIGHT) right = true;
        }

        void handleKeyRelease(KeyCode code) {
            if (code == KeyCode.UP) up = false;
            else if (code == KeyCode.DOWN) down = false;
            else if (code == KeyCode.LEFT) left = false;
            else if (code == KeyCode.RIGHT) right = false;
        }

        void move() {
            double dx = 0, dy = 0;

            if (up) dy -= 2;
            if (down) dy += 2;
            if (left) dx -= 2;
            if (right) dx += 2;

            double newX = getTranslateX() + dx;
            double newY = getTranslateY() + dy;

            if (newX >= 0 && newX <= backgroundImage.getWidth() - getFitWidth()) {
                setTranslateX(newX);
            }
            if (newY >= 0 && newY <= backgroundImage.getHeight() - getFitHeight()) {
                setTranslateY(newY);
            }

            BackgroundPosition bgPos = pane.getBackground().getImages().get(0).getPosition();
            pane.setBackground(new Background(new BackgroundImage(backgroundImage, BackgroundRepeat.NO_REPEAT,
                    BackgroundRepeat.NO_REPEAT, new BackgroundPosition(bgPos.getHorizontalSide(),
                    bgPos.getHorizontalPosition() - dx, false, bgPos.getVerticalSide(),
                    bgPos.getVerticalPosition() - dy, false), BackgroundSize.DEFAULT)));
        }


    }
}

