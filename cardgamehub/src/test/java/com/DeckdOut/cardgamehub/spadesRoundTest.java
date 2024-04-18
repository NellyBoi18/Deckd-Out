package com.DeckdOut.cardgamehub;

import java.util.ArrayList;
import org.junit.jupiter.api.Test;
import com.DeckdOut.cardgamehub.model.*;
import com.DeckdOut.cardgamehub.logic.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Assertions;

public class spadesRoundTest {
    
    public static ArrayList<Card> trickCards, p1Hand, p2Hand, p3Hand, p4Hand;
    public static Card card3, card4;
    public static Card p1Card0, p1Card1, p1Card2, p1Card3, p1Card4, p1Card5, p1Card6, p1Card7, p1Card8, p1Card9, p1Card10, p1Card11, p1Card12;
    public static Card p2Card0, p2Card1, p2Card2, p2Card3, p2Card4, p2Card5, p2Card6, p2Card7, p2Card8, p2Card9, p2Card10, p2Card11, p2Card12;
    public static Card p3Card0, p3Card1, p3Card2, p3Card3, p3Card4, p3Card5, p3Card6, p3Card7, p3Card8, p3Card9, p3Card10, p3Card11, p3Card12;
    public static Card p4Card0, p4Card1, p4Card2, p4Card3, p4Card4, p4Card5, p4Card6, p4Card7, p4Card8, p4Card9, p4Card10, p4Card11, p4Card12;

    public static SpadesRound round;
    public static Player p1, p2, p3, p4;



