package com.DeckdOut.cardgamehub.service;

import com.DeckdOut.cardgamehub.model.Card;
import com.DeckdOut.cardgamehub.repository.CardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Service class responsible for managing Card entities.
 */
@Service
public class CardService implements CardServiceInterface {

    @Autowired
    CardRepository cardRepository;

    /**
     * Adds a new card to the repository.
     *
     * @param card The card to be added.
     * @return A string indicating the result of the operation.
     */
    @Override
    public String addCard(Card card) {
        // if (cardRepository.findByOwner(card.getOwner()) != null)
        //     return "Card with owner already exists";
        Card result = cardRepository.save(card);
        return "Successful";
    }

    /**
     * Removes a card from the repository.
     *
     * @param card The card to be removed.
     * @return A string indicating the result of the operation.
     */
    @Override
    public String removeCard(Card card) {
        if (cardRepository.findByOwner(card.getOwner()) == null)
            return "Card with owner does not exist";
        cardRepository.delete(card);
        return "Successful";
    }

    /**
     * Retrieves all cards from the repository.
     *
     * @return A list containing all cards, sorted by descending ID.
     */
    @Override
    public List<Card> findAllCards() {
        return cardRepository.findAll(Sort.by(Sort.Direction.DESC, "id"));
    }

    /**
     * Removes all cards
     * 
     * @return a string indicating the result of the operation
     */
    @Override
    public String removeAllCards(){
        List<Card> allCards = findAllCards();
        for(int i = 0; i < allCards.size(); i++){
            cardRepository.delete(allCards.get(i));
        }
        
        return "Successful";
    }
}
