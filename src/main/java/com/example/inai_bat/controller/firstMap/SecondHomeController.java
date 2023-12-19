package com.example.inai_bat.controller.firstMap;

import com.example.inai_bat.controller.GameController;
import com.example.inai_bat.service.TextAnimator;
import com.example.inai_bat.service.TextOutput;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class SecondHomeController implements Initializable {

    TextAnimator textAnimator, textAnimator2, textAnimator3, textAnimator4;


    @FXML
    private Button button1, button2, button3, button4, exitButton;

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

        textAnimator = new TextAnimator("\"В тот вечер я, действительно, проводила время в лесу, пытаясь запечатлеть красоту заката. Это была моя попытка поймать в кадр момент, когда звезды начинают пробуждаться на небесах. Но, к сожалению, мое внимание было полностью поглощено работой, и я не заметила ничего необычного или подозрительного вокруг.\"",
                0.2, textOutput);
        textAnimator2 = new TextAnimator("\"Что касается господина Краузе, то мы не общались особо много, но каждая встреча с ним была приятной. Он был талантливым художником, чьи картины заставляли задуматься. Но я не могу сказать, что знала его личностно.\"",
                0.2, textOutput);
        textAnimator3 = new TextAnimator("\"Относительно Эммы Шнайдер, она, конечно, талантливая торговка, но наши интересы различны. Я не часто захожу в антикварные магазины, хотя в ее магазине я бывала пару раз. Никаких неприятных моментов у нас не было.\"",
                0.2, textOutput);
        textAnimator4 = new TextAnimator("\"А вот с господином Шмидтом у меня несколько больше общего. Я часто захожу в библиотеку, где он рассказывает интересные истории о прошлом деревни. Он образованный человек, и его рассказы всегда приносят что-то новое.\"",
                0.2, textOutput);

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
    void handleButtonClick1(ActionEvent event) {
        new Thread(textAnimator).start();
        button1.setDisable(true);
    }

    @FXML
    void handleButtonClick2(ActionEvent event) {
        new Thread(textAnimator2).start();
        button2.setDisable(true);
    }

    @FXML
    void handleButtonClick3(ActionEvent event) {
        new Thread(textAnimator3).start();
        button3.setDisable(true);
    }

    @FXML
    void handleButtonClick4(ActionEvent event) {
        new Thread(textAnimator4).start();
        button4.setDisable(true);
    }
}
