package com.DeckdOut.cardgamehub.Logic;

import com.DeckdOut.cardgamehub.model.*;
import java.util.Random;
import java.util.ArrayList;

/**
 * Class for a single round in the spades card game
 */
public class SpadesRound {
    private int p1SpadesBid, p2SpadesBid, p3SpadesBid, p4SpadesBid; //prediction for the number of spades tricks each player predicts that will win (their bids)
    private int p1SpadesTricks = 0; //number of spades tricks player 1 wins (the user)
    private int p2SpadesTricks = 0; //number of spades tricks player 2 wins
    private int p3SpadesTricks = 0; //number of spades tricks player 3 wins
    private int p4SpadesTricks = 0; //number of spades tricks player 4 wins
    private int team1SpadesPred = p1SpadesBid + p3SpadesBid; //prediciton of the number of spades tricks team 1 will win (user's team)
    private int team2SpadesPred = p2SpadesBid + p4SpadesBid; //prediction of the number of spades tricks team 2 will win 
    private Trick[] spadesTrick; //arraylist of cards in a spades trick 
    private Player spadesStartPlayer; //the starting player of a spades trick (i.e. the one who leads)
    private Deck deck = new Deck(); //the deck of cards
    private Player p1Spades, p2Spades, p3Spades, p4Spades; //the 4 different players in the spades game 
    private int team1SpadesOvrTricks; //the number of overspadesTrick for team 1
    private int team2SpadesOvrTricks; //the number of overspadesTrick for team 2
    //private boolean spadesRoundEnd;
    private String spadesLeadingSuit;

    /**
     * Constructor
     * Sets up a round of Spades by initializing the global fields
     * 
     * @param team1SpadesPred integer variable of number of spades tricks the first team will win
     * @param team2SpadesPred integer variable of number of spades tricks the second team will win
     * @param p1Spades the 1st player in a game of spades (this is always the user)
     * @param p2Spades the 2nd player in a game of spades (this is a CPU)
     * @param p3Spades the 3rd player in a game of spades (this is a CPU)
     * @param p4Spades the 4th player in a game of spades (this is a CPU)
     */
    public SpadesRound(int team1SpadesPred, int team2SpadesPred, Player p1Spades, Player p2Spades, Player p3Spades, Player p4Spades){
        this.team1SpadesPred = team1SpadesPred;
        this.team2SpadesPred = team2SpadesPred;
        this.p1Spades = p1Spades;
        this.p2Spades = p2Spades;
        this.p3Spades = p3Spades;
        this.p4Spades = p4Spades;
        this.spadesTrick = new Trick[13];
    }



    //p1SpadesCheckLegalCards
    public boolean legalCardCheck(Card card) {
        ArrayList<Card> hand = p1Spades.getHand();

        //if user no trump and has leading suit, must play leading suit
        if(!p1Spades.hasTrump(hand, "Spades") && p1Spades.hasLeadingSuit(hand, spadesLeadingSuit)) {
            if(card.getSuit().equals(spadesLeadingSuit)) {
                return true; //given card is in leading suit, it is legal
            }
            else {
                return false; //given card is not in leading suit, it is not legal
            }
        }

        //if user has both trump and leading suit, can play trump or leading suit
        else if(p1Spades.hasTrump(hand, "Spades") && p1Spades.hasLeadingSuit(hand, spadesLeadingSuit)) {
            if(!card.getSuit().equals(spadesLeadingSuit)) {
                return false; //given card is not leading suit, it is not legal
            }
            else {
                return true; //given card is either trump or leading suit, so it is legal
            }
        } 

        //all other scenarios are always acceptable for any card to be played
        else {
            return true;
        }
    } 



