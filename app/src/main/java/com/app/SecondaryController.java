package com.app;


import java.util.ArrayList;
import java.util.List;

import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.stage.Modality;
import javafx.stage.Stage;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javafx.beans.value.ChangeListener;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import java.time.LocalDate;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;


public class SecondaryController {

    private User currentUser;
    private BookCollection bookCollection;
    private String currentBook;
    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML
    private Label titleLabel;

    @FXML
    private ListView<String> searchedListView;

    @FXML
    private Button logoutButton;

    @FXML
    private Button searchButton;

    @FXML
    private Label currentBookLabel;

    @FXML 
    private Label descriptionLabel;

    private ChangeListener<String> bookSelectionListener;


    @FXML
    private TextField searchTextField;



    public SecondaryController() {

        // Initialize the book collection
        bookCollection = new BookCollection("Library");
        // Load books from the database
        loadBooksFromDatabase();
  
    }
    





    @FXML
    private void handleLogoutButtonAction(ActionEvent event) throws IOException, SQLException {

        String username = currentUser.getUserName();
        String password = currentUser.getPassword();

        Database database = new Database();
        Connection connection = database.getConnection();

        String query = "SELECT * FROM users WHERE username = ? AND password = ?";
        PreparedStatement stmt = connection.prepareStatement(query);
        stmt.setString(1, username);
        stmt.setString(2, password);

        ResultSet rs = stmt.executeQuery();

        if (rs.next()) {
            // If user exists, set the logged_in status in the database to 0
            int userId = rs.getInt("id");
            String updateQuery = "UPDATE users SET logged_in = 0 WHERE id = ?";
            PreparedStatement updateStmt = connection.prepareStatement(updateQuery);
            updateStmt.setInt(1, userId);
            updateStmt.executeUpdate();
        } else {
            System.out.println("User not found");
        }




        Parent root = FXMLLoader.load(getClass().getResource("Primary.fxml"));
        Scene scene = new Scene(root);
        String css = this.getClass().getResource("appStyle.css").toExternalForm();
        scene.getStylesheets().add(css);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void handleSearchButtonAction(ActionEvent event) {
        System.out.println("Search button clicked");
        String searchQuery = searchTextField.getText();

        // Clear the current book collection before searching
        bookCollection.clear();

        // Create a list to hold the search results
        List<String> resultString = new ArrayList<>();

        // Prepare the SQL query to fetch books based on the search query
        String sql = "SELECT title, genre, author, price, publication_date, description, language FROM books WHERE title LIKE ?";

        // Create an instance of the Database class to manage connections
        Database database = new Database(); // Assuming you have a no-argument constructor

        try (Connection connection = database.getConnection(); // Get connection from the Database class
            PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            // Set the parameter for the search query
            preparedStatement.setString(1, "%" + searchQuery + "%"); // Use wildcards for partial matches

            // Execute the query
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                // Iterate through the result set and add titles to the resultString and the BookCollection
                while (resultSet.next()) {
                    String title = resultSet.getString("title");
                    String genre = resultSet.getString("genre");
                    String author = resultSet.getString("author");
                    double price = resultSet.getDouble("price");
                    LocalDate publicationDate = resultSet.getDate("publication_date").toLocalDate();
                    String description = resultSet.getString("description");
                    String language = resultSet.getString("language");

                    // Add book to collection
                    bookCollection.addBook(title, genre, author, price, publicationDate, description, language);
                    resultString.add(title);
                }
            }

        } catch (SQLException e) {
            System.err.println("Error during search: " + e.getMessage());
        } finally {
            // Close the connection using your method
            database.closeConnection();
        }

        // Update the ListView with the search results
        searchedListView.getItems().setAll(resultString);

        // Remove the previous listener if it exists
        if (bookSelectionListener != null) {
            searchedListView.getSelectionModel().selectedItemProperty().removeListener(bookSelectionListener);
        }

        // Add listener to handle selection
        bookSelectionListener = (observable, oldValue, newValue) -> {
            // Find the book object corresponding to the selected title
            Book selectedBook = bookCollection.getBookFromTitle(newValue);
            if (selectedBook != null) {
                // Set the text of currentBookLabel to the string representation of the selected book
                currentBookLabel.setText(selectedBook.toString());
                System.out.println(selectedBook.getDescription());
                descriptionLabel.setText(selectedBook.getDescription());
                // Set the currentBook variable to the selected book title
                currentBook = selectedBook.getTitle();
            }
        };
        
        searchedListView.getSelectionModel().selectedItemProperty().addListener(bookSelectionListener);
    }

    @FXML
    private void handleAddBookButtonAction(ActionEvent event) {
    try {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("AddBookPopup.fxml"));
        Parent root = fxmlLoader.load();

        // Get the controller instance
        SceneController controller = fxmlLoader.getController();
        // Set the bookCollection
        controller.setBookCollection(bookCollection);
        // Set the mainController
        controller.setMainController(this); // Pass the reference to the main controller

        // Create a new stage for the popup window
        Stage stage = new Stage();
        stage.setTitle("Add Book");
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setScene(new Scene(root));
        stage.showAndWait();
    } catch (IOException e) {
        e.printStackTrace();
    }
}




    @FXML
    private void handleBorrowBookButtonAction(ActionEvent event) throws SQLException, IOException {
    Book selectedBook = bookCollection.getBookFromTitle(currentBook);
    if (selectedBook != null) {
        selectedBook.setBorrowed(true);
        currentUser.borrowBook(selectedBook); // Assuming this method tracks the borrowed book in the user's list

        // Call the borrowBook method from the Database class
        Database database = new Database(); // Ensure the Database class instance is initialized properly
        long bookId = selectedBook.getId(); // Assuming you have a method to get the book's ID
        LocalDate borrowDate = LocalDate.now(); // Set current date as the borrow date

        database.borrowBook(borrowDate, bookId, currentUser);
        
        // It's a good practice to close the database connection here if you don't need it anymore
        database.closeConnection();
    }

    currentUser.printBorrowedBooks();
}



    @FXML
    private void handleReturnBookButtonAction(ActionEvent event) {
        Book selectedBook = bookCollection.getBookFromTitle(currentBook);
        if (selectedBook != null) {
            selectedBook.setBorrowed(false);
            currentUser.returnBook(selectedBook);
        }

        currentUser.printBorrowedBooks();

    }
    @FXML
    public void test() {
        if (currentUser != null) {
            titleLabel.setText(currentUser.getUserName());
        }
    }

    
    // Method to load books from the database into the BookCollection
    private void loadBooksFromDatabase() {
        Database database = new Database();
        String query = "SELECT * FROM books"; 
        try (Connection connection = database.getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(query);
                ResultSet resultSet = preparedStatement.executeQuery()) {

            int count = 0; // To keep track of how many books are loaded
            while (resultSet.next()) {
                String title = resultSet.getString("title");
                String genre = resultSet.getString("genre");
                String author = resultSet.getString("author");
                double price = resultSet.getDouble("price");
                LocalDate publicationDate = resultSet.getDate("publication_date").toLocalDate();
                String description = resultSet.getString("description");
                String language = resultSet.getString("language");

                // Add book to collection
                bookCollection.addBook(title, genre, author, price, publicationDate, description, language);
                count++; // Increment the count
            }
            System.out.println("Total books loaded: " + count); // Log the total count
        } catch (SQLException e) {
            System.err.println("Error loading books: " + e.getMessage());
        }
    }


    public void currentUser(User user) {
        this.currentUser = user;
    }


    public void setBookCollection(BookCollection bookCollection) {
        this.bookCollection = bookCollection;
    }

}