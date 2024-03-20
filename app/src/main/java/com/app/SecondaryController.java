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

import javafx.beans.value.ChangeListener;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;



import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;


public class SecondaryController {

    private User currentUser;
    private BookCollection bookCollection;
    private String currentBook;
    private Stage stage;
    private Scene scene;
    private Parent root;

    public SecondaryController() {

        // Initialize the book collection
        bookCollection = new BookCollection("Library");
    
        // Add sample books to the collection
        bookCollection.addBook("To Kill a Mockingbird", "Fiction", "Harper Lee");
        bookCollection.addBook("1984", "Dystopian Fiction", "George Orwell");
        bookCollection.addBook("The Great Gatsby", "Fiction", "F. Scott Fitzgerald");
        bookCollection.addBook("Pride and Prejudice", "Romance", "Jane Austen");
        bookCollection.addBook("The Catcher in the Rye", "Fiction", "J.D. Salinger");
        bookCollection.addBook("The Hobbit", "Fantasy", "J.R.R. Tolkien");
        bookCollection.addBook("Brave New World", "Dystopian Fiction", "Aldous Huxley");
        bookCollection.addBook("Harry Potter & the PS", "Fantasy", "J.K. Rowling");
        bookCollection.addBook("The Lord of the Rings", "Fantasy", "J.R.R. Tolkien");
        bookCollection.addBook("The Da Vinci Code", "Mystery", "Dan Brown");
        bookCollection.addBook("The Hunger Games", "Young Adult", "Suzanne Collins");
        bookCollection.addBook("The Alchemist", "Fiction", "Paulo Coelho");
        bookCollection.addBook("The Chronicles of Narnia", "Fantasy", "C.S. Lewis");
        bookCollection.addBook("The Picture of Dorian Gray", "Gothic Fiction", "Oscar Wilde");
        bookCollection.addBook("Jane Eyre", "Gothic Fiction", "Charlotte Brontë");
        bookCollection.addBook("The Road", "Post-Apocalyptic Fiction", "Cormac McCarthy");
        bookCollection.addBook("Moby-Dick", "Adventure", "Herman Melville");
        bookCollection.addBook("The Shining", "Horror", "Stephen King");
        bookCollection.addBook("The Bell Jar", "Autobiographical Fiction", "Sylvia Plath");
        bookCollection.addBook("Gone with the Wind", "Historical Fiction", "Margaret Mitchell");
        bookCollection.addBook("The Kite Runner", "Fiction", "Khaled Hosseini");
        bookCollection.addBook("Crime and Punishment", "Psychological Fiction", "Fyodor Dostoevsky");
        bookCollection.addBook("Wuthering Heights", "Gothic Fiction", "Emily Brontë");
        bookCollection.addBook("The Odyssey", "Epic Poetry", "Homer");
        bookCollection.addBook("Lord of the Flies", "Allegorical Novel", "William Golding");
        bookCollection.addBook("Frankenstein", "Gothic Fiction", "Mary Shelley");

    }
    
    
    
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
    private TextField searchTextField;

    @FXML
    private void handleLogoutButtonAction(ActionEvent event) throws IOException {
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

    List<Book> books = bookCollection.searchBooks(searchQuery);
    List<String> resultString = new ArrayList<>();
    for (Book book : books) {
        resultString.add(book.getTitle());
    }

    searchedListView.getItems().setAll(resultString);

    searchedListView.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
        @Override
        public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
            // Find the book object corresponding to the selected title
            Book selectedBook = bookCollection.getBookFromTitle(newValue);
            if (selectedBook != null) {
                // Set the text of currentBookLabel to the string representation of the selected book
                currentBookLabel.setText(selectedBook.toString());
                // Set the currentBook variable to the selected book title
                currentBook = selectedBook.getTitle();
            }
        }
    });
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
    private void handleReturnBookButtonAction(ActionEvent event) {

    }
    @FXML
    public void test() {
        if (currentUser != null) {
            titleLabel.setText(currentUser.getUserName());
        }
    }

    



public void currentUser(User user) {
    this.currentUser = user;
}


public void setBookCollection(BookCollection bookCollection) {
    this.bookCollection = bookCollection;
}

}