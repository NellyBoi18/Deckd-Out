package com.DeckdOut.cardgamehub;

import org.springframework.boot.test.context.SpringBootTest;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Assertions;

import com.DeckdOut.cardgamehub.ObjectCode.*;

@SpringBootTest
public class CardTests{
      
    public static Player player;
    public static Card card1;

    /*
     * Setting up the card that will be tested
     */
    @BeforeAll
    public static void setupClass(){
        player = new Player("playerName");
        card1 = new Card("Spades", 3);
        card1.setOwner(player);
    }

    /**
     * Unit tests for card object
     */
    
    /*
     * Unit test for string output of card object
     */
    @Test
    public void stringOutTest(){
        Assertions.assertEquals("Suit: Spades | Value: 3 | Owner: playerName | Dealt: false", card1.toString(), "stringOutTest Fail");
    }

    /*
     * Unit test for card dealt status false
     */
    @Test
    public void cardFalseDealtTest(){
        Assertions.assertEquals(false, card1.getDealt(), "cardFalseDealtTest Fail");
    }

    /*
     * Unit test for card dealt status true
     */
    @Test
    public void cardTrueDealtTest(){
        card1.setDealt(true);
        Assertions.assertEquals(true, card1.getDealt(), "cardTrueDealtTest fail");
    }

    /*
     * Unit test for card value
     */
    @Test
    public void cardValueTest(){
        Assertions.assertEquals(3, card1.getCardValue(), "cardValueTest fail");
    }

    /*
     * Unit test for card suit
     */
    @Test
    public void cardGetSuitTest(){
        Assertions.assertEquals("Spades", card1.getSuit(), "cardGetSuitTest fail");
    }
    
    /*
     * Unit test card owner
     */
    @Test
    public void cardGetOwnerTest(){
        Assertions.assertEquals(player, card1.getOwner(), "cardGetOwnerTest fail");
    }

}