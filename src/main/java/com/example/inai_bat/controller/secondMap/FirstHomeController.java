package com.example.inai_bat.controller.secondMap;

import com.example.inai_bat.controller.firstMap.GameController;
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

public class FirstHomeController extends BaseHomeController implements Initializable {


    @FXML
    private Label label;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        TextOutput textOutput = textOut -> Platform.runLater(() -> label.setText(textOut));
        initializeTextAnimators(textOutput);
    }

    @Override
    protected void initializeTextAnimators(TextOutput textOutput) {
        textAnimator = new TextAnimator("Ja natürlich. In letzter Zeit ist etwas Seltsames passiert. Ich bemerkte Schatten und hörte ungewöhnliche Geräusche in ruhigen Ecken des Dorfes. Aber ich dachte, das wären nur meine Fantasien und ich hätte zu hart gearbeitet, aber ich kann von morgens bis abends auf der Post sein, und genau das ist am Tag des Mordes passiert.", 0.2, textOutput);
        textAnimator2 = new TextAnimator("(nachdenklich) Gerhard war ein freundlicher Mann. Wir trafen uns im Dorf und tauschten Neuigkeiten aus. Hat mir immer mit der Post geholfen, wenn etwas Besonderes passiert ist. Er war immer der Erste, der zu Hilfe kam, dieser Mann tut mir leid.", 0.2, textOutput);
        textAnimator3 = new TextAnimator("Carla war schon immer eine fleißige und zuverlässige Frau. Wir stehen uns nicht allzu nahe, aber sie war immer gutherzig. Ich bezweifle, dass eine so reine Seele so etwas tun könnte. Obwohl... In letzter Zeit ist Carla zurückgezogener geworden und manchmal sieht man sie etwas Unverständliches murmeln.", 0.2, textOutput);
        textAnimator4 = new TextAnimator("Emil... er war immer irgendwie still. Mann der Erde. Wir kommunizieren nicht viel. Er strahlt etwas Geheimnisvolles aus, aber ich war nicht besonders mit ihm befreundet, daher kann ich nichts Besonderes mitteilen.", 0.2, textOutput);

    }

    @Override
    protected void handleExitButton(ActionEvent event) {
        GameController2.startGame2();
        closeCurrentWindow(event);
    }

    @Override
    protected void handleOnButton(ActionEvent event) {
        showResultAlert("So schade", "Sie verloren", ButtonType.CLOSE,
                () -> {
                    GameController.startGame();
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

