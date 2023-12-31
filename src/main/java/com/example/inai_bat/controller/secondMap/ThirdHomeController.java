package com.example.inai_bat.controller.secondMap;

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
        textAnimator = new TextAnimator("Nein, ich glaube nicht, aber wenn man darüber nachdenkt, hat Carla am Tag des Mordes nach Wasserstoffperoxid gerochen, das gefiel mir nicht besonders, und ihr Gesicht war am Boden zerstört, wenn man das so beschreiben kann.", 0.2, textOutput);
        textAnimator2 = new TextAnimator("Er war ein arroganter Nachbar mit der seltsamen Neigung, ständig unhöflich zu sein. Ich mochte ihn als Person nie und habe daher nicht wirklich mit ihm kommuniziert.", 0.2, textOutput);
        textAnimator3 = new TextAnimator("Eine besorgte Frau, die ständig mit ihrem Bruder stritt. Sie arbeitete ständig in ihrem Laden und versuchte zu expandieren, aber ihr Bruder kam ihr in die Quere.", 0.2, textOutput);
        textAnimator4 = new TextAnimator("Ein frivoler Mann, nicht mehr und nicht weniger, er hat nur Post zugestellt und mit Carla geflirtet.", 0.2, textOutput);
    }

    @Override
    protected void handleExitButton(ActionEvent event) {
        GameController2.startGame2();
        closeCurrentWindow(event);
    }

    @Override
    protected void handleOnButton(ActionEvent event) {
        showResultAlert("So schade", "Sie verloren", ButtonType.CLOSE,
                () -> {
                    GameController2.startGame2();
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

