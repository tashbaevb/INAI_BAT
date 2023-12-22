package com.example.inai_bat.controller.secondMap;

import com.example.inai_bat.service.TextAnimator;
import com.example.inai_bat.service.TextOutput;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public abstract class BaseHomeController implements Initializable {

    TextAnimator textAnimator, textAnimator2, textAnimator3, textAnimator4;
    boolean isButtonClicked = false;
    boolean isButton1Clicked = false;
    boolean isButton2Clicked = false;
    boolean isButton3Clicked = false;
    boolean isButton4Clicked = false;

    @FXML
    protected Label label;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        TextOutput textOutput = textOut -> Platform.runLater(() -> label.setText(textOut));
        initializeTextAnimators(textOutput);
    }

    protected abstract void initializeTextAnimators(TextOutput textOutput);

    @FXML
    protected abstract void handleExitButton(ActionEvent event);

    @FXML
    protected abstract void handleOnButton(ActionEvent event);

    @FXML
    protected abstract void handleButtonClick1(ActionEvent event);

    @FXML
    protected abstract void handleButtonClick2(ActionEvent event);

    @FXML
    protected abstract void handleButtonClick3(ActionEvent event);

    @FXML
    protected abstract void handleButtonClick4(ActionEvent event);

    protected void closeCurrentWindow(ActionEvent event) {
        Node source = (Node) event.getSource();
        Stage stage = (Stage) source.getScene().getWindow();
        stage.close();
    }

    protected void showResultAlert(String title, String content,
                                   ButtonType buttonType, Runnable onClose) {
        Alert alert = new Alert(Alert.AlertType.NONE, "", buttonType);
        alert.setHeaderText(null);
        alert.setTitle(title);
        alert.setContentText(content);
        alert.setOnCloseRequest(e -> {
            if (onClose != null) {
                onClose.run();
            }
        });

        alert.showAndWait();
    }

    protected void handleButtonClick(int buttonNumber, TextAnimator textAnimator) {
        if (!isButtonClicked) {
            switch (buttonNumber) {
                case 1:
                    if (!isButton1Clicked) {
                        runTextAnimation(textAnimator);
                    }
                    break;
                case 2:
                    if (!isButton2Clicked) {
                        runTextAnimation(textAnimator2);
                    }
                    break;
                case 3:
                    if (!isButton3Clicked) {
                        runTextAnimation(textAnimator3);
                    }
                    break;
                case 4:
                    if (!isButton4Clicked) {
                        runTextAnimation(textAnimator4);
                    }
                    break;
            }
        }
    }

    private void runTextAnimation(TextAnimator textAnimator) {
        new Thread(() -> {
            textAnimator.run();
            Platform.runLater(this::resetButtonState);
        }).start();
        isButtonClicked = true;
    }

    protected void resetButtonState() {
        isButtonClicked = false;
        isButton1Clicked = false;
        isButton2Clicked = false;
        isButton3Clicked = false;
        isButton4Clicked = false;
    }
}
