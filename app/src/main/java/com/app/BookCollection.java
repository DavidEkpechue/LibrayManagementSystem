package com.app;

import java.util.ArrayList;
import java.util.Comparator;

public class BookCollection {

    // ArrayList to store books
    private ArrayList<Book> books;
    // Name of the book collection
    private String collectionName;

    /**
     * Constructor to initialize the book collection with a name.
     *
     * @param collectionName The name of the book collection.
     */
    public BookCollection(String collectionName) {
        // Set the name of the book collection
        this.collectionName = collectionName;
        // Initialize the ArrayList to store books
        this.books = new ArrayList<>();
    }

    /**
     * Getter method to retrieve the name of the book collection.
     *
     * @return The name of the book collection.
     */
    public String getName() {
        // Returns the name of the book collection
        return collectionName;
    }

    /**
     * Setter method to set the name of the book collection.
     *
     * @param name The name of the book collection to be set.
     */
    public void setName(String name) {
        // Sets the name of the book collection
        this.collectionName = name;
    }

    /**
     * Adds a new book to the collection.
     *
     * @param title The title of the book.
     * @param genre The genre of the book.
     * @param id The ID of the book.
     */
    public void addBook(String title, String genre, int id) {
        // Create a new book object
        Book newBook = new Book(id);
        // Set the title and genre of the book
        newBook.setGenre(genre);
        newBook.setTitle(title);
        // Add the new book to the collection
        books.add(newBook);
    }

    /**
     * Retrieves a book from the collection based on its title.
     *
     * @param title The title of the book to search for.
     * @return The Book object if found, or null if not found.
     */
    public Book getBookFromTitle(String title) {
        // Iterate through each book in the collection
        for (Book book : books) {
            // Check if the book's title matches the given title (case-insensitive)
            if (book.getTitle() != null && book.getTitle().equalsIgnoreCase(title)) {
                return book; // Return the found book
            }
        }
        return null; // Return null if the book is not found
    }

    /**
     * Retrieves a book from the collection based on its ID.
     *
     * @param id The ID of the book to search for.
     * @return The Book object if found, or null if not found.
     */
    public Book getBookFromId(int id) {
        // Iterate through each book in the collection
        // Check if the book's ID matches the given ID
        // If a match is found, return the book
        // If no match is found, return null
        for (Book book : books) {
            if (book.getId() == id) {
                return book;
            }
        }
        return null;
    }
    

    /**
     * Removes a book from the collection by its ID.
     *
     * @param  id  the ID of the book to remove
     *
     * This method retrieves a book from the collection based on its ID
     * using the getBookFromId() method. If a book with the given ID is found,
     * it is removed from the collection using the remove() method of the ArrayList.
     */
    public void removeBook(int id) {
        // Retrieve the book with the given ID
        Book bookToRemove = getBookFromId(id);

        // Check if a book with the given ID exists in the collection
        if (bookToRemove != null) {
            // Remove the book from the collection
            books.remove(bookToRemove);
        }

    }

    /**
     * Prints the details of all books in the collection.
     * If the collection is empty, it prints a message indicating so.
     */
    public void printBookDetails() {
        // Check if the collection is empty
        if (books.isEmpty()) {
            // Print a message indicating that there are no books in the collection
            System.out.println("No books in the collection.");
            return;
        }

        // Print a message indicating that book details will be printed
        System.out.println("Book details in the collection '" + collectionName + "':");

        // Iterate through each book in the collection
        for (Book book : books) {
            // Print the details of the current book
            System.out.println(String.format("Title: %s, Genre: %s, ID: %d", book.getTitle(), book.getGenre(), book.getId()));
        }
    }

    /**
     * Retrieves the total number of books in the collection.
     *
     * @return The total number of books in the collection.
     */
    public int getBookCount() {
        // Returns the size of the ArrayList of books, which represents the total number of books in the collection.
        return books.size();
    }


    /**
     * Checks if the collection is empty.
     *
     * This method checks if the collection of books is empty.
     *
     * @return true if the collection is empty, false otherwise.
     */
    public boolean isEmpty() {
        // Check if the ArrayList of books is empty.
        // The isEmpty() method of ArrayList returns true if the ArrayList is empty,
        // and false otherwise.
        return books.isEmpty();
    }

    /**
     * Clears the collection and removes all books.
     *
     * This method removes all the books from the collection, effectively
     * emptying the collection. It is used to reset the collection to
     * an empty state.
     */
    public void clear() {
        // Clear the ArrayList of books to remove all books from the collection
        books.clear();
    }

    // Method to sort the books in the collection by title
    public void sortByTitle() {
        books.sort(Comparator.comparing(Book::getTitle));
    }

    // Method to sort the books in the collection by author
    public void sortByAuthor() {
        books.sort(Comparator.comparing(Book::getAuthor));
    }

    // Method to sort the books in the collection by genre
    public void sortByGenre() {
        books.sort(Comparator.comparing(Book::getGenre));
    }

    /**
     * Searches for books in the collection based on a keyword.
     *
     * @param keyword The keyword to search for.
     * @return An ArrayList containing the search results.
     */
    public ArrayList<Book> searchBooks(String keyword) {
        // Create an ArrayList to store the search results
        ArrayList<Book> searchResults = new ArrayList<>();

        // Convert the keyword to lowercase to perform case-insensitive comparison
        String lowerCaseKeyword = keyword.toLowerCase();

        // Iterate through each book in the collection
        for (Book book : books) {
            // Check if the lowercase title, author, or genre of the book contains the lowercase keyword

            // Convert the title, author, and genre of the book to lowercase
            String lowerCaseTitle = book.getTitle().toLowerCase();
            String lowerCaseAuthor = book.getAuthor().toLowerCase();
            String lowerCaseGenre = book.getGenre().toLowerCase();

            // Check if any of the lowercase attributes contain the lowercase keyword
            if (lowerCaseTitle.contains(lowerCaseKeyword) ||
                    lowerCaseAuthor.contains(lowerCaseKeyword) ||
                    lowerCaseGenre.contains(lowerCaseKeyword)) {
                // If the book matches the search criteria, add it to the searchResults ArrayList
                searchResults.add(book);
            }
        }

        // Return the ArrayList containing the search results
        return searchResults;
    }


    /**
     * Reserve a book by its ID.
     *
     * @param id The ID of the book to be reserved.
     */
    public void reserveBook(int id) {
        // Get the book with the given ID
        Book book = getBookFromId(id);

        // Check if the book exists and is not currently borrowed
        if (book != null && !book.isBorrowed()) {
            // Set the book to a reserved state
            book.setBorrowed(true);
        }
    }


    /**
     * Return a borrowed book by its ID.
     *
     * This method gets a book with the given ID and checks if it is borrowed. If it is, the book is set to a non-borrowed state.
     *
     * @param id The ID of the book to be returned.
     */
    public void returnBook(int id) {
        // Get the book with the given ID
        Book book = getBookFromId(id);

        // Check if the book exists and is currently borrowed
        if (book != null && book.isBorrowed()) {
            // Set the book to a non-borrowed state
            book.setBorrowed(false);
        }
}

}
