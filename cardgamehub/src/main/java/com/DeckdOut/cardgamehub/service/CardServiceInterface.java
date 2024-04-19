package com.DeckdOut.cardgamehub.service;

import com.DeckdOut.cardgamehub.model.Card;

import java.util.List;

public interface CardServiceInterface {
    public String addCard(Card card);
    public String removeCard(Card card);
    public List<Card> findAllCards();
}