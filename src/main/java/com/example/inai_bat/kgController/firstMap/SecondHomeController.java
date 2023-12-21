package com.example.inai_bat.kgController.firstMap;

import com.example.inai_bat.kgController.secondMap.KgGameController2;
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

        textAnimator = new TextAnimator("\"Ошол кечте мен токойдо убакыт өткөрдүм, күндүн батышынын кооздугун тартууга аракет кылдым. Бул менин асманда жылдыздар ойгоно баштаган учурду тартууга аракетим болду. Бирок, тилекке каршы, көңүлүм толугу менен жумушка берилип кетти. , жана мен айланада адаттан тыш же шектүү эч нерсе байкаган жокмун.\"",
                0.2, textOutput);
        textAnimator2 = new TextAnimator("\"Краузе мырзага келсек, көп баарлашчу эмеспиз, бирок аны менен болгон ар бир жолугушуу жагымдуу болду. Ал таланттуу сүрөтчү экен, сүрөттөрү сизди ойго салды. Бирок мен аны жеке тааныйм деп айта албайм\".",
                0.2, textOutput);
        textAnimator3 = new TextAnimator("«Эмма Шнайдерге келсек, ал, албетте, таланттуу соодагер, бирок биздин кызыкчылыктарыбыз эки башка, мен анын дүкөнүнө бир нече жолу барсам да, антиквариат дүкөндөрүнө көп бара бербейм. көз ирмемдер».",
                0.2, textOutput);
        textAnimator4 = new TextAnimator("\"Бирок мени Шмидт мырза менен бир аз көбүрөөк окшоштуктар бар. Мен китепканага көп барам, ал жерде ал айылдын өткөнү тууралуу кызыктуу окуяларды айтып берет. Ал билимдүү адам жана анын окуялары ар дайым жаңы нерселерди алып келет\".",
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
        ButtonType goToNextSceneButton = new ButtonType("Кийинки Сценага өтүңүз");
        Alert alert = new Alert(Alert.AlertType.NONE, "", goToNextSceneButton);
        alert.setHeaderText(null);
        alert.setTitle("Куттуктайм");
        alert.setContentText("СЕН ЖЕНДИҢ");

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

