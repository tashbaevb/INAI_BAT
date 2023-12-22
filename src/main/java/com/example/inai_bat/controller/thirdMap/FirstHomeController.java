package com.example.inai_bat.controller.thirdMap;

import com.example.inai_bat.controller.firstMap.GameController;
import com.example.inai_bat.controller.secondMap.GameController2;
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

public class FirstHomeController extends BaseHomeController implements Initializable {

    @FXML
    private Label label;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        TextOutput textOutput = textOut -> Platform.runLater(() -> label.setText(textOut));
        initializeTextAnimators(textOutput);
    }

    @Override
    protected void initializeTextAnimators(TextOutput textOutput) {
        textAnimator = new TextAnimator("Nein, ich habe nichts Ungewöhnliches gesehen. Ich verließ das Haus früh am Morgen und kam spät in der Nacht zurück. Ich wusste nicht, dass Marcus Becker etwas zugestoßen war, bis die Polizei eintraf.", 0.2, textOutput);
        textAnimator2 = new TextAnimator("Ich weiß, dass er ein grausamer und skrupelloser Mann war, der seine Arbeiter ausbeutete und das Gesetz manipulierte. Ich habe versucht, seine Verbrechen aufzuklären und ihn vor Gericht zu bringen.", 0.2, textOutput);
        textAnimator3 = new TextAnimator("Ich kenne ihn nicht persönlich, aber ich habe gehört, dass er für Marcus Becker als Fahrer gearbeitet hat. Ich denke, er könnte Zeuge oder Teilnehmer seiner skrupellosen Machenschaften gewesen sein.", 0.2, textOutput);
        textAnimator4 = new TextAnimator("Ich weiß, dass sie klug und gerissen ist, ich habe sie ein paar Mal im Haus von Marcus Becker gesehen. Ich glaube, sie war seine Geliebte.", 0.2, textOutput);

    }

    @Override
    protected void handleExitButton(ActionEvent event) {
        GameController3.startGame3();
        closeCurrentWindow(event);
    }

    @Override
    protected void handleOnButton(ActionEvent event) {
        showResultAlert("So schade", "Sie verloren", ButtonType.CLOSE,
                () -> {
                    GameController3.startGame3();
                    closeCurrentWindow(event);
                });
    }

    @Override
    protected void handleButtonClick1(ActionEvent event) {
        handleButtonClick(1, textAnimator);
    }

    @Override
    protected void handleButtonClick2(ActionEvent event) {
        handleButtonClick(2, textAnimator2);
    }

    @Override
    protected void handleButtonClick3(ActionEvent event) {
        handleButtonClick(3, textAnimator3);
    }

    @Override
    protected void handleButtonClick4(ActionEvent event) {
        handleButtonClick(4, textAnimator4);
    }

}

