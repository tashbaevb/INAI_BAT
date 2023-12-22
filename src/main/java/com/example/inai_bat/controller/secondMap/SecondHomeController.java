package com.example.inai_bat.controller.secondMap;

import com.example.inai_bat.kgController.thirdMap.GameController3;
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

public class SecondHomeController extends BaseHomeController implements Initializable {

    @FXML
    private Label label;

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
        showResultAlert("GLÜCKWUNSCH", "Sie HABEN GEWONNEN", ButtonType.CLOSE,
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

