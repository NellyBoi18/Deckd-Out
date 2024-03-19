import java.util.ArrayList;
import java.util.Collections;

public class Deck{
    private ArrayList<Card> deck; //the deck of cards

    /**
     * Constructor
     * Createst the deck that will be played with.
     * Initializes an ArrayList of type Card, as well as creates all Card objects
     */
    public Deck(){
        deck = new ArrayList<>();
        String suit;
        for(int val = 1; val < 14; val++){
                suit = "Spades";
                Card card = new Card(suit, val);
                deck.add(card);
        }
        for(int val = 1; val < 14; val++){
                suit = "Diamonds";
                Card card = new Card(suit, val);
                deck.add(card); 
        }
        for(int val = 1; val < 14; val++){
                suit = "Hearts";
                Card card = new Card(suit, val);
                deck.add(card);
        }
        for(int val = 1; val < 14; val++){
                suit = "Clubs";
                Card card = new Card(suit, val);
                deck.add(card);
        }   
    }

    /**
     * Shuffles the deck 
     */
    public void shuffle(){
        Collections.shuffle(deck);
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
    public ArrayList<Card> euchreDeal(Player playerName){
        ArrayList<Card> hand = new ArrayList<>();
        int cardsDealt = 0;
        int i = 0;

        //Deals 5 undealt cards to player hand
        while(cardsDealt < 5){
            if(!deck.get(i).getDealt() && deck.get(i).getOwner() == null && (deck.get(i).getCardValue() > 8 || deck.get(i).getCardValue() == 1)){
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

    //TODO
    public Card cardCompareEuchre(){
        return null;
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