    @BeforeAll
    public static void setup(){
        trickCards = new ArrayList();
        p1 = new Player("P1");
        p2 = new Player("P2");
        p3 = new Player("P3");
        p4 = new Player("P4");

        p1Card0 = new Card("Hearts", 8, p1);
        p2Card0 = new Card("Diamonds", 8, p2);
        p3Card0 = new Card("Clubs", 8, p3);
        p4Card0 = new Card("Hearts", 8, p4);

        trickCards.add(p1Card0);
        trickCards.add(p2Card0);
        trickCards.add(p3Card0);
        trickCards.add(p4Card0);


        p1Card1 = new Card("Hearts", 4, p1);
        p1Card2 = new Card("Spades", 4, p1);
        p1Card3 = new Card("Diamonds", 4, p1);
        p1Card4 = new Card("Clubs", 4, p1);
        p1Card5 = new Card("Hearts", 10, p1);
        p1Card6 = new Card("Spades", 10, p1);
        p1Card7 = new Card("Diamonds", 10, p1);
        p1Card8 = new Card("clubs", 10, p1);
        p1Card9 = new Card("Hearts", 14, p1);
        p1Card10 = new Card("Spades", 14, p1);
        p1Card11 = new Card("Diamonds", 14, p1);
        p1Card12 = new Card("Clubs", 14, p1);

        p1Hand = new ArrayList<>();
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


        p2Card1 = new Card("Hearts", 5, p2);
        p2Card2 = new Card("Spades", 5, p2);
        p2Card3 = new Card("Diamonds", 5, p2);
        p2Card4 = new Card("Clubs", 5, p2);
        p2Card5 = new Card("Hearts", 11, p2);
        p2Card6 = new Card("Spades", 11, p2);
        p2Card7 = new Card("Diamonds", 11, p2);
        p2Card8 = new Card("clubs", 11, p2);
        p2Card9 = new Card("Hearts", 2, p2);
        p2Card10 = new Card("Spades", 2, p2);
        p2Card11 = new Card("Diamonds", 2, p2);
        p2Card12 = new Card("Clubs", 2, p2);

        p2Hand = new ArrayList<>();
        p2Hand.add(p2Card0);
        p2Hand.add(p2Card1);
        p2Hand.add(p2Card2);
        p2Hand.add(p2Card3);
        p2Hand.add(p2Card4);
        p2Hand.add(p2Card5);
        p2Hand.add(p2Card6);
        p2Hand.add(p2Card7);
        p2Hand.add(p2Card8);
        p2Hand.add(p2Card9);
        p2Hand.add(p2Card10);
        p2Hand.add(p2Card11);
        p2Hand.add(p2Card12);

        p2.setHand(p2Hand);

        p3Card1 = new Card("Spades", 7, p3);
        p3Card2 = new Card("Spades", 6, p3);
        p3Card3 = new Card("Diamonds", 6, p3);
        p3Card4 = new Card("Clubs", 6, p3);
        p3Card5 = new Card("Spades", 12, p3);
        p3Card6 = new Card("Spades", 13, p3);
        p3Card7 = new Card("Diamonds", 12, p3);
        p3Card8 = new Card("clubs", 12, p3);
        p3Card9 = new Card("Hearts", 3, p3);
        p3Card10 = new Card("Spades", 3, p3);
        p3Card11 = new Card("Spades", 9, p3);
        p3Card12 = new Card("Clubs", 3, p3);

        p3Hand = new ArrayList<>();
        p3Hand.add(p3Card0);
        p3Hand.add(p3Card1);
        p3Hand.add(p3Card2);
        p3Hand.add(p3Card3);
        p3Hand.add(p3Card4);
        p3Hand.add(p3Card5);
        p3Hand.add(p3Card6);
        p3Hand.add(p3Card7);
        p3Hand.add(p3Card8);
        p3Hand.add(p3Card9);
        p3Hand.add(p3Card10);
        p3Hand.add(p3Card11);
        p3Hand.add(p3Card12);

        p3.setHand(p3Hand);

        p4Card1 = new Card("Hearts", 6, p4);
        p4Card2 = new Card("Hearts", 7, p4);
        p4Card3 = new Card("Diamonds", 7, p4);
        p4Card4 = new Card("Clubs", 7, p4);
        p4Card5 = new Card("Hearts", 13, p4);
        p4Card6 = new Card("Hearts", 12, p4);
        p4Card7 = new Card("Diamonds", 13, p4);
        p4Card8 = new Card("clubs", 13, p4);
        p4Card9 = new Card("Hearts", 9, p4);
        p4Card10 = new Card("Diamonds", 3, p4);
        p4Card11 = new Card("Diamonds", 9, p4);
        p4Card12 = new Card("Clubs", 9, p4);

        p4Hand = new ArrayList<>();
        p4Hand.add(p4Card0);
        p4Hand.add(p4Card1);
        p4Hand.add(p4Card2);
        p4Hand.add(p4Card3);
        p4Hand.add(p4Card4);
        p4Hand.add(p4Card5);
        p4Hand.add(p4Card6);
        p4Hand.add(p4Card7);
        p4Hand.add(p4Card8);
        p4Hand.add(p4Card9);
        p4Hand.add(p4Card10);
        p4Hand.add(p4Card11);
        p4Hand.add(p4Card12);

        p4.setHand(p4Hand);

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
        Player test = round.trickLogicSpades(p1Hand, p2Hand, p3Hand, p4Hand, p1);
        Assertions.assertEquals(p3, test, "p1StartingTest fail");
    }

    @Test
    public void p2StartingTest(){
        Player test = round.trickLogicSpades(p1Hand, p2Hand, p3Hand, p4Hand, p2);
        Assertions.assertEquals(p3, test, "p2StartingTest fail");
    }

    @Test
    public void p3StartingTest(){
        Player test = round.trickLogicSpades(p1Hand, p2Hand, p3Hand, p4Hand, p3);
        Assertions.assertEquals(p2, test, "p3StartingTest fail");
    }

    @Test
    public void p4StartingTest(){
        Player test = round.trickLogicSpades(p1Hand, p2Hand, p3Hand, p4Hand, p4);
        Assertions.assertEquals(p4, test, "p4StartingTest fail");
    }
}
