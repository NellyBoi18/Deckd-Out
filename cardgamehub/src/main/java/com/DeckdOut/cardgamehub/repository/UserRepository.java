package com.DeckdOut.cardgamehub.repository;

import com.DeckdOut.cardgamehub.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Repository interface for managing User entities in the database.
 */
public interface UserRepository extends JpaRepository<User, Integer> {

    /**
     * Finds a user by username.
     *
     * @param username The username of the user to find.
     * @return The user with the specified username, or null if not found.
     */
    User findByUsername(String username);

    /**
     * Finds a user by email.
     *
     * @param email The email of the user to find.
     * @return The user with the specified email, or null if not found.
     */
    User findByEmail(String email);
}
