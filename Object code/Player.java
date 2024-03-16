import java.util.ArrayList;

public class Player {

    private string userName;
    //private int orderVal;
    //private boolean wonTrick;
    private int bid;
    private ArrayList<Card> hand;

    /**
     * Constructor, sets the name and bid
     */
    public Player(String userName) {
        this.userName = userName;
        
    }

    /**
     * Returns 
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

    public void setBid(int bid) {
        this.bid = bid;
    }

    public int getBid(){
        return bid;
    }

    public void setHand(ArrayList<Card> Hand){
        this.hand = hand;
    }

    public ArrayList<Card> getHand(){
        return hand;
    }

    public void removePlayedCard(Card playedCard){
        hand.remove(playedCard);
    }
    
    /*
    //SCOPE UP
    public void sortHand(Stirng username) {

    }

    private void 
    */



}