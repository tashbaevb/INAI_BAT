package com.example.inai_bat.kgController.firstMap;

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

    protected int askedQuestions = 0;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        TextOutput textOutput = textOut -> Platform.runLater(() -> label.setText(textOut));
        initializeTextAnimators(textOutput);
    }

    @Override
    protected void initializeTextAnimators(TextOutput textOutput) {
        textAnimator = new TextAnimator(" ", 0.2, textOutput);
        textAnimator2 = new TextAnimator("Краузе мырзага келсек, көп баарлашчу эмеспиз, бирок аны менен болгон ар бир жолугушуу жагымдуу болду. Ал таланттуу сүрөтчү экен, сүрөттөрү сизди ойго салды. Бирок мен аны жеке тааныйм деп айта албайм.", 0.2, textOutput);
        textAnimator3 = new TextAnimator("Эмма Шнайдерге келсек, ал, албетте, таланттуу соодагер, бирок биздин кызыкчылыктарыбыз эки башка, мен анын дүкөнүнө бир нече жолу барсам да, антиквариат дүкөндөрүнө көп бара бербейм. көз ирмемдер.", 0.2, textOutput);
        textAnimator4 = new TextAnimator("Бирок мени Шмидт мырза менен бир аз көбүрөөк окшоштуктар бар. Мен китепканага көп барам, ал жерде ал айылдын өткөнү тууралуу кызыктуу окуяларды айтып берет. Ал билимдүү адам жана анын окуялары ар дайым жаңы нерселерди алып келет.", 0.2, textOutput);
    }

    @Override
    protected void handleExitButton(ActionEvent event) {
        KgGameController.startGame();
        closeCurrentWindow(event);
    }

    @Override
    protected void handleOnButton(ActionEvent event) {
        showResultAlert("Куттуктайбыз!", "СИЗ ЖЕНДИҢИЗ", ButtonType.CLOSE,
                () -> {
                    try {
                        Stage currentStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/com/example/inai_bat/map2/kg/introduction2.fxml"));
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

