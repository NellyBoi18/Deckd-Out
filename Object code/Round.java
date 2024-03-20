import java.util.Random;
import java.util.ArrayList;

public class Round {
    private int p1Bid, p2Bid, p3Bid, p4Bid; //prediction of the number of traick a player will win
    private int p1Tricks = 0; //number of tricks player 1 wins
    private int p2Tricks = 0; //number of tricks player 2 wins
    private int p3Tricks = 0; //number of tricks player 3 wins
    private int p4Tricks = 0; //number of tricks player 4 wins
    private int team1Pred = p1Bid + p3Bid; //prediciton of the number of tricks team 1 will win
    private int team2Pred = p2Bid + p4Bid; //prediction of the number of tricks team 2 will win 
    private String player1, player2, player3, player4; 
    private Trick[] tricks; 
    private Player startPlayer;
    private Deck deck = new Deck(); //the deck of cards
    private Player p1, p2, p3, p4; ////the 4 different players in the game 
    private int team1OverTricks; //the number of overtricks for team 1
    private int team2OverTricks; //the number of overtricks for team 2


    /**
     * Constructor
     * Sets up a round of Spades
     * 
     * @param team1Pred integer variable of number of tricks the first team will win
     * @param team2Pred integer variable of number of tricks the second team will win
     * @param player1 player variable of the name of player 1
     * @param player2 player variable of the name of player 2
     * @param player3 player variable of the name of player 3
     * @param player4 player variable of the name of player 4
     */
    public Round(int team1Pred, int team2Pred, Player p1, Player p2, Player p3, Player p4){
        this.team1Pred = team1Pred;
        this.team2Pred = team2Pred;
        this.p1 = p1;
        this.p2 = p2;
        this.p3 = p3;
        this.p4 = p4;
        this.tricks = new Trick[13];

    }

    /**
     * Method that contains the logic for a trick of Spades
     * 
     * @param p1Hand the hand of cards of the first player
     * @param p2Hand the hand of cards of the second player
     * @param p3Hand the hand of cards of the third player
     * @param p4Hand the hand of cards of the fourth player
     */
    public void trickLogicSpades(ArrayList<Card> p1Hand, ArrayList<Card> p2Hand, ArrayList<Card> p3Hand, ArrayList<Card> p4Hand){
        ArrayList<Card> trickCards = new ArrayList<>();
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
        if(winningCard.getOwner().equals(p1)){
            p1Tricks++;
        }
        else if(winningCard.getOwner().equals(p2)){
            p2Tricks++;
        }
        else if(winningCard.getOwner().equals(p3)){
            p3Tricks++;
        }
        else{
            p4Tricks++;
        }
        startPlayer = winningCard.getOwner();
        //TODO SEND WINNING PLAYER TO FRONTEND
    }

    /**
     * Method that performs the logic for a round of Spades
     * 
     * @return array of two ints, representing the scores of team1 and team2 respectively
     */
    public int[] playRoundSpades(){
        Random rand = new Random();
        int firstPlayer = rand.nextInt(4); //who plays first in the first round
        deck.shuffle();
        
        ArrayList<Card> p1Hand = deck.spadesDeal(p1);
        p1.setHand(p1Hand);
        ArrayList<Card> p2Hand = deck.spadesDeal(p2);
        p2.setHand(p2Hand);
        ArrayList<Card> p3Hand = deck.spadesDeal(p3);
        p3.setHand(p3Hand);
        ArrayList<Card> p4Hand = deck.spadesDeal(p4);
        p4.setHand(p4Hand);


        //TODO: GET BOTH TEAMS PREDICTIONS FROM FRONTEND --> HARDCODED HERE
        team1Pred = 6;
        team2Pred = 7;

        
        //first trick of a round 
        if(firstPlayer == 0){
            startPlayer = p1;
            trickLogicSpades(p1Hand, p2Hand, p3Hand, p4Hand);
        }
        else if(firstPlayer == 1){
            startPlayer = p2;
            trickLogicSpades(p1Hand, p2Hand, p3Hand, p4Hand);
        }
        else if(firstPlayer == 2){
            startPlayer = p3;
            trickLogicSpades(p1Hand, p2Hand, p3Hand, p4Hand);
        }
        else{
            startPlayer = p4;
            trickLogicSpades(p1Hand, p2Hand, p3Hand, p4Hand);
        }

        //the rest of the tricks of a round
        for(int i = 0; i < 12; i++){
            trickLogicSpades(p1Hand, p2Hand, p3Hand, p4Hand);
        }
        
        //calculate scores after all rounds
        int team1Pts = pointCalc(p1Tricks, p3Tricks, team1Pred, team1OverTricks, "team1");
        int team2Pts = pointCalc(p2Tricks, p4Tricks, team2Pred, team2OverTricks, "team2");
        int[] roundPoints = new int[]{team1Pts, team2Pts};

        return roundPoints;
    }

    /**
     * Method that calculates the points that a single team earn after a round of Spades
     * 
     * @param player1Tricks the amount of tricks that the first member of the team has won
     * @param player2Tricks the amount of tricks that the second member of the team has won
     * @param prediction the amount of tricks that the team as a whole predicted (player1 bid + player2 bid) 
     * @param teamOverTricks the amount of overtricks that the team currently has
     * @param team string representation of the team (team1 vs team2)
     * @return the final amount of points that a team has earned in a round of play
     */
    public int pointCalc(int player1Tricks, int player2Tricks, int prediction, int teamOverTricks, String team){
        int finalPoints = 0; 
        int totalTricks = player1Tricks + player2Tricks;
        int diff = totalTricks -= prediction;

        //if bid (i.e. prediction) was met
        if(totalTricks >= prediction) {
            finalPoints += prediction * 10;
            //if team had any overtricks
            if(diff > 0) {
                finalPoints += diff;
                teamOverTricks += diff; 
            }
        }

        //check for overtricks, if 10+ minus 100 from total score and reset overtrick counter for respective team
        if(teamOverTricks > 10) {
            finalPoints -= 100;
            if(team.equals("team1")) { setTeam1OvrTricks(0); }
            if(team.equals("team2")) { setTeam2OvrTricks(0); } 
        }
        //return final amount of points for round
        return finalPoints;
    }

    /**
     * Sets the number of overtricks for team 1
     * 
     * @param num the number of overtricks that team 1 will be set to
     */ 
    public void setTeam1OvrTricks(int num) {
        this.team1OverTricks = num;
    }

    /**
     * Sets the number of overtricks for team 2
     * 
     * @param num the number of overtricks that team 2 will be set to
     */ 
    public void setTeam2OvrTricks(int num) {
        this.team2OverTricks = num;
    }

}
