package com.DeckdOut.cardgamehub;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.DeckdOut.cardgamehub.model.User;
import com.DeckdOut.cardgamehub.repository.UserRepository;

/**
 * Main application class for the card game hub.
 */
@SpringBootApplication
public class CardgamehubApplication implements CommandLineRunner {

    /**
     * Main method to run the card game hub application.
     *
     * @param args Command line arguments.
     */
    public static void main(String[] args) {
        SpringApplication.run(CardgamehubApplication.class, args);
    }

    @Autowired
	private UserRepository userRepository;

	@Override
	public void run(String... args) throws Exception {
		this.userRepository.save(new User("Jennifer", "Kim", "jckim7@wisc.edu"));
	}

}
