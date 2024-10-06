package com.app;


import java.util.ArrayList;
import java.util.List;

import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.scene.control.Alert.AlertType;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;



public class PrimaryController {

    private Book book; // Reference to the Book class#
    private List<User> userList;
    private Stage stage;
    private Scene scene;
    private Parent root;



    public PrimaryController() {

        
        // Initialize the book
        book = new Book(1);
        book.setTitle("Initial Book Title");
        userList = new ArrayList<>();
        
        // Add some sample users to the list
        userList.add(new User("1", "1", 1));
        userList.add(new User("password2", "username2", 2));
        userList.add(new User("password3", "username3", 3));
        userList.add(new User("", "", 4));

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
    private void login(ActionEvent event) {
    String username = usernameField.getText();
    String password = passwordField.getText();

    // Create an instance of Database class to handle DB interactions
    Database database = new Database();
    Connection connection = database.getConnection();

    try {
        String query = "SELECT * FROM users WHERE username = ? AND password = ?";
        PreparedStatement stmt = connection.prepareStatement(query);
        stmt.setString(1, username);
        stmt.setString(2, password);

        ResultSet rs = stmt.executeQuery();

        if (rs.next()) {
            // If user exists, set the logged_in status in the database
            int userId = rs.getInt("id");
            String updateQuery = "UPDATE users SET logged_in = true WHERE id = ?";
            PreparedStatement updateStmt = connection.prepareStatement(updateQuery);
            updateStmt.setInt(1, userId);
            updateStmt.executeUpdate();

            showAlert("Login Successful", "Welcome, " + username + "!");
            User user = new User(rs.getString("password"), rs.getString("username"), rs.getInt("role"));
            user.setLoggedIn(true);
            
            try {
                switchToScene2(event, user);
            } catch (IOException e) {
                // Handle the exception, e.g., log the error or show an error message
            }

        } else {
            // If no user is found
            showAlert("Login Failed", "Invalid username or password.");
        }

    } catch (SQLException e) {
        e.printStackTrace();
        showAlert("Error", "Database error occurred.");
    } finally {
        database.closeConnection(); // Always close the connection after use
    }  
}

    private void showAlert(String title, String message) {
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }


    /**
     * Switches to scene 1.
    *
    * @param  event The action event
    * @throws IOException if an I/O error occurs
    */
    public void switchToScene1(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("primary.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }


     /**
  * Switches to scene 2 when triggered by an ActionEvent.
  *
  * @param  event	The ActionEvent that triggers the switch
  * @return        	void (no return value)
  */
 public void switchToScene2(ActionEvent event, User user) throws IOException {
    FXMLLoader loader = new FXMLLoader(getClass().getResource("secondary.fxml"));
    root = loader.load();
    
    SecondaryController controller = loader.getController();
    
    controller.currentUser(user);


    stage = (Stage)((Node)event.getSource()).getScene().getWindow();

    scene = new Scene(root);
    String css = this.getClass().getResource("appStyle.css").toExternalForm();
    scene.getStylesheets().add(css);
    stage.setScene(scene);
    stage.show();
   }



}

