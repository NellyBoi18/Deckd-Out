package com.DeckdOut.cardgamehub.repository;

import com.DeckdOut.cardgamehub.model.Card;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Repository interface for managing Card entities in the database.
 */
public interface CardRepository extends JpaRepository<Card, Integer> {

    /**
     * Finds a card by its owner.
     *
     * @param owner The owner of the card to find.
     * @return The card with the specified owner, or null if not found.
     */
    Card findByOwner(String owner);
}
