package com.DeckdOut.cardgamehub.model;

import jakarta.persistence.*;

public class User {
    /**
     * The unique identifier of the user.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int userId;

    /**
     * The name of the user.
     */
    private String userName;

    /**
     * The level of the user.
     */
    private String password;

    /**
     * Constructs a new User object with default values.
     */
    public User() {
    }

    /**
     * Retrieves the unique identifier of the test user.
     *
     * @return The unique identifier of the test user.
     */
    public int getUserId() {
        return userId;
    }

    /**
     * Sets the unique identifier of the test user.
     *
     * @param id The unique identifier to set.
     */
    public void setUserId(int userId) {
        this.userId = userId;
    }

    /**
     * Retrieves the name of the test user.
     *
     * @return The name of the test user.
     */
    public String getUserName() {
        return userName;
    }

    /**
     * Sets the name of the test user.
     *
     * @param name The name to set.
     */
    public void setName(String username) {
        this.userName = username;
    }

    public String getPassword() {
        return userName;
    }

    /**
     * Sets the name of the test user.
     *
     * @param name The name to set.
     */
    public void setPassword(String username) {
        this.userName = username;
    }


}
