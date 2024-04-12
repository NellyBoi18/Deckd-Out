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
@RequestMapping("/Users")
@CrossOrigin
public class UserController {

    @Autowired
    UserService userService;

    /**
     * Endpoint for adding a new user.
     *
     * @param user The user object to be added.
     * @return A string indicating the success or failure of the operation.
     */
    @PostMapping("/add")
    public String addUser(@RequestBody User user) {
        return userService.addUser(user);
    }

    /**
     * Endpoint for retrieving all users.
     *
     * @return A list of all users stored in the system.
     */
    @GetMapping
    public List<User> findAllUsers() {
        return userService.findAllUser();
    }
}
