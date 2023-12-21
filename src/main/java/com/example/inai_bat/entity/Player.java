package com.example.inai_bat.entity;

import javafx.fxml.FXMLLoader;
import javafx.geometry.Bounds;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;

public class Player extends ImageView {

    Image upStand, upLeft, upRight, downLeft, downRight, rightLeft, rightRight, leftRight, leftLeft, currentImage;

    boolean up, down, left, right;
    double maxX, maxY;

    private List<Bounds> houseBoundsList = new ArrayList<>();

    public Player(int x, int y, Image upStand, Image upLeft, Image upRight, Image downLeft, Image downRight,
                  Image rightLeft, Image rightRight, Image leftRight, Image leftLeft, double maxX, double maxY) {
        super(upStand);
        this.upStand = upStand;
        this.upLeft = upLeft;
        this.upRight = upRight;
        this.downLeft = downLeft;
        this.downRight = downRight;
        this.rightLeft = rightLeft;
        this.rightRight = rightRight;
        this.leftRight = leftRight;
        this.leftLeft = leftLeft;
        this.maxX = maxX;
        this.maxY = maxY;

        currentImage = upStand;

        houseBoundsList.add(new Rectangle(60, 367, 160, 85).getBoundsInLocal());
        houseBoundsList.add(new Rectangle(1190, 165, 130, 55).getBoundsInLocal());

        setTranslateX(x);
        setTranslateY(y);
        setFitWidth(30);
        setFitHeight(60);
    }

    public void handleKeyPress(KeyCode code) {
        if (code == KeyCode.UP) up = true;
        else if (code == KeyCode.DOWN) down = true;
        else if (code == KeyCode.LEFT) left = true;
        else if (code == KeyCode.RIGHT) right = true;
        else if (code == KeyCode.E) {
            if (getTranslateX() == 170 && getTranslateY() == 460) {
                openFirstHome();
            } else if (getTranslateX() == 1280 && getTranslateY() == 240) {
                openSecondHome();
            } else if (getTranslateX() == 1330 && getTranslateY() == 580) {
                openThirdHome();
            }
        } else if (code == KeyCode.R) {
            openFirstMenu();
        }
    }

