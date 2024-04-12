package com.DeckdOut.cardgamehub.service;

import com.DeckdOut.cardgamehub.model.User;

import java.util.List;

public interface UserServiceInterface {
    public String addUser(User user);
    public List<User> findAllUsers();
}