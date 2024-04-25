import React, { useState } from 'react';

/**
 * The CardDeck component generates a deck of playing cards, shuffles them,
 * and renders each card with its suit and rank.
 */
const CardDeck = () => {
    // Array of card ranks
    const RANKS = ["A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K"];
    // Array of card suits
    const SUITS = ["diamonds", "clubs", "hearts", "spades"];
    // Calculated total number of cards in a deck
    const DECK_SIZE = RANKS.length * SUITS.length;

    /**
     * Creates an unshuffled deck of playing cards.
     * @returns {Array} An array of card objects each with a rank and suit.
     */
    const createDeck = () => {
        let cards = [];
        for (let i = 0; i < DECK_SIZE; i++) {
            cards.push({
                suit: SUITS[Math.floor(i / RANKS.length)],
                rank: RANKS[i % RANKS.length]
            });
        }
        return cards;
    };

    /**
     * Shuffles an array of card objects.
     * @param {Array} cards - The deck of cards to shuffle.
     * @returns {Array} The shuffled array of cards.
     */
    const shuffleDeck = (cards) => {
        for (let i = cards.length - 1; i > 0; i--) {
            const j = Math.floor(Math.random() * (i + 1));
            [cards[i], cards[j]] = [cards[j], cards[i]];
        }
        return cards;
    };

    // State to hold the shuffled deck of cards
    const [cards] = useState(shuffleDeck(createDeck()));

    /**
     * Retrieves the symbol for a given suit.
     * @param {string} suit - The suit of the card.
     * @returns {string} The symbol representing the suit of the card.
     */
    const getSuitSymbol = (suit) => {
        const symbols = {
            diamonds: '♦',
            clubs: '♣',
            hearts: '♥',
            spades: '♠'
        };
        return symbols[suit];
    };

    // Render the deck of cards as a series of div elements
    return (
        <div style={{ display: 'flex', flexWrap: 'wrap', justifyContent: 'center', padding: '20px' }}>
            {cards.map((card, index) => (
                <div key={index} style={{
                    height: "140px",
                    width: "100px",
                    margin: "10px",
                    display: "flex",
                    flexDirection: "column",
                    justifyContent: "center",
                    alignItems: "center",
                    background: "#fff",
                    border: "1px solid #000",
                    borderRadius: "8px",
                    boxShadow: "0 2px 10px rgba(0,0,0,0.3)",
                    color: card.suit === 'diamonds' || card.suit === 'hearts' ? 'red' : 'black',
                    fontFamily: "'Times New Roman', serif",
                    position: 'relative',
                    fontSize: '18px',
                }}>
                    <div style={{ position: 'absolute', top: '10px', left: '10px' }}>
                        <div style={{ fontSize: '24px' }}>{card.rank}</div>
                        <div style={{ fontSize: '18px' }}>{getSuitSymbol(card.suit)}</div>
                    </div>
                    <div style={{ fontSize: '48px' }}>{getSuitSymbol(card.suit)}</div>
                    <div style={{ position: 'absolute', bottom: '10px', right: '10px', transform: 'rotate(180deg)' }}>
                        <div style={{ fontSize: '24px' }}>{card.rank}</div>
                        <div style={{ fontSize: '18px' }}>{getSuitSymbol(card.suit)}</div>
                    </div>
                </div>
            ))}
        </div>
    );
};

export default CardDeck;
