package com.DeckdOut.cardgamehub.repository;

import com.DeckdOut.cardgamehub.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;


/**
 * Repository interface for managing User entities in the database.
 */
public interface UserRepository extends JpaRepository<User, Integer> {
    User findByUsername(String username);
    User findByEmail(String email);
}
