package com.DeckdOut.cardgamehub.model;

import jakarta.persistence.*;

/**
 * Represents a card entity in the card game hub application.
 */
@Entity(name="card")
public class Card {
    /**
     * The unique identifier of the card.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    /**
     * The suit of the card.
     */
    @Column(nullable = false, length = 50)
    private String suit;

    /**
     * The value of the card.
     */
    @Column(nullable = false)
    private int value;

    /**
     * The player that owns the card
     */
    @Column(nullable = false, length = 50)
    private String owner;

    /**
     * Constructs a new Card object with default values.
     */
    public Card() {
    }

    /**
     * Retrieves the unique identifier of the Card.
     *
     * @return The unique identifier of the Card.
     */
    public int getId() {
        return id;
    }

    /**
     * Retrieves the suit of the card.
     *
     * @return The suit of the card.
     */
    public String getSuit() {
        return suit;
    }

    /**
     * Sets the suit of the card.
     *
     * @param suit The suit to suit.
     */
    public void setSuit(String suit) {
        this.suit = suit;
    }

    /**
     * Retrieves the value of the card.
     *
     * @return The value of the card.
     */
    public int getValue() {
        return value;
    }

    /**
     * Sets the value of the card.
     *
     * @param value The value to card.
     */
    public void setValue(int value) {
        this.value = value;
    }

    /**
     * Retrieves the owner of the card.
     *
     * @return The owner of the card.
     */
    public String getOwner() {
        return owner;
    }

    /**
     * Sets the owner of the card.
     *
     * @param owner The owner of the card.
     */
    public void setOwner(String owner) {
        this.owner = owner;
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
