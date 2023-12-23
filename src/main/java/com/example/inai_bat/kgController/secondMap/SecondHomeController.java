package com.example.inai_bat.kgController.secondMap;

import com.example.inai_bat.kgController.firstMap.KgGameController;
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

public class SecondHomeController extends BaseHomeController implements Initializable {

    private int askedQuestions = 0;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        TextOutput textOutput = textOut -> Platform.runLater(() -> label.setText(textOut));
        initializeTextAnimators(textOutput);
    }

    @Override
    public void initializeTextAnimators(TextOutput textOutput) {
        textAnimator = new TextAnimator("Ммм, мен ойлойм, чындыгында жок, эгерде өлтүрүлгөндөн кийин бардык тургундардын маанайы начарлап, баары кайгылуу басып жүрүшөт", 0.2, textOutput);
        textAnimator2 = new TextAnimator("Коп, ал менин жакшы коргон иним болчу, биз чогуу чонойдук, албетте мен аны башка жашоочуларга караганда жакшы билем, ооба, жакында эле чыр-чатактар болуп жатты, бирок баары бир качандыр бир куну бутот деп ойлочумун, баарыбыз кичинебиз. баарынан чарчадым ж.б.", 0.2, textOutput);
        textAnimator3 = new TextAnimator("Ал сени көргөндө аппак аппак жылмайып, колун булгалаган таттуу адам. Ал бул жердин эң жарык жашоочусу. Мен анын чымынды өлтүрө алаарына күмөнүм бар, бирок бул жерде адам.", 0.2, textOutput);
        textAnimator4 = new TextAnimator("Ал сырдуу адам, эртеден кечке үйүнөн чыкпайт жана адамдар менен сейрек сүйлөшөт, мен ал жөнүндө түшүнүктүү бир нерсе айта алаарыма күмөнүм бар.", 0.2, textOutput);
    }

    @Override
    protected void handleExitButton(ActionEvent event) {
        KgGameController2.startGame2();
        closeCurrentWindow(event);
    }

    @Override
    protected void handleOnButton(ActionEvent event) {
        showResultAlert("Куттуктайбыз!", "СИЗ ЖЕНДИҢИЗ", ButtonType.CLOSE,
                () -> {
                    try {
                        Stage currentStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/com/example/inai_bat/map3/introduction3.fxml"));
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

