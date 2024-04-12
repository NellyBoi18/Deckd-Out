import java.util.Random;
import java.util.ArrayList;

public class EuchreRound {
    private String declaredTrump; //the string of the suit that is declared to be trump by a player in a round of euchre
    private String flippedTrump; //the string of the suit that is flipped up as trump in a round of euchre
    private int p1EuchreTricks = 0; //number of euchre tricks player 1 wins (the user)
    private int p2EuchreTricks = 0; //number of euchre tricks player 2 wins
    private int p3EuchreTricks = 0; //number of euchre tricks player 3 wins
    private int p4EuchreTricks = 0; //number of euchre tricks player 4 wins
    private String teamPrediction; //which team thinks they will win 3+ tricks
    private int team1EuchreTricks = p1EuchreTricks + p3EuchreTricks; 
    private int team2EuchreTricks = p2EuchreTricks + p4EuchreTricks; 
    //private String trickWinner =  //prediciton of the number of euchre tricks team 1 will win (user's team)
    private Trick[] euchreTrick; //arraylist of cards in a euchre trick 
    private Player euchreStartPlayer; //the starting player of a euchre trick (i.e. the one who leads)
    private Deck deck = new Deck(); //the deck of cards
    private Player p1Euchre, p2Euchre, p3Euchre, p4Euchre; //the 4 different players in the euchre game 
    //private boolean spadesRoundEnd;
    private String EuchreLeadingSuit;
    private boolean goAlone; //whether or not the user/cpu wants to go alone
    private boolean nameSuit; //whether or not the user/cpu wants to name a suit
    private int dealerTracker; //tracks who the dealer is (1 = p1, 2 = p2, 3 = p3, 4 = p4)


    /**
     * Constructor
     * Sets up a round of Euchre by initializing the global fields
     * 
     * @param teamPrediction string variable of which team thinks they will win 3+ tricks
     * @param p1Euchre the 1st player in a game of euchre (this is always the user)
     * @param p2Euchre the 2nd player in a game of euchre (this is a CPU)
     * @param p3Euchre the 3rd player in a game of euchre (this is a CPU)
     * @param p4Euchre the 4th player in a game of euchre (this is a CPU)
     */
    public EuchreRound(String teamPrediction, Player p1Euchre, Player p2Euchre, Player p3Euchre, Player p4Euchre){
        this.teamPrediction = teamPrediction;
        this.p1Euchre = p1Euchre;
        this.p2Euchre = p2Euchre;
        this.p3Euchre = p3Euchre;
        this.p4Euchre = p4Euchre;
        this.euchreTrick = new Trick[4]; //TODO FIX

    }


    /**
     * Method that contains the logic for a trick of Euchre
     * 
     * @param p1EuchreHand the hand of cards of the first player
     * @param p2EuchreHand the hand of cards of the second player
     * @param p3EuchreHand the hand of cards of the third player
     * @param p4EuchreHand the hand of cards of the fourth player
     * @return the winner of the trick
     */
    public Player trickLogicSpades(ArrayList<Card> p1EuchreHand, ArrayList<Card> p2EuchreHand, ArrayList<Card> p3EuchreHand, ArrayList<Card> p4EuchreHand, Player euchreStartPlayer){
        //TODO get cards in trick depending on starting player, remove cards from hand


        //create the trick
        ArrayList<Card> trickCards = new ArrayList<>();
        Trick trick = new Trick(trickCards);

        //get winner of trick
        Card winningCard = trick.winnerOfEuchreTrick();
        if(winningCard.getOwner().equals(p1Euchre)){
            p1EuchreTricks++;
        }
        else if(winningCard.getOwner().equals(p2Euchre)){
            p2EuchreTricks++;
        }
        else if(winningCard.getOwner().equals(p3Euchre)){
            p3EuchreTricks++;
        }
        else{
            p4EuchreTricks++;
        }
        euchreStartPlayer = winningCard.getOwner();
        return euchreStartPlayer;
    }


