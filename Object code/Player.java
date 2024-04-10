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





    //HASTRUMP METHOD
    public boolean hasTrump(ArrayList<Card> hand) {
        for(Card card : hand) {
            if(card.getSuit().equals("Spades")) {
                return true;
            }
        }
        return false;
    }


    //HEAD LEADING SUIT METHOD
    public boolean hasLeadingSuit(ArrayList<Card> hand, String leadingSuit) {
        for(Card card : hand) {
            if(card.getSuit().equals(leadingSuit)) {
                return true;
            }
        }
        return false;
    }





    /*
    //SCOPE UP -- QOL Change
    public void sortHand(ArrayList<Card> hand) { }
    */

}
