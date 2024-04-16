package com.DeckdOut.cardgamehub.model;

import jakarta.persistence.*;

/**
 * Represents a test user entity in the card game hub application.
 */
@Entity
public class User {
    /**
     * The unique identifier of the user.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    /**
     * The username of the user.
     */
    private String username;

    /**
     * The email of the user.
     */
    private String email;

    /**
     * The password of the user.
     */
    private String password;

    /**
     * The number of spades game the user has played
     */
    private int spadesNumGames;

    /**
     * The number of spades game the user has won
     */
    private int spadesGamesWon;

    /**
     * The number of euchre game the user has played
     */
    private int euchreNumGames;

    /**
     * The number of euchre game the user has won
     */
    private int euchreGamesWon;

    /**
     * Constructs a new User object with default values.
     */
    public User() {
    }

    /**
     * Retrieves the unique identifier of the user.
     *
     * @return The unique identifier of the user.
     */
    public int getId() {
        return id;
    }

    // /**
    //  * Sets the unique identifier of the user.
    //  *
    //  * @param id The unique identifier to set.
    //  */
    // public void setId(int id) {
    //     this.id = id;
    // }

    /**
     * Retrieves the username of the user.
     *
     * @return The username of the user.
     */
    public String getUsername() {
        return username;
    }

    /**
     * Sets the username of the user.
     *
     * @param username The username to set.
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * Retrieves the email of the user.
     *
     * @return The email of the user.
     */
    public String getEmail() {
        return email;
    }

    /**
     * Sets the email of the user.
     *
     * @param email The email to set.
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Retrieves the password of the user.
     *
     * @return The password of the user.
     */
    public String getPassword() {
        return password;
    }

    /**
     * Sets the password of the user.
     *
     * @param password The password to set.
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Retrieves the number of spades games the user has played.
     *
     * @return The number of spades games the user has played.
     */
    public int getSpadesNumGames() {
        return spadesNumGames;
    }

    /**
     * Sets the number of spades games the user has played.
     *
     * @param spadesNumGames The number of spades games to set.
     */
    public void setSpadesNumGames(int spadesNumGames) {
        this.spadesNumGames = spadesNumGames;
    }

    /**
     * Retrieves the number of spades games the user has won.
     *
     * @return The number of spades games the user has won.
     */
    public int getSpadesGamesWon() {
        return spadesGamesWon;
    }

    /**
     * Sets the number of spades games the user has won.
     *
     * @param spadesNumGames The number of spades game wins to set.
     */
    public void setSpadesGamesWon(int spadesGamesWon) {
        this.spadesGamesWon = spadesGamesWon;
    }

    /**
     * Retrieves the number of spades games the user has played.
     *
     * @return The number of spades games the user has played.
     */
    public int getEuchreNumGames() {
        return euchreNumGames;
    }

    /**
     * Sets the number of spades games the user has played.
     *
     * @param spadesNumGames The number of spades games to set.
     */
    public void setEuchreNumGames(int euchreNumGames) {
        this.euchreNumGames = euchreNumGames;
    }

    /**
     * Retrieves the number of spades games the user has won.
     *
     * @return The number of spades games the user has won.
     */
    public int getEuchreGamesWon() {
        return euchreGamesWon;
    }

    /**
     * Sets the number of spades games the user has won.
     *
     * @param spadesNumGames The number of spades game wins to set.
     */
    public void setEuchreGamesWon(int euchreGamesWon) {
        this.euchreGamesWon = euchreGamesWon;
    }


}
