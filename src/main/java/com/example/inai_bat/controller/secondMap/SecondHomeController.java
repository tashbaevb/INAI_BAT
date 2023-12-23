package com.example.inai_bat.controller.secondMap;

import com.example.inai_bat.service.TextAnimator;
import com.example.inai_bat.service.TextOutput;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ButtonType;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class SecondHomeController extends BaseHomeController implements Initializable {

    private int askedQuestions = 0;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        TextOutput textOutput = textOut -> Platform.runLater(() -> label.setText(textOut));
        initializeTextAnimators(textOutput);
    }

    @Override
    protected void initializeTextAnimators(TextOutput textOutput) {
        textAnimator = new TextAnimator("Hmm, lassen Sie mich nachdenken, eigentlich nein, außer dass sich nach dem Mord die Stimmung aller Bewohner verschlechtert hat und alle traurig umherlaufen", 0.2, textOutput);
        textAnimator2 = new TextAnimator("Vieles, er war mein lieber Bruder, wir sind zusammen aufgewachsen, natürlich kenne ich ihn besser als andere Bewohner, ja, es gab kürzlich Konflikte, aber ich dachte immer noch, dass sie eines Tages enden würden, wir sind alle nur ein bisschen müde von allem und so.", 0.2, textOutput);
        textAnimator3 = new TextAnimator("Er ist ein süßer Mann, der, wenn er dich sieht, ein schneeweißes Lächeln lächelt und mit der Hand winkt. Er ist der klügste Bewohner dieses Ortes. Ich bezweifle, dass er in der Lage ist, eine Fliege zu töten, aber hier einen Menschen.", 0.2, textOutput);
        textAnimator4 = new TextAnimator("Er ist ein geheimnisvoller Mann, er verlässt sein Haus nicht den ganzen Tag und kommuniziert selten mit Menschen. Ich bezweifle, dass ich irgendetwas Verständliches über ihn erzählen kann.", 0.2, textOutput);
    }


    @Override
    protected void handleExitButton(ActionEvent event) {
        GameController2.startGame2();
        closeCurrentWindow(event);
    }

    @Override
    protected void handleOnButton(ActionEvent event) {
        showResultAlert("Glückwunsch", "SIE HABEN GEWONNEN", ButtonType.CLOSE,
                () -> {
                    try {
                        Stage currentStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/com/example/inai_bat/map3/introduction3.fxml"));
                        Parent parent = fxmlLoader.load();
                        Stage stage = new Stage();
                        stage.setScene(new Scene(parent));
                        stage.show();
                        currentStage.close();
                    } catch (IOException exception) {
                        exception.printStackTrace();
                    }
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

