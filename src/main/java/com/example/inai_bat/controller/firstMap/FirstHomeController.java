package com.example.inai_bat.controller.firstMap;

import com.example.inai_bat.service.TextAnimator;
import com.example.inai_bat.service.TextOutput;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.ButtonType;

import java.net.URL;
import java.util.ResourceBundle;

public class FirstHomeController extends BaseHomeController implements Initializable {

    private int askedQuestions = 0;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        TextOutput textOutput = textOut -> Platform.runLater(() -> label.setText(textOut));
        initializeTextAnimators(textOutput);
    }

    @Override
    protected void initializeTextAnimators(TextOutput textOutput) {
        textAnimator = new TextAnimator("Emma blickt dem Detektiv in die Augen und antwortet: „Nein, dieser Abend war wie jeder andere. Im Dorf ist es immer so ruhig, besonders nach Ladenschluss. Mir ist nichts Ungewöhnliches aufgefallen. Obwohl, warte, das Am Tag zuvor erwarb Louise Stein einen Gladius-Soldaten der IV. Gallischen Legion.", 0.2, textOutput);
        textAnimator2 = new TextAnimator("Emma nickt langsam, als würde sie viele Details in ihrer Erinnerung durchgehen: „Leonid war ein talentierter Künstler. Wir haben natürlich kommuniziert, besonders als er antike Gegenstände für seine Werke brauchte. Er war Stammkunde meines Ladens. Aber da Es gab keine Konflikte oder Meinungsverschiedenheiten zwischen uns. „Ich habe seine kreative Vision respektiert, genauso wie er wahrscheinlich meine Sammlung respektiert hat.“", 0.2, textOutput);
        textAnimator3 = new TextAnimator("Emma, wieder langsam über die Frage nachdenkend, antwortet: „Louise ist ein junges Mädchen und ich respektiere ihre Leidenschaft für die Fotografie. Wir haben uns nicht oft getroffen, aber sie war in meinem Laden und wir haben manchmal ein paar Worte gewechselt. Nichts Ungewöhnliches.“ in ihrem Verhalten oder ihrer Einstellung. „Ich habe es bei mir nicht gemerkt.“", 0.2, textOutput);
        textAnimator4 = new TextAnimator("Emma antwortet mit einem Schatten des Nachdenkens in ihren Augen: \"Otto war immer ein guter Nachbar. Wir unterhielten uns, tauschten Erinnerungen an die Vergangenheit aus, und manchmal kam er in meinem Laden vorbei. Aber ich kann mir nicht vorstellen, dass er so etwas getan hat. Er wirkte immer so friedlich und freundlich.", 0.2, textOutput);
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
