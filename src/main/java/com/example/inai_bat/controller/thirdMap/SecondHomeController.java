package com.example.inai_bat.controller.thirdMap;

import com.example.inai_bat.controller.firstMap.GameController;
import com.example.inai_bat.controller.secondMap.GameController2;
import com.example.inai_bat.controller.thirdMap.GameController3;
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
        textAnimator = new TextAnimator("Nein, ich habe nichts Ungewöhnliches gesehen. Ich kam nach der Arbeit nach Hause und ging in die Werkstatt, um mein Auto zu reparieren. Ich habe keine Geräusche oder Schreie aus dem Haus von Markus Becker gehört.", 0.2, textOutput);
        textAnimator2 = new TextAnimator("Ich weiß, dass er mein Arbeitgeber war, und ich war bei verschiedenen Gelegenheiten für ihn auf Reisen. Ich weiß nicht, was er gemacht hat, und es interessiert mich auch nicht. Ich habe nur meine Arbeit gemacht und wurde dafür bezahlt.", 0.2, textOutput);
        textAnimator3 = new TextAnimator("Ich kenne sie nicht persönlich, aber ich habe sie mehrmals gesehen, als sie sich dem Haus von Markus Becker mit einer Kamera und einem Mikrofon näherte. Ich glaube, sie war eine Journalistin, die versuchte, einen sensationellen Bericht über ihn zu machen.", 0.2, textOutput);
        textAnimator4 = new TextAnimator("Ich kenne sie nicht persönlich, aber ich habe sie ein paar Mal gesehen, als sie mit einer Tasche und Papieren das Haus von Marcus Becker verließ. Ich glaube, sie war seine Sekretärin oder Buchhalterin. Ich weiß nicht, in welcher Beziehung sie zueinander standen, aber ich denke, sie könnte über seine Finanzen Bescheid gewusst haben.", 0.2, textOutput);
    }

    @Override
    protected void handleExitButton(ActionEvent event) {
        GameController3.startGame3();
        closeCurrentWindow(event);
    }

    @Override
    protected void handleOnButton(ActionEvent event) {
        showResultAlert("So schade", "Sie verloren", ButtonType.CLOSE,
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

