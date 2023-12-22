package com.example.inai_bat.controller.secondMap;

import com.example.inai_bat.service.TextAnimator;
import com.example.inai_bat.service.TextOutput;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.stage.Stage;


import java.net.URL;
import java.util.ResourceBundle;

public class ThirdHomeController implements Initializable {

    TextAnimator textAnimator, textAnimator2, textAnimator3, textAnimator4;
    boolean isButtonClicked = false;
    boolean isButton1Clicked = false;
    boolean isButton2Clicked = false;
    boolean isButton3Clicked = false;
    boolean isButton4Clicked = false;

    @FXML
    private Button button1, button2, button3, button4, exitButton, onButton;

    @FXML
    private Label label;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        TextOutput textOutput = new TextOutput() {
            @Override
            public void writeText(String textOut) {
                Platform.runLater(() -> label.setText(textOut));
            }
        };

        textAnimator = new TextAnimator("Nein, ich glaube nicht, aber wenn man darüber nachdenkt, hat Carla am Tag des Mordes nach Wasserstoffperoxid gerochen, das gefiel mir nicht besonders, und ihr Gesicht war am Boden zerstört, wenn man das so beschreiben kann",
                0.2, textOutput);
        textAnimator2 = new TextAnimator("Er war ein arroganter Nachbar mit der seltsamen Neigung, ständig unhöflich zu sein. Ich mochte ihn als Person nie und habe daher nicht wirklich mit ihm kommuniziert",
                0.2, textOutput);
        textAnimator3 = new TextAnimator("Eine besorgte Frau, die ständig mit ihrem Bruder stritt. Sie arbeitete ständig in ihrem Laden und versuchte zu expandieren, aber ihr Bruder kam ihr in die Quere.",
                0.2, textOutput);
        textAnimator4 = new TextAnimator("Ein frivoler Mann, nicht mehr und nicht weniger, er hat nur Post zugestellt und mit Carla geflirtet.",
                0.2, textOutput);

    }

    void resetButtonState() {
        isButtonClicked = false;
        button1.setDisable(false);
        button2.setDisable(false);
        button3.setDisable(false);
        button4.setDisable(false);
    }

    @FXML
    void handleExitButton(ActionEvent event) {
        GameController2.startGame2();
        closeCurrentWindow(event);
    }

    private void closeCurrentWindow(ActionEvent event) {
        Node source = (Node) event.getSource();
        Stage stage = (Stage) source.getScene().getWindow();
        stage.close();
    }


    @FXML
    void handleOnButton(ActionEvent event) {
        ButtonType repeatAgain = new ButtonType("Noch ein Mal");
        Alert alert = new Alert(Alert.AlertType.NONE, "", repeatAgain);
        alert.setHeaderText(null);
        alert.setTitle("So schade");
        alert.setContentText("Sie verloren");

        alert.setOnCloseRequest(e -> {

            GameController2.startGame2();
            closeCurrentWindow(event);
        });

        alert.showAndWait();
    }


    @FXML
    void handleButtonClick1(ActionEvent event) {
        if (!isButtonClicked) {
            if (!isButton1Clicked) {
                new Thread(() -> {
                    textAnimator.run();
                    Platform.runLater(this::resetButtonState);
                }).start();
                isButton1Clicked = true;
                isButtonClicked = true;
            }
        }
    }

    @FXML
    void handleButtonClick2(ActionEvent event) {
        if (!isButtonClicked) {
            if (!isButton2Clicked) {
                new Thread(() -> {
                    textAnimator2.run();
                    Platform.runLater(this::resetButtonState);
                }).start();
                isButton2Clicked = true;
                isButtonClicked = true;
            }
        }
    }

    @FXML
    void handleButtonClick3(ActionEvent event) {
        if (!isButtonClicked) {
            if (!isButton3Clicked) {
                new Thread(() -> {
                    textAnimator3.run();
                    Platform.runLater(this::resetButtonState);
                }).start();
                isButton3Clicked = true;
                isButtonClicked = true;
            }
        }
    }

    @FXML
    void handleButtonClick4(ActionEvent event) {
        if (!isButtonClicked) {
            if (!isButton4Clicked) {
                new Thread(() -> {
                    textAnimator4.run();
                    Platform.runLater(this::resetButtonState);
                }).start();
                isButton4Clicked = true;
                isButtonClicked = true;
            }
        }
    }
}

