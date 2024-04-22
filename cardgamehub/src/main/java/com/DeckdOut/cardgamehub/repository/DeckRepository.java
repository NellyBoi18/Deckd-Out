package com.DeckdOut.cardgamehub.repository;

import com.DeckdOut.cardgamehub.model.Deck;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DeckRepository extends JpaRepository<Deck, Integer>{

    
}
