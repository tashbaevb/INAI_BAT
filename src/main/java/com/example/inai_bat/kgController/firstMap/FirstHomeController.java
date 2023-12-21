package com.example.inai_bat.kgController.firstMap;

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

        textAnimator = new TextAnimator("Эмма детективдин көзүн карап, мындай деп жооп берет: \"Жок, бул кеч дагы башкалардай болду. Айыл дайыма тынч, айрыкча дүкөндөр жабылгандан кийин. Мен адаттан тыш эч нерсе байкаган жокмун. Бирок, күтө тур, күн мурун Луиза Стейн Гладиус аскери IV Галлик легионуна ээ болгон\"",
                0.2, textOutput);
        textAnimator2 = new TextAnimator("Эмма эсинде көп майда-чүйдөсүнө чейин айтып жаткандай жай башын ийкейт: \"Леонид таланттуу сүрөтчү болгон. Биз, албетте, анын чыгармалары үчүн антиквариат буюмдар керек болгондо байланышып турчубуз. Ал менин дүкөнүмдүн туруктуу кардары болчу. Бирок ошол жерде Ортобузда эч кандай чыр-чатактар \u200B\u200Bже пикир келишпестиктер болгон жок \"Мен анын чыгармачыл көз карашын сыйлачумун, ал менин коллекциямды сыйлагандай эле.\"",
                0.2, textOutput);
        textAnimator3 = new TextAnimator("Эмма акырын суроонун үстүнөн ойлонуп, мындай деп жооп берет: \"Луиза жаш кыз жана мен анын сүрөткө болгон ынтасын сыйлайм. Биз көп жолукчу эмеспиз, бирок ал менин дүкөнүмдө болчу, кээде бир нече сөздү алмаштырчубуз. Адаттагыдай эч нерсе жок. анын жүрүм-турумунда же мамилесинде.\" Мен өзүм менен байкаган жокмун.\"",
                0.2, textOutput);
        textAnimator4 = new TextAnimator("Эмма, анын көзүнө ой жүгүртүп, мындай деп жооп берет: \"Отто ар дайым жакшы кошуна болгон. Биз баарлашып, өткөндү эскерчүбүз, ал кээде менин дүкөнүмдүн жанына токтоп калчу. Бирок мен анын мындай кылып жатканын элестете албайм. ушуга окшош.\" \"Ал ар дайым тынч жана ынтымактуу көрүнчү.\"",
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
        KgGameController.startGame();
        closeCurrentWindow(event);
    }

    private void closeCurrentWindow(ActionEvent event) {
        Node source = (Node) event.getSource();
        Stage stage = (Stage) source.getScene().getWindow();
        stage.close();
    }


    @FXML
    void handleOnButton(ActionEvent event) {
        ButtonType repeatAgain = new ButtonType("Дагы бир жолу");
        Alert alert = new Alert(Alert.AlertType.NONE, "", repeatAgain);
        alert.setHeaderText(null);
        alert.setTitle("Мындай уят");
        alert.setContentText("Сиз утулдунуз");

        alert.setOnCloseRequest(e -> {

            KgGameController.startGame();
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