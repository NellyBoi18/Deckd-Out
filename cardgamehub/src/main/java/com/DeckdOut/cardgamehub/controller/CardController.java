package com.DeckdOut.cardgamehub.controller;

import com.DeckdOut.cardgamehub.model.Card;
import com.DeckdOut.cardgamehub.service.CardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controller class responsible for handling HTTP requests related to cards in the card game hub application.
 */
@RestController
@RequestMapping("/card")
@CrossOrigin
public class CardController {

    @Autowired
    CardService cardService;

    /**
     * Endpoint for adding a new card.
     *
     * @param card The card object to be added.
     * @return A string indicating the success or failure of the operation.
     */
    @PostMapping("/add")
    public String addCard(@RequestBody Card card) {
        return cardService.addCard(card);
    }

    /**
     * Endpoint for removing a card.
     *
     * @param card The card object to be removed.
     * @return A string indicating the success or failure of the operation.
     */
    @PostMapping("/remove")
    public String removeCard(@RequestBody Card card) {
        return cardService.removeCard(card);
    }

    /**
     * Endpoint for removing all cards.
     * 
     * @return A string indicating the success or failure of the operation.
     */
    @PostMapping("/removeAll")
    public String removeAllCards() {
        return cardService.removeAllCards();
    }

    /**
     * Endpoint for retrieving all cards.
     *
     * @return A list of all cards stored in the system.
     */
    @GetMapping
    public List<Card> findAllCards() {
        return cardService.findAllCards();
    }
}
