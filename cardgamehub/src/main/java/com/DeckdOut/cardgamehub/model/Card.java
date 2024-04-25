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
    private int cardValue;

    /**
     * The player that owns the card
     */
    @Column(nullable = false, length = 50)
    private Player owner;

    /**
     * The card is dealt to player
     */
    @Column(nullable = false)
    private boolean dealt;

    /**
     * Constructs a new Card object with default values.
     */
//    public Card(String suit, int cardValue) {
//        this.suit = suit;
//        this.cardValue = cardValue;
//    }

    /**
     * Constructs a new Card object with default values.
     */
//    public Card(String suit, int cardValue, Player owner){
//        this.suit = suit;
//        this.cardValue = cardValue;
//        this.owner = owner;
//
//    }

    public Card(){
        
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
    public int getCardValue() {
        return cardValue;
    }

    /**
     * Sets the value of the card.
     *
     * @param value The value of the card.
     */
    public void setCardValue(int value) {
        this.cardValue = value;
    }

    /**
     * Retrieves the owner of the card.
     *
     * @return The owner of the card.
     */
    public Player getOwner() {
        return owner;
    }

    /**
     * Sets the owner of the card.
     *
     * @param owner The owner of the card.
     */
    public void setOwner(Player owner) {
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

    /**
     * toString method for Card object
     * 
     * @return the Suit, Value, and Owner of the card;
     */
    public String toString(){
        if(cardValue == 11){
            return "Suit: " + suit + " | Value: Jack" + " | Owner: " + owner.getuserName() + " | Dealt: " + dealt;
        }
        if(cardValue == 12){
            return "Suit: " + suit + " | Value: Queen" + " | Owner: " + owner.getuserName() + " | Dealt: " + dealt;
        }
        if(cardValue == 13){
            return "Suit: " + suit + " | Value: King" + " | Owner: " + owner.getuserName() + " | Dealt: " + dealt;
        }
        if(cardValue == 14){
            return "Suit: " + suit + " | Value: Ace" + " | Owner: " + owner.getuserName() + " | Dealt: " + dealt;
        }
        else{
            return "Suit: " + suit + " | Value: " + cardValue + " | Owner: " + owner.getuserName() + " | Dealt: " + dealt;
        }
    }
}
