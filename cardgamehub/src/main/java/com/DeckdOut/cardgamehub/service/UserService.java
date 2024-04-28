package com.DeckdOut.cardgamehub.service;

import com.DeckdOut.cardgamehub.model.User;
import com.DeckdOut.cardgamehub.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Service class responsible for managing User entities.
 */
@Service
public class UserService implements UserServiceInterface {

    @Autowired
    UserRepository userRepository;

    /**
     * Adds a new user.
     *
     * @param user The user to be added.
     * @return A string indicating the result of the operation.
     */
    @Override
    public String registerUser(User user) {

        if(userRepository.findByUsername(user.getUsername()) != null) return "User with username already exists";
        if(userRepository.findByEmail(user.getEmail()) != null) return "User with email already exists";
        User result = userRepository.save(user);
        return "registerUser Successful";
    }

    /**
     * Retrieves all users.
     *
     * @return A list containing all users, sorted by descending ID.
     */
    @Override
    public String loginUser(User user) {

        User DBUser = userRepository.findByUsername(user.getUsername());
        if(DBUser == null) return "User does not exist";
        if(!user.getPassword().toString().equals(DBUser.getPassword().toString())) return "Password is incorrect" ;

        User result = userRepository.save(user);
        return "loginUser Successful";
    }

    @Override
    public List<User> findAllUsers() {
        return userRepository.findAll(Sort.by(Sort.Direction.DESC, "id"));
    }
}
