package com.DeckdOut.cardgamehub.ObjectCode;

import java.util.ArrayList;

/**
 * Class pertaining to the player including information such as username, bid, and hand.
 */
public class Player {
    private String userName; //username of the player
    private int bid; // how many tricks the player thinks they will win in a round 
    private ArrayList<Card> hand; // the player's hand of cards

    /**
     * Constructor, sets the name of the player
     * 
     * @param userName the String username of the player
     */
    public Player(String userName) {
        this.userName = userName; 
    }

    // /**
    //  * Returns the card that the user chooses to play (Note: card FROM frontend)
    //  * 
    //  * @param card the card that is picked by the player (from frontend)
    //  * @return the card object that the user has picked
    //  */
    // //THIS METHOD NEEDS TO BE IN FRONTEND, NOT IN BACKEND
    // public Card pickCard(Player player) {
    //     return cardFromFrontend;
    // }

    /**
     * Setter method for the bid of the player
     * This sets the bid of the player to be whatever is passed
     * 
     * @param bid the amount of tricks that the player predicts they will win
     */ 
    public void setBid(int bid) {
        this.bid = bid;
    }

    /**
     * Getter method for the bid of the player
     * This gets the bid of the player to be whatever is passed
     * 
     * @return return the amount of tricks that the player predicts they will win
     */ 
    public int getBid(){
        return bid;
    }

    /**
     * Setter method for the hand of the player
     * This sets which cards are in the user's hand
     * 
     * @param hand the list of cards that a user has in their hand
     */ 
    public void setHand(ArrayList<Card> hand){
        this.hand = hand;
    }

    /**
     * Getter method for the hand of the player
     * This gets which cards are in the user's hand
     * 
     * @return the list of cards that a user has in their hand
     */  
    public ArrayList<Card> getHand(){
        return hand;
    }

    /**
     * This removes a single card from the users hand; the card that is removed is given by the parameter
     * 
     * @param playedCard the card that will be removed from the player's hand; also the card that has been played
     */ 
    public void removePlayedCard(Card playedCard) {
        hand.remove(playedCard);
    }

    /**
     * Getter method for the username of the player
     * 
     * @return the username (in string format) of the player
     */  
    //NOTE: GET FROM DATABASE
    public String getuserName(){
        return userName;
    }


