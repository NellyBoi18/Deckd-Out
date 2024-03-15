package com.DeckdOut.cardgamehub.service;

import com.DeckdOut.cardgamehub.model.TestUser;
import com.DeckdOut.cardgamehub.repository.TestUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TestUserService implements TestUserServiceInterface{

    @Autowired
    TestUserRepository testUserRepository;
    @Override
    public String addTestUser(TestUser testUser) {
        TestUser result = testUserRepository.save(testUser);
        return "Successful";
    }

    @Override
    public List<TestUser> findAllTestUser() {
        return testUserRepository.findAll(Sort.by(Sort.Direction.DESC, "id"));
    }
}

