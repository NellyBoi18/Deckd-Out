package com.DeckdOut.cardgamehub.ObjectCode;

import java.util.ArrayList;

/**
 * Figure which player goes first
 * Figure what is the leading suit
 * Figure what card wins trick
 * Figure which team wins trick and gets point
 */
public class Trick {
    private String leadingSuit; //the suit of the first card deal in a trick
    private String trump; //the trump suit
    private Card winningCard; //the card that wins a trick
    private ArrayList<Card> trickCards; //cards that are played in the trick, from first played to last played
    private Player winningPlayer; //the player who wins the trick 

    /**
     * Constructor 
     * Sets up trick in a game of Spades
     * 
     * @param leadingSuit string variable of the leading suit in a trick of Spades
     */
    public Trick(ArrayList<Card> trickCards) {
        this.leadingSuit = trickCards.get(0).getSuit();
        this.trickCards = trickCards;
    }

    /**
     * Determines the card that wins the spades trick
     * 
     * @return the card that wins the trick
     */
    public Card winnerOfTrick(){
        return cardCompareSpades(leadingSuit, trickCards);
    }

    /**
     * Determines the card that wins the euchre trick
     * 
     * @return the card that wins the trick
     */
    public Card winnerOfEuchreTrick(String trump1){
        return cardCompareEuchre(leadingSuit, trickCards, trump1);
    }


    /**
     * Compares the played cards in a trick based on the suit first, then the value of the card.
     * For Euchre game only
     * 
     * @param leadingSuit string variable of the leading suit played
     * @param euchreTrickCards ArrayList variable of Card objects of the played cards in the trick
     * @param trump the suit that is trump
     * @return the card the wins the trick
     */
    public Card cardCompareEuchre(String leadingSuit, ArrayList<Card> euchreTrickCards, String trump){
        Card winningCard = null;
        Card highestTrump = new Card("Spades", 0);
        Card highestLeadingSuit = new Card("Spades", 0);

        for (Card card : euchreTrickCards) {
            //right bower wins
            if(card.equals(new Card(trump, 11))) {
                winningCard = card;
            }
            //else left bower wins
            else if (card.equals(new Card(leftBowerSuit(trump), 11))) {
                winningCard = card;
            }
            //else highest trump wins
            else if(card.getSuit().equals(trump)) {
                for (Card card2 : euchreTrickCards) {
                    if(card2.getCardValue() > highestTrump.getCardValue()) {
                        highestLeadingSuit = card2;
                    }
                }
                return highestTrump; 
            }
            //else highest leading suit wins
            else {
                for (Card card1 : euchreTrickCards) {
                    if(card1.getCardValue() > highestLeadingSuit.getCardValue()) {
                        highestLeadingSuit = card1;
                    }
                }
                return highestLeadingSuit; 
            }
        }
        return winningCard;
    }


    /**
     * Method that gets the suit of the left (worse) bower
     * 
     * @param trump the suit that is trump
     * @return the string representation of the suit of the left bower
     */ 
    public String leftBowerSuit(String trump) {
        if(trump.equals("Spades")) {
            return "Clubs";
        }
        if(trump.equals("Clubs")) {
            return "Spades";
        }
        if(trump.equals("Diamonds")) {
            return "Hearts";
        }
        else {
            return "Diamonds";    
        }
    }

    /**
     * Gets the winning player of the trick
     * 
     * @return the wining player of the trick
     */
    public Player getWinningPlayer() {
        return winningPlayer;
    }

    /**
     * Compares the played cards in a trick based on the suit first, then the value of the card.
     * For Spades game only
     * 
     * @param leadingSuit string variable of the leading suit played
     * @param trickCards ArrayList variable of Card objects of the played cards in the trick
     * @return the card the wins the trick
     */
    public Card cardCompareSpades(String leadingSuit, ArrayList<Card> trickCards){
        boolean spadePresent = false;
        Card highestCard = null;
        int maxCardVal = 0;
        for(int i = 0; i < 4; i++){
            if(trickCards.get(i).getSuit().equals("Spades")){
                spadePresent = true;
            }
        }

        if(spadePresent){
            for(int i = 0; i < 4; i++){
                if(trickCards.get(i).getSuit().equals("Spades")){
                    if(maxCardVal < trickCards.get(i).getCardValue()){
                        maxCardVal = trickCards.get(i).getCardValue();
                        highestCard = trickCards.get(i);
                    }
                }
            }
            return highestCard;
        }
        else{
            for(int i = 0; i < 4; i++){
                if(trickCards.get(i).getSuit().equals(leadingSuit)){
                    if(maxCardVal < trickCards.get(i).getCardValue()){
                        maxCardVal = trickCards.get(i).getCardValue();
                        highestCard = trickCards.get(i);
                    }
                }
            }
            return highestCard;
        }
    }
}
