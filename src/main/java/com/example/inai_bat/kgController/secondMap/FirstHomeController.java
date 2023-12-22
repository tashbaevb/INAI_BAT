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

        textAnimator = new TextAnimator("Ооба албетте. Акыркы убакта бир кызыктай нерсе болуп жатат. Мен көлөкөлөрдү байкадым жана айылдын тынч бурчтарынан адаттан тыш үндөрдү уктум. Бирок мен бул жөн эле менин фантазиям деп ойлочумун, мен өтө көп иштедим, бирок эртең мененден кечке чейин почта бөлүмүндө боло алам, адам өлтүрүлгөн күнү так ушундай болду.",
                0.2, textOutput);
        textAnimator2 = new TextAnimator("(ойлуу) Герхард боорукер адам эле. Айылдан жолугуп, кабар алмаштык. Эгер өзгөчө бир нерсе болуп калса, мага почта менен жардам берчү. Ар дайым биринчилерден болуп жардамга келчү, бул кишиге боорум ооруйт.",
                0.2, textOutput);
        textAnimator3 = new TextAnimator("Карла дайыма эмгекчил жана ишенимдүү аял болгон. Биз өтө жакын эмеспиз, бирок ал ар дайым боорукер. Ушундай аруу жандын колунан ушундай иш келеринен күмөнүм бар. Болсо да... Акыркы кездери Карла ого бетер тїшїнїксїз болуп, кээде анын тїшїнїксїз бирдемелерди күбүрөп жатканын көрүүгө болот.",
                0.2, textOutput);
        textAnimator4 = new TextAnimator("Эмиль... эмнегедир унчукпай жүрчү. Жердин адамы. Биз көп сүйлөшпөйбүз. Ал сырдуу сезимди жаратат, бирок мен аны менен өзгөчө дос болгон эмесмин, ошондуктан өзгөчө эч нерсе бөлүшө албайм.",
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
        alert.setTitle("Мындай уят");
        alert.setContentText("Сиз утулдунуз");

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

