package com.example.inai_bat.controller.secondMap;

import com.example.inai_bat.service.TextAnimator;
import com.example.inai_bat.service.TextOutput;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class FirstHomeController implements Initializable {

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

        textAnimator = new TextAnimator("Ja natürlich. In letzter Zeit ist etwas Seltsames passiert. Ich bemerkte Schatten und hörte ungewöhnliche Geräusche in ruhigen Ecken des Dorfes. Aber ich dachte, das wären nur meine Fantasien und ich hätte zu hart gearbeitet, aber ich kann von morgens bis abends auf der Post sein, und genau das ist am Tag des Mordes passiert.",
                0.2, textOutput);
        textAnimator2 = new TextAnimator("(nachdenklich) Gerhard war ein freundlicher Mann. Wir trafen uns im Dorf und tauschten Neuigkeiten aus. Hat mir immer mit der Post geholfen, wenn etwas Besonderes passiert ist. Er war immer der Erste, der zu Hilfe kam, dieser Mann tut mir leid.",
                0.2, textOutput);
        textAnimator3 = new TextAnimator("Carla war schon immer eine fleißige und zuverlässige Frau. Wir stehen uns nicht allzu nahe, aber sie war immer gutherzig. Ich bezweifle, dass eine so reine Seele so etwas tun könnte. Obwohl... In letzter Zeit ist Carla zurückgezogener geworden und manchmal sieht man sie etwas Unverständliches murmeln.",
                0.2, textOutput);
        textAnimator4 = new TextAnimator("Emil... er war immer irgendwie still. Mann der Erde. Wir kommunizieren nicht viel. Er strahlt etwas Geheimnisvolles aus, aber ich war nicht besonders mit ihm befreundet, daher kann ich nichts Besonderes mitteilen.",
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

