package com.DeckdOut.cardgamehub.service;

import com.DeckdOut.cardgamehub.model.User;
import com.DeckdOut.cardgamehub.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService implements UserServiceInterface{

    @Autowired
    UserRepository userRepository;
    @Override
    public String addUser(User user) {

        if(userRepository.findByUsername(user.getUsername()) != null) return "User with username already exists";
        if(userRepository.findByEmail(user.getEmail()) != null) return "User with email already exists";
        User result = userRepository.save(user);
        return "Successful";
    }

    @Override
    public List<User> findAllUsers() {
        return userRepository.findAll(Sort.by(Sort.Direction.DESC, "id"));
    }
}