    /**
     * Method that contains the logic for a trick of Spades
     * 
     * @param spadesStartPlayer the starting player of a spades trick
     * @return the winner of the trick
     */
    public Player trickLogicSpades(Player spadesStartPlayer){
        ArrayList<Card> trickCards = new ArrayList<>();
  
        //P1 starting player
        if(spadesStartPlayer.equals(p1Spades)) { 
            spadesStartPlayer = p1Spades;
            //p1 (user) pickCard Loop
            boolean done1 = false;
            Card p1SpadesCard = null;
            while(!done1) {
                p1SpadesCard = p1Spades.pickCard(p1Spades);  //GET FROM FRONTEND
                done1 = legalCardCheck(p1SpadesCard);
            }
            p1Spades.removePlayedCard(p1SpadesCard); //remove played card from hand
            spadesLeadingSuit = p1SpadesCard.getSuit(); //set new leading suit
            
            //other users

            Card p2SpadesCard = p2Spades.cpuChooseCardSpades(p2Spades, spadesLeadingSuit, spadesStartPlayer); 
            trickCards.add(p2SpadesCard);
            p2Spades.removePlayedCard(p2SpadesCard);  //remove played card from hand
            Card p3SpadesCard = p3Spades.cpuChooseCardSpades(p3Spades, spadesLeadingSuit, spadesStartPlayer); 
            trickCards.add(p3SpadesCard);
            p3Spades.removePlayedCard(p3SpadesCard);  //remove played card from hand
            Card p4SpadesCard = p4Spades.cpuChooseCardSpades(p4Spades, spadesLeadingSuit, spadesStartPlayer);  
            trickCards.add(p4SpadesCard);
            p4Spades.removePlayedCard(p4SpadesCard);  //remove played card from hand
        }

        //P2 starting player
        else if(spadesStartPlayer.equals(p2Spades)) { 
            spadesStartPlayer = p2Spades;
            Card p2SpadesCard = p2Spades.cpuChooseCardSpades(p2Spades, "None", spadesStartPlayer); 
            trickCards.add(p2SpadesCard);
            p2Spades.removePlayedCard(p2SpadesCard);  //remove played card from hand
            spadesLeadingSuit = p2SpadesCard.getSuit(); //set new leading suit
            
            //other users

            Card p3SpadesCard = p3Spades.cpuChooseCardSpades(p3Spades, spadesLeadingSuit, spadesStartPlayer); 
            trickCards.add(p3SpadesCard);
            p3Spades.removePlayedCard(p3SpadesCard);  //remove played card from hand
            Card p4SpadesCard = p4Spades.cpuChooseCardSpades(p4Spades, spadesLeadingSuit, spadesStartPlayer);
            trickCards.add(p4SpadesCard);
            p4Spades.removePlayedCard(p4SpadesCard);  //remove played card from hand
            //p1 (user) pickCard Loop
            boolean done1 = false;
            Card p1SpadesCard = null;
            while(!done1) {
                p1SpadesCard = p1Spades.pickCard(p1Spades);  //GET FROM FRONTEND
                done1 = legalCardCheck(p1SpadesCard);
            }
            p1Spades.removePlayedCard(p1SpadesCard); //remove played card from hand
        }


        //P3 starting player
        else if(spadesStartPlayer.equals(p3Spades)) { 
            spadesStartPlayer = p3Spades;
            Card p3SpadesCard = p3Spades.cpuChooseCardSpades(p3Spades, "None", spadesStartPlayer); 
            trickCards.add(p3SpadesCard);
            p3Spades.removePlayedCard(p3SpadesCard);  //remove played card from hand
            spadesLeadingSuit = p3SpadesCard.getSuit(); //set new leading suit

            //other users

            Card p4SpadesCard = p4Spades.cpuChooseCardSpades(p4Spades, spadesLeadingSuit, spadesStartPlayer);
            trickCards.add(p4SpadesCard);
            p4Spades.removePlayedCard(p4SpadesCard);  //remove played card from hand
            //p1 (user) pickCard Loop
            boolean done1 = false;
            Card p1SpadesCard = null;
            while(!done1) {
                p1SpadesCard = p1Spades.pickCard(p1Spades);  //GET FROM FRONTEND
                done1 = legalCardCheck(p1SpadesCard);
            }
            p1Spades.removePlayedCard(p1SpadesCard); //remove played card from hand
            Card p2SpadesCard = p2Spades.cpuChooseCardSpades(p2Spades, spadesLeadingSuit, spadesStartPlayer);
            trickCards.add(p2SpadesCard);
            p2Spades.removePlayedCard(p2SpadesCard);  //remove played card from hand
        }

        //P4 starting player
        else if(spadesStartPlayer.equals(p4Spades)) { 
            spadesStartPlayer = p4Spades;
            Card p4SpadesCard = p4Spades.cpuChooseCardSpades(p4Spades, "None", spadesStartPlayer); 
            trickCards.add(p4SpadesCard);
            p4Spades.removePlayedCard(p4SpadesCard);  //remove played card from hand
            spadesLeadingSuit = p4SpadesCard.getSuit(); //set new leading suit

            //other users

            //p1 (user) pickCard Loop
            boolean done1 = false;
            Card p1SpadesCard = null;
            while(!done1) {
                p1SpadesCard = p1Spades.pickCard(p1Spades);  //GET FROM FRONTEND
                done1 = legalCardCheck(p1SpadesCard);
            }
            p1Spades.removePlayedCard(p1SpadesCard); //remove played card from hand
            Card p2SpadesCard = p2Spades.cpuChooseCardSpades(p2Spades, spadesLeadingSuit, spadesStartPlayer);
            trickCards.add(p2SpadesCard);
            p2Spades.removePlayedCard(p2SpadesCard);  //remove played card from hand
            Card p3SpadesCard = p3Spades.cpuChooseCardSpades(p3Spades, spadesLeadingSuit, spadesStartPlayer); 
            trickCards.add(p3SpadesCard);
            p3Spades.removePlayedCard(p3SpadesCard);  //remove played card from hand
        }

        //create the trick
        Trick trick = new Trick(trickCards);

        //get winner of trick
        Card winningCard = trick.winnerOfTrick();
        if(winningCard.getOwner().equals(p1Spades)){
            p1SpadesTricks++;
        }
        else if(winningCard.getOwner().equals(p2Spades)){
            p2SpadesTricks++;
        }
        else if(winningCard.getOwner().equals(p3Spades)){
            p3SpadesTricks++;
        }
        else{
            p4SpadesTricks++;
        }
        spadesStartPlayer = winningCard.getOwner();
        return spadesStartPlayer;
    }

