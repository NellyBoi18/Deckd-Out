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

    @Test
    public void getNameTest(){
        Assertions.assertEquals("Name", player.getuserName(), "getNameTest fail");
    }

    @Test
    public void getBidTest(){
        Assertions.assertEquals(10, player.getBid(), "getBidTest fail");
    }

    @Test
    public void getHandTest(){
        Assertions.assertEquals(hand, player.getHand(), "getHandTest fail");
    }

    @Test 
    public void removePlayedCardTest(){
        player.removePlayedCard(card1);
        Assertions.assertEquals(playedHand.size(), player.getHand().size(), "removePlayedCardTest fail");
    }

    @Test
    public void cardRemovedFromHandTest(){
        Assertions.assertEquals(playedHand, player.getHand(), "cardRemovedFromHandTest fail");
    }
}
