package com.app;
import java.util.ArrayList;

public class User {
    private String password;
    private String userName;
    private final int userID;
    private boolean isLoggedIn;
    private ArrayList<Book> booksBorrowed;

        /**
     * Constructs a User object with the given password, userName, userID, isLoggedIn status, and booksBorrowed ArrayList.
     *
     * @param  password        The password of the User object.
     * @param  userName        The userName of the User object.
     * @param  userID          The userID of the User object.
     * @param  isLoggedIn      Whether the User object is logged in or not.
     * @param  booksBorrowed   The booksBorrowed ArrayList of the User object.
     */
    public User(String password, String userName, int userID) {
        this.password = password;
        this.userName = userName;
        this.userID = userID;
        this.isLoggedIn = false;
        this.booksBorrowed = new ArrayList<Book>();
    }


    /**
     * Returns a string representation of the User object,
     * including the password, userName, userID, isLoggedIn status,
     * and the booksBorrowed ArrayList.
     *
     * @return A string representation of the User object.
     */
    @Override
    public String toString() {
        return  "password='" + password +
                "\nuserName=" + userName +
                "\nuserID=" + userID +
                "\nisLoggedIn=" + isLoggedIn +
                "\nbooksBorrowed=" + booksBorrowed;
    }

    /**
     * Returns the password of the User object.
     *
     * @return The password of the User object.
     */
    public String getPassword() {
        return password;
    }

    /**
     * Sets the password of the User object to the given password.
     *
     * @param  password The password to set the User object to.
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Returns the userName of the User object.
     *
     * @return The userName of the User object.
     */
    public String getUserName() {
        return userName;
    }

    /**
     * Sets the userName of the User object to the given userName.
     *
     * @param  userName The userName to set the User object to.
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }

    /**
     * Returns the userID of the User object.
     *
     * @return The userID of the User object.
     */
    public int getUserID() {
        return userID;
    }


    /**
     * Returns whether the User object is logged in or not.
     *
     * @return Whether the User object is logged in or not.
     */
    public boolean isLoggedIn() {
        return isLoggedIn;
    }

    /**
     * Sets the loggedIn status of the User object to the given loggedIn status.
     *
     * @param  loggedIn The loggedIn status to set the User object to.
     */
    public void setLoggedIn(boolean loggedIn) {
        isLoggedIn = loggedIn;
    }

    /**
     * Returns the booksBorrowed ArrayList of the User object.
     *
     * @return The booksBorrowed ArrayList of the User object.
     */
    public ArrayList<Book> getBooksBorrowed() {
        return booksBorrowed;
    }

    /**
     * Sets the booksBorrowed ArrayList of the User object to the given booksBorrowed ArrayList.
     *
     * @param  booksBorrowed The booksBorrowed ArrayList to set the User object to.
     */
    public void setBooksBorrowed(ArrayList<Book> booksBorrowed) {
        this.booksBorrowed = booksBorrowed;
    }




}
