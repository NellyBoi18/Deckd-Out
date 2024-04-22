package com.DeckdOut.cardgamehub.controller;

import com.DeckdOut.cardgamehub.model.Deck;
import com.DeckdOut.cardgamehub.service.DeckService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controller class responsible for handling HTTP requests related to decks in the card game hub application
 */
@RestController
@RequestMapping("/deck")
@CrossOrigin
public class DeckController {

    @Autowired
    DeckService deckService;
    
    /**
     * Endpoint for adding a new deck
     * 
     * @param deck The deck object to be added
     * @return A string indicating the success or failure of the operation
     */
    @PostMapping("/add")
    public String addDeck(@RequestBody Deck deck){
        return deckService.addDeck(deck);
    }

    /**
     * Endpoint for retrieving all deck
     * 
     * @return a list of all decks stored in the system
     */
    @GetMapping
    public List<Deck> findDeck(){
        return deckService.findDeck();
    }
}
