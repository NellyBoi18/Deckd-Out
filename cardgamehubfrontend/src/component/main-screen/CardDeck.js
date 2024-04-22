import React, { useState } from 'react';

const CardDeck = () => {
    const RANKS = ["A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K"];
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
        <div style={{ display: 'flex', flexWrap: 'wrap', justifyContent: 'center', padding: '20px' }}>
            {cards.map((card, index) => (
                <div key={index} style={{
                    height: "140px",
                    width: "100px",
                    margin: "10px",
                    display: "flex",
                    flexDirection: "column",
                    justifyContent: "center", // Align items vertically centered
                    alignItems: "center", // Align items horizontally centered
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
                    <div style={{ fontSize: '48px' }}>{getSuitSymbol(card.suit)}</div> {/* Increased size for center symbol */}
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
