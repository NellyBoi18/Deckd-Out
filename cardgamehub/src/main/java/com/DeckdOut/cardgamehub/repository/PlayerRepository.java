package com.DeckdOut.cardgamehub.repository;

import com.DeckdOut.cardgamehub.model.Card;
import com.DeckdOut.cardgamehub.model.Player;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repository interface for managing Player entities in the database.
 */
@Repository
public interface PlayerRepository extends JpaRepository<Player, Integer>{

    /**
     * Finds a player by username
     *
     * @param username The username of the player to find
     * @return The player with the specified username, or null if not found.
     */
    Player findByName(String username);
}