    public void openFirstMenu() {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/com/example/inai_bat/menus/firstMenu.fxml"));
            Parent parent = (Parent) fxmlLoader.load();
            Stage stage = new Stage();

            stage.setScene(new Scene(parent));
            stage.show();

            ((Stage) getScene().getWindow()).close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public void handleKeyPress2(KeyCode code) {
        if (code == KeyCode.UP) up = true;
        else if (code == KeyCode.DOWN) down = true;
        else if (code == KeyCode.LEFT) left = true;
        else if (code == KeyCode.RIGHT) right = true;
        else if (code == KeyCode.E) {
            if (getTranslateX() == 350 && getTranslateY() == 300) {
                map2OpenFirstHome();
            } else if (getTranslateX() == 290 && getTranslateY() == 650) {
                map2OpenSecondHome();
            } else if (getTranslateX() == 790 && getTranslateY() == 260) {
                map2OpenThirdHome();
            }
        } else if (code == KeyCode.R) {
            openSecondMenu();
        }
    }


    public void openSecondMenu() {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/com/example/inai_bat/menus/secondMenu.fxml"));
            Parent parent = (Parent) fxmlLoader.load();
            Stage stage = new Stage();

            stage.setScene(new Scene(parent));
            stage.show();

            ((Stage) getScene().getWindow()).close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public void handleKeyPress3(KeyCode code) {
        if (code == KeyCode.UP) up = true;
        else if (code == KeyCode.DOWN) down = true;
        else if (code == KeyCode.LEFT) left = true;
        else if (code == KeyCode.RIGHT) right = true;
        else if (code == KeyCode.E) {
            if (getTranslateX() == 180 && getTranslateY() == 170) {
                map3OpenFirstHome();
            } else if (getTranslateX() == 660 && getTranslateY() == 550) {
                map3OpenSecondHome();
            } else if (getTranslateX() == 1270 && getTranslateY() == 200) {
                map3OpenThirdHome();
            }
        } else if (code == KeyCode.R) {
            openThirdMenu();
        }
    }


    public void openThirdMenu() {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/com/example/inai_bat/menus/thirdMenu.fxml"));
            Parent parent = (Parent) fxmlLoader.load();
            Stage stage = new Stage();

            stage.setScene(new Scene(parent));
            stage.show();

            ((Stage) getScene().getWindow()).close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void map3OpenFirstHome() {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/com/example/inai_bat/thirdMap/firstHome.fxml"));
            Parent parent = (Parent) fxmlLoader.load();
            Stage stage = new Stage();

            stage.setScene(new Scene(parent));
            stage.show();

            ((Stage) getScene().getWindow()).close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public void map3OpenSecondHome() {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/com/example/inai_bat/thirdMap/secondHome.fxml"));
            Parent parent = (Parent) fxmlLoader.load();
            Stage stage = new Stage();

            stage.setScene(new Scene(parent));
            stage.show();

            ((Stage) getScene().getWindow()).close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public void map3OpenThirdHome() {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/com/example/inai_bat/thirdMap/thirdHome.fxml"));
            Parent parent = (Parent) fxmlLoader.load();
            Stage stage = new Stage();

            stage.setScene(new Scene(parent));
            stage.show();

            ((Stage) getScene().getWindow()).close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public void map2OpenFirstHome() {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/com/example/inai_bat/secondMap/firstHome.fxml"));
            Parent parent = (Parent) fxmlLoader.load();
            Stage stage = new Stage();

            stage.setScene(new Scene(parent));
            stage.show();

            ((Stage) getScene().getWindow()).close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public void map2OpenSecondHome() {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/com/example/inai_bat/secondMap/secondHome.fxml"));
            Parent parent = (Parent) fxmlLoader.load();
            Stage stage = new Stage();

            stage.setScene(new Scene(parent));
            stage.show();

            ((Stage) getScene().getWindow()).close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public void map2OpenThirdHome() {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/com/example/inai_bat/secondMap/thirdHome.fxml"));
            Parent parent = (Parent) fxmlLoader.load();
            Stage stage = new Stage();

            stage.setScene(new Scene(parent));
            stage.show();

            ((Stage) getScene().getWindow()).close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public void openFirstHome() {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/com/example/inai_bat/firstMap/firstHome.fxml"));
            Parent parent = (Parent) fxmlLoader.load();
            Stage stage = new Stage();

            stage.setScene(new Scene(parent));
            stage.show();

            ((Stage) getScene().getWindow()).close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public void openSecondHome() {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/com/example/inai_bat/firstMap/secondHome.fxml"));
            Parent parent = (Parent) fxmlLoader.load();
            Stage stage = new Stage();

            stage.setScene(new Scene(parent));
            stage.show();

            ((Stage) getScene().getWindow()).close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public void openThirdHome() {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/com/example/inai_bat/firstMap/thirdHome.fxml"));
            Parent parent = (Parent) fxmlLoader.load();
            Stage stage = new Stage();

            stage.setScene(new Scene(parent));
            stage.show();

            ((Stage) getScene().getWindow()).close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public void handleKeyRelease(KeyCode code) {
        if (code == KeyCode.UP) up = false;
        else if (code == KeyCode.DOWN) down = false;
        else if (code == KeyCode.LEFT) left = false;
        else if (code == KeyCode.RIGHT) right = false;
    }

    public void printCoordinates() {
        System.out.println("X: " + getTranslateX() + ", Y: " + getTranslateY());
    }

    boolean step;
    int frameCount = 0;

    public void move() {
        double maxX = 1437;
        double maxY = 785;

        frameCount++;
        if (frameCount % 7 == 0) {
//            printCoordinates();

            if (up && getTranslateY() > 0 ) {
                setTranslateY(getTranslateY() - 10);
                setImage(step ? upLeft : upRight);
            } else if (down && getTranslateY() < maxY - 20) {
                setTranslateY(getTranslateY() + 10);
                setImage(step ? downLeft : downRight);
            } else if (left && getTranslateX() > 0) {
                setTranslateX(getTranslateX() - 10);
                setImage(step ? leftLeft : leftRight);
            } else if (right && getTranslateX() < maxX - 10 ) {
                setTranslateX(getTranslateX() + 10);
                setImage(step ? rightLeft : rightRight);
            }
            step = !step;
        }
    }

    private boolean checkCollision(double deltaX, double deltaY) {
        double newX = getTranslateX() + deltaX;
        double newY = getTranslateY() + deltaY;

        Bounds playerBounds = new Rectangle(newX, newY, 30, 60).getBoundsInParent();

        for (Bounds houseBounds : houseBoundsList) {
            if (playerBounds.intersects(houseBounds)) {
                return true;
            }
        }

        return false;
    }
}