    /**
     * Method that performs the logic for a round of Spades
     * 
     * @return array of two ints, representing the scores of team1 and team2 respectively
     */
    public int[] playRoundSpades(){
       
        //shuffle deck
        deck.shuffle();

        //deal hands to all players
        ArrayList<Card> p1SpadesHand = deck.spadesDeal(p1Spades);
        p1Spades.setHand(p1SpadesHand);
        ArrayList<Card> p2SpadesHand = deck.spadesDeal(p2Spades);
        p2Spades.setHand(p2SpadesHand);
        ArrayList<Card> p3SpadesHand = deck.spadesDeal(p3Spades);
        p3Spades.setHand(p3SpadesHand);
        ArrayList<Card> p4SpadesHand = deck.spadesDeal(p4Spades);
        p4Spades.setHand(p4SpadesHand);


        int p1Pred = 3; //GET FROM FRONTEND
        int p2Pred = p3Spades.cpuChooseBid(p3Spades);
        team1SpadesPred = p1Pred + p2Pred; //set team 1 predictions
        team2SpadesPred = p2Spades.cpuChooseBid(p2Spades) + p4Spades.cpuChooseBid(p4Spades); //set team 2 predictions
        
        Random rand = new Random();
        int firstPlayer = rand.nextInt(4); //who plays first in the first round

        //first trick of a round 
        if(firstPlayer == 0){
            spadesStartPlayer = p1Spades;
            //trickLogicSpades(p1SpadesHand, p2SpadesHand, p3SpadesHand, p4SpadesHand, p1Spades);
            trickLogicSpades(spadesStartPlayer);
        }
        else if(firstPlayer == 1){
            spadesStartPlayer = p2Spades;
            //trickLogicSpades(p1SpadesHand, p2SpadesHand, p3SpadesHand, p4SpadesHand, p2Spades);
            trickLogicSpades(spadesStartPlayer);
        }
        else if(firstPlayer == 2){
            spadesStartPlayer = p3Spades;
            //trickLogicSpades(p1SpadesHand, p2SpadesHand, p3SpadesHand, p4SpadesHand, p3Spades);
            trickLogicSpades(spadesStartPlayer);
        }
        else{
            spadesStartPlayer = p4Spades;
            //trickLogicSpades(p1SpadesHand, p2SpadesHand, p3SpadesHand, p4SpadesHand, p4Spades);
            trickLogicSpades(spadesStartPlayer);
        }

        //the rest of the spadesTrick of a round
        for(int i = 0; i < 12; i++){
            //trickLogicSpades(p1SpadesHand, p2SpadesHand, p3SpadesHand, p4SpadesHand, spadesStartPlayer);
        }
        
        //calculate scores after all rounds
        int team1Pts = pointCalc(p1SpadesTricks, p3SpadesTricks, team1SpadesPred, team1SpadesOvrTricks, "team1");
        int team2Pts = pointCalc(p2SpadesTricks, p4SpadesTricks, team2SpadesPred, team2SpadesOvrTricks, "team2");
        int[] roundPoints = new int[]{team1Pts, team2Pts};

        //return the array of team 1 and 2 points earned in a round
        return roundPoints;
    }

