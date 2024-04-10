import java.util.ArrayList;

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
     * Determines the card that wins trick
     * 
     * @return the card that wins the trick
     */
    public Card winnerOfTrick(){
        return cardCompareSpades(leadingSuit, trickCards);
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
    //Card card1, Card card2, Card card3, Card card4
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
