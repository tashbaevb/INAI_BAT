package com.example.inai_bat.controller.firstMap;

import com.example.inai_bat.controller.GameController;
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

        textAnimator = new TextAnimator("Эмма, всматриваясь в глаза детектива, отвечает: \"Нет, этот вечер был как и любой другой. В деревне всегда так тихо, особенно после закрытия магазинов. Я не заметила ничего необычного. Хотя, подождите, за день до этого Луиза Штайн приобрела Гладиус солдата IV Галльского легиона\"",
                0.2, textOutput);
        textAnimator2 = new TextAnimator("Эмма медленно кивает, словно она перебирает в памяти множество деталей: \"Леонид был талантливым художником. Мы общались, конечно, особенно когда ему нужны были антикварные предметы для его работ. Он был постоянным клиентом моего магазина. Но никаких конфликтов или разногласий между нами не было. Я уважала его творческий взгляд, как и он, вероятно, уважал мою коллекцию.\"",
                0.2, textOutput);
        textAnimator3 = new TextAnimator("Эмма, снова медленно обдумывая вопрос, отвечает: \"Луиза - молодая девушка, и я уважаю ее страсть к фотографии. Нам не часто приходилось пересекаться, но она бывала в моем магазине, и мы иногда обменивались несколькими словами. Ничего необычного в ее поведении или отношениях со мной я не замечала.\"",
                0.2, textOutput);
        textAnimator4 = new TextAnimator("Эмма, с тенью размышлений в глазах, отвечает: \"Отто всегда был добрым соседом. Мы действительно общались, делясь воспоминаниями о прошлом, и он иногда заглядывал ко мне в магазин. Но я не могу представить себе, чтобы он мог совершить что-то подобное. Он всегда казался таким мирным и дружелюбным.\"",
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

