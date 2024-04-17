package com.DeckdOut.cardgamehub;

import java.util.ArrayList;
import org.junit.jupiter.api.Test;
import com.DeckdOut.cardgamehub.model.*;
import com.DeckdOut.cardgamehub.logic.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Assertions;

public class spadesRoundTest {
    
    public static ArrayList<Card> trickCards;
    public static Card p1Card0, card2, card3, card4;
    public static Card p1Card1, p1Card2, p1Card3, p1Card4, p1Card5, p1Card6, p1Card7, p1Card8, p1Card9, p1Card10, p1Card11, p1Card12;
    public static SpadesRound round;
    public static Player p1, p2, p3, p4;

    @BeforeAll
    public static void setup(){
        trickCards = new ArrayList();
        p1 = new Player("P1");
        p2 = new Player("P2");
        p3 = new Player("P3");
        p4 = new Player("P4");

        p1Card0 = new Card("Hearts", 3, p1);
        card2 = new Card("Diamonds", 3, p2);
        card3 = new Card("Clubs", 3, p3);
        card4 = new Card("Hearts", 2, p4);

        trickCards.add(p1Card0);
        trickCards.add(card2);
        trickCards.add(card3);
        trickCards.add(card4);


        p1Card1 = new Card("Hearts", 4, p1);
        p1Card2 = new Card("Spades", 4, p1);
        p1Card3 = new Card("Diamonds", 4, p1);
        p1Card4 = new Card("Clubs", 4, p1);
        p1Card5 = new Card("Hearts", 10, p1);
        p1Card6 = new Card("Spadess", 10, p1);
        p1Card7 = new Card("Diamonds", 10, p1);
        p1Card8 = new Card("clubs", 10, p1);
        p1Card9 = new Card("Hearts", 14, p1);
        p1Card10 = new Card("Spades", 14, p1);
        p1Card11 = new Card("Diamonds", 14, p1);
        p1Card12 = new Card("Clubs", 14, p1);

        ArrayList<Card> p1Hand = new ArrayList<>();
        p1Hand.add(p1Card0);
        p1Hand.add(p1Card1);
        p1Hand.add(p1Card2);
        p1Hand.add(p1Card3);
        p1Hand.add(p1Card4);
        p1Hand.add(p1Card5);
        p1Hand.add(p1Card6);
        p1Hand.add(p1Card7);
        p1Hand.add(p1Card8);
        p1Hand.add(p1Card9);
        p1Hand.add(p1Card10);
        p1Hand.add(p1Card11);
        p1Hand.add(p1Card12);

        p1.setHand(p1Hand);


        round = new SpadesRound(1, 1, p1, p2, p3, p4);

    }

    /*
     * Unit test for points when tricks won is equal to the bid
     */
    @Test
    public void pointEqualPredTest(){
        int pointsEqualTrickpred = round.pointCalc(1, 1, 2, 0, "team1");
        Assertions.assertEquals(20, pointsEqualTrickpred, "pointEqualPredTest fail");

    }

    /*
     * Unit test for point when tricks won is more than bid
     */
    @Test
    public void pointsMorePredTest(){
        int pointsMoreTrickPred = round.pointCalc(3, 3, 2, 0, "team1");
        Assertions.assertEquals(24, pointsMoreTrickPred, "pointsMorePredTest fail");
    }

    /*
     * Unit test for points when tricks won is less than bid
     */
    @Test 
    public void pointsLessPredTest(){
        int pointsLessTrickPred = round.pointCalc(2,2, 6, 0, "team1");
        Assertions.assertEquals(0, pointsLessTrickPred, "pointsLessPredTest fail");
    }

    /*
     * Unit test for points when tricks won is 10+ more than bid
     */
    @Test
    public void pointTenMorePredTest(){
        int pointsOverTen = round.pointCalc(10, 2, 1, 0, "team1");
        Assertions.assertEquals(-79, pointsOverTen, "pointTenMorePredTest fail");
    }




    @Test
    public void p1StartingTest(){
        Player test = round.trickLogicSpades(trickCards, trickCards, trickCards, trickCards, p1);
        Assertions.assertEquals(p1, test, "Trick logic test fail");
    }
}
