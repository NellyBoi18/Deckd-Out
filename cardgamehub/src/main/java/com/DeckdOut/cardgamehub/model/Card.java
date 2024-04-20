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
     * The card is dealt to player
     */
    @Column(nullable = false)
    private boolean dealt;

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
     * @param suit The suit of the card.
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
     * @param value The value of the card.
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
     * Retrieves the card dealt status
     * 
     * @return The boolean of card dealt status
     */
    public boolean getDealt(){
        return dealt;
    }

    /**
     * Sets the card dealt status
     * 
     * @param dealt The card dealt status
     */
    public void setDealt(boolean dealt){
        this.dealt = dealt;
    }

    /**
     * Determines if card is spades
     * 
     * @return true if the card is spades, false if not
     */
    public boolean isSpade(){
        return suit.equals("Spades");
    }
}
