package com.DeckdOut.cardgamehub;

import com.DeckdOut.cardgamehub.ObjectCode.*;

import org.junit.jupiter.api.*;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;

/**
 * JUnit test class for testing the Player class.
 */
@SpringBootTest // Specifies that the test is a Spring Boot test
public class PlayerTests {
    // Static variables for test setup
    public static Player player;
    public static ArrayList<Card> hand, playedHand;
    public static Card card1, card2, card3, card4, card5, card6, card7, card8, card9, card10, card11, card12, card13;

    /**
     * Set up for player and hand to be tested.
     */
    @BeforeAll
    public static void setup(){
        // Initialize variables
        player = new Player("Name");
        player.setBid(10);
        hand = new ArrayList<>();

        // Create cards and add to hand
        card1 = new Card("Spades", 3, player);
        hand.add(card1);
        card2 = new Card("Spades", 5, player);
        hand.add(card2);
        // Remaining card creations and additions to hand...

        // Set player's hand
        player.setHand(hand);

        // Create a played hand for testing removePlayedCard method
        playedHand = new ArrayList<>();
        playedHand.add(card2);
        // Remaining card additions to played hand...
    }

    /**
     * Test method for getting player's username.
     */
    @Test
    public void getNameTest(){
        Assertions.assertEquals("Name", player.getuserName(), "getNameTest fail");
    }

    /**
     * Test method for getting player's bid.
     */
    @Test
    public void getBidTest(){
        Assertions.assertEquals(10, player.getBid(), "getBidTest fail");
    }

    /**
     * Test method for getting player's hand.
     */
    @Test
    public void getHandTest(){
        Assertions.assertEquals(hand, player.getHand(), "getHandTest fail");
    }

    // /**
    //  * Test method for removing played card from player's hand.
    //  */
    // @Test 
    // public void removePlayedCardTest(){
    //     player.removePlayedCard(card1);
    //     Assertions.assertEquals(playedHand.size(), player.getHand().size(), "removePlayedCardTest fail");
    // }

}
