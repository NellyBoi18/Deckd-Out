package com.DeckdOut.cardgamehub.controller;

import com.DeckdOut.cardgamehub.model.TestUser;
import com.DeckdOut.cardgamehub.service.TestUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controller class responsible for handling HTTP requests related to test users in the card game hub application.
 */
@RestController
@RequestMapping("/testUser")
@CrossOrigin(origins = "http://localhost:3000/")
public class TestUserController {

    @Autowired
    TestUserService testUserService;

    /**
     * Endpoint for adding a new test user.
     *
     * @param testUser The test user object to be added.
     * @return A string indicating the success or failure of the operation.
     */
    @PostMapping("/add")
    public String addTestUser(@RequestBody TestUser testUser) {
        return testUserService.addTestUser(testUser);
    }

    /**
     * Endpoint for retrieving all test users.
     *
     * @return A list of all test users stored in the system.
     */
    @GetMapping
    public List<TestUser> findAllTestUsers() {
        return testUserService.findAllTestUser();
    }
}
