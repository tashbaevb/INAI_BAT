package com.example.inai_bat.kgController.firstMap;

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

        textAnimator = new TextAnimator("Отто акырын башын ийкеп жооп берет: \"Жок, детектив, ошол күнү кечинде баары кадимкидей тынч жана тынч болчу. Мен адаттан тыш эч нерсе эсимде жок болчу. Бир деталдан башкасы, кечээ кечинде фрау Луиза көпкө турду. өлтүрүлгөн мырзанын эшиги».",
                0.2, textOutput);
        textAnimator2 = new TextAnimator("\"Леонид таланттуу сүрөтчү болчу, мен анын студиясына көп келчүмүн. Биз айылдын өткөн-кеткени тууралуу жагымдуу маек куруп жаттык. Ал өзүнүн сүрөттөрүндөй мистикалуу эле, бирок ортобузда эч кандай чыр-чатактар \u200B\u200Bболгон эмес. Ар дайым бири-бирибизди түшүнүп тургандай сезилчүбүз.\"",
                0.2, textOutput);
        textAnimator3 = new TextAnimator("Отто ойлонуп, жооп берет: \"Эмма экөөбүз жакшы таанышпыз. Мен анын дүкөнүнө бат-баттан барып турам, ал мен үчүн кызыктуу антиквариаттардын жана кызыктуу окуялардын булагы болчу. Эч качан пикир келишпестик болгон эмес, ар дайым достук мамиледе болуп турчубуз\".",
                0.2, textOutput);
        textAnimator4 = new TextAnimator("Отто: \"Луизанын жүрөгү жаш адам. Анын сүрөткө болгон ынтызарлыгы жугуштуу. Биз анча жакын эмеспиз, бирок кээде анын чыгармачыл долбоорлорун изилдеген китепканага барып турам. Ал биздин тынч айылга жаңы көз карашты алып келет\".",
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
        KgGameController.startGame();
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

            KgGameController.startGame();
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