    /**
     * Method that calculates the points that a single team earn after a round of Spades
     * 
     * @param player1spadesTrick the amount of spadesTrick that the first member of the team has won
     * @param player2spadesTrick the amount of spadesTrick that the second member of the team has won
     * @param prediction the amount of spadesTrick that the team as a whole predicted (player1 bid + player2 bid) 
     * @param teamOverspadesTrick the amount of overspadesTrick that the team currently has
     * @param team string representation of the team (team1 vs team2)
     * @return the final amount of points that a team has earned in a round of play
     */
    public int pointCalc(int player1spadesTrick, int player2spadesTrick, int prediction, int teamOverspadesTrick, String team){
        int finalPoints = 0; 
        int totalspadesTrick = player1spadesTrick + player2spadesTrick;
        int diff = totalspadesTrick - prediction;

        //if bid (i.e. prediction) was met
        if(totalspadesTrick >= prediction) {
            finalPoints += prediction * 10;
            //if team had any overspadesTrick
            if(diff > 0) {
                finalPoints += diff;
                teamOverspadesTrick += diff; 
            }
        }

        //check for overspadesTrick, if 10+ minus 100 from total score and reset overtrick counter for respective team
        if(teamOverspadesTrick > 10) {
            finalPoints -= 100;
            if(team.equals("team1")) { setTeam1OvrspadesTrick(0); }
            if(team.equals("team2")) { setTeam2OvrspadesTrick(0); } 
        }
        //return final amount of points for round
        return finalPoints;
    }

    /**
     * Sets the number of overspadesTrick for team 1
     * 
     * @param num the number of overspadesTrick that team 1 will be set to
     */ 
    public void setTeam1OvrspadesTrick(int num) {
        this.team1SpadesOvrTricks = num;
    }

    /**
     * Sets the number of overspadesTrick for team 2
     * 
     * @param num the number of overspadesTrick that team 2 will be set to
     */ 
    public void setTeam2OvrspadesTrick(int num) {
        this.team2SpadesOvrTricks = num;
    }



    public ArrayList<Card> getLegalCards(String spadesLeadingSuit) {
        ArrayList<Card> legalCards = new ArrayList<Card>();
        for(Card card1 : p1Spades.getHand())
            if(card1.getSuit().equals(spadesLeadingSuit) || card1.getSuit().equals("Spades")) {
                legalCards.add(card1);
            }
        return legalCards;
    }



}
