package com.DeckdOut.cardgamehub.repository;

import com.DeckdOut.cardgamehub.model.Deck;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repository interface for managing Deck entities in teh database
 */
public interface DeckRepository extends JpaRepository<Deck, Integer>{
    /**
     * Finds deck
     * 
     * @return deck 
     */
    Deck findDeck();
    
}
