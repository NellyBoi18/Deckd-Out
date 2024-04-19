package com.DeckdOut.cardgamehub.service;

import com.DeckdOut.cardgamehub.model.Card;
import com.DeckdOut.cardgamehub.repository.CardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CardService implements CardServiceInterface{

    @Autowired
    CardRepository cardRepository;
    @Override
    public String addCard(Card card) {

        if(cardRepository.findByOwner(card.getOwner()) != null) return "Card with owner already exists";
        Card result = cardRepository.save(card);
        return "Successfull";


        // if(userRepository.findByUsername(user.getUsername()) != null) return "User with username already exists";
        // if(userRepository.findByEmail(user.getEmail()) != null) return "User with email already exists";
        // User result = userRepository.save(user);
        // return "Successful";
    }

    @Override
    public String removeCard(Card card) {

        if(cardRepository.findByOwner(card.getOwner()) == null) return "Card with owner does not exist";
        cardRepository.delete(card);
        return "Successfull";

    }

    @Override
    public List<Card> findAllCards() {
        
        return cardRepository.findAll(Sort.by(Sort.Direction.DESC, "id"));
    }
}

