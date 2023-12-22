package com.example.inai_bat.controller.firstMap;

import com.example.inai_bat.service.TextAnimator;
import com.example.inai_bat.service.TextOutput;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ButtonType;

import java.net.URL;
import java.util.ResourceBundle;


public class ThirdHomeController extends BaseHomeController implements Initializable {

    @FXML
    private Label label;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        TextOutput textOutput = textOut -> Platform.runLater(() -> label.setText(textOut));
        initializeTextAnimators(textOutput);
    }

    @Override
    protected void initializeTextAnimators(TextOutput textOutput) {
        textAnimator = new TextAnimator("Otto antwortet langsam nickend: „Nein, Detektiv, an diesem Abend war alles so ruhig und gelassen wie immer. Ich konnte mich an nichts Ungewöhnliches erinnern. Bis auf ein Detail stand Frau Louise letzte Nacht sehr lange da.“ die Tür des Herrn getötet.“", 0.2, textOutput);
        textAnimator2 = new TextAnimator("„Leonid war ein talentierter Künstler, und ich besuchte oft sein Atelier. Wir führten angenehme Gespräche über die Vergangenheit des Dorfes. Er war mystisch, wie seine Bilder, aber zwischen uns kam es zu keinen Konflikten. Es schien immer, als hätten wir uns verstanden.“", 0.2, textOutput);
        textAnimator3 = new TextAnimator("Otto denkt nach und antwortet: \"Emma und ich sind gute Bekannte. Ich besuche ihren Laden, und sie ist für mich eine Quelle für interessante Antiquitäten und unterhaltsame Geschichten. Wir hatten noch nie eine Meinungsverschiedenheit und haben uns immer freundlich unterhalten.\"", 0.2, textOutput);
        textAnimator4 = new TextAnimator("Otto lächelt: \"Louise ist eine junge Seele. Ihre Begeisterung für die Fotografie ist ansteckend. Wir stehen uns nicht sehr nahe, aber manchmal besuche ich die Bibliothek, wo sie ihre kreativen Projekte erforscht. Sie bringt eine neue Perspektive in unser ruhiges Dorf.\"", 0.2, textOutput);
    }

    @Override
    protected void handleExitButton(ActionEvent event) {
        GameController.startGame();
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

