package com.DeckdOut.cardgamehub.ObjectCode;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Class relating to the deck of cards used in the games
 */
public class Deck{
    private ArrayList<Card> deck; //the deck of cards
    private Card flippedCard; //card that is flipped as trump for a round

    /**
     * Constructor
     * Createst the deck that will be played with.
     * Initializes an ArrayList of type Card, as well as creates all Card objects
     */
    public Deck(){
        deck = new ArrayList<>();
        //deal spades cards
        for(int val = 2; val < 15; val++){
                Card card = new Card("Spades", val); 
                deck.add(card);
        }
        //deal diamonds cards
        for(int val = 2; val < 15; val++){
                Card card = new Card("Diamonds", val);
                deck.add(card); 
        }
        //deal hearts cards
        for(int val = 2; val < 15; val++){
                Card card = new Card("Hearts", val);
                deck.add(card);
        }
        //deal clubs cards
        for(int val = 2; val < 15; val++){
                Card card = new Card("Clubs", val);
                deck.add(card);
        }   
    }

    /**
     * Shuffles the deck randomly
     */
    public void shuffle(){
        Collections.shuffle(deck);
    }

    /**
    * Gets the card that is flipped at the end of a euchre deal
    *
    * @return the card that is flipped at the end of a euchre deal
    */
    public Card getFlippedCard() {
        return this.flippedCard;
    }

    /**
     * Deal cards for Spades to a single player
     * Sets the owner of the card and marks the card as being dealt so it cannot be dealt again
     * This should be used 4 times, 1 for each player
     * 
     * @param playerName player variable for the name of the player
     * @return an ArrayList of Card objects, this is the hand of cards the player is dealt
     */
    public ArrayList<Card> spadesDeal(Player playerName){
        ArrayList<Card> hand = new ArrayList<>();
        int cardsDealt = 0;
        int i = 0;

        //Deals first 13 undealt cards to player hand
        while(cardsDealt < 13){
            if(!deck.get(i).getDealt() && deck.get(i).getOwner() == null){
                deck.get(i).setOwner(playerName);
                deck.get(i).setDealt(true);
                hand.add(deck.get(i));
                cardsDealt++;
            }
            i++;
        }
        return hand;
    }

    /**
     * Deal cards for Euchre to all players
     * 
     * @param p1 the first player in a game of euchre (also the user)
     * @param p2 the second player in a game of euchre
     * @param p3 the third player in a game of euchre
     * @param p4 the fourth player in a game of euchre
     * @return an ArrayList of Card objects, this is the hand of cards each player is dealt in 
     * sequential order and the final card is the flipped card (i.e. indexes 0-4 is player1's hand, 
     * indexes 5-9 is player2's hand, indexes 10-14 is player2's hand, indexes 15-19 is player2's 
     * hand, and index 20 is the flipped card)
     */
    public ArrayList<Card> euchreDeal(Player p1, Player p2, Player p3, Player p4){
        ArrayList<Card> hand = new ArrayList<>();
        int cardsDealt = 0;
        int i = 0;
        
        while(cardsDealt < 21){
            //only get cards that do not have owners AND are values of 9 or above
            if(!deck.get(i).getDealt() && deck.get(i).getOwner() == null && (deck.get(i).getCardValue() > 8)){
                //p1 hand not full, give card to hand
                if(p1.getHand().size() < 5) {
                    deck.get(i).setOwner(p1);
                    deck.get(i).setDealt(true);  
                    hand.add(deck.get(i));  
                    cardsDealt++;  
                }
                //p2 hand not full, give card to hand
                if(p2.getHand().size() < 5) {
                    deck.get(i).setOwner(p2);
                    deck.get(i).setDealt(true);
                    hand.add(deck.get(i)); 
                    cardsDealt++;    
                }
                //p3 hand not full, give card to hand
                if(p3.getHand().size() < 5) {
                    deck.get(i).setOwner(p3);
                    deck.get(i).setDealt(true);
                    hand.add(deck.get(i)); 
                    cardsDealt++;    
                }
                //p4 hand not full, give card to hand
                if(p4.getHand().size() < 5) {
                    deck.get(i).setOwner(p4);
                    deck.get(i).setDealt(true);
                    hand.add(deck.get(i)); 
                    cardsDealt++;    
                }
                //all hands full, get last card to be flipped up 
                this.flippedCard = deck.get(i);
                cardsDealt++;
            }
            ++i; 
        }
        //return final hand
        return hand;
    }
    
    /**
     * toString method for Deck object
     * 
     * @return Returns the entire playable deck, i.e. all the cards in the ArrayList
     */
    public String toString(){
        for(int i = 0; i < deck.size(); i++){
            System.out.println(deck.get(i).toString());
        }
        return "";
    }
}
