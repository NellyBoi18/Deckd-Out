package com.DeckdOut.cardgamehub.repository;

import com.DeckdOut.cardgamehub.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Repository interface for managing User entities in the database.
 */
public interface UserRepository extends JpaRepository<User, Integer> {

}
