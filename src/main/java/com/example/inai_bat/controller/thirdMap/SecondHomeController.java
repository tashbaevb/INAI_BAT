package com.example.inai_bat.controller.thirdMap;

import com.example.inai_bat.controller.firstMap.GameController;
import com.example.inai_bat.controller.thirdMap.GameController3;
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

public class SecondHomeController implements Initializable {

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

        textAnimator = new TextAnimator("Nein, ich habe nichts Ungewöhnliches gesehen. Ich kam nach der Arbeit nach Hause und ging in die Werkstatt, um mein Auto zu reparieren. Ich habe keine Geräusche oder Schreie aus dem Haus von Markus Becker gehört.",
                0.2, textOutput);
        textAnimator2 = new TextAnimator("Ich weiß, dass er mein Arbeitgeber war, und ich war bei verschiedenen Gelegenheiten für ihn auf Reisen. Ich weiß nicht, was er gemacht hat, und es interessiert mich auch nicht. Ich habe nur meine Arbeit gemacht und wurde dafür bezahlt.",
                0.2, textOutput);
        textAnimator3 = new TextAnimator("Ich kenne sie nicht persönlich, aber ich habe sie mehrmals gesehen, als sie sich dem Haus von Markus Becker mit einer Kamera und einem Mikrofon näherte. Ich glaube, sie war eine Journalistin, die versuchte, einen sensationellen Bericht über ihn zu machen.",
                0.2, textOutput);
        textAnimator4 = new TextAnimator("Ich kenne sie nicht persönlich, aber ich habe sie ein paar Mal gesehen, als sie mit einer Tasche und Papieren das Haus von Marcus Becker verließ. Ich glaube, sie war seine Sekretärin oder Buchhalterin. Ich weiß nicht, in welcher Beziehung sie zueinander standen, aber ich denke, sie könnte über seine Finanzen Bescheid gewusst haben.",
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
        GameController3.startGame3();
        closeCurrentWindow(event);
    }

    private void closeCurrentWindow(ActionEvent event) {
        Node source = (Node) event.getSource();
        Stage stage = (Stage) source.getScene().getWindow();
        stage.close();
    }


    @FXML
    void handleOnButton(ActionEvent event) {
        ButtonType goToNextSceneButton = new ButtonType("Noch ein Mal");
        Alert alert = new Alert(Alert.AlertType.NONE, "", goToNextSceneButton);
        alert.setHeaderText(null);
        alert.setTitle("So schade");
        alert.setContentText("Sie verloren");

        alert.setOnCloseRequest(e -> {

            GameController3.startGame3();
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

