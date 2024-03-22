package com.DeckdOut.cardgamehub.repository;

import com.DeckdOut.cardgamehub.model.TestUser;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Repository interface for managing TestUser entities in the database.
 */
public interface TestUserRepository extends JpaRepository<TestUser, Integer> {

}
