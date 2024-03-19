public class SpadeGameLogic {
    String player1Name, player2Name, player3Name, player4Name;
    Deck deck = new Deck();
    int team1PT = 0;
    int team2PT = 0;

    /** 
     * Logic for a game of Spades
     */
    public void gameLogic(){
        //logic for getting the name of the players

        Player player1 = new Player(player1Name);
        player1.setBid(); //need logic for getting the big from the player
        Player player2 = new Player(player2Name);
        player2.setBid();
        Player player3 = new Player(player3Name);
        player3.setBid();
        Player player4 = new Player(player4Name);
        player4.setBid();

        //logic for getting the bid of each player

        while(team1PT < 500 || team2PT < 500){
            Round round = new Round(); //will need to initialize
            int[] points = round.playRoundSpades();
            team1PT =+ points[1];
            team2PT =+ points[2];
        }
    }
    

}
