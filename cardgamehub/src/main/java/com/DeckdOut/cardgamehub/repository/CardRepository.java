package com.DeckdOut.cardgamehub.repository;

import com.DeckdOut.cardgamehub.model.Card;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;


/**
 * Repository interface for managing User entities in the database.
 */
public interface CardRepository extends JpaRepository<Card, Integer> {
    Card findByUsername(String username);
    Card findByEmail(String email);
}
