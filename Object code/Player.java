import java.util.ArrayList;

/**
 * Class pertaining to the player including information such as username, bid, and hand.
 */
public class Player {
    private String userName; //username of the player (NOTE: GET FROM FRONTEND --> HOW?)
    private int bid; // how many tricks the player thinks they will win in a round 
    private ArrayList<Card> hand; // the player's hand of cards

    /**
     * Constructor, sets the name of the player
     */
    public Player(String userName) {
        this.userName = userName;
        
    }

    /**
     * Returns the card that the user chooses to play (Note: card from frontend)
     * 
     * @param card the card that is picked by the player (from frontend)
     * @return the card object that the user has picked
     */ 
    public Card pickCard(Card card) {
        /*
        for(int i = 0; i < 13; i++){
            if(hand.get(i).equals(card)){
                break;
            }
            if(i == 12 && !hand.get(i).equals(card)){
                
            }
        }
        */
       return card;
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
     * @param return the amount of tricks that the player predicts they will win
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
     * @param return the list of cards that a user has in their hand
     */  
    public ArrayList<Card> getHand(){
        return hand;
    }

    /**
     * This removes a single card from the users hand; the card that is removed is given by the parameter
     * 
     * @param playedCard the card that will be removed from the player's hand; also the card that has been played
     */ 
    public void removePlayedCard(Card playedCard){
        hand.remove(playedCard);
    }
    
    /*
    //SCOPE UP -- QOL Change
    public void sortHand(ArrayList<Card> hand) { }
    */

    /**
     * Getter method for the username of the player
     * 
     * @param return the username (in string format) of the player
     */  
    public String getuserName(){
        return userName;
    }


}
