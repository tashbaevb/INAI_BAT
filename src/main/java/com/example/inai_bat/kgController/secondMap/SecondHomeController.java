package com.example.inai_bat.kgController.secondMap;

import com.example.inai_bat.kgController.thirdMap.GameController3;
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

        textAnimator = new TextAnimator("Ммм, мен ойлойм, чындыгында жок, эгерде өлтүрүлгөндөн кийин бардык тургундардын маанайы начарлап, баары кайгылуу басып жүрүшөт",
                0.2, textOutput);
        textAnimator2 = new TextAnimator("Коп, ал менин жакшы коргон иним болчу, биз чогуу чонойдук, албетте мен аны башка жашоочуларга караганда жакшы билем, ооба, жакында эле чыр-чатактар \u200B\u200Bболуп жатты, бирок баары бир качандыр бир куну бутот деп ойлочумун, баарыбыз кичинебиз. баарынан чарчадым ж.б.",
                0.2, textOutput);
        textAnimator3 = new TextAnimator("Ал сени көргөндө аппак аппак жылмайып, колун булгалаган таттуу адам. Ал бул жердин эң жарык жашоочусу. Мен анын чымынды өлтүрө алаарына күмөнүм бар, бирок бул жерде адам.",
                0.2, textOutput);
        textAnimator4 = new TextAnimator("Ал сырдуу адам, эртеден кечке үйүнөн чыкпайт жана адамдар менен сейрек сүйлөшөт, мен ал жөнүндө түшүнүктүү бир нерсе айта алаарыма күмөнүм бар.",
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
        ButtonType goToNextSceneButton = new ButtonType("Кеттик");
        Alert alert = new Alert(Alert.AlertType.NONE, "", goToNextSceneButton);
        alert.setHeaderText(null);
        alert.setTitle("Куттуктайбыз");
        alert.setContentText("Сиз уттунуз");

        alert.setOnCloseRequest(e -> {

            GameController3.startGame3();
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

