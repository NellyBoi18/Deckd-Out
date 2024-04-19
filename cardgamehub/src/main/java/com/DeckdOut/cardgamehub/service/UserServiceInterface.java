package com.DeckdOut.cardgamehub.service;

import com.DeckdOut.cardgamehub.model.User;

import java.util.List;

/**
 * Interface defining methods for managing User entities.
 */
public interface UserServiceInterface {
    /**
     * Adds a new user.
     *
     * @param user The user to be added.
     * @return A string indicating the result of the operation.
     */
    public String addUser(User user);

    /**
     * Retrieves all users.
     *
     * @return A list containing all users.
     */
    public List<User> findAllUsers();
}
