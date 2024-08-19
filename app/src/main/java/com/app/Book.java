package com.app;

import java.time.LocalDate;
import java.util.Date;

public class Book {
    private String title;
    private String genre;
    private int book_id;
    private double price;
    private String description;
    private String language;
    private boolean isBorrowed;
    private String isbn;

    private String author;
    private LocalDate publicationDate;

    public Book(int id) {
        this.book_id = id;
    }

    /**
     * Returns a string representation of the object.
     *
     * @return         	the string representation of the object
     */
    /**
     * Returns a string representation of the object.
     *
     * @return         	the string representation of the object
     */
    public String toString() {
        return
                "Title: " + title +
                "\n\nGenre: " + genre +
                "\n\nPrice: " + price +
                "\n\nAuthor: " + author +
                "\n\nPublication Date: " + publicationDate +
                "\n\nBorrowed: " + isBorrowed;

    }


    /**
     * Retrieves the title of the object.
     *
     * @return the title of the object
     */
    public String getTitle() {
        return title;
    }


    /**
     * Sets the title of the object.
     *
     * @param  title  the new title to be set
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * A description of the entire Java function.
     *
     * @return         	description of return value
     */
    public String getGenre() {
        return genre;
    }

    /**
     * Set the genre of the object.
     *
     * @param  genre  the genre to be set
     * @return       void
     */
    public void setGenre(String genre) {
        this.genre = genre;
    }

    /**
     * A description of the entire Java function.
     *
     * @return         	description of return value
     */
    public int getId() {
        return book_id;
    }

    /**
     * Sets the ID of the book.
     *
     * @param  book_id   the ID of the book
     */
    public void setId(int book_id) {
        this.book_id = book_id;
    }

    /**
     * Retrieves the price of the book.
     *
     * @return the price of the book
     */
    public double getPrice() {
        return price;
    }

    /**
     * Sets the price of the book.
     *
     * @param  price  the price to be set
     */
    public void setPrice(double price) {
        this.price = price;
    }

    /**
     * Retrieves the description of the book.
     *
     * @return the description of the book
     */
    public String getDescription() {
        return description;
    }

    /**
     * Sets the description of the book.
     *
     * @param  description  the description to be set
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Retrieves the language of the book.
     *
     * @return the language of the book
     */
    public String getLanguage() {
        return language;
    }

    /**
     * Sets the language of the book.
     *
     * @param  language  the language to be set
     */
    public void setLanguage(String language) {
        this.language = language;
    }

    /**
     * Retrieves the borrowed status of the book.
     *
     * @return the borrowed status of the book
     */
    public boolean isBorrowed() {
        return isBorrowed;
    }

    /**
     * Sets the borrowed status of the book.
     *
     * @param  borrowed  the borrowed status to be set
     */
    public void setBorrowed(boolean borrowed) {
        isBorrowed = borrowed;
    }

    /**
     * Retrieves the ISBN of the book.
     *
     * @return the ISBN of the book
     */
    public String getIsbn() {
        return isbn;
    }

    /**
     * Sets the ISBN of the book.
     *
     * @param  isbn  the ISBN to be set
     */
    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    /**
     * Retrieves the publication date of the book.
     *
     * @return the publication date of the book
     */
    public LocalDate getPublicationDate() {
        return publicationDate;
    }

    /**
     * Sets the publication date of the book.
     *
     * @param  publicationDate  the publication date to be set
     */
    public void setPublicationDate(LocalDate publicationDate) {
        this.publicationDate = publicationDate;
    }

    /**
     * Retrieves the author of the book.
     *
     * @return the author of the book
     */
    public String getAuthor() {
        return  author;
    }

    /**
     * Sets the author of the book.
     *
     * @param  author  the author to be set
     */
    public void setAuthor(String author) {
        this.author = author;
    }


}
