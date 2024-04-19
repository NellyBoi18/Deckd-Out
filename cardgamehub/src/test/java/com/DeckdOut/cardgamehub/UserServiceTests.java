package com.DeckdOut.cardgamehub;

import org.junit.jupiter.api.*;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;

import com.DeckdOut.cardgamehub.model.User;
import com.DeckdOut.cardgamehub.repository.UserRepository;
import com.DeckdOut.cardgamehub.service.UserService;

@SpringBootTest
public class UserServiceTests {

    @Test
    public void testAddUser_Successful() {
        // Mock UserRepository
        UserRepository userRepository = mock(UserRepository.class);
        UserService userService = new UserService();

        // Create a new user
        User user = new User();
        user.setUsername("testUser");
        user.setEmail("test@example.com");
        user.setPassword("password");

        // Mock UserRepository behavior
        when(userRepository.findByUsername("testUser")).thenReturn(null);
        when(userRepository.findByEmail("test@example.com")).thenReturn(null);
        when(userRepository.save(user)).thenReturn(user);

        // Test addUser method
        String result = userService.addUser(user);

        // Verify that the user was saved and the correct message is returned
        assertEquals("Successful", result);
        verify(userRepository, times(1)).save(user);
    }

    @Test
    public void testAddUser_DuplicateUsername() {
        // Mock UserRepository
        UserRepository userRepository = mock(UserRepository.class);
        UserService userService = new UserService();

        // Create a new user
        User user = new User();
        user.setUsername("existingUser");
        user.setEmail("test@example.com");
        user.setPassword("password");

        // Mock UserRepository behavior
        when(userRepository.findByUsername("existingUser")).thenReturn(user);

        // Test addUser method with duplicate username
        String result = userService.addUser(user);

        // Verify that the user was not saved and the correct message is returned
        assertEquals("User with username already exists", result);
        verify(userRepository, never()).save(user);
    }

    @Test
    public void testAddUser_DuplicateEmail() {
        // Mock UserRepository
        UserRepository userRepository = mock(UserRepository.class);
        UserService userService = new UserService();

        // Create a new user
        User user = new User();
        user.setUsername("testUser");
        user.setEmail("existing@example.com");
        user.setPassword("password");

        // Mock UserRepository behavior
        when(userRepository.findByUsername("testUser")).thenReturn(null);
        when(userRepository.findByEmail("existing@example.com")).thenReturn(user);

        // Test addUser method with duplicate email
        String result = userService.addUser(user);

        // Verify that the user was not saved and the correct message is returned
        assertEquals("User with email already exists", result);
        verify(userRepository, never()).save(user);
    }

    @Test
    public void testFindAllUsers() {
        // Mock UserRepository
        UserRepository userRepository = mock(UserRepository.class);
        UserService userService = new UserService();

        // Create a list of users
        List<User> users = new ArrayList<>();
        User user1 = new User();
        user1.setUsername("user1");
        user1.setEmail("user1@example.com");
        users.add(user1);

        User user2 = new User();
        user2.setUsername("user2");
        user2.setEmail("user2@example.com");
        users.add(user2);

        // Mock UserRepository behavior
        when(userRepository.findAll()).thenReturn(users);

        // Test findAllUsers method
        List<User> result = userService.findAllUsers();

        // Verify that the correct list of users is returned
        assertEquals(users, result);
    }
}