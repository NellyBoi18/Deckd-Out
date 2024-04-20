package com.DeckdOut.cardgamehub;

import java.util.ArrayList;
import org.junit.jupiter.api.Test;
import com.DeckdOut.cardgamehub.model.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Assertions;

public class playerTest {
    public static Player player;
    public static ArrayList<Card> hand, playedHand;
    public static Card card1, card2, card3, card4, card5, card6, card7, card8, card9, card10, card11, card12, card13;

    @BeforeAll
    public static void setup(){
        player = new Player("Name");
        player.setBid(10);
        hand = new ArrayList();
        card1 = new Card("Spades", 3, player);
        hand.add(card1);
        card2 = new Card("Spades", 5, player);
        hand.add(card2);
        card3 = new Card("Spades", 10, player);
        hand.add(card3);
        card4 = new Card("Spades", 13, player);
        hand.add(card4);
        card5 = new Card("Hearts", 3, player);
        hand.add(card5);
        card6 = new Card("Diamonds", 3, player);
        hand.add(card6);
        card7 = new Card("Clubs", 3, player);
        hand.add(card7);
        card8 = new Card("Hearts", 2, player);
        hand.add(card8);
        card9 = new Card("Clubs", 2, player);
        hand.add(card9);
        card10 = new Card("Diamonds", 2, player);
        hand.add(card10);
        card11 = new Card("Hearts", 5, player);
        hand.add(card11);
        card12 = new Card("Hearts", 12, player);
        hand.add(card12);
        card13 = new Card("Diamonds", 7, player);
        hand.add(card13);

        player.setHand(hand);

        playedHand = new ArrayList();
        playedHand.add(card2);
        playedHand.add(card3);
        playedHand.add(card4);
        playedHand.add(card5);
        playedHand.add(card6);
        playedHand.add(card7);
        playedHand.add(card8);
        playedHand.add(card9);
        playedHand.add(card10);
        playedHand.add(card11);
        playedHand.add(card12);
        playedHand.add(card13);
    }

    /*
     * Unit test to get name of player
     */
    @Test
    public void getNameTest(){
        Assertions.assertEquals("Name", player.getuserName(), "getNameTest fail");
    }

    /*
     * Unit test to get bid of player
     */
    @Test
    public void getBidTest(){
        Assertions.assertEquals(10, player.getBid(), "getBidTest fail");
    }

    /*
     * Unit test to get hand of player
     */
    @Test
    public void getHandTest(){
        Assertions.assertEquals(hand, player.getHand(), "getHandTest fail");
    }

    /*
     * Unit test to remove card from player's hand
     */
    @Test 
    public void removePlayedCardTest(){
        player.removePlayedCard(card1);
        Assertions.assertEquals(playedHand.size(), player.getHand().size(), "removePlayedCardTest fail");
    }
    
    /*
     * Unit test to remove card from player's hand
     */
    @Test
    public void cardRemovedFromHandTest(){
        player.removePlayedCard(card1);
        Assertions.assertEquals(playedHand, player.getHand(), "cardRemovedFromHandTest fail");
    }

    /*
     * Unit test of handHasTrump method, detects if player hand has trump cards (Spades)
     */
    @Test
    public void handHasTrumpTest(){
        Assertions.assertEquals(true, player.hasTrump(hand, "Spades"), "handHasTrumpTest fail");
    }

    /*
     * Unit test of getHighNorm method, finds last highest card in player hand that is not trump(Spades), in this case is Hearts 12
     */
    @Test
    public void getHighNormTest(){
        Assertions.assertEquals(card12, player.getHighNorm(player, "Spades"), "getHighNormTest fail");
    }

    /*
     * Unit test of getLowNorm method, finds last and lowest card in player hand that is not trump(Spades), in this case is Diamonds 2
     */
    @Test
    public void getLowNormTest(){
        Assertions.assertEquals(card10, player.getLowNorm(player, "Spades"), "getLowNormTest fail");
    }

    /*
     * Unit test of numTrump method, finds the number of trump(Spades) cards in player's hand.
     */
    @Test 
    public void numTrumpTest(){
        Assertions.assertEquals(4, player.numTrump(player, "Spades"), "numTrumpTest fail");
    }

    /*
     * Unit test of containsCard method, finds if specific card is present in player's hand
     */
    @Test
    public void containsCardTest(){
        Assertions.assertEquals(true, player.containsCard(card1, player), "containsCardTest true fail");

        Card card = new Card("Spades", 2, player);
        Assertions.assertEquals(false, player.containsCard(card, player), "containsCardTest false fail");
    }

    /*
     * Unit test of containsNormAce method, find if player's hand contains a non-trump Ace
     * method should return false if there is no non-trump Ace or if the only Ace is trump(Spades)
     */
    @Test
    public void containsNormAceTest(){
        Assertions.assertEquals(false, player.containsNormAce(player, "Spades"), "containsNormActTest false fail");

        Card card1New = new Card("Diamonds", 14, player);
        Card card2New = new Card("Spades", 14, player);
        hand.add(card2New);
        player.setHand(hand);
        Assertions.assertEquals(false, player.containsNormAce(player, "Spades"), "contiansNormAceTest false 2 fail");
        hand.add(card1New);
        player.setHand(hand);
        Assertions.assertEquals(true, player.containsNormAce(player, "Spades"), "containsNormActTest true fail");
        
    }
    
    /*
     * Unit test of getHighSuit method
     */
    @Test
    public void getHighSuitTest(){
        System.out.println(player.getHighSuit(player, "Spades"));
        Assertions.assertEquals(card4, player.getHighSuit(player, "Spades"), "getHighSuitTest fail");
    }

    @Test
    public void getLowSuitTest(){
        System.out.println(player.getHand().toString());
        System.out.println(player.getHand().size());
        Assertions.assertEquals(card1, player.getLowSuit(player, "Spades"), "getLowSuitTest fail");
    }

    @Test
    public void hasGivenSuitTest(){
        Assertions.assertEquals(true, player.hasGivenSuit(player, "Spades"), "hasGivenSuitTest Spades fail");
        Assertions.assertEquals(true, player.hasGivenSuit(player, "Diamonds"), "hasGivenSuitTest Diamonds fail");
        Assertions.assertEquals(true, player.hasGivenSuit(player, "Hearts"), "hasGivenSuitTest Hearts fail");
        Assertions.assertEquals(true, player.hasGivenSuit(player, "Clubs"), "hasGivenSuitTest Clubs fail");        
    }

    @Test
    public void hasGivenCardTest(){
        Assertions.assertEquals(true, player.hasGivenCard(player, "Spades", 13), "hasGivenCardTest true fail");
        Assertions.assertEquals(false, player.hasGivenCard(player, "Spades", 14), "hasGivenCardTest true fail");

    }

    @Test
    public void numNonTrumpValsTest(){
        Assertions.assertEquals(3, player.numNonTrumpVals(player, 3, "Spades"), "numNonTrumpvalsTest fail");
    }

    @Test
    public void cpuChooseCardSpadesTest(){
        Card card = player.cpuChooseCardSpades(player, "Spades", player);
        System.out.println(card);
        Assertions.assertEquals(card4, card, "cpuShooseCardSpadesTest fail");
    }

    @Test
    public void cpuChooseBidTest(){
        Assertions.assertEquals(3, player.cpuChooseBid(player), "cpuChooseBidTest fail");
    }
}
