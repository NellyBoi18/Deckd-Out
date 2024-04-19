package com.DeckdOut.cardgamehub.service;

import com.DeckdOut.cardgamehub.model.Card;

import java.util.List;

/**
 * Interface defining methods for managing Card entities.
 */
public interface CardServiceInterface {
    /**
     * Adds a new card.
     *
     * @param card The card to be added.
     * @return A string indicating the result of the operation.
     */
    public String addCard(Card card);

    /**
     * Removes a card.
     *
     * @param card The card to be removed.
     * @return A string indicating the result of the operation.
     */
    public String removeCard(Card card);

    /**
     * Retrieves all cards.
     *
     * @return A list containing all cards.
     */
    public List<Card> findAllCards();
}
