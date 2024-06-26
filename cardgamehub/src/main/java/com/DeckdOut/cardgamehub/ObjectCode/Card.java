package com.DeckdOut.cardgamehub.ObjectCode;

/**
 * Stores the card suit, card value, card owner, and if the card is dealt
 */
public class Card{
    private String suit; //suit of the card 
    private int cardValue; //value of the card, 11-J, 12-Q, 13-K, 14-Ace
    private Player owner; //owner of the card ie who's hand the card came from
    private boolean dealt; //if the card has been dealt to a player

    /**
     * Class constructor
     * Creates card with private values for suit, card value, and card owner
     * 
     * @param suit string variable for the card suit
     * @param cardValue integer variable of the card value 11-J, 12-Q, 13-K
     * @param owner player variable for the card owner
     */
    public Card(String suit, int cardValue, Player owner){
        this.suit = suit;
        this.cardValue = cardValue;
        this.owner = owner;
    }

    /**
     * Class constructor
     * Creates card with private values for suit and card value
     * This is usually used to create a deack, but the cards are not dealt to players
     * 
     * @param suit string variable for the card suit
     * @param value integer variable for the card value 11-J, 12-Q, 13-K
     */
    public Card(String suit, int value){
        this.suit = suit;
        this.cardValue = value;
    }

    /**
     * Setter method for the card owner
     * This is for when the card is dealt to a player
     * 
     * @param owner player variable for the player name
     */
    public void setOwner(Player owner){
        this.owner = owner;
    }

    /**
     * Setter method for the card dealt status
     * Set true if the card is dealt to a player
     * 
     * @param dealt boolean variable for the card dealt status
     */
    public void setDealt(boolean dealt){
        this.dealt = dealt;
    }

    /**
     * Getter method for the card dealt status
     * 
     * @return true if card is dealt, false if not
     */
    public boolean getDealt(){
        return dealt;
    }
    /**
     * Getter method for suit
     * 
     * @return string of the card suit
     */
    public String getSuit(){
        return suit;
    }

    /**
     * Getter method for card value
     * 
     * @return integer of the card value 11-J, 12-Q, 13-K, 14-Ace
     */
    public int getCardValue(){
        return cardValue;
    }
    
    /**
     * Getter method for owner
     * 
     * @return player of the owner of the card
     */
    public Player getOwner(){
        return owner;
    }

    /**
     * Returns if the given card is spades
     * 
     * @return true if the card is a spade, and false if not
     */
    public boolean isSpade(){
        return suit.equals("Spades");
    }

    /**
     * toString method for Card object
     * 
     * @return the Suit, Value, and Owner of the card
     */
    public String toString(){
        //Jack
        if(cardValue == 11){
            return "Suit: " + suit + " | Value: Jack" + " | Owner: " + owner.getuserName() + " | Dealt: " + dealt;
        }
        //Queen
        if(cardValue == 12){
            return "Suit: " + suit + " | Value: Queen" + " | Owner: " + owner.getuserName() + " | Dealt: " + dealt;
        }
        //King
        if(cardValue == 13){
            return "Suit: " + suit + " | Value: King" + " | Owner: " + owner.getuserName() + " | Dealt: " + dealt;
        }
        //Ace
        if(cardValue == 14){
            return "Suit: " + suit + " | Value: Ace" + " | Owner: " + owner.getuserName() + " | Dealt: " + dealt;
        }
        //Number Cards
        else{
            return "Suit: " + suit + " | Value: " + cardValue + " | Owner: " + owner.getuserName() + " | Dealt: " + dealt;
        }
    }
}
