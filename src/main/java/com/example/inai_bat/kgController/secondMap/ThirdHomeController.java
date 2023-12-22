package com.example.inai_bat.kgController.secondMap;

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

        textAnimator = new TextAnimator("Жок, мен ойлобойм, бирок ойлонуп көрсөң, киши өлтүрүлгөн күнү Карла суутектин кычкылы жыттанган, мен аны абдан жактырган жокмун, анын жүзү кыйрап калды, эгер мен аны ушундай сүрөттөй алам.",
                0.2, textOutput);
        textAnimator2 = new TextAnimator("Ал текебер кошуна болчу, дайыма орой боло турган кызыктай мүнөзү бар, мен аны адам катары эч качан жактырчу эмесмин, ошондуктан мен аны менен сүйлөшпөймүн.",
                0.2, textOutput);
        textAnimator3 = new TextAnimator("Бир тууганы менен тынымсыз урушкан, кыйналган аял. Ал ар дайым дүкөнүндө иштеп, кеңейтүүгө аракет кылып жүргөн, бирок агасы жолтоо болуп калган.",
                0.2, textOutput);
        textAnimator4 = new TextAnimator("Жеңил адам, аз да, көп да эмес, болгону почтаны жеткирип, Карла менен ойнош эле.",
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
        KgGameController2.startGame2();
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
        alert.setTitle("Уят");
        alert.setContentText("Туура эмес");

        alert.setOnCloseRequest(e -> {

            KgGameController2.startGame2();
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

