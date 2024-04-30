package com.DeckdOut.cardgamehub;

import com.DeckdOut.cardgamehub.ObjectCode.*;

import org.junit.jupiter.api.*;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;

/**
 * JUnit test class for testing the Trick class.
 */
@SpringBootTest // Specifies that the test is a Spring Boot test
public class TrickTests {
    
    // Static variables for test setup
    public static Deck deck1;
    public static Player p1, p2, p3, p4;
    public static Card card1, card2, card3, card4, card5, card6, card7, card8;
    public static ArrayList<Card> trick1Cards, trick2Cards, trick3Cards;
    public static Trick trick1, trick2, trick3;

    /**
     * Set up for tricks to be tested.
     */
    @BeforeAll
    public static void setup(){
        // Initialize variables
        deck1 = new Deck();
        p1 = new Player("P1");
        p2 = new Player("P2");
        p3 = new Player("P3");
        p4 = new Player("P4");

        // Create cards for testing
        card1 = new Card("Spades", 3, p1);
        card2 = new Card("Spades", 5, p2);
        card3 = new Card("Spades", 10, p3);
        card4 = new Card("Spades", 13, p4);
        
        // Create cards list for trick 1
        trick1Cards = new ArrayList<>();
        trick1Cards.add(card1);
        trick1Cards.add(card2);
        trick1Cards.add(card3);
        trick1Cards.add(card4);

        // Create cards for trick 2
        card5 = new Card("Hearts", 3, p1);
        card6 = new Card("Diamonds", 3, p2);
        card7 = new Card("Clubs", 3, p3);
        card8 = new Card("Hearts", 2, p4);

        // Create cards list for trick 2
        trick2Cards = new ArrayList<>();
        trick2Cards.add(card5);
        trick2Cards.add(card6);
        trick2Cards.add(card7);
        trick2Cards.add(card8);

        // Create cards list for trick 3
        trick3Cards = new ArrayList<>();
        trick3Cards.add(card1);
        trick3Cards.add(card6);
        trick3Cards.add(card7);
        trick3Cards.add(card8);

        // Create Trick instances for testing
        trick1 = new Trick(trick1Cards);
        trick2 = new Trick(trick2Cards);
        trick3 = new Trick(trick3Cards);
    }

    /**
     * Unit test for winner of trick of Spades.
     */
    @Test
    public void spadeTrickTest(){
        Assertions.assertEquals(card4, trick1.winnerOfTrick(), "spadeTrickTest fail");
    }

    /**
     * Unit test for winner of trick with no Spades.
     */
    @Test
    public void noSpadeTrickTest(){
        Assertions.assertEquals(card5, trick2.winnerOfTrick(), "noSpadeTrickTest fail");
    }

    /**
     * Unit test for winner of trick with 1 Spade card present.
     */
    @Test
    public void spadePresentTrickTest(){
        Assertions.assertEquals(card1, trick3.winnerOfTrick(), "spadePresentTrickTest fail");
    }
}
