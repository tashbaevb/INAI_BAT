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

        textAnimator = new TextAnimator("Эмма детективдин көзүн карап, мындай деп жооп берет: \"Жок, бул кеч да башкалардай болду. Айрыкча дүкөндөр жабылгандан кийин айыл дайыма тынч. Мен адаттан тыш эч нерсе байкаган жокмун. Бирок, күтө туруңуз, бир күн мурун Луиза Стейн IV Галлик Легионунун жоокеринин Гладиусун алган.\"",
                0.2, textOutput);
        textAnimator2 = new TextAnimator("Эмма эсинде энчеме жикме-жик жикме-жик гезден гечип барян ялы, жай башыны иййэр. \"Леонид таланттуу сүрөтчү болгон. Биз, албетте, өзгөчө анын чыгармалары үчүн антиквариат буюмдары керек болгондо сүйлөшчүбүз. Ал менин дүкөнүмдүн туруктуу кардары болчу. Бирок ортобузда эч кандай чыр-чатак, пикир келишпестик болгон жок. Ал менин коллекциямды сыйлагандай, мен анын чыгармачылык көз карашын сыйлачумун.\"",
                0.2, textOutput);
        textAnimator3 = new TextAnimator("Эмма дагы акырын суроону карап, жооп берет: \"Луиза жаш кыз жана мен анын сүрөткө болгон ышкысын сыйлайм. Экөөбүз көп көрүшчү эмеспиз, бирок ал менин дүкөнүмдү кыдырып, анда-санда бир-эки сөздү алмаштырып турчубуз. Мен анын жүрүм-турумунан же мага болгон мамилесинде адаттан тыш эч нерсе байкаган жокмун.\"",
                0.2, textOutput);
        textAnimator4 = new TextAnimator("Эмма, көзүнө чагылуу көлөкө менен жооп берет: \"Отто ар дайым жакшы кошуна болуп келген. Биз баарлашып, өткөн күндөрдү эскердик, ал кээде менин дүкөнүмдүн жанына токтойт. Бирок мен анын мындай кылганын элестете албайм. Ал ар дайым ушунчалык тынч жана достук көрүнчү.\"",
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

