package com.example.inai_bat.kgController.firstMap;

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
        textAnimator = new TextAnimator("Эмма детективдин көзүн карап, мындай деп жооп берет: \"Жок, бул кеч дагы башкалардай болду. Айыл дайыма тынч, айрыкча дүкөндөр жабылгандан кийин. Мен адаттан тыш эч нерсе байкаган жокмун. Бирок, күтө тур, күн мурун Луиза Стейн Гладиус аскери IV Галлик легионуна ээ болгон\"", 0.2, textOutput);
        textAnimator2 = new TextAnimator("Эмма эсинде көп майда-чүйдөсүнө чейин айтып жаткандай жай башын ийкейт: \"Леонид таланттуу сүрөтчү болгон. Биз, албетте, анын чыгармалары үчүн антиквариат буюмдар керек болгондо байланышып турчубуз. Ал менин дүкөнүмдүн туруктуу кардары болчу. Бирок ошол жерде Ортобузда эч кандай чыр-чатактар же пикир келишпестиктер болгон жок \"Мен анын чыгармачыл көз карашын сыйлачумун, ал менин коллекциямды сыйлагандай эле.\"", 0.2, textOutput);
        textAnimator3 = new TextAnimator("Эмма акырын суроонун үстүнөн ойлонуп, мындай деп жооп берет: \"Луиза жаш кыз жана мен анын сүрөткө болгон ынтасын сыйлайм. Биз көп жолукчу эмеспиз, бирок ал менин дүкөнүмдө болчу, кээде бир нече сөздү алмаштырчубуз. Адаттагыдай эч нерсе жок. анын жүрүм-турумунда же мамилесинде.\" Мен өзүм менен байкаган жокмун.\"", 0.2, textOutput);
        textAnimator4 = new TextAnimator("Эмма, анын көзүнө ой жүгүртүп, мындай деп жооп берет: \"Отто ар дайым жакшы кошуна болгон. Биз баарлашып, өткөндү эскерчүбүз, ал кээде менин дүкөнүмдүн жанына токтоп калчу. Бирок мен анын мындай кылып жатканын элестете албайм. ушуга окшош.\" \"Ал ар дайым тынч жана ынтымактуу көрүнчү.\"", 0.2, textOutput);
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