package com.example.inai_bat.kgController.secondMap;

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
        textAnimator = new TextAnimator("Ооба албетте. Акыркы убакта бир кызыктай нерсе болуп жатат. Мен көлөкөлөрдү байкадым жана айылдын тынч бурчтарынан адаттан тыш үндөрдү уктум. Бирок мен бул жөн эле менин фантазиям деп ойлочумун, мен өтө көп иштедим, бирок эртең мененден кечке чейин почта бөлүмүндө боло алам, адам өлтүрүлгөн күнү так ушундай болду.", 0.2, textOutput);
        textAnimator2 = new TextAnimator("(Ойлонууп) Герхард боорукер адам эле. Айылдан жолугуп, кабар алмаштык. Эгер өзгөчө бир нерсе болуп калса, мага почта менен жардам берчү. Ар дайым биринчилерден болуп жардамга келчү, бул кишиге боорум ооруйт.", 0.2, textOutput);
        textAnimator3 = new TextAnimator("Карла дайыма эмгекчил жана ишенимдүү аял болгон. Биз өтө жакын эмеспиз, бирок ал ар дайым боорукер. Ушундай аруу жандын колунан ушундай иш келеринен күмөнүм бар. Болсо да... Акыркы кездери Карла ого бетер тїшїнїксїз болуп, кээде анын тїшїнїксїз бирдемелерди күбүрөп жатканын көрүүгө болот.", 0.2, textOutput);
        textAnimator4 = new TextAnimator("Эмиль... эмнегедир унчукпай жүрчү. Жердин адамы. Биз көп сүйлөшпөйбүз. Ал сырдуу сезимди жаратат, бирок мен аны менен өзгөчө дос болгон эмесмин, ошондуктан өзгөчө эч нерсе бөлүшө албайм.", 0.2, textOutput);
    }

    @Override
    protected void handleExitButton(ActionEvent event) {
        KgGameController2.startGame2();
        closeCurrentWindow(event);
    }

    @Override
    protected void handleOnButton(ActionEvent event) {
        showResultAlert("Кандай уят", "Сиз Утлдуңуз", ButtonType.CLOSE,
                () -> {
                    KgGameController2.startGame2();
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

