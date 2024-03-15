package com.DeckdOut.cardgamehub.controller;

import com.DeckdOut.cardgamehub.model.TestUser;
import com.DeckdOut.cardgamehub.service.TestUserService;
import com.DeckdOut.cardgamehub.service.TestUserServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/testUser")
@CrossOrigin
public class TestUserController {

    @Autowired
    TestUserService testUserService;

    @PostMapping("/add")
    public String addStudent( @RequestBody TestUser testUser){
        return testUserService.addTestUser(testUser);
    }

    @GetMapping
    public List<TestUser> findALlStudents(){
        return testUserService.findAllTestUser();
    }
}
