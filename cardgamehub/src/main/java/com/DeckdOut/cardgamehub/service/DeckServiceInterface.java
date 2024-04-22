package com.DeckdOut.cardgamehub.service;

import com.DeckdOut.cardgamehub.model.Deck;

import java.util.List;

public interface DeckServiceInterface {
    /**
     * Adds a new deck
     * 
     * @param deck the deck to be added
     * @return a string indicating the result of the operation
     */
    public String addDeck(Deck deck);

    /**
     * Removes a deck
     * 
     * @param deck The deck to be removed
     * @return a string indicating the result of the operation
     */
    public String removeDeck(Deck deck);

    /**
     * Retrieves all decks
     * 
     * @return a list containing all decks
     */
    public List<Deck> findDeck();

}
