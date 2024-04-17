package com.DeckdOut.cardgamehub;

import java.util.ArrayList;
import org.junit.jupiter.api.Test;
import com.DeckdOut.cardgamehub.model.*;
import com.DeckdOut.cardgamehub.logic.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Assertions;

public class roundTest {
    
    public static ArrayList<Card> trickCards;
    public static Card card1, card2, card3, card4;
    public static Round round;
    public static Player p1, p2, p3, p4;

    @BeforeAll
    public static void setup(){
        trickCards = new ArrayList();
        p1 = new Player("P1");
        p2 = new Player("P2");
        p3 = new Player("P3");
        p4 = new Player("P4");

        card1 = new Card("Hearts", 3, p1);
        card2 = new Card("Diamonds", 3, p2);
        card3 = new Card("Clubs", 3, p3);
        card4 = new Card("Hearts", 2, p4);

        trickCards.add(card1);
        trickCards.add(card2);
        trickCards.add(card3);
        trickCards.add(card4);

        round = new Round(1, 1, p1, p2, p3, p4);
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
}
