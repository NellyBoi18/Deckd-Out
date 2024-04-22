package com.DeckdOut.cardgamehub.service;

import com.DeckdOut.cardgamehub.model.Deck;
import com.DeckdOut.cardgamehub.repository.DeckRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Service class responsible for managing Deck entities
 */
@Service
public class DeckService implements DeckServiceInterface{
    
    @Autowired
    DeckRepository deckRepository;

    /**
     * Adds a new deck to the repository
     * 
     * @param deck the deck to be added
     * @return a string indicating the result of the operation
     */
    @Override
    public String addDeck(Deck deck){
        Deck result = deckRepository.save(deck);
        return "Successful";
    }

    /**
     * Removes acard from the repository
     * 
     * @param deck the deck to be removed
     * @return a string indicating the result of the operation
     */
    @Override
    public String removeDeck(Deck deck){
        deckRepository.delete(deck);
        return "Successful";
    }

    /**
     * Retrieves all cards from the repository
     * 
     * @return a list containing all decks, sorted by descending ID
     */
    @Override
    public List<Deck> findDeck(){
        return deckRepository.findAll(Sort.by(Sort.Direction.DESC, "id"));
    }
}
