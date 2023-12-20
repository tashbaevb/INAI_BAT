package com.example.inai_bat.controller.firstMap;

import com.example.inai_bat.service.TextAnimator;
import com.example.inai_bat.service.TextOutput;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.stage.Stage;


import java.net.URL;
import java.util.ResourceBundle;

public class ThirdHomeController implements Initializable {

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

        textAnimator = new TextAnimator("Отто, медленно кивая, отвечает: \"Нет, детектив, в тот вечер было все так же тихо и спокойно, как обычно. Ничего не выходящего из обыденности я не запомнил. Кроме одной детали, вчера вечером Фрау Луиза очень долго стояла у двери у господина убитого.\"",
                0.2, textOutput);
        textAnimator2 = new TextAnimator("\"Леонид был талантливым художником, и я часто бывал у него в студии. У нас были приятные разговоры о прошлом деревни. Он был мистическим, как и его картины, но никаких конфликтов между нами не возникало. Всегда казалось, что мы понимаем друг друга.\"",
                0.2, textOutput);
        textAnimator3 = new TextAnimator("Отто, думая, отвечает: \"С Эммой мы хорошие знакомые. Я часто бываю в ее магазине, и она была для меня источником интересных антиквариатов и занимательных рассказов. Мы никогда не имели разногласий, всегда общались дружелюбно.\"",
                0.2, textOutput);
        textAnimator4 = new TextAnimator("Отто улыбается: \"Луиза - молодой души человек. Ее энтузиазм за фотографию заразителен. Мы не очень близки, но иногда бываю в библиотеке, где она исследует свои творческие проекты. Она приносит свежий взгляд на нашу тихую деревню.\"",
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
        ButtonType goToNextSceneButton = new ButtonType("Go to Next Scene");
        Alert alert = new Alert(Alert.AlertType.NONE, "", goToNextSceneButton);
        alert.setHeaderText(null);
        alert.setTitle("Congratil");
        alert.setContentText("YOU WON");

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

