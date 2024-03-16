import java.util.Random;

public class Round {
    private int p1Bid, p2Bid, p3Bid, p4Bid; //prediction of the number of traick a player will win
    private int p1PT = 0; //point tracker for players
    private int p2PT = 0; //point tracker for players
    private int p3PT = 0; //point tracker for players
    private int p4PT = 0; //point tracker for players
    private int team1Pred = p1Bid + p3Bid; //prediciton of the number of tricks team 1 will win
    private int team2Pred = p2Bid + p4Bid; //prediction of the number of tricks team 2 will win 
    private String player1, player2, player3, player4;
    private Trick[] tricks;
    private String startPlayer;
    private Deck deck = new Deck();
    private Player p1, p2, p3, p4;


    /**
     * Constructor
     * Sets up a round of Spades
     * 
     * @param team1Pred integer variable of number of tricks the first team will win
     * @param team2Pred integer variable of number of tricks the second team will win
     * @param player1 string variable of the name of player 1
     * @param player2 string variable of the name of player 2
     * @param player3 string variable of the name of player 3
     * @param player4 string variable of the name of player 4
     */
    public Round(int team1Pred, int team2Pred, String player1, String player2, String player3, String player4){
        this.team1Pred = team1Pred;
        this.team2Pred = team2Pred;
        this.player1 = player1;
        this.player2 = player2;
        this.player3 = player3;
        this.player4 = player4;
        this.tricks = new Trick[13];

    }

    /**
     * Method that contains the logic for a trick of Spades
     */
    public void trickLogicSpades(ArrayList<Card> p1Hand, ArrayList<Card> p2Hand, ArrayList<Card> p3Hand, ArrayList<Card> p4Hand){
        ArrayList<Card> trickCards;
        //TODO:
        //Player method to play card in order.
        //determine order of cards played
        //Need a method to loop from 4th player to 1st player ie something like p2 -> p3 -> p4 -> p1
        //add cards to trickCards arraylist

        //trickCards.add(p1.pickCard(card))
        //p1.removePlayedCard(card);
        //trickCards.add(p2.pickCard(card))
        //p2.removePlayedCard(card);
        //trickCards.add(p3.pickCard(card))
        //p3.removePlayedCard(card);
        //trickCards.add(p4.pickCard(card))
        //p4.removePlayedCard(card);

        Trick trick = new Trick(trickCards);
        Card winningCard = trick.winnerOfTrick();
        if(winnerCard.getOwner.equals(player1)){
            p1PT++;
        }
        else if(winnerCard.getOwner.equals(player2)){
            p2PT++;
        }
        else if(winnerCard.getOnwer.equals(player3)){
            p3PT++;
        }
        else{
            p4PT++;
        }
        startPlayer = winningCard.getOwner;
    }

    /**
     * Method that performs the logic for a round of Spades
     */
    public int[] playRoundSpades(){
        Random rand = new Random();
        int firstPlayer = rand.nextInt(4); //who plays first in a round
        deck.shuffle();
        
        ArrayList<Card> p1Hand = deck.spadesDeal(player1)
        p1.setHand(p1Hand);
        ArrayList<Card> p2Hand = deck.spadesDeal(player2)
        p2.setHand(p2Hand);
        ArrayList<Card> p3Hand = deck.spadesDeal(player3)
        p3.setHand(p3Hand);
        ArrayList<Card> p4Hand = deck.spadesDeal(player4)
        p4.setHand(p4Hand);
        
        //first trick of a round 
        if(firstPlayer == 0){
            startPlayer = player1;
            trickLogicSpades(p1Hand, p2Hand, p3Hand, p4Hand);
        }
        else if(firstPlayer == 1){
            startPlayer = player2;
            trickLogicSpades(p1Hand, p2Hand, p3Hand, p4Hand);
        }
        else if(firstPlayer == 2){
            startPlayer = player3;
            trickLogicSpades(p1Hand, p2Hand, p3Hand, p4Hand);
        }
        else{
            startPlayer = player4;
            trickLogicSpades(p1Hand, p2Hand, p3Hand, p4Hand);
        }

        //the rest of the tricks of a round
        for(int i = 0; i < 12; i++){
            trickLogicSpades(p1Hand, p2Hand, p3Hand, p4Hand);
        }

        int team1PT = p1PT + p3PT;
        int team2PT = p2PT + p4PT; 


    }

    /**
     * Method that calculates the points a team earns after a round of Spades
     * 
     */
    public int pointCalc(int team1PT, int team2PT, int team1Pred, int team2Pred){

    }
}