    /**
     * TODO: THIS WHOLE METHOD
     * Method that performs the logic for a round of Spades
     * 
     * @return array of two ints, representing the scores of team1 and team2 respectively
     */
    public int[] playRoundEuchre(){
        Random rand = new Random();
        int firstPlayer = rand.nextInt(4); //who plays first in the first round
        deck.shuffle();
        
        //deal hands to all players
        ArrayList<Card> p1EuchreHand = deck.spadesDeal(p1Euchre);
        p1Euchre.setHand(p1EuchreHand);
        ArrayList<Card> p2EuchreHand = deck.spadesDeal(p2Euchre);
        p2Euchre.setHand(p2EuchreHand);
        ArrayList<Card> p3EuchreHand = deck.spadesDeal(p3Euchre);
        p3Euchre.setHand(p3EuchreHand);
        ArrayList<Card> p4EuchreHand = deck.spadesDeal(p4Euchre);
        p4Euchre.setHand(p4EuchreHand);

        //NOTES:
        //cpuSuitDecision() eturns an array of 2 strings
        //indes 0: "Yes" or "No" based on if they want to play the flippedTrump
        //index 1: string of suit that player wants to pick, "Pass" if no good suit to pick

        //decide what suit will be
        String[] p1Choice = p1Euchre.getSuitDecision(flippedTrump); //GET FROM FRONTEND
        String[] p2Choice = p2Euchre.cpuSuitDecision(p2Euchre, flippedTrump); 
        String[] p3Choice = p3Euchre.cpuSuitDecision(p3Euchre, flippedTrump); 
        String[] p4Choice = p4Euchre.cpuSuitDecision(p4Euchre, flippedTrump);

        //player1 decides trump first, and they choose to flippedTrump for trump
        if(dealerTracker == 1 && p1Choice[0].equals("Yes")) {
            declaredTrump = flippedTrump; 
        }
        else if(dealerTracker == 1 && p1Choice[0].equals("Yes")) {
            declaredTrump = flippedTrump; 
        }
        else if(dealerTracker == 1 && p1Choice[0].equals("Yes")) {
            declaredTrump = flippedTrump; 
        }
        else if(dealerTracker == 1 && p1Choice[0].equals("Yes")) {
            declaredTrump = flippedTrump; 
        }
        else {

        }
        


        
        //TODO RANDOM NUMBER GENERATOR
        //first trick of a round 
        if(firstPlayer == 0){
            spadesStartPlayer = p1Spades;
            trickLogicSpades(p1SpadesHand, p2SpadesHand, p3SpadesHand, p4SpadesHand, p1Spades);
        }
        else if(firstPlayer == 1){
            spadesStartPlayer = p2Spades;
            trickLogicSpades(p1SpadesHand, p2SpadesHand, p3SpadesHand, p4SpadesHand, p2Spades);
        }
        else if(firstPlayer == 2){
            spadesStartPlayer = p3Spades;
            trickLogicSpades(p1SpadesHand, p2SpadesHand, p3SpadesHand, p4SpadesHand, p3Spades);
        }
        else{
            spadesStartPlayer = p4Spades;
            trickLogicSpades(p1SpadesHand, p2SpadesHand, p3SpadesHand, p4SpadesHand, p4Spades);
        }

        //the rest of the spadesTrick of a round
        for(int i = 0; i < 12; i++){
            trickLogicSpades(p1SpadesHand, p2SpadesHand, p3SpadesHand, p4SpadesHand, spadesStartPlayer);
        }
        
        //calculate scores after all rounds
        int team1Pts = pointCalc(p1SpadesTricks, p3SpadesTricks, team1SpadesPred, team1SpadesOvrTricks, "team1");
        int team2Pts = pointCalc(p2SpadesTricks, p4SpadesTricks, team2SpadesPred, team2SpadesOvrTricks, "team2");
        int[] roundPoints = new int[]{team1Pts, team2Pts};

        //return the array of team 1 and 2 points earned in a round
        return roundPoints;
    }





}
