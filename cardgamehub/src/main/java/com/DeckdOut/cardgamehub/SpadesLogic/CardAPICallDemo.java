package com.DeckdOut.cardgamehub.SpadesLogic;

import com.DeckdOut.cardgamehub.APICaller.CardAPICaller;
import com.DeckdOut.cardgamehub.model.Card;

/**
 * A demo class to test fetching cards from the API.
 */
public class CardAPICallDemo {

    /**
     * Main method to test fetching cards from the API.
     *
     * @param args The command-line arguments (not used).
     */
    public static void main(String[] args) {
        Card[] cards = CardAPICaller.getCardsFromAPI();

        // Print cards
        System.out.println("Cards:");
        for (Card card : cards) {
            System.out.println(card.getId() + ", " + card.getSuit() + ", " + card.getValue() + ", " + card.getOwner());
        }
    }
}
