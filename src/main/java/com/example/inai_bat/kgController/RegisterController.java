package com.example.inai_bat.kgController;

import com.example.inai_bat.MainApplication;
import com.example.inai_bat.config.JdbcDao;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.stage.Window;

import java.io.IOException;
import java.sql.SQLException;

public class RegisterController {
    @FXML
    private TextField fullNameField;

    @FXML
    private TextField emailIdField;

    @FXML
    private PasswordField passwordField;

    @FXML
    private Button submitButton;

    @FXML
    public void register(ActionEvent event) throws SQLException {

        Window owner = submitButton.getScene().getWindow();

        if (fullNameField.getText().isEmpty()) {
            showAlert(Alert.AlertType.ERROR, owner, "Form Error!",
                    "Please enter your name");
            return;
        }

        if (emailIdField.getText().isEmpty()) {
            showAlert(Alert.AlertType.ERROR, owner, "Form Error!",
                    "Please enter your email id");
            return;
        }
        if (passwordField.getText().isEmpty()) {
            showAlert(Alert.AlertType.ERROR, owner, "Form Error!",
                    "Please enter a password");
            return;
        }

        String fullName = fullNameField.getText();
        String emailId = emailIdField.getText();
        String password = passwordField.getText();

        JdbcDao jdbcDao = new JdbcDao();
        jdbcDao.insertRecord(emailId, password);

        showAlert(Alert.AlertType.CONFIRMATION, owner, "Registration Successful!",
                "Welcome " + fullNameField.getText());
    }

    public void openLoginWindow(ActionEvent event) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(MainApplication.class.getResource("login.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            Stage loginStage = new Stage();
            loginStage.setTitle("Login");
            loginStage.setScene(scene);
            loginStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }

        ((Node) event.getSource()).getScene().getWindow().hide();
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
