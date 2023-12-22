package com.example.inai_bat.entity;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.stage.Stage;

public class KgPlayer extends Player {

    public KgPlayer(int x, int y, Image upStand, Image upLeft, Image upRight, Image downLeft, Image downRight,
                    Image rightLeft, Image rightRight, Image leftRight, Image leftLeft, double maxX, double maxY) {
        super(x, y, upStand, upLeft, upRight, downLeft, downRight, rightLeft, rightRight, leftRight, leftLeft, maxX, maxY);
    }

    @Override
    public void handleKeyPress(KeyCode code) {
        if (code == KeyCode.UP) up = true;
        else if (code == KeyCode.DOWN) down = true;
        else if (code == KeyCode.LEFT) left = true;
        else if (code == KeyCode.RIGHT) right = true;
        else if (code == KeyCode.E) {
            if (getTranslateX() == 170 && getTranslateY() == 460) {
                kgOpenFirstHome();
            } else if (getTranslateX() == 1280 && getTranslateY() == 240) {
                kgOpenSecondHome();
            } else if (getTranslateX() == 1330 && getTranslateY() == 580) {
                kgOpenThirdHome();
            }
        } else if (code == KeyCode.R) {
            kgOpenFirstMenu();
        }
    }

    @Override
    public void handleKeyPress2(KeyCode code) {
        if (code == KeyCode.UP) up = true;
        else if (code == KeyCode.DOWN) down = true;
        else if (code == KeyCode.LEFT) left = true;
        else if (code == KeyCode.RIGHT) right = true;
        else if (code == KeyCode.E) {
            if (getTranslateX() == 350 && getTranslateY() == 300) {
                kgMap2OpenFirstHome();
            } else if (getTranslateX() == 290 && getTranslateY() == 650) {
                kgMap2OpenSecondHome();
            } else if (getTranslateX() == 790 && getTranslateY() == 260) {
                kgMap2OpenThirdHome();
            }
        } else if (code == KeyCode.R) {
            kgOpenSecondMenu();
        }
    }


    private void open(String path) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(path));
            Parent parent = fxmlLoader.load();
            Stage stage = new Stage();

            stage.setScene(new Scene(parent));
            stage.show();

            ((Stage) getScene().getWindow()).close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void openMenu(int map) {
        open("/com/example/inai_bat/menus/kgMenu" + map + ".fxml");
    }

    public void openHome(int map, int home) {
        open("/com/example/inai_bat/map" + map + "/kg/kgHome" + home + ".fxml");
    }


    public void kgOpenFirstMenu() {
        openMenu(1);
    }

    public void kgOpenSecondMenu() {
        openMenu(2);
    }


    public void kgOpenFirstHome() {
        openHome(1, 1);
    }

    public void kgOpenSecondHome() {
        openHome(1, 2);
    }

    public void kgOpenThirdHome() {
        openHome(1, 3);
    }


    public void kgMap2OpenFirstHome() {
        openHome(2, 1);
    }

    public void kgMap2OpenSecondHome() {
        openHome(2, 2);
    }

    public void kgMap2OpenThirdHome() {
        openHome(2, 3);
    }
}
