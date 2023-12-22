package com.example.inai_bat.controller;

import com.example.inai_bat.MainApplication;
import com.example.inai_bat.config.JdbcDao;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.stage.Window;

import java.io.IOException;
import java.sql.*;

import static com.example.inai_bat.config.JdbcDao.*;

public class LoginController {
    private JdbcDao jdbcDao;

    public LoginController() {
        jdbcDao = new JdbcDao();
    }

    @FXML
    private TextField emailField;

    @FXML
    private PasswordField passwordField;

    public void login(ActionEvent event) {
        Window owner = emailField.getScene().getWindow();

        String email = emailField.getText();
        String password = passwordField.getText();

        if (email.isEmpty() && password.isEmpty()) {
            showAlert(Alert.AlertType.ERROR, owner, "Form Error!", "Please enter both email and password.");
            return;
        }

        if (!isEmailInDatabase(email)) {
            showAlert(Alert.AlertType.ERROR, owner, "Login Failed", "Email not found.");
            return;
        }

        String dbPassword = getPasswordFromDatabase(email);

        if (dbPassword.equals(password)) {
            openHomeWindow(event);
        } else {
            showAlert(Alert.AlertType.ERROR, owner, "Login Failed", "Incorrect password.");
        }
    }

    private String getPasswordFromDatabase(String email) {
        return jdbcDao.getPasswordByEmail(email);
    }


    private boolean isEmailInDatabase(String email) {
        String query = "SELECT COUNT(*) FROM users WHERE email = ?";

        try (Connection connection = DriverManager.getConnection(jdbcDao.getDatabaseUrl(), jdbcDao.getDatabaseUsername(), jdbcDao.getDatabasePassword());
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, email);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                int count = resultSet.getInt(1);
                return count > 0;
            }
        } catch (SQLException e) {
            printSQLException(e);
        }

        return false;
    }


    public void openRegisterWindow(MouseEvent event) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(MainApplication.class.getResource("register.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            Stage loginStage = new Stage();
            loginStage.setTitle("Register");
            loginStage.setScene(scene);
            loginStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }

        ((Node) event.getSource()).getScene().getWindow().hide();
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


    private void showAlert(Alert.AlertType alertType, Window owner, String title, String message) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.initOwner(owner);
        alert.show();
    }
}