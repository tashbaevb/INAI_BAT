package com.example.inai_bat.kgController.secondMap;

import com.example.inai_bat.service.TextAnimator;
import com.example.inai_bat.service.TextOutput;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.ButtonType;

import java.net.URL;
import java.util.ResourceBundle;

public class ThirdHomeController extends BaseHomeController implements Initializable {

    private int askedQuestions = 0;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        TextOutput textOutput = textOut -> Platform.runLater(() -> label.setText(textOut));
        initializeTextAnimators(textOutput);
    }

    @Override
    protected void initializeTextAnimators(TextOutput textOutput) {
        textAnimator = new TextAnimator("Жок, мен ойлобойм, бирок ойлонуп көрсөң, киши өлтүрүлгөн күнү Карла суутектин кычкылы жыттанган, мен аны абдан жактырган жокмун, анын жүзү кыйрап калды, эгер мен аны ушундай сүрөттөй алам.", 0.2, textOutput);
        textAnimator2 = new TextAnimator("Ал текебер кошуна болчу, дайыма орой боло турган кызыктай мүнөзү бар, мен аны адам катары эч качан жактырчу эмесмин, ошондуктан мен аны менен сүйлөшпөймүн.", 0.2, textOutput);
        textAnimator3 = new TextAnimator("Бир тууганы менен тынымсыз урушкан, кыйналган аял. Ал ар дайым дүкөнүндө иштеп, кеңейтүүгө аракет кылып жүргөн, бирок агасы жолтоо болуп калган.", 0.2, textOutput);
        textAnimator4 = new TextAnimator("Жеңил адам, аз да, көп да эмес, болгону почтаны жеткирип, Карла менен ойнош эле.", 0.2, textOutput);
    }

    @Override
    protected void handleExitButton(ActionEvent event) {
        KgGameController2.startGame2();
        closeCurrentWindow(event);
    }

    @Override
    protected void handleOnButton(ActionEvent event) {
        showResultAlert("Кандай уят", "Сиз утулдунуз", ButtonType.CLOSE,
                () -> {
                    KgGameController2.startGame2();
                    closeCurrentWindow(event);
                });
    }

    @Override
    protected void handleButtonClick1(ActionEvent event) {
        handleButtonClick(1, textAnimator);
        askedQuestions++;
        toggleButtonVisibility();
    }

    @Override
    protected void handleButtonClick2(ActionEvent event) {
        handleButtonClick(2, textAnimator2);
        askedQuestions++;
        toggleButtonVisibility();
    }

    @Override
    protected void handleButtonClick3(ActionEvent event) {
        if (askedQuestions == 1) {
            handleButtonClick(3, textAnimator3);
            askedQuestions++;
        }
    }

    @Override
    protected void handleButtonClick4(ActionEvent event) {
        if (askedQuestions == 1) {
            handleButtonClick(4, textAnimator4);
            askedQuestions++;
        }
    }
}

