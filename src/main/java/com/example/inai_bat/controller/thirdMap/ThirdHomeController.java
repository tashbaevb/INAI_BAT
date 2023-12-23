package com.example.inai_bat.controller.thirdMap;

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

public class ThirdHomeController extends BaseHomeController implements Initializable {

    private int askedQuestions = 0;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        TextOutput textOutput = textOut -> Platform.runLater(() -> label.setText(textOut));
        initializeTextAnimators(textOutput);
    }

    @Override
    protected void initializeTextAnimators(TextOutput textOutput) {
        textAnimator = new TextAnimator("Nein, ich habe nichts Ungewöhnliches gesehen. Ich verließ das Haus gegen sechs Uhr abends und ging in den Laden, um Lebensmittel einzukaufen. In der Nähe des Hauses von Markus Becker habe ich keine verdächtigen Personen oder Autos bemerkt.", 0.2, textOutput);
        textAnimator2 = new TextAnimator("Er war mein Arbeitgeber, und ich habe ihm bei dem Papierkram geholfen. Ich weiß nicht, was er getan hat, und es ist mir auch egal.", 0.2, textOutput);
        textAnimator3 = new TextAnimator("Ich kenne sie nicht persönlich, aber ich habe von Marcus Becker von ihr gehört. Er sagte, sie sei eine aufdringliche Journalistin, die versuche, seinen Ruf und sein Geschäft zu ruinieren. Er sagte, sie sei sein Feind und er wolle sie verklagen.", 0.2, textOutput);
        textAnimator4 = new TextAnimator("Ich kenne ihn nicht persönlich, aber ich habe ihn ein paar Mal gesehen, als er Marcus Becker abholte. Er war sein Fahrer und Sicherheitsbeamter. Er sagte, er sei sein Freund und er habe ihn vor Gefahren geschützt.", 0.2, textOutput);
    }

    @Override
    protected void handleExitButton(ActionEvent event) {
        GameController3.startGame3();
        closeCurrentWindow(event);
    }

    @Override
    protected void handleOnButton(ActionEvent event) {
        showResultAlert("Glückwunsch", "SIE HABEN GEWONNEN", ButtonType.CLOSE,
                () -> {
                    try {
                        Stage currentStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/com/example/inai_bat/map1/introduction.fxml"));
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

