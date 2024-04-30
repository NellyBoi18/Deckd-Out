package com.DeckdOut.cardgamehub.ObjectCode;

import java.util.Random;
import java.util.ArrayList;

/**
 * Class for an entire euchre game
 */
public class EuchreRound {

    private String declaredTrump; //the string of the suit that is declared to be trump by a player in a round of euchre
    private String flippedTrump; //the string of the suit that is flipped up as trump in a round of euchre
    private Card flippedCard; //the card that is flipped after dealing a euchre hand
    private int p1EuchreTricks = 0; //number of euchre tricks player 1 wins (the user)
    private int p2EuchreTricks = 0; //number of euchre tricks player 2 wins
    private int p3EuchreTricks = 0; //number of euchre tricks player 3 wins
    private int p4EuchreTricks = 0; //number of euchre tricks player 4 wins
    private String teamPrediction; //which team thinks they will win 3+ tricks
    private int team1EuchreTricks = p1EuchreTricks + p3EuchreTricks; //total euchre tricks won for team1
    private int team2EuchreTricks = p2EuchreTricks + p4EuchreTricks; //total euchre tricks won for team2
    //private String trickWinner =  //prediciton of the number of euchre tricks team 1 will win (user's team)
    private Trick[] euchreTrick; //arraylist of cards in a euchre trick 
    private Player euchreStartPlayer; //the starting player of a euchre trick (i.e. the one who leads)
    private Deck deck = new Deck(); //the deck of cards
    private Player p1Euchre, p2Euchre, p3Euchre, p4Euchre; //the 4 different players in the euchre game
    private String EuchreLeadingSuit; //the leading suit of a euchre trick
    //private boolean nameSuit; //whether or not the user/cpu wants to name a suit
    private int dealerTracker; //tracks who the dealer is (1 = p1, 2 = p2, 3 = p3, 4 = p4)
    private String[] p1Choice, p2Choice, p3Choice, p4Choice; //the choices of all players for what suit they want to play
    private int team1OverallPts, team2OverallPts; //the total points for each team (first to 15 wins)

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
        this.euchreTrick = new Trick[4]; 
    }

    /**
     * Method that contains the logic for a trick of Euchre
     * 
     * @param euchreStartPlayer the starting player of a euchre trick
     * @return the winner of the trick
     */
    public Player trickLogicEuchre(Player euchreStartPlayer){
        //TODO get cards in trick depending on starting player, remove cards from hand
        //NOTE: same thing as spades, just convert variables


        //create the trick
        ArrayList<Card> trickCards = new ArrayList<>();
        Trick trick = new Trick(trickCards);

        //get winner of trick
        Card winningCard = trick.winnerOfEuchreTrick(flippedTrump);
        //p1 wins trick
        if(winningCard.getOwner().equals(p1Euchre)){
            p1EuchreTricks++;
        }
        //p2 wins trick
        else if(winningCard.getOwner().equals(p2Euchre)){
            p2EuchreTricks++;
        }
        //p3 wins trick
        else if(winningCard.getOwner().equals(p3Euchre)){
            p3EuchreTricks++;
        }
        //p4 wins trick
        else{
            p4EuchreTricks++;
        }
        //set next starting player to be winner of trick
        euchreStartPlayer = winningCard.getOwner();
        return euchreStartPlayer;
    }

    /**
     * Method that performs the logic for a round of Euchre
     * 
     * @return string "team1" if team 1 wins the game, or "team2" if team 2 wins the game
     */
    public String playRoundEuchre(){
        Random rand = new Random();
        int firstPlayer = rand.nextInt(4); //get who plays first in the first round randomly
        boolean finished = false;
        boolean playRound = true;

        //while the game is not finished...
        while(!finished) {
            setupEuchreHand(); //setup euchre hands before each trick

            //player1 decides trump first, and they choose to flippedTrump for trump
            if(firstPlayer == 0 && p1Choice[0].equals("Yes")) {
                declaredTrump = flippedTrump; 
            }
            //player2 decides trump first, and they choose to flippedTrump for trump
            else if(firstPlayer == 1 && p2Choice[0].equals("Yes")) {
                declaredTrump = flippedTrump; 
            }
            //player3 decides trump first, and they choose to flippedTrump for trump
            else if(firstPlayer == 2 && p3Choice[0].equals("Yes")) {
                declaredTrump = flippedTrump; 
            }
            //player4 decides trump first, and they choose to flippedTrump for trump
            else if(firstPlayer == 3 && p4Choice[0].equals("Yes")) {
                declaredTrump = flippedTrump; 
            }
            else {
                //nobody wants to play flipped trump, check if anybody wants to name trump
                //p1 wants to name trump, set trump to their pick if yes
                if(!p1Choice[1].equals("Pass")) {
                    declaredTrump = p1Choice[1];
                }
                else if(!p2Choice[1].equals("Pass")) {
                    declaredTrump = p2Choice[1];
                }
                else if(!p3Choice[1].equals("Pass")) {
                    declaredTrump = p3Choice[1];
                }
                else if(!p4Choice[1].equals("Pass")) {
                    declaredTrump = p4Choice[1];
                }
                else {
                    //nobody wants to name trump --> move on to next round
                    playRound = false; 
                }
            }
        
            if(playRound) {
                if(firstPlayer == 0){
                    euchreStartPlayer = p1Euchre;
                    trickLogicEuchre(p1Euchre);
                }
                else if(firstPlayer == 1){
                    euchreStartPlayer = p2Euchre;
                    trickLogicEuchre(p2Euchre);
                }
                else if(firstPlayer == 2){
                    euchreStartPlayer = p3Euchre;
                    trickLogicEuchre(p3Euchre);
                }
                else{
                    euchreStartPlayer = p4Euchre;
                    trickLogicEuchre(p4Euchre);
                }

                //the rest of the spadesTrick of a round
                for(int i = 0; i < 5; i++){
                    trickLogicEuchre(euchreStartPlayer);
                }

                team1EuchreTricks = p1EuchreTricks + p3EuchreTricks;
                team2EuchreTricks = p2EuchreTricks + p4EuchreTricks;
                //team 1 scenarios
                //team1 wins 3/4 tricks and they named trump --> 1 pt
                if((team1EuchreTricks == 3 || team1EuchreTricks == 4) && (declaredTrump.equals(p1Choice[1])) || declaredTrump.equals(p3Choice[1])) {
                    team1OverallPts += 1;
                }
                //team1 wins 3/4 tricks and they DID NOT name trump --> 2 pts
                else if((team1EuchreTricks == 3 || team1EuchreTricks == 4) && (declaredTrump.equals(p2Choice[1])) || declaredTrump.equals(p4Choice[1])) {
                    team1OverallPts += 2;
                }
                //team1 wins 5 tricks and they DID NOT name trump --> 2 pts
                else if((team1EuchreTricks == 5)) {
                    team1OverallPts += 2;
                }
                //team 2 scenarios
                //team2 wins 3/4 tricks and they named trump --> 1 pt
                if((team2EuchreTricks == 3 || team2EuchreTricks == 4) && (declaredTrump.equals(p2Choice[1])) || declaredTrump.equals(p4Choice[1])) {
                    team1OverallPts += 1;
                }
                //team2 wins 3/4 tricks and they DID NOT name trump --> 2 pts
                if((team2EuchreTricks == 3 || team2EuchreTricks == 4) && (declaredTrump.equals(p1Choice[1])) || declaredTrump.equals(p3Choice[1])) {
                    team1OverallPts += 2;
                }
                //team2 wins 5 tricks and they DID NOT name trump --> 2 pts
                else if((team2EuchreTricks == 5)) {
                    team1OverallPts += 2;
                }
        
                if(team1EuchreTricks >= 15) {
                    finished = true;
                    //GAME IS DONE -- TEAM1 WINS
                    return "team1";
                }
                else if(team2EuchreTricks >= 15) {
                    finished = true;
                    //GAME IS DONE -- TEAM2 WINS
                    return "team2";
                }
                //nobody has wone yet --> continue with loop
            }
        }
        return "";
    }

    /**
     * Method that sets up a hand of euchre, including shuffling the deck, giving cards to all 
     * players, getting the flipped card, getting flippped trump, and getting the trump decisions 
     * for all of the players in the game.
     * 
     * Call this method before each trick to set it up properly.
     * 
     */
    public void setupEuchreHand() {
        //shuffle deck
        deck.shuffle();
        
        //deal hands to all players (returns an arraylist of cards where first 5 cards are for p1, second 5 cards are for p2, etc... and last card is flipped trump)
        ArrayList<Card> allHands = deck.euchreDeal(p1Euchre, p2Euchre, p3Euchre, p4Euchre);
        //get flipped Card
        this.flippedCard = deck.getFlippedCard();
        //get flipped card suit (trump suit)
        this.flippedTrump = flippedCard.getSuit();

        //deal out hands
        ArrayList<Card> p1EuchreHand = (ArrayList<Card>) allHands.subList(0,4);
        p1Euchre.setHand(p1EuchreHand);
        ArrayList<Card> p2EuchreHand = (ArrayList<Card>) allHands.subList(5,9);
        p1Euchre.setHand(p2EuchreHand);
        ArrayList<Card> p3EuchreHand = (ArrayList<Card>) allHands.subList(10,14);
        p1Euchre.setHand(p3EuchreHand);
        ArrayList<Card> p4EuchreHand = (ArrayList<Card>) allHands.subList(15,19);
        p1Euchre.setHand(p4EuchreHand);

        //NOTES:
        //cpuSuitDecision() eturns an array of 2 strings
        //indes 0: "Yes" or "No" based on if they want to play the flippedTrump
        //index 1: string of suit that player wants to pick, "Pass" if no good suit to pick

        //get trump decisions for all players
        // p1Choice = p1Euchre.getSuitDecision(flippedTrump); //GET FROM FRONTEND
        p2Choice = p2Euchre.cpuSuitDecision(p2Euchre, flippedTrump); 
        p3Choice = p3Euchre.cpuSuitDecision(p3Euchre, flippedTrump); 
        p4Choice = p4Euchre.cpuSuitDecision(p4Euchre, flippedTrump);
        return;
    }
}
