package com.DeckdOut.cardgamehub.service;

import com.DeckdOut.cardgamehub.APICallers.CardAPICaller;
import com.DeckdOut.cardgamehub.controller.CardController;
import com.DeckdOut.cardgamehub.model.Card;
import com.DeckdOut.cardgamehub.repository.CardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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
        Card result = cardRepository.save(card);
        return "AddCard Successful";
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
        return "RemoveCard Successful";
    }

    /**
     * Removes all cards from the repository.
     *
     * @return A string indicating the result of the operation.
     */
    @Override
    public String removeAllCards() {
        cardRepository.deleteAll();
        return "RemoveAll Successful";
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

    /*
     * Update an existing card from the repository to have isPlayed = true
     * 
     *  @return A string indicating the result of the operation.
     */
    @Override
    public String updateCard(Card card) {
        Card existingCard = cardRepository.findBySuitAndValue(card.getSuit(), card.getValue());
        
        if (existingCard != null) {
            existingCard.setPlayed(true);
            cardRepository.save(existingCard);
            return "Card updated successfully";
        } else {
            return "Card not found";
        }
    }



    /*
     * Gets winner of a trick
     * 
     *  @return A string indicating the result of the operation.
     */
    @Override
    public String getWinner() {
        Card[] cards1 = CardAPICaller.getCardsFromAPI();
        ArrayList<Card> cards = new ArrayList<>();
        for(Card card : cards1) {
            cards.add(card);
        }
        ArrayList<Card> trick = new ArrayList<>();
        Card userCard = new Card();
  

        ArrayList<Card> hand1 = new ArrayList<>();
        ArrayList<Card> hand2 = new ArrayList<>();
        ArrayList<Card> hand3 = new ArrayList<>();
        ArrayList<Card> hand4 = new ArrayList<>();
        for(Card card : cards) {
            if(card.getOwner().equals("Player")) {
                hand1.add(card);
            }
            else if(card.getOwner().equals("CPU1")) {
                hand2.add(card);
            }
            else if(card.getOwner().equals("CPU2")) {
                hand3.add(card);
            }
            else if(card.getOwner().equals("CPU3")) {
                hand4.add(card);
            }
        }

        //adds player 1 card
        for(Card card : hand1) {
            if(card.isPlayed()) {
                trick.add(card);
                userCard = card;
                break;
            }
        }
        //trick logic
        //get cpu cards to trick
        Card cpu1Card = cpuCardLogic(userCard, hand2);
        trick.add(cpu1Card);
        Card cpu2Card = cpuCardLogic(userCard, hand3);
        trick.add(cpu2Card);
        Card cpu3Card = cpuCardLogic(userCard, hand4);
        trick.add(cpu3Card);

        //get user card to trick
        Card winningCard = cardCompareSpades(userCard.getSuit(), trick);
        winningCard.setSuit("victory");

        CardController cardController = new CardController();
        return cardController.addCard(winningCard);
    }


    /*
     * Decides CPU's card to play. Helper function for the getWinner() method.
     * 
     * @param userCard The person's card in question
     * @param hand the hand of the player in question
     *  @return the card that is the best card for the player to play
     */
    public Card cpuCardLogic(Card userCard, ArrayList<Card> hand) {
        String leadingSuit = userCard.getSuit();

        //first leading suit
        for(Card card : hand) {
            if(card.getSuit().equals(leadingSuit)) {
                return card;
            }
        }

        //else return first card in hand
        return hand.get(0);
    } 


    /**
     * Compares the played cards in a trick based on the suit first, then the value of the card.
     * For Spades game only
     * 
     * @param leadingSuit string variable of the leading suit played
     * @param trickCards ArrayList variable of Card objects of the played cards in the trick
     * @return the card the wins the trick
     */
    public Card cardCompareSpades(String leadingSuit, ArrayList<Card> trickCards) {
        boolean spadePresent = false;
        Card highestCard = null;
        int maxCardVal = 0;
        for(int i = 0; i < 4; i++){
            if(trickCards.get(i).getSuit().equals("Spades")){
                spadePresent = true;
            }
        }

        if(spadePresent){
            for(int i = 0; i < 4; i++){
                if(trickCards.get(i).getSuit().equals("Spades")){
                    if(maxCardVal < trickCards.get(i).getValue()){
                        maxCardVal = trickCards.get(i).getValue();
                        highestCard = trickCards.get(i);
                    }
                }
            }
            return highestCard;
        }
        else{
            for(int i = 0; i < 4; i++){
                if(trickCards.get(i).getSuit().equals(leadingSuit)){
                    if(maxCardVal < trickCards.get(i).getValue()){
                        maxCardVal = trickCards.get(i).getValue();
                        highestCard = trickCards.get(i);
                    }
                }
            }
            return highestCard;
        }
    }

    public static void main(String[] args) {
        CardService cardService = new CardService();
        String result = cardService.getWinner();
        System.out.println(result);
    }
}
