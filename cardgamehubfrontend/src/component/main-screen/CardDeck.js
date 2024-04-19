import React, { useState } from 'react';

const CardDeck = () => {
    const RANKS = ["ace", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten", "jack", "queen", "king"];
    const SUITS = ["diamonds", "clubs", "hearts", "spades"];
    const DECK_SIZE = RANKS.length * SUITS.length;

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

    const shuffleDeck = (cards) => {
        for (let i = cards.length - 1; i > 0; i--) {
            const j = Math.floor(Math.random() * (i + 1));
            [cards[i], cards[j]] = [cards[j], cards[i]];
        }
        return cards;
    };

    const [cards] = useState(shuffleDeck(createDeck()));

    const getSuitSymbol = (suit) => {
        const symbols = {
            diamonds: '♦',
            clubs: '♣',
            hearts: '♥',
            spades: '♠'
        };
        return symbols[suit];
    };

    return (
        <div style={{ display: 'flex', flexWrap: 'wrap', justifyContent: 'center' }}>
            {cards.map((card, index) => (
                <div key={index} className={`card ${card.suit}`} style={{
                    height: "80px",
                    width: "50px",
                    padding: "10px",
                    margin: "5px",
                    display: "inline-block",
                    background: "#ffffff",
                    borderRadius: "3px",
                    color: card.suit === 'diamonds' || card.suit === 'hearts' ? '#ed0000' : '#000000'
                }}>
                    <span className="rank">{card.rank}</span> <span className="suit">{getSuitSymbol(card.suit)}</span>
                </div>
            ))}
        </div>
    );
};

export default CardDeck;
