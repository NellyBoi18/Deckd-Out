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

        // if(userRepository.findByUsername(user.getUsername()) != null) return "User with username already exists";
        // if(userRepository.findByEmail(user.getEmail()) != null) return "User with email already exists";
        // User result = userRepository.save(user);
        // return "Successful";
    }

    @Override
    public List<Card> findAllCards() {
        // return userRepository.findAll(Sort.by(Sort.Direction.DESC, "id"));
    }
}

