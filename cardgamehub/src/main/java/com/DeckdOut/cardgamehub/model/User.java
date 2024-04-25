package com.DeckdOut.cardgamehub.model;

import jakarta.persistence.*;

/**
 * Represents a user entity in the card game hub application.
 */
@Entity(name="user")
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
    @Column(nullable = false, length=50)
    private String username;

    /**
     * The email of the user.
     */
    @Column(nullable = false, length=50)
    private String email;

    /**
     * The password of the user.
     */
    @Column(nullable = false)
    private String password;

    /**
     * The number of spades games the user has played.
     */
    @Column(nullable = true)
    private int spadesNumGames;

    /**
     * The number of spades games the user has won.
     */
    @Column(nullable = true)
    private int spadesGamesWon;

    /**
     * The number of euchre games the user has played.
     */
    @Column(nullable = true)
    private int euchreNumGames;

    /**
     * The number of euchre games the user has won.
     */
    @Column(nullable = true)
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
     * Retrieves the number of euchre games the user has played.
     *
     * @return The number of euchre games the user has played.
     */
    public int getEuchreNumGames() {
        return euchreNumGames;
    }

    /**
     * Sets the number of euchre games the user has played.
     *
     * @param euchreNumGames The number of euchre games to set.
     */
    public void setEuchreNumGames(int euchreNumGames) {
        this.euchreNumGames = euchreNumGames;
    }

    /**
     * Retrieves the number of euchre games the user has won.
     *
     * @return The number of euchre games the user has won.
     */
    public int getEuchreGamesWon() {
        return euchreGamesWon;
    }

    /**
     * Sets the number of euchre games the user has won.
     *
     * @param euchreNumGames The number of euchre game wins to set.
     */
    public void setEuchreGamesWon(int euchreGamesWon) {
        this.euchreGamesWon = euchreGamesWon;
    }
}
