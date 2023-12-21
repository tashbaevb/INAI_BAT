package com.example.inai_bat.kgController.pauseMenu;

import com.example.inai_bat.MainApplication;
import com.example.inai_bat.kgController.thirdMap.GameController3;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class ThirdMenuController {

    @FXML
    void play(ActionEvent event) {
        GameController3.startGame3();
        closeCurrentWindow(event);
    }

    private void closeCurrentWindow(ActionEvent event) {
        Node source = (Node) event.getSource();
        Stage stage = (Stage) source.getScene().getWindow();
        stage.close();
    }


    @FXML
    private void exitToMenu(ActionEvent event) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(MainApplication.class.getResource("home.fxml"));
            Parent root = fxmlLoader.load();
            Scene scene = new Scene(root);
            Stage homeStage = new Stage();
            homeStage.setTitle("Home");
            homeStage.setScene(scene);
            homeStage.show();

            Stage firstMenu = (Stage) ((Node) event.getSource()).getScene().getWindow();
            firstMenu.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
