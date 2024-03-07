/**
 * Figure which player goes first
 * Figure what is the leading suit
 * Figure what card wins trick
 * Figure which team wins trick and gets point
 */
public class Trick{
    private String leadingSuit; //the suit of the first card deal in a trick
    private String trumpSuit; //the trump suit
    private Card winningCard; //the card that wins a trick
    private ArrayList<Card> trickCards; //cards that are played in the trick, from first played to last played
    private String winningPlayer; 

    /**
     * Constructor 
     * Sets up trick in a game of Spades
     * 
     * @param leadingSuit string variable of the leading suit in a trick of Spades
     */
    public Trick(ArrayList<Card> trickCards){
        this.leadingSuit = trickCards.get(1).getSuit;
        this.trickCards = trickCards;
    }

    /**
     * Determines the card that wins trick
     * 
     * @return the card that wins the trick
     */
    public Card winnerOfTrick(){
        return cardCompareSpades(leadingSuit, trickCards);
    }

    
}
