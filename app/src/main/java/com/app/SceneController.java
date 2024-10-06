package com.app;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import java.time.LocalDate;



public class SceneController {
    private BookCollection bookCollection;
    private SecondaryController mainController;


@FXML
private Button addBookButton;
@FXML
private TextField titleField;
@FXML
private TextField genreField;
@FXML
private TextField authorField;
@FXML
private TextField priceField;
@FXML
private TextArea descriptionArea;
@FXML
private TextField languageField;
@FXML
private DatePicker dateField;


    /**
     * Sets the book collection for this object.
     *
     * @param  bookCollection  the book collection to be set
     */
public void setBookCollection(BookCollection bookCollection) {
    this.bookCollection = bookCollection;
}

    /**
     * Sets the main controller for this object.
     *
     * @param  mainController  the main controller to be set
     */
public void setMainController(SecondaryController mainController) {
    this.mainController = mainController;
}


    /**
     * Adds a new book to the book collection and updates the main controller with the updated collection.
     *
     * @param  event  the ActionEvent that triggered the method
     */
@FXML
private void addBook(ActionEvent event) {
    String title = titleField.getText();
    String genre = genreField.getText();
    String author = authorField.getText();
    double price = Double.parseDouble(priceField.getText());
    String description = descriptionArea.getText();
    String language = languageField.getText();
    LocalDate publicationDate = dateField.getValue();

    // Add the new book to the collection
    bookCollection.addBook(title, genre, author, price, publicationDate, description, language);

    // Save the new book to the database
    saveBookToDatabase(title, genre, author, price, description, language, publicationDate);

    // Clear fields after adding book
    clearFields();

    // Close the popup window
    Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
    stage.close();

    // Pass the updated bookCollection back to the main controller
    if (mainController != null) {
        mainController.setBookCollection(bookCollection);
    }
}

private void saveBookToDatabase(String title, String genre, String author, double price, String description, String language, LocalDate publicationDate) {
    Database database = new Database();

    String query = "INSERT INTO books (title, genre, author, price, publication_date, description, language) VALUES (?, ?, ?, ?, ?, ?, ?)";
    try (Connection connection = database.getConnection();
         PreparedStatement preparedStatement = connection.prepareStatement(query)) {

        // Set the parameters for the SQL query
        preparedStatement.setString(1, title);
        preparedStatement.setString(2, genre);
        preparedStatement.setString(3, author);
        preparedStatement.setDouble(4, price);
        preparedStatement.setDate(5, java.sql.Date.valueOf(publicationDate));
        preparedStatement.setString(6, description);
        preparedStatement.setString(7, language);

        // Execute the insert
        int rowsAffected = preparedStatement.executeUpdate();
        if (rowsAffected > 0) {
            System.out.println("Book added to the database successfully!");
        } else {
            System.err.println("Failed to add the book to the database.");
        }

    } catch (SQLException e) {
        System.err.println("Error adding book to database: " + e.getMessage());
    }
}



    private void clearFields() {
        titleField.clear();
        genreField.clear();
        authorField.clear();

    }
}

 

