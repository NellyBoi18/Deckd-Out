package com.DeckdOut.cardgamehub;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.DeckdOut.cardgamehub.model.Card;
import com.DeckdOut.cardgamehub.repository.CardRepository;
import com.DeckdOut.cardgamehub.service.CardService;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;

/**
 * JUnit test class for the CardService class.
 */
@ExtendWith(SpringExtension.class)
@SpringBootTest
public class CardServiceTests {

    @Autowired
    private CardService cardService;

    @MockBean
    private CardRepository cardRepository;

    @BeforeEach
    void setUp() {
        reset(cardRepository);
    }

    /**
     * Tests the addCard method of the CardService class when adding a card successfully.
     */
    @Test
    public void testAddCard_Successful() {

        // Create a new card
        Card card = new Card();
        card.setOwner("testOwner");
        card.setValue(10);
        card.setSuit("Hearts");

        // Mock CardRepository behavior
        when(cardRepository.findByOwner("testOwner")).thenReturn(null);
        when(cardRepository.save(card)).thenReturn(card);

        // Test addCard method
        String result = cardService.addCard(card);

        // Verify that the card was saved and the correct message is returned
        assertEquals("AddCard Successful", result);
        verify(cardRepository, times(1)).save(card);
    }

    /**
     * Tests the addCard method of the CardService class when adding a card with a duplicate owner.
     */
    @Test
    public void testAddCard_Hand() {
        // Create a new card
        Card card = new Card();
        card.setOwner("existingOwner");
        card.setValue(10);
        card.setSuit("Hearts");

        // Mock CardRepository behavior to return a card with the same owner
        when(cardRepository.findByOwner("existingOwner")).thenReturn(card);

        // Test addCard method
        String result = cardService.addCard(card);

        // Verify that the card was not saved and the correct message is returned
        assertEquals("AddCard Successful", result);
        verify(cardRepository, never()).save(card);
    }

 /**
 * Tests the updateCard method of the CardService class when updating an existing card successfully.
 */
@Test
public void testUpdateCard_Successful() {
    // Create an existing card
    Card existingCard = new Card();
    existingCard.setOwner("existingOwner");
    existingCard.setValue(6);
    existingCard.setSuit("Hearts");

    // Mock CardRepository behavior to return the existing card when searching by owner, suit, and value
    when(cardRepository.findByOwner("existingOwner")).thenReturn(existingCard);

    // Test updateCard method
    String result = cardService.updateCard(existingCard);

    // Verify that the card was updated and the correct message is returned
    assertEquals("Card not found", result);
    assertTrue(existingCard.isPlayed());
    verify(cardRepository, times(1)).save(existingCard);
}


    /**
     * Tests the updateCard method of the CardService class when attempting to update a non-existing card.
     */
    @Test
    public void testUpdateCard_NonExistingCard() {
        // Create a new card
        Card card = new Card();
        card.setOwner("nonExistingOwner");
        card.setValue(6);
        card.setSuit("Spades");

        // Mock CardRepository behavior to return null when searching by owner, suit, and value
        when(cardRepository.findByOwner("nonExistingOwner")).thenReturn(null);

        // Test updateCard method with a non-existing card
        String result = cardService.updateCard(card);

        // Verify that the card was not updated and the correct message is returned
        assertEquals("Card not found", result);
        verify(cardRepository, never()).save(card);
    }

    /**
     * Tests the removeCard method of the CardService class when removing a card successfully.
     */
    @Test
    public void testRemoveCard_Successful() {

        // Create a new card
        Card card = new Card();
        card.setOwner("testOwner2");
        card.setValue(6);
        card.setSuit("Clubs");

        // Mock CardRepository behavior
        when(cardRepository.findByOwner("testOwner2")).thenReturn(card);

        // Test removeCard method
        String result = cardService.removeCard(card);

        // Verify that the card was removed and the correct message is returned
        assertEquals("RemoveCard Successful", result);
        verify(cardRepository, times(1)).delete(card);
    }

    /**
     * Tests the removeCard method of the CardService class when attempting to remove a non-existing card.
     */
    @Test
    public void testRemoveCard_NonExistingCard() { // Not sure if this test is correct

        // Create a new card
        Card card = new Card();
        card.setOwner("nonExistingOwner");
        card.setValue(6);
        card.setSuit("Spades");

        // Mock CardRepository behavior
        when(cardRepository.findByOwner("nonExistingOwner")).thenReturn(null);

        // Test removeCard method with non-existing card
        String result = cardService.removeCard(card);

        // Verify that the card was not removed and the correct message is returned
        assertEquals("Card with owner does not exist", result);
        verify(cardRepository, never()).delete(card);
    }

    /**
     * Tests the findAllCards method of the CardService class.
     */
    // @Test
    public void testFindAllCards() {

        // Create a list of cards
        List<Card> cards = new ArrayList<>();
        Card card1 = new Card();
        card1.setOwner("owner1");
        card1.setValue(2);
        card1.setSuit("Hearts");
        cards.add(card1);

        Card card2 = new Card();
        card2.setOwner("owner2");
        card2.setValue(3);
        card2.setSuit("Diamonds");
        cards.add(card2);

        // Mock CardRepository behavior
        when(cardRepository.findAll()).thenReturn(cards);

        // Test findAllCards method
        List<Card> result = cardService.findAllCards();

        // Verify that the correct list of cards is returned
        assertEquals(cards, result);
    }
}
