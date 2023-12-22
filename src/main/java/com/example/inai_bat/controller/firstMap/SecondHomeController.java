package com.example.inai_bat.controller.firstMap;

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
        textAnimator = new TextAnimator("„An diesem Abend verbrachte ich tatsächlich Zeit im Wald und versuchte, die Schönheit des Sonnenuntergangs einzufangen. Es war mein Versuch, den Moment einzufangen, in dem die Sterne am Himmel zu erwachen beginnen. Aber leider war meine Aufmerksamkeit völlig in die Arbeit vertieft , und ich habe in der Umgebung nichts Ungewöhnliches oder Verdächtiges bemerkt.“", 0.2, textOutput);
        textAnimator2 = new TextAnimator("„Was Herrn Krause betrifft, wir haben nicht viel miteinander gesprochen, aber jedes Treffen mit ihm war angenehm. Er war ein talentierter Künstler, dessen Bilder einen zum Nachdenken anregten. Ich kann aber nicht sagen, dass ich ihn persönlich gekannt habe.“", 0.2, textOutput);
        textAnimator3 = new TextAnimator("„Emma Schneider ist natürlich eine talentierte Handwerkerin, aber unsere Interessen sind unterschiedlich. Ich gehe nicht oft in Antiquitätengeschäfte, obwohl ich schon ein paar Mal in ihrem Geschäft war. Uns hat es nichts Unangenehmes gegeben.“ Momente.“", 0.2, textOutput);
        textAnimator4 = new TextAnimator("„Mit Herrn Schmidt verbindet mich aber noch etwas mehr. Ich gehe oft in die Bibliothek, wo er interessante Geschichten über die Vergangenheit des Dorfes erzählt. Er ist ein gebildeter Mann, und seine Geschichten bringen immer etwas Neues.“here", 0.2, textOutput);
    }

    @Override
    protected void handleExitButton(ActionEvent event) {
        GameController.startGame();
        closeCurrentWindow(event);
    }

    @Override
    protected void handleOnButton(ActionEvent event) {
        showResultAlert("Glückwunsch", "SIE HABEN GEWONNEN", ButtonType.CLOSE,
                () -> {
                    try {
                        Stage currentStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/com/example/inai_bat/map2/introduction2.fxml"));
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

