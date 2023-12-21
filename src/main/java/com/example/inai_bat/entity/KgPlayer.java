package com.example.inai_bat.entity;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.stage.Stage;

public class KgPlayer extends Player{

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


    public void kgOpenFirstHome() {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/com/example/inai_bat/firstMap/kg/firstHome.fxml"));
            Parent parent = (Parent) fxmlLoader.load();
            Stage stage = new Stage();

            stage.setScene(new Scene(parent));
            stage.show();

            ((Stage) getScene().getWindow()).close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public void kgOpenSecondHome() {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/com/example/inai_bat/firstMap/kg/secondHome.fxml"));
            Parent parent = (Parent) fxmlLoader.load();
            Stage stage = new Stage();

            stage.setScene(new Scene(parent));
            stage.show();

            ((Stage) getScene().getWindow()).close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public void kgOpenThirdHome() {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/com/example/inai_bat/firstMap/kg/thirdHome.fxml"));
            Parent parent = (Parent) fxmlLoader.load();
            Stage stage = new Stage();

            stage.setScene(new Scene(parent));
            stage.show();

            ((Stage) getScene().getWindow()).close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void kgOpenFirstMenu() {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/com/example/inai_bat/menus/kgFirstMenu.fxml"));
            Parent parent = (Parent) fxmlLoader.load();
            Stage stage = new Stage();

            stage.setScene(new Scene(parent));
            stage.show();

            ((Stage) getScene().getWindow()).close();
        } catch (Exception e) {
            e.printStackTrace();
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


    public void kgMap2OpenFirstHome() {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/com/example/inai_bat/secondMap/kg/firstHome.fxml"));
            Parent parent = (Parent) fxmlLoader.load();
            Stage stage = new Stage();

            stage.setScene(new Scene(parent));
            stage.show();

            ((Stage) getScene().getWindow()).close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public void kgMap2OpenSecondHome() {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/com/example/inai_bat/secondMap/kg/secondHome.fxml"));
            Parent parent = (Parent) fxmlLoader.load();
            Stage stage = new Stage();

            stage.setScene(new Scene(parent));
            stage.show();

            ((Stage) getScene().getWindow()).close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public void kgMap2OpenThirdHome() {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/com/example/inai_bat/secondMap/kg/thirdHome.fxml"));
            Parent parent = (Parent) fxmlLoader.load();
            Stage stage = new Stage();

            stage.setScene(new Scene(parent));
            stage.show();

            ((Stage) getScene().getWindow()).close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public void kgOpenSecondMenu() {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/com/example/inai_bat/menus/kgSecondMenu.fxml"));
            Parent parent = (Parent) fxmlLoader.load();
            Stage stage = new Stage();

            stage.setScene(new Scene(parent));
            stage.show();

            ((Stage) getScene().getWindow()).close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }




}
