package com.example.inai_bat.controller.firstMap;

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

        textAnimator = new TextAnimator("Emma blickt dem Detektiv in die Augen und antwortet: „Nein, dieser Abend war wie jeder andere. Im Dorf ist es immer so ruhig, besonders nach Ladenschluss. Mir ist nichts Ungewöhnliches aufgefallen. Obwohl, warte, das Am Tag zuvor erwarb Louise Stein einen Gladius-Soldaten der IV. Gallischen Legion.",
                0.2, textOutput);
        textAnimator2 = new TextAnimator("Emma nickt langsam, als würde sie viele Details in ihrer Erinnerung durchgehen: „Leonid war ein talentierter Künstler. Wir haben natürlich kommuniziert, besonders als er antike Gegenstände für seine Werke brauchte. Er war Stammkunde meines Ladens. Aber da Es gab keine Konflikte oder Meinungsverschiedenheiten zwischen uns. „Ich habe seine kreative Vision respektiert, genauso wie er wahrscheinlich meine Sammlung respektiert hat.“",
                0.2, textOutput);
        textAnimator3 = new TextAnimator("Emma, \u200B\u200B\u200B\u200Bwieder langsam über die Frage nachdenkend, antwortet: „Louise ist ein junges Mädchen und ich respektiere ihre Leidenschaft für die Fotografie. Wir haben uns nicht oft getroffen, aber sie war in meinem Laden und wir haben manchmal ein paar Worte gewechselt. Nichts Ungewöhnliches.“ in ihrem Verhalten oder ihrer Einstellung. „Ich habe es bei mir nicht gemerkt.“",
                0.2, textOutput);
        textAnimator4 = new TextAnimator("Emma, \u200B\u200B\u200B\u200Bwieder langsam über die Frage nachdenkend, antwortet: „Louise ist ein junges Mädchen und ich respektiere ihre Leidenschaft für die Fotografie. Wir haben uns nicht oft getroffen, aber sie war in meinem Laden und wir haben manchmal ein paar Worte gewechselt. Nichts Ungewöhnliches.“ in ihrem Verhalten oder ihrer Einstellung. „Ich habe es bei mir nicht gemerkt.“",
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
        GameController.startGame();
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

            GameController.startGame();
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