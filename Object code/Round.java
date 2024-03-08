import java.util.Random;

public class Round {
    private int team1Pred, team2Pred; //the prediction of the number of tricks a team will win in a round of Spades
    private String player1, player2, player3, player4;
    private Trick[] tricks;
    private int startPlayer;
    //TODO: add individual bids
    //TODO: javadocs

    public Round(int team1Pred, int team2Pred, String player1, String player2, String player3, String player4){
        this.team1Pred = team1Pred;
        this.team2Pred = team2Pred;
        this.player1 = player1;
        this.player2 = player2;
        this.player3 = player3;
        this.player4 = player4;
        this.tricks = new Trick[13];
    }

    public void trickLogic(){
        
    }

    public void playRound(){
        Random rand = new Random();
        startPlayer = rand.nextInt(4);
        if(startPlayer == 0){

        }
        else if(startPlayer == 1){
            
        }
        else if(startPlayer == 2){
            
        }
        else{

        }

        for(int i = 0; i < 12; i++){

        }
    }
}
