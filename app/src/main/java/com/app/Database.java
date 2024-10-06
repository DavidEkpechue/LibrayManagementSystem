package com.app;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

public class Database {
    // Change the URL to a valid JDBC URL for MySQL
    private static final String URL = "jdbc:mysql://localhost:3306/library_db"; 
    private static final String USER = "root"; 
    private static final String PASSWORD = ""; 

    private Connection connection;

    public Database() {
        try {
            // Establish connection to MySQL
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("Database connection established.");
        } catch (SQLException e) {
            System.err.println("Connection failed: " + e.getMessage());
        }
    }

    public Connection getConnection() {
        return connection;
    }

    // Method to close the connection when done
    public void closeConnection() {
        try {
            if (connection != null && !connection.isClosed()) {
                connection.close();
                System.out.println("Database connection closed.");
            }
        } catch (SQLException e) {
            System.err.println("Error closing connection: " + e.getMessage());
        }
    }

    // Example method to retrieve data from a table
    public void retrieveBooks() {
        String query = "SELECT * FROM books"; // Assume 'books' is a table in your database
        try (PreparedStatement preparedStatement = connection.prepareStatement(query);
             ResultSet resultSet = preparedStatement.executeQuery()) {

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String title = resultSet.getString("title");
                String author = resultSet.getString("author");
                System.out.println("ID: " + id + ", Title: " + title + ", Author: " + author);
            }
        } catch (SQLException e) {
            System.err.println("Error retrieving data: " + e.getMessage());
        }
    }

    // Method to borrow a book and add to borrowed_books table
    public void borrowBook(LocalDate borrowDate, long bookId, User currentUser) throws IOException, SQLException {
        String username = currentUser.getUserName();
        String password = currentUser.getPassword();
    
        Database database = new Database();
        Connection connection = null;
        PreparedStatement userStmt = null;
        ResultSet rs = null;
    
        try {
            connection = database.getConnection();
            
            // Step 1: Retrieve the user ID based on username and password
            String user_query = "SELECT id FROM users WHERE username = ? AND password = ?";
            userStmt = connection.prepareStatement(user_query);
            userStmt.setString(1, username);
            userStmt.setString(2, password);
            
            rs = userStmt.executeQuery();
    
            if (rs.next()) {
                int userId = rs.getInt("id"); // Retrieve the user's ID
    
                // Step 2: Insert the record into borrowed_books
                String query = "INSERT INTO borrowed_books (user_id, book_id, borrow_date) VALUES (?, ?, ?)";
                try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                    preparedStatement.setInt(1, userId);
                    preparedStatement.setLong(2, bookId); // Use the passed bookId
                    preparedStatement.setDate(3, java.sql.Date.valueOf(borrowDate)); // Convert LocalDate to java.sql.Date
                    
                    int rowsAffected = preparedStatement.executeUpdate();
                    if (rowsAffected > 0) {
                        System.out.println("Book borrowed successfully.");
                    }
                } catch (SQLException e) {
                    System.err.println("Error borrowing book: " + e.getMessage());
                }
            } else {
                System.out.println("User not found or incorrect credentials.");
            }
        } catch (SQLException e) {
            System.err.println("Error connecting to the database: " + e.getMessage());
        } finally {
            // Close resources in reverse order of their creation
            if (rs != null) try { rs.close(); } catch (SQLException e) { e.printStackTrace(); }
            if (userStmt != null) try { userStmt.close(); } catch (SQLException e) { e.printStackTrace(); }
            if (connection != null) database.closeConnection(); // This will close the connection
        }
    }
    


    // Main method for testing
    public static void main(String[] args) {
        Database db = new Database();
        db.retrieveBooks(); // Retrieve and print all books
        db.closeConnection();
    }
}
