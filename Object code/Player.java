//TODO ADD LOGIC TO PREVENT ILLEGAL MOVE


import java.util.ArrayList;

/**
 * Class pertaining to the player including information such as username, bid, and hand.
 */
public class Player {
    private String userName; //username of the player (NOTE: GET FROM FRONTEND --> HOW? TODO change to FROM daatbase
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

    /**
     * Returns the card that the user chooses to play (Note: card FROM frontend)
     * 
     * @param card the card that is picked by the player (from frontend)
     * @return the card object that the user has picked
     */
    //THIS METHOD NEEDS TO BE IN FRONTEND, NOT IN BACKEND
    public Card pickCard(Player player) {
        return cardFromFrontend;
    }

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
    public String getuserName(){
        return userName;
    }


    /**
     * Method that checks if a player has at least 1 trump card in their hand
     * 
     * @param hand the player's hand of cards
     * @param trump the string of the suit that is trump in the round
     * @return true is the user has at least 1 trump card in their hand, false otherwise
     */  
    public boolean hasTrump(ArrayList<Card> hand, String trump) {
        for(Card card : hand) {
            if(card.getSuit().equals(trump)) {
                return true;
            }
        }
        return false;
    }


    //HEAD LEADING SUIT METHOD -- NOT USED RN
    public boolean hasLeadingSuit(ArrayList<Card> hand, String leadingSuit) {
        for(Card card : hand) {
            if(card.getSuit().equals(leadingSuit)) {
                return true;
            }
        }
        return false;
    }


    //Gets the highest value card in a player's hand that isn't trump
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

    //get low norm
    public Card getLowNorm(Player player, String trump) {
        int min = 0;
        Card finalCard = new Card("Diamonds", 1);
        for(Card card : player.getHand()) {
            if(card.getCardValue() <= min && !card.getSuit().equals(trump)) {
                min = card.getCardValue();
                finalCard = card;
            }
        }
        return finalCard;
    }
 
    //number of trump cards in hand (in this case it is spades)
    public int numTrump(Player player, String trump) {
        int counter = 0;
        for(Card card: player.getHand()) {
            if(card.getSuit().equals(trump)) {
                counter += 1;
            }
        }
        return counter;
    }


    //does this card exist in hand?
    public boolean containsCard(Card card, Player player) {
        for(Card card1 : player.getHand()) {
            if(card1.equals(card)) {
                return true;
            }
        }
        return false;
    }

    //does an ace card exist in hand?
    public boolean containsNormAce(Player player, String trump) {
        for(Card card1 : player.getHand()) {
            if(card1.getCardValue() == 14 && !card1.getSuit().equals(trump)) {
                return true;
            }
        }
        return false;
    }




    //get high card of a suit (doesn't handle case of no suit)
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

    //get low card of a suit (doesn't handle case of no suit)
    public Card getLowSuit(Player player, String suit) {
        int min = 0;
        Card finalCard = new Card(suit, 14);
        for(Card card1 : player.getHand()) {
            if(card1.getCardValue() <= min && card1.getSuit().equals(suit)) {
                min = card1.getCardValue();
                finalCard = card1;
            }
        }
        return finalCard;
    }
    

    //returns true if player has 1 or more of the suit given, and false otherwise
    public boolean hasGivenSuit(Player player, String suit) {
        for(Card card : player.getHand()) {
            if(card.getSuit().equals(suit)) {
                return true;
            }
        }
        return false;
    }


    //returns true if player has the specificed card
    public boolean hasGivenCard(Player player, String suit, int cardVal) {
        for(Card card : player.getHand()) {
            if(card.getSuit().equals(suit) && card.getCardValue() == cardVal) {
                return true;
            }
        }
        return false;
    }


    //returns the number of cards that a player has of the specified value of any suit that is not spades
    public int numNonTrumpVals(Player player, int cardVal, String trump) {
        int counter = 0;
        for(Card card : player.getHand()) {
            if(!card.getSuit().equals(trump) && card.getCardValue() == cardVal) {
                counter ++;
            }
        }
        return counter;
    }


    //returns the number of cards that a player has of the specified value of any suit that is not spades
    public int numVals(Player player, int cardVal) {
        int counter = 0;
        for(Card card : player.getHand()) {
            if(card.getCardValue() == cardVal) {
                counter ++;
            }
        }
        return counter;
    }

    //check for better bower (right bower)
    public boolean hasRightBower(Player player, String trump) {
        for(Card card : player.getHand()) {
            if(card.getSuit().equals(trump) && card.getCardValue() == 11) {
                return true;
            }
        }
        return false;
    }

    //check for worse bower (left bower)
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

    //get left bower suit
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

    //get the suits that are not trump
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


    



  
  

    //logic for CPU picking a card to play in a trick
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



    //logic for CPU choosing a reasonable bid
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



    //returns an array of 2 strings
    //indes 0: "Yes" or "No" based on if they want to play the flippedTrump
    //index 1: string of suit that player wants to pick, "Pass" if no good suit to pick
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


    //choose whether or not to play
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
