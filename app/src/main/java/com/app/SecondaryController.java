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

    public SecondaryController() {

        // Initialize the book collection
        bookCollection = new BookCollection("Library");
    
        // Add sample books to the collection
        bookCollection.addBook("To Kill a Mockingbird", "Fiction", "Harper Lee", 12.99, LocalDate.of(1960, 7, 11), "A Pulitzer Prize-winning novel set in the American South during the Great Depression.", "English");
        bookCollection.addBook("1984", "Science Fiction", "George Orwell", 10.99, LocalDate.of(1949, 6, 8), "A dystopian novel portraying a totalitarian regime and surveillance state.", "English");
        bookCollection.addBook("The Great Gatsby", "Fiction", "F. Scott Fitzgerald", 11.99, LocalDate.of(1925, 4, 10), "A classic American novel exploring themes of wealth, love, and the American Dream.", "English");
        bookCollection.addBook("Pride and Prejudice", "Romance", "Jane Austen", 9.99, LocalDate.of(1813, 1, 28), "A romantic comedy of manners set in early 19th-century England.", "English");
        bookCollection.addBook("Harry Potter and the Philosopher's Stone", "Fantasy", "J.K. Rowling", 14.99, LocalDate.of(1997, 6, 26), "The first book in the Harry Potter series, following the journey of a young wizard.", "English");
        bookCollection.addBook("The Catcher in the Rye", "Fiction", "J.D. Salinger", 10.49, LocalDate.of(1951, 7, 16), "A coming-of-age novel narrated by a teenager struggling with adolescence and society.", "English");
        bookCollection.addBook("The Hobbit", "Fantasy", "J.R.R. Tolkien", 13.49, LocalDate.of(1937, 9, 21), "A fantasy novel following the journey of Bilbo Baggins as he sets out on an adventure.", "English");
        bookCollection.addBook("Jane Eyre", "Gothic Fiction", "Charlotte Brontë", 8.99, LocalDate.of(1847, 10, 16), "A classic novel telling the story of an orphaned governess and her tumultuous love life.", "English");
        bookCollection.addBook("The Da Vinci Code", "Thriller", "Dan Brown", 11.99, LocalDate.of(2003, 3, 18), "A mystery thriller following symbologist Robert Langdon as he investigates a murder in the Louvre.", "English");
        bookCollection.addBook("The Alchemist", "Fiction", "Paulo Coelho", 9.49, LocalDate.of(1988, 8, 17), "A philosophical novel about a shepherd named Santiago on a journey to find his personal legend.", "English");
        bookCollection.addBook("Les Misérables", "Historical Fiction", "Victor Hugo", 12.99, LocalDate.of(1862, 3, 15), "An epic historical novel set in early 19th-century France, following the lives of several characters.", "French");
        bookCollection.addBook("Don Quixote", "Adventure", "Miguel de Cervantes", 10.99, LocalDate.of(1605, 1, 16), "A satirical novel about an elderly knight who sets out on a quest to revive chivalry.", "Spanish");
        bookCollection.addBook("Anna Karenina", "Fiction", "Leo Tolstoy", 11.49, LocalDate.of(1877, 8, 19), "A tragic novel depicting the lives of Russian aristocrats, particularly the affair between Anna and Count Vronsky.", "Russian");
        bookCollection.addBook("Moby-Dick", "Adventure", "Herman Melville", 11.99, LocalDate.of(1851, 10, 18), "A novel depicting Captain Ahab's obsessive quest for revenge on the white whale Moby Dick.", "English");
        bookCollection.addBook("The Lord of the Rings", "Fantasy", "J.R.R. Tolkien", 17.99, LocalDate.of(1954, 7, 29), "A high-fantasy epic following the journey to destroy the One Ring and defeat the Dark Lord Sauron.", "English");
        bookCollection.addBook("War and Peace", "Historical Fiction", "Leo Tolstoy", 13.99, LocalDate.of(1869, 1, 13), "An epic novel set during the Napoleonic Wars, exploring themes of love, war, and destiny.", "Russian");
        bookCollection.addBook("The Picture of Dorian Gray", "Gothic Fiction", "Oscar Wilde", 9.49, LocalDate.of(1890, 7, 20), "A philosophical novel about a young man whose portrait ages while he remains young and handsome.", "English");
        bookCollection.addBook("Frankenstein", "Gothic Fiction", "Mary Shelley", 8.99, LocalDate.of(1818, 1, 1), "A classic novel depicting the scientist Victor Frankenstein and the creature he brings to life.", "English");
        bookCollection.addBook("One Hundred Years of Solitude", "Magical Realism", "Gabriel García Márquez", 12.49, LocalDate.of(1967, 5, 30), "A novel following the Buendía family through several generations in the fictional town of Macondo.", "Spanish");
        bookCollection.addBook("The Odyssey", "Epic Poetry", "Homer", 10.99, LocalDate.of(-800, 1, 1), "An epic poem attributed to Homer, telling the story of Odysseus's journey home after the Trojan War.", "Ancient Greek");
        bookCollection.addBook("Crime and Punishment", "Psychological Fiction", "Fyodor Dostoevsky", 11.49, LocalDate.of(1866, 1, 1), "A psychological novel exploring themes of morality, guilt, and redemption through the story of Raskolnikov.", "Russian");
        bookCollection.addBook("The Brothers Karamazov", "Philosophical Fiction", "Fyodor Dostoevsky", 11.99, LocalDate.of(1880, 1, 1), "A philosophical novel delving into themes of faith, reason, and morality through the lives of the Karamazov brothers.", "Russian");
        bookCollection.addBook("The Count of Monte Cristo", "Adventure", "Alexandre Dumas", 10.99, LocalDate.of(1844, 1, 28), "An adventure novel following the journey of Edmond Dantès, who seeks revenge against those who wronged him.", "French");
        bookCollection.addBook("The Road", "Post-Apocalyptic Fiction", "Cormac McCarthy", 10.99, LocalDate.of(2006, 9, 26), "A post-apocalyptic novel following a father and son's journey through a burned America.", "English");
        bookCollection.addBook("The Hitchhiker's Guide to the Galaxy", "Science Fiction", "Douglas Adams", 9.99, LocalDate.of(1979, 10, 12), "A comedic science fiction series following the adventures of Arthur Dent and his alien friend Ford Prefect.", "English");
        bookCollection.addBook("The Bell Jar", "Autobiographical Fiction", "Sylvia Plath", 8.49, LocalDate.of(1963, 1, 14), "A semi-autobiographical novel detailing a young woman's descent into mental illness.", "English");
        bookCollection.addBook("Wuthering Heights", "Gothic Fiction", "Emily Brontë", 8.99, LocalDate.of(1847, 12, 19), "A Gothic novel exploring themes of love, revenge, and social class on the Yorkshire moors.", "English");
        bookCollection.addBook("Slaughterhouse-Five", "Satirical Science Fiction", "Kurt Vonnegut", 11.49, LocalDate.of(1969, 3, 31), "A satirical novel depicting the experiences of Billy Pilgrim, a soldier who becomes 'unstuck in time.'", "English");
        bookCollection.addBook("The Handmaid's Tale", "Dystopian Fiction", "Margaret Atwood", 12.49, LocalDate.of(1985, 6, 14), "A dystopian novel set in a totalitarian society where women are oppressed and used for reproductive purposes.", "English");
        bookCollection.addBook("The Kite Runner", "Historical Fiction", "Khaled Hosseini", 10.99, LocalDate.of(2003, 5, 29), "A novel following the friendship between Amir, a wealthy Pashtun boy, and Hassan, a Hazara servant's son, set in Afghanistan.", "English");
        bookCollection.addBook("Norwegian Wood", "Coming-of-Age Fiction", "Haruki Murakami", 11.99, LocalDate.of(1987, 9, 1), "A coming-of-age novel set in 1960s Tokyo, exploring themes of love, loss, and mental health.", "Japanese");
        bookCollection.addBook("The Shadow of the Wind", "Historical Mystery", "Carlos Ruiz Zafón", 12.49, LocalDate.of(2001, 1, 1), "A mystery novel set in post-war Barcelona, following a young boy's discovery of a mysterious book.", "Spanish");
        bookCollection.addBook("The Name of the Wind", "Fantasy", "Patrick Rothfuss", 13.49, LocalDate.of(2007, 3, 27), "The first book in the Kingkiller Chronicle series, narrating the life story of Kvothe, a legendary figure.", "English");
        bookCollection.addBook("The Holy Bible (King James Version)", "Religious Text", "Various Authors", 0.00, LocalDate.of(1611, 1, 1), "The King James Version (KJV) of the Bible, a translation into English by the Church of England.", "English");

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
    private Label descriptionLabel;

  

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
                System.out.println(selectedBook.getDescription());
                descriptionLabel.setText(selectedBook.getDescription());
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
private void handleBorrowBookButtonAction(ActionEvent event) {
    Book selectedBook = bookCollection.getBookFromTitle(currentBook);
    if (selectedBook != null) {
        selectedBook.setBorrowed(true);
        currentUser.borrowBook(selectedBook);
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

    



public void currentUser(User user) {
    this.currentUser = user;
}


public void setBookCollection(BookCollection bookCollection) {
    this.bookCollection = bookCollection;
}

}