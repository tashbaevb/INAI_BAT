package com.example.inai_bat.kgController.firstMap;

import com.example.inai_bat.service.TextAnimator;
import com.example.inai_bat.service.TextOutput;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.ButtonType;

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
        textAnimator = new TextAnimator("Отто акырын башын ийкеп жооп берет: \"Жок, детектив, ошол күнү кечинде баары кадимкидей тынч жана тынч болчу. Мен адаттан тыш эч нерсе эсимде жок болчу. Бир деталдан башкасы, кечээ кечинде фрау Луиза көпкө турду. өлтүрүлгөн мырзанын эшиги».", 0.2, textOutput);
        textAnimator2 = new TextAnimator("\"Леонид таланттуу сүрөтчү болчу, мен анын студиясына көп келчүмүн. Биз айылдын өткөн-кеткени тууралуу жагымдуу маек куруп жаттык. Ал өзүнүн сүрөттөрүндөй мистикалуу эле, бирок ортобузда эч кандай чыр-чатактар болгон эмес. Ар дайым бири-бирибизди түшүнүп тургандай сезилчүбүз.\"", 0.2, textOutput);
        textAnimator3 = new TextAnimator("Отто ойлонуп, жооп берет: \"Эмма экөөбүз жакшы таанышпыз. Мен анын дүкөнүнө бат-баттан барып турам, ал мен үчүн кызыктуу антиквариаттардын жана кызыктуу окуялардын булагы болчу. Эч качан пикир келишпестик болгон эмес, ар дайым достук мамиледе болуп турчубуз\".", 0.2, textOutput);
        textAnimator4 = new TextAnimator("Отто: \"Луизанын жүрөгү жаш адам. Анын сүрөткө болгон ынтызарлыгы жугуштуу. Биз анча жакын эмеспиз, бирок кээде анын чыгармачыл долбоорлорун изилдеген китепканага барып турам. Ал биздин тынч айылга жаңы көз карашты алып келет\".", 0.2, textOutput);
    }

    @Override
    protected void handleExitButton(ActionEvent event) {
        KgGameController.startGame();
        closeCurrentWindow(event);
    }

    @Override
    protected void handleOnButton(ActionEvent event) {
        showResultAlert("Кандай уят", "Сиз Утлдуңуз", ButtonType.CLOSE,
                () -> {
                    KgGameController.startGame();
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

