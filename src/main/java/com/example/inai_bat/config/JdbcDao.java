package com.example.inai_bat.config;

import java.sql.*;

public class JdbcDao {

    private static final String DATABASE_URL = "jdbc:mysql://localhost:3306/inai";
    private static final String DATABASE_USERNAME = "root";
    private static final String DATABASE_PASSWORD = "1801";
    private static final String INSERT_QUERY = "INSERT INTO users (full_name, email, password) VALUES (?, ?, ?)";
    private static final String SELECT_PASSWORD_QUERY = "SELECT password FROM users WHERE email = ?";


    public void insertRecord(String fullName, String email, String password) throws SQLException {

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e1) {
            e1.printStackTrace();
        }

        try (Connection connection = DriverManager
                .getConnection(DATABASE_URL, DATABASE_USERNAME, DATABASE_PASSWORD);

             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_QUERY)) {
            preparedStatement.setString(1, fullName);
            preparedStatement.setString(2, email);
            preparedStatement.setString(3, password);

            System.out.println(preparedStatement);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            printSQLException(e);
        }
    }


    public String getPasswordByEmail(String email) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        }

        try (Connection connection = DriverManager.getConnection(DATABASE_URL, DATABASE_USERNAME, DATABASE_PASSWORD);
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_PASSWORD_QUERY)) {
            preparedStatement.setString(1, email);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                return resultSet.getString("password");
            }
        } catch (SQLException e) {
            printSQLException(e);
        }

        return null;
    }

    public static void printSQLException(SQLException ex) {
        for (Throwable e : ex) {
            if (e instanceof SQLException) {
                e.printStackTrace(System.err);
                System.err.println("SQLState: " + ((SQLException) e).getSQLState());
                System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
                System.err.println("Message: " + e.getMessage());
                Throwable t = ex.getCause();
                while (t != null) {
                    System.out.println("Cause: " + t);
                    t = t.getCause();
                }
            }
        }
    }

    public String getDatabaseUrl() {
        return DATABASE_URL;
    }

    public String getDatabaseUsername() {
        return DATABASE_USERNAME;
    }

    public String getDatabasePassword() {
        return DATABASE_PASSWORD;
    }
}
