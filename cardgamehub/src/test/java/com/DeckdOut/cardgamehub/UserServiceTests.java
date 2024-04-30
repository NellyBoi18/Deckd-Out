package com.DeckdOut.cardgamehub;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.DeckdOut.cardgamehub.model.User;
import com.DeckdOut.cardgamehub.repository.UserRepository;
import com.DeckdOut.cardgamehub.service.UserService;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class UserServiceTests {

    @Autowired
    private UserService userService;

    @MockBean
    private UserRepository userRepository;

    @BeforeEach
    void setUp() {
        reset(userRepository);
    }

    /**
     * Tests the addUser method of the UserService class when adding a user successfully.
     */
    @Test
    public void testAddUser_Successful() {
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
        String result = userService.registerUser(user);

        // Verify that the user was saved and the correct message is returned
        assertEquals("registerUser Successful", result);
        verify(userRepository, times(1)).save(user);
    }

        /**
     * Tests the addUser method of the UserService class when adding a user with a duplicate username.
     */
    @Test
    public void testAddUser_DuplicateUsername() {
        // Create a new user
        User user = new User();
        user.setUsername("existingUser");
        user.setEmail("test@example.com");
        user.setPassword("password");

        // Mock UserRepository behavior to return a user with the same username
        when(userRepository.findByUsername("existingUser")).thenReturn(user);

        // Test addUser method
        String result = userService.registerUser(user);

        // Verify that the user was not saved and the correct message is returned
        assertEquals("User with username already exists", result);
        verify(userRepository, never()).save(user);
    }

    /**
     * Tests the addUser method of the UserService class when adding a user with a duplicate email.
     */
    @Test
    public void testAddUser_DuplicateEmail() {
        // Create a new user
        User user = new User();
        user.setUsername("testUser");
        user.setEmail("existing@example.com");
        user.setPassword("password");

        // Mock UserRepository behavior to return a user with the same email
        when(userRepository.findByEmail("existing@example.com")).thenReturn(user);

        // Test addUser method
        String result = userService.registerUser(user);

        // Verify that the user was not saved and the correct message is returned
        assertEquals("User with email already exists", result);
        verify(userRepository, never()).save(user);
    }

    /**
     * Tests the findByUsername method of the UserService class when searching for an existing user by username.
     */
    @Test
    public void testFindByUsername_ExistingUser() {
        // Create a user
        User user = new User();
        user.setUsername("testUser");
        user.setEmail("test@example.com");
        user.setPassword("password");

        // Mock UserRepository behavior to return the user when searching by username
        when(userRepository.findByUsername("testUser")).thenReturn(user);

        // Test findByUsername method
        String result = userService.loginUser(user);

        // Verify that the correct user is returned
        assertEquals("loginUser Successful", result);
    }

    /**
     * Tests the findByUsername method of the UserService class when searching for a non-existing user by username.
     */
    @Test
    public void testFindByUsername_NonExistingUser() {
        // Create a user
        User user = new User();
        user.setUsername("nonExistingUser");
        user.setEmail("test@example.com");
        user.setPassword("password");

        // Mock UserRepository behavior to return null when searching by username
        when(userRepository.findByUsername(anyString())).thenReturn(null);

        // Test findByUsername method with a non-existing username
        String result = userService.loginUser(user);

        // Verify that user does not exist
        assertEquals("User does not exist", result);
        verify(userRepository, never()).save(user);
    }

    /**
     * Tests the findAllUsers method of the UserService class.
     */
    // @Test
    public void testFindAllUsers() {
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
