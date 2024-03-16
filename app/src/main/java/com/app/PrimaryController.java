package com.app;


import java.util.ArrayList;
import java.util.List;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;

public class PrimaryController {

    private Book book; // Reference to the Book class#
    private User user;
    private List<User> userList;

    public PrimaryController() {
        // Initialize the book
        book = new Book(1);
        book.setTitle("Initial Book Title");
        userList = new ArrayList<>();
        
        // Add some sample users to the list
        userList.add(new User("password1", "username1", 1));
        userList.add(new User("password2", "username2", 2));
        userList.add(new User("password3", "username3", 3));

    }



    @FXML
    private Label title;

    @FXML
    private Label primaryText;

    @FXML
    private Button primaryButton;

    @FXML
    private TextField usernameField;

    @FXML
    private TextField passwordField;

    @FXML
    private void initialize() {
        // Initialize UI components or perform any setup here
        title.setText("Library System");
    }

    @FXML
    private void onPrimaryButtonClick() {
        // Perform any logic here
        primaryText.setText(book.getTitle());
    }

    /**
     * Handles the login process by checking the entered username and password
     * against the list of User objects.
     * If a match is found, the user's login status is set to true and a success
     * message is displayed. Otherwise, a failure message is displayed.
     */
    @FXML
    private void login() {
        // Get entered username and password
        String username = usernameField.getText();
        String password = passwordField.getText();

        // Iterate through the list of User objects
        for (User user : userList) {
            // Check if the entered credentials match a User object
            if (user.getUserName().equals(username) && user.getPassword().equals(password)) {
                // Set the user's login status to true
                user.setLoggedIn(true);
                // Display a success message with the username
                showAlert("Login Successful", "Welcome, " + username + "!");
                // Exit the method after a successful login
                return;
            }
        }
        // Display a failure message if no match is found
        showAlert("Login Failed", "Invalid username or password.");
    }

    private void showAlert(String title, String message) {
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}
