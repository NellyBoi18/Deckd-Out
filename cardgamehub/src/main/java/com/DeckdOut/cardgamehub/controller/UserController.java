package com.DeckdOut.cardgamehub.controller;

import com.DeckdOut.cardgamehub.model.User;
import com.DeckdOut.cardgamehub.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controller class responsible for handling HTTP requests related to users in the card game hub application.
 */
@RestController
@RequestMapping("/user")
@CrossOrigin
public class UserController {

    @Autowired
    UserService userService;

    /**
     * Endpoint for registering a new user.
     *
     * @param user The user object to be registered.
     * @return A string indicating the success or failure of the operation.
     */
    @PostMapping("/register")
    public String registerUser(@RequestBody User user) {
        return userService.registerUser(user);
    }

    /**
     * Endpoint for logging in a user.
     *
     * @param user The user object to be registered.
     * @return A string indicating the success or failure of the operation.
     */
    @PostMapping("/login")
    public String loginUser(@RequestBody User user) {
        return userService.loginUser(user);
    }

    /**
     * Endpoint for retrieving all test users.
     *
     * @return A list of all test users stored in the system.
     */
    @GetMapping
    public List<User> findAllUsers() {
        return userService.findAllUsers();
    }
}
