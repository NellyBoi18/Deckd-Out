package com.DeckdOut.cardgamehub;

import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import org.junit.jupiter.api.Test;
import com.DeckdOut.cardgamehub.ObjectCode.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Assertions;

/**
 * JUnit test class for testing the SpadesRound class.
 */
@SpringBootTest // Specifies that the test is a Spring Boot test
public class SpadesRoundTests {
    
    // Static variables for test setup
    public static ArrayList<Card> trickCards;
    public static Card card1, card2, card3, card4;
    public static SpadesRound round;
    public static Player p1, p2, p3, p4;

    /**
     * Method to set up test environment before running any test.
     */
    @BeforeAll
    public static void setup(){
        // Initialize variables
        trickCards = new ArrayList();
        p1 = new Player("P1");
        p2 = new Player("P2");
        p3 = new Player("P3");
        p4 = new Player("P4");

        // Create cards for testing
        card1 = new Card("Hearts", 3, p1);
        card2 = new Card("Diamonds", 3, p2);
        card3 = new Card("Clubs", 3, p3);
        card4 = new Card("Hearts", 2, p4);

        // Add cards to trick
        trickCards.add(card1);
        trickCards.add(card2);
        trickCards.add(card3);
        trickCards.add(card4);

        // Create SpadesRound instance for testing
        round = new SpadesRound(1, 1, p1, p2, p3, p4);
    }

    /**
     * Test method to check point calculation when predicted and actual tricks are equal.
     */
    @Test
    public void pointEqualPredTest(){
        int pointsEqualTrickpred = round.pointCalc(1, 1, 2, 0, "team1");
        Assertions.assertEquals(20, pointsEqualTrickpred, "pointEqualPredTest fail");
    }

    /**
     * Test method to check point calculation when predicted tricks are more than actual tricks.
     */
    @Test
    public void pointsMorePredTest(){
        int pointsMoreTrickPred = round.pointCalc(3, 3, 2, 0, "team1");
        Assertions.assertEquals(24, pointsMoreTrickPred, "pointsMorePredTest fail");
    }

    /**
     * Test method to check point calculation when predicted tricks are less than actual tricks.
     */
    @Test 
    public void pointsLessPredTest(){
        int pointsLessTrickPred = round.pointCalc(2,2, 6, 0, "team1");
        Assertions.assertEquals(0, pointsLessTrickPred, "pointsLessPredTest fail");
    }

    /**
     * Test method to check point calculation when total tricks exceed ten.
     */
    @Test
    public void pointTenMorePredTest(){
        int pointsOverTen = round.pointCalc(10, 2, 1, 0, "team1");
        Assertions.assertEquals(-79, pointsOverTen, "pointTenMorePredTest fail");
    }
}
