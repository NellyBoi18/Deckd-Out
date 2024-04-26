package com.DeckdOut.cardgamehub.service;

import com.DeckdOut.cardgamehub.model.User;

import java.util.List;

/**
 * Interface defining methods for managing User entities.
 */
public interface UserServiceInterface {
    public String registerUser(User user);
    public String loginUser(User user);
    public List<User> findAllUsers();
}