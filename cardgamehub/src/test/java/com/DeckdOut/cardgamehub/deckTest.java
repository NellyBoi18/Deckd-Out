package com.DeckdOut.cardgamehub;

import java.util.ArrayList;
import org.junit.jupiter.api.Test;
import com.DeckdOut.cardgamehub.model.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Assertions;

public class deckTest {

    public static Deck deck1;
    public static Deck deck2;
    public static Player p1;
    public static Player p2;
    public static Player p3;
    public static Player p4;

    /*
     * Set up for deck objects for testing
     */
    @BeforeAll
    public static void setup(){
        deck1 = new Deck();
        deck2 = new Deck();
        p1 = new Player("P1");
        p2 = new Player("P2");
        p3 = new Player("P3");
        p4 = new Player("P4");
    }

    /*
     * Unit test for dealing cards for spades
     */
    @Test
    public void spadesDealTest(){
        deck1.shuffle();
        ArrayList<Card> p1Hand = deck1.spadesDeal(p1);
        Assertions.assertEquals(13, p1Hand.size(), "spadesDealTest fail");
    }

    /*
     * Unit test for dealing cards for euchre
     */
    @Test
    public void euchreDealTest(){
        deck2.shuffle();
        ArrayList<Card> p2Hand = deck2.euchreDeal(p1, p2, p3, p4);
        Assertions.assertEquals(5, p2Hand.size(), "euchreDealTest fail");
    }
    
}