    /**
     * Method that checks if a player has at least 1 trump card in their hand
     * 
     * @param hand the player's hand of cards
     * @param trump the string of the suit that is trump in the round
     * @return true is the user has at least 1 trump card in their hand, and false otherwise
     */  
    public boolean hasTrump(ArrayList<Card> hand, String trump) {
        for(Card card : hand) {
            if(card.getSuit().equals(trump)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Method that checks if a player has at least 1 card of the leading suit in their hand
     * 
     * @param hand the player's hand of cards
     * @param leadingSuit the string of the suit that the leading suit in a round
     * @return true is the user has at least 1 card of the leading suit in their hand, and
     * false otherwise
     */  
    public boolean hasLeadingSuit(ArrayList<Card> hand, String leadingSuit) {
        for(Card card : hand) {
            if(card.getSuit().equals(leadingSuit)) {
                return true;
            }
        }
        return false;
    }


    /**
     * Method that gets the highest value card in a player's hand that isn't trump
     * 
     * @param player the player in question
     * @param trump the string of the suit that is trump
     * @return the card that has the highest value that is also not in the trump suit
     */ 
    public Card getHighNorm(Player player, String trump) {
        int max = 0;
        Card finalCard = new Card("Diamonds", 14);
        for(Card card : player.getHand()) {
            if(card.getCardValue() >= max && !card.getSuit().equals(trump)) {
                max = card.getCardValue();
                finalCard = card;
            }
        }
        return finalCard;
    }

    /**
     * Method that gets the lowest value card in a player's hand that isn't trump
     * 
     * @param player the player in question
     * @param trump the string of the suit that is trump
     * @return the card that has the lowest value that is also not in the trump suit
     */ 
    public Card getLowNorm(Player player, String trump) {
        int min = 14;
        Card finalCard = new Card("Diamonds", 1);
        for(Card card : player.getHand()) {
            if(card.getCardValue() <= min && !card.getSuit().equals(trump)) {
                min = card.getCardValue();
                finalCard = card;
            }
        }
        return finalCard;
    }
 
    /**
     * Method that returns the number of trump cards in a pleyer's hand
     * 
     * @param player the player in question
     * @param trump the string of the suit that is trump
     * @return the number of cards in the player's hand that are in the trump suit
     */ 
    public int numTrump(Player player, String trump) {
        int counter = 0;
        for(Card card: player.getHand()) {
            if(card.getSuit().equals(trump)) {
                counter += 1;
            }
        }
        return counter;
    }

    /**
     * Method that searches through a players hand and checks if a given card is in it
     * 
     * @param card the card that will be looked for in the player's hand
     * @param player the player in question
     * @return true if the player's hand contains the given card, and false otherwise
     */ 
    public boolean containsCard(Card card, Player player) {
        for(Card card1 : player.getHand()) {
            if(card1.equals(card)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Method that checks if a player's hand contains an ace card of a non-trump suit
     * 
     * @param player the player in question
     * @param trump the string of the suit that is trump
     * @return true if the player's hand contains an ace card of a non-trump suit, 
     * and false otherwise
     */
    public boolean containsNormAce(Player player, String trump) {
        for(Card card1 : player.getHand()) {
            if(card1.getCardValue() == 14 && !card1.getSuit().equals(trump)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Method that gets the highest card in a player's hand of a given suit
     * 
     * @param player the player in question
     * @param suit the string of the given suit 
     * @return the card of the highest value in a given suit in a player's hand
     */
    public Card getHighSuit(Player player, String suit) {
        int max = 0;
        Card finalCard = new Card(suit, 14);
        for(Card card1 : player.getHand()) {
            if(card1.getCardValue() >= max && card1.getSuit().equals(suit)) {
                max = card1.getCardValue();
                finalCard = card1;
            }
        }
        return finalCard;
    }

    /**
     * Method that gets the lowest card in a player's hand of a given suit
     * 
     * @param player the player in question
     * @param suit the string of the given suit 
     * @return the card of the lowest value in a given suit in a player's hand
     */
    public Card getLowSuit(Player player, String suit) {
        int min = 14;
        Card finalCard = new Card(suit, 14);
        for(Card card1 : player.getHand()) {
            if(card1.getCardValue() <= min && card1.getSuit().equals(suit)) {
                min = card1.getCardValue();
                finalCard = card1;
            }
        }
        return finalCard;
    }
    
    /**
     * Method checks if a player has 1 or more of a given suit 
     * 
     * @param player the player in question
     * @param suit the string of the given suit 
     * @return true if the player has 1 or more of the suit given, and false otherwise
     */
    public boolean hasGivenSuit(Player player, String suit) {
        for(Card card : player.getHand()) {
            if(card.getSuit().equals(suit)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Method that searches through a players hand and checks if a given card is in it
     * 
     * @param player the player in question
     * @param suit the suit of the card that will be looked for in the player's hand
     * @param cardVal the value of the card in question
     * @return true if the player's hand contains the given card, and false otherwise
     */ 
    public boolean hasGivenCard(Player player, String suit, int cardVal) {
        for(Card card : player.getHand()) {
            if(card.getSuit().equals(suit) && card.getCardValue() == cardVal) {
                return true;
            }
        }
        return false;
    }

    /**
     * Method that gets the number of cards that a player has of the specified value
     * of any suit that is not in the trump suit
     * 
     * @param player the player in question
     * @param cardVal the value of the card in question
     * @param trump the suit that is trump
     * @return the number of cards that a player has of the specified value of any suit that
     * is not in the trump suit
     */ 
    public int numNonTrumpVals(Player player, int cardVal, String trump) {
        int counter = 0;
        for(Card card : player.getHand()) {
            if(!card.getSuit().equals(trump) && card.getCardValue() == cardVal) {
                counter ++;
            }
        }
        return counter;
    }

    /**
     * Method that gets the number of cards that a player has of the specified value
     * of any suit that is not in the trump suit
     * 
     * @param player the player in question
     * @param cardVal the value of the card in question
     * @return the number of cards that a player has of the specified value
     */ 
    public int numVals(Player player, int cardVal) {
        int counter = 0;
        for(Card card : player.getHand()) {
            if(card.getCardValue() == cardVal) {
                counter ++;
            }
        }
        return counter;
    }

    /**
     * Method that checks if a player has the right (better) bower in their hand
     * 
     * @param player the player in question
     * @param trump the suit that is trump
     * @return true if a player has the right (better) bower in their hand, and false otherwise
     */ 
    public boolean hasRightBower(Player player, String trump) {
        for(Card card : player.getHand()) {
            if(card.getSuit().equals(trump) && card.getCardValue() == 11) {
                return true;
            }
        }
        return false;
    }

    /**
     * Method that checks if a player has the left (worse) bower in their hand
     * 
     * @param player the player in question
     * @param trump the suit that is trump
     * @return true if a player has the left (worse) bower in their hand, and false otherwise
     */ 
    public boolean hasLeftBower(Player player, String trump) {
        //get left bower suit
        String complimentSuit = getLeftBowerSuit(trump);
        for(Card card : player.getHand()) {
            if(card.getSuit().equals(complimentSuit) && card.getCardValue() == 11) {
                return true;
            }
        }
        return false;
    }

    /**
     * Method that gets the suit of the left (better) bower
     * 
     * @param trump the suit that is trump
     * @return string representing the suit of the left bower given the trump suit
     */ 
    public String getLeftBowerSuit(String trump) {
        String complimentSuit = "";
        if(trump.equals("Spades")) {
            complimentSuit = "Clubs";
        }
        if(trump.equals("Clubs")) {
            complimentSuit = "Spades";
        }
        if(trump.equals("Hearts")) {
            complimentSuit = "Diamonds";
        }
        if(trump.equals("Diamonds")) {
            complimentSuit = "Hearts";
        }
        return complimentSuit;
    }

    /**
     * Method that gets all of the suits that are not trump
     * 
     * @param trump the suit that is trump
     * @return array of strings containing all of them suits that are not trump given trump
     */ 
    public String[] getNonTrumpSuits(String trump) {
        String[] finalArr = new String[3];
        if(trump.equals("Spades")) {
            finalArr[0] = "Clubs";
            finalArr[1] = "Hearts";
            finalArr[3] = "Diamonds";
            return finalArr;
        }
        else if(trump.equals("Clubs")) {
            finalArr[0] = "Spades";
            finalArr[1] = "Hearts";
            finalArr[3] = "Diamonds";
            return finalArr;
        }
        else if(trump.equals("Hearts")) {
            finalArr[0] = "Clubs";
            finalArr[1] = "Spades";
            finalArr[3] = "Diamonds";
            return finalArr;
        }
        else {
            finalArr[0] = "Clubs";
            finalArr[1] = "Hearts";
            finalArr[3] = "Spades";
            return finalArr;
        }     
    }

    /**
     * Method that picks the correct card to play for the CPU (card picking logic)
     * 
     * @param cpu the player 
     * @param leadingSuit the leading suit in a trick
     * @param startPlayer the starting player of a trick
     * @return the card that the CPU will choose to play 
     */ 
    public Card cpuChooseCardSpades(Player cpu, String leadingSuit, Player startPlayer) {
        ArrayList<Card> cpuHand = cpu.getHand();

        //case where 1 card is left --> play it
        if(cpuHand.size() == 1) {
            return cpuHand.getFirst();
        }

        //Now we know CPU has 2+ cards

        //CPU has lead --> any card is playable 
        if(startPlayer.equals(cpu)) {
            //case1: play non-trump ace 
            for(Card aceCard : cpuHand) {
                if(aceCard.getCardValue() == 14 && !aceCard.isSpade()) {
                    return aceCard;
                }
            }

            //case2: play low spades if have 5+
            if(numTrump(cpu, "Spades") >= 5) {
                return getLowSuit(cpu, "Spades");
            }

            //case4: play highest spade
            if(numTrump(cpu, "Spades") >= 1) {
                return getHighSuit(cpu, "Spades");
            }

            //case5: play highest non-trump 
            return getHighNorm(cpu, "Spades");
        }

        //CPU doesn't have lead
        else {
            //start player has leading suit --> play highest card of leading suit (NOTE: IGNORING PARTNER -- can scope up)
            if(hasGivenSuit(cpu, leadingSuit)) {
                return getHighSuit(cpu, leadingSuit);
            }
            //CPU doesn't have leading suit 
            else {
                //case1: play highest trump (can scope up)
                if(hasTrump(cpuHand, "Spades")) {
                    return getHighSuit(cpu, "Spades");
                }

                //case2: play lowest non-trump and non-suit
                return getLowNorm(cpu, "Spades");
            }
        }
        //return null;
    }



    /**
     * Method chooses the most reasonable bid to place (FOR CPUs)
     * 
     * @param cpu the player 
     * @return the number of tricks that the player will predict they will win given their hand
     */ 
    public int cpuChooseBid(Player cpu) {
        int finalBid = 1;
        ArrayList<Card> cpuHand = cpu.getHand();
        //guarantueed tricks are non-trump aces, royal trumps
        //probably tricks are non-trump royals
        
        //add any non-trump aces the user has as predicted tricks
        finalBid += numNonTrumpVals(cpu, 14, "Spades");

        //add any royal trump
        for(Card card : cpuHand) {
            //add jack of spades as predicted tricks
            if(card.isSpade() && card.getCardValue() == 11) {
                finalBid ++;
            }
            //add queen of spades as predicted tricks
            if(card.isSpade() && card.getCardValue() == 12) {
                finalBid ++;
            }
            //add king of spades as predicted tricks
            if(card.isSpade() && card.getCardValue() == 13) {
                finalBid ++;
            }
            //add ace of spades as predicted tricks
            if(card.isSpade() && card.getCardValue() == 14) {
                finalBid ++;
            }
        }

        //add 1 trick for any number of non-trump jack-king cards
        Card highestNorm = getHighNorm(cpu, "Spades");
        if(highestNorm.getCardValue() > 10 && highestNorm.getCardValue() != 14) {
            finalBid++;
        }
        return finalBid;
    }

    /**
     * Method chooses the most reasonable suit to pick as trump given the player's hand
     * 
     * @param cpu the player 
     * @param flippedTrump the suit that is flipped up as trump after a euchre deal
     * @return an array of two strings, where the first one is either "Yes" if the player
     * wants to play the flippedTrump, and "No" otherwise. The second string in the array 
     * is either the string of the suit the player will pick to play as trump, or "Pass" if 
     * there is not a good enough suit to pick and they hope to pass the round instead
     */ 
    public String[] cpuSuitDecision(Player cpu, String flippedTrump) {
        String[] returnVals = new String[2];
        returnVals[0] = ""; //to avoid null exceptions
        returnVals[1] = ""; //to avoid null exceptions
        ArrayList<Card> cpuHand = cpu.getHand();

        //want to play flipped trump
        if(playDecision(cpu, flippedTrump)) {
            returnVals[0] = "Yes";
            returnVals[1] = "Pass";
            return returnVals;
        }
        else { //don't want to play flipped trump
            //get nontrump suits
            String[] suits = getNonTrumpSuits(flippedTrump);
            //decide if want to play non-flipped trump
            for(String suit : suits) {
                if(playDecision(cpu, suit)) {
                    returnVals[0] = "No";
                    returnVals[1] = suit;
                    return returnVals; 
                }
            }
            //don't want to play flipped trump and don't want to name trump
            returnVals[0] = "No";
            returnVals[1] = "Pass";
            return returnVals;
        }
    }

    /**
     * Method that checks if the user wants to play the given trump given their hand
     * 
     * @param cpu the player 
     * @param trump the suit that is trump
     * @return true if the player wants to play the given trump, and false otherwise
     */ 
    public boolean playDecision(Player cpu, String trump) {
        ArrayList <Card> cpuHand = cpu.getHand();
        
        //when to play:
        //both bowers
        if(hasLeftBower(cpu, trump) && hasRightBower(cpu, trump)) {
            return true;
        }
        //4+ trump 
        else if(numTrump(cpu, trump) >= 4) {
            return true;
        }
        //3+ aces 
        else if(numVals(cpu, 14) >= 3) {
            return true;
        }
        //right bauer + 2+ trump
        else if(hasRightBower(cpu, trump) && numTrump(cpu, trump) >= 2) {
            return true;
        }
        //right bauer + 1+ trump + 1+ aces
        else if(hasRightBower(cpu, trump) && numTrump(cpu, trump) >=1 && numVals(cpu, 14) >= 1) {
            return true;
        }
        //2+ aces + trump 3+ 
        else if(numVals(cpu, 14) >= 2 && numTrump(cpu, trump) >= 3) {
            return true;
        }
        //left bauer + 2+ trump
        else if(hasLeftBower(cpu, trump) && numTrump(cpu, trump) >= 2) {
            return true;
        }
        //left bauer + 1+ ace + king trump
        else if(hasLeftBower(cpu, trump) && numNonTrumpVals(cpu, 14, trump) >= 1 && hasGivenCard(cpu, trump, 13)) {
            return true;
        }
        //left bauer + 1+ ace + queen trump
        else if(hasLeftBower(cpu, trump) && numNonTrumpVals(cpu, 14, trump) >= 1 && hasGivenCard(cpu, trump, 12)) {
            return true;
        }
        else {
            return false;
        }
    }
}
