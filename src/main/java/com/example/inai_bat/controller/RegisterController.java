package com.example.inai_bat.controller;

import com.example.inai_bat.MainApplication;
import com.example.inai_bat.config.JdbcDao;
import javafx.fxml.FXML;

import java.io.IOException;
import java.sql.SQLException;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import javafx.stage.Window;

public class RegisterController {
    @FXML
    private TextField emailIdField;

    @FXML
    private PasswordField passwordField;

    @FXML
    public void register(ActionEvent event) throws SQLException {
        Window owner = emailIdField.getScene().getWindow();

        if (emailIdField.getText().isEmpty() || passwordField.getText().isEmpty()) {
            showAlert(Alert.AlertType.ERROR, owner, "Formular Fehler!!",
                    "Bitte geben Sie sowohl Ihre E-Mail-Adresse als auch Ihr Passwort ein.");
            return;
        }
        String emailId = emailIdField.getText();
        String password = passwordField.getText();

        JdbcDao jdbcDao = new JdbcDao();
        jdbcDao.insertRecord(emailId, password);

        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Anmeldung erfolgreich!");
        alert.setHeaderText(null);
        alert.setContentText("Willkommen " + emailIdField.getText());
        alert.initOwner(owner);
        alert.showAndWait().ifPresent(response -> {
            if (response == ButtonType.OK) {
                openHomeWindow(event);
            }
        });
    }

    @FXML
    private void openHomeWindow(ActionEvent event) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(MainApplication.class.getResource("home.fxml"));
            Parent root = fxmlLoader.load();
            Scene scene = new Scene(root);
            Stage homeStage = new Stage();
            homeStage.setTitle("Home");
            homeStage.setScene(scene);
            homeStage.show();

            Stage loginStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            loginStage.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    private static void showAlert(Alert.AlertType alertType, Window owner, String title, String message) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.initOwner(owner);
        alert.show();
    }
}
