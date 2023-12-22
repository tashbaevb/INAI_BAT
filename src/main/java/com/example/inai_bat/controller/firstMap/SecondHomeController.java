package com.example.inai_bat.controller.firstMap;

import com.example.inai_bat.controller.secondMap.GameController2;
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
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class SecondHomeController implements Initializable {

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

        textAnimator = new TextAnimator("„An diesem Abend verbrachte ich tatsächlich Zeit im Wald und versuchte, die Schönheit des Sonnenuntergangs einzufangen. Es war mein Versuch, den Moment einzufangen, in dem die Sterne am Himmel zu erwachen beginnen. Aber leider war meine Aufmerksamkeit völlig in die Arbeit vertieft , und ich habe in der Umgebung nichts Ungewöhnliches oder Verdächtiges bemerkt.“",
                0.2, textOutput);
        textAnimator2 = new TextAnimator("„Was Herrn Krause betrifft, wir haben nicht viel miteinander gesprochen, aber jedes Treffen mit ihm war angenehm. Er war ein talentierter Künstler, dessen Bilder einen zum Nachdenken anregten. Ich kann aber nicht sagen, dass ich ihn persönlich gekannt habe.“",
                0.2, textOutput);
        textAnimator3 = new TextAnimator("„Emma Schneider ist natürlich eine talentierte Handwerkerin, aber unsere Interessen sind unterschiedlich. Ich gehe nicht oft in Antiquitätengeschäfte, obwohl ich schon ein paar Mal in ihrem Geschäft war. Uns hat es nichts Unangenehmes gegeben.“ Momente.“",
                0.2, textOutput);
        textAnimator4 = new TextAnimator("„Mit Herrn Schmidt verbindet mich aber noch etwas mehr. Ich gehe oft in die Bibliothek, wo er interessante Geschichten über die Vergangenheit des Dorfes erzählt. Er ist ein gebildeter Mann, und seine Geschichten bringen immer etwas Neues.“",
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
        ButtonType goToNextSceneButton = new ButtonType("Weiter zur nächsten Szene");
        Alert alert = new Alert(Alert.AlertType.NONE, "", goToNextSceneButton);
        alert.setHeaderText(null);
        alert.setTitle("Glückwunsch");
        alert.setContentText("SIE HABEN GEWONNEN");

        alert.setOnCloseRequest(e -> {
            try {
                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/com/example/inai_bat/secondMap/introduction2.fxml"));
                Parent parent = fxmlLoader.load();
                Stage stage = new Stage();

                stage.setScene(new Scene(parent));
                stage.show();

                Stage currentStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                currentStage.close();
            } catch (IOException exception) {
                exception.printStackTrace();
            }
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

