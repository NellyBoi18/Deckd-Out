package com.DeckdOut.cardgamehub.ObjectCode;

/**
 * Class for the logic in a game of Spades
 */
 public class SpadeGameLogic {
    String player1Name, player2Name, player3Name, player4Name;
    Deck deck = new Deck();

    int team1PT = 0;
    int team2PT = 0;
    int placeHldrBid = 3;

    /** 
     * Logic for a game of Spades
     */
    public void gameLogic(){
        /**
         * TODO:
         * logic for getting string name of player from UI
         * player1Name =;
         * player2Name =;
         * player3Name =;
         * player4Name =;
         */

        /**
         * TODO:
         * logic for getting int bid from the player from the UI
         */
        Player player1 = new Player(player1Name); 
        player1.setBid(placeHldrBid); 
        Player player2 = new Player(player2Name);
        player2.setBid(placeHldrBid);
        Player player3 = new Player(player3Name);
        player3.setBid(placeHldrBid);
        Player player4 = new Player(player4Name);
        player4.setBid(placeHldrBid);

        //logic for team bid prediction
        team1PT = player1.getBid() + player3.getBid();
        team2PT = player2.getBid() + player4.getBid();

        while(team1PT < 500 || team2PT < 500){
            SpadesRound round = new SpadesRound(team1PT, team2PT, player1, player2, player3, player4);
            int[] points = round.playRoundSpades();
            team1PT =+ points[1];
            team2PT =+ points[2];
        }
    }
    

}
