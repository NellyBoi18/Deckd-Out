package com.DeckdOut.cardgamehub.model;

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
        String suit;
        for(int val = 2; val < 15; val++){
                Card card = new Card("Spades", val); 
                deck.add(card);
        }
        for(int val = 2; val < 15; val++){
                Card card = new Card("Diamonds", val);
                deck.add(card); 
        }
        for(int val = 2; val < 15; val++){
                Card card = new Card("Hearts", val);
                deck.add(card);
        }
        for(int val = 2; val < 15; val++){
                Card card = new Card("Clubs", val);
                deck.add(card);
        }   
    }

    /**
     * Shuffles the deck 
     */
    public void shuffle(){
        Collections.shuffle(deck);
    }

    //getter method for flipped trump card
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
     * Deal cards for Euchre
     */
    /**
     * Deal cards for Euchre to a single player
     * Sets the owner of the card and marks the card as being dealt so it cannot be dealt again
     * This should be used 5 times, 4 for players, 1 for the left over cards
     * 
     * @param playerName player variable for the name of the player
     * @return an ArrayList of Card objects, this is the hand of cards the player is dealt
     */
    public ArrayList<Card> euchreDeal(Player p1, Player p2, Player p3, Player p4){
        ArrayList<Card> hand = new ArrayList<>();
        int cardsDealt = 0;
        int i = 0;
        
        while(cardsDealt < 21){
            if(!deck.get(i).getDealt() && deck.get(i).getOwner() == null && (deck.get(i).getCardValue() > 8)){
                //p1 hand not full, give card to hand
                if(p1.getHand().size() < 5) {
                    deck.get(i).setOwner(p1);
                    deck.get(i).setDealt(true);
                    //p1.getHand().add(deck.get(i));  
                    hand.add(deck.get(i));  
                    cardsDealt++;  
                }
                //p2 hand not full, give card to hand
                if(p2.getHand().size() < 5) {
                    deck.get(i).setOwner(p2);
                    deck.get(i).setDealt(true);
                    //p2.getHand().add(deck.get(i));
                    hand.add(deck.get(i)); 
                    cardsDealt++;    
                }
                //p3 hand not full, give card to hand
                if(p3.getHand().size() < 5) {
                    deck.get(i).setOwner(p3);
                    deck.get(i).setDealt(true);
                    //p3.getHand().add(deck.get(i));
                    hand.add(deck.get(i)); 
                    cardsDealt++;    
                }
                //p4 hand not full, give card to hand
                if(p4.getHand().size() < 5) {
                    deck.get(i).setOwner(p4);
                    deck.get(i).setDealt(true);
                    //p4.getHand().add(deck.get(i));
                    hand.add(deck.get(i)); 
                    cardsDealt++;    
                }
                //all hands full, get last card
                this.flippedCard = deck.get(i);
                cardsDealt++;
            }
            ++i; 
        }





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
