package com.app;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

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

    // Add the new book to the collection
    bookCollection.addBook(title, genre, author);

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



    private void clearFields() {
        titleField.clear();
        genreField.clear();
        authorField.clear();

    }
}

 

