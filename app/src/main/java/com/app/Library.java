package com.app;

public class Library {

    private Book book;

    public Library() {
        // Initialize the book
        book = new Book(1);
        book.setTitle("Initial Book Title");
    }

    // Method to set the title of the book
    public void setBookTitle(String newTitle) {
        book.setTitle(newTitle);
    }

    // Method to get the title of the book
    public String getBookTitle() {
        return book.getTitle();
    }
}
