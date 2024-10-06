package com.app;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Database {
    private static final String URL = "http://localhost/phpmyadmin/index.php?route=/database/structure&db=library_db"; 
    private static final String USER = "root"; 
    private static final String PASSWORD = "root"; 

    private Connection connection;

    public Database() {
        try {
            // Establish connection to MySQL
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Connection getConnection() {
        return connection;
    }

    // Close the connection when done
    public void closeConnection() {
        try {
            if (connection != null) {
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
