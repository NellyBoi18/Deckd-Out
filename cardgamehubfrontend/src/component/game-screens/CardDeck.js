import React, { useState } from 'react';

// These functions are now defined outside the component and are exported
export const createDeck = () => {
    const RANKS = ["A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K"];
    const SUITS = ["diamonds", "clubs", "hearts", "spades"];
    let cards = [];
    for (let suit of SUITS) {
        for (let rank of RANKS) {
            cards.push({ suit, rank });
        }
    }
    return cards;
};

export const shuffleDeck = (cards) => {
    for (let i = cards.length - 1; i > 0; i--) {
        const j = Math.floor(Math.random() * (i + 1));
        [cards[i], cards[j]] = [cards[j], cards[i]];
    }
    return cards;
};

const CardDeck = () => {
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

    const handleCardClick = async (card) => {
        console.log(`Clicked on ${card.rank} of ${card.suit}`);
        try {
            const response = await fetch('http://localhost:8080/card/add', {
                method: 'POST',
                headers: {
                    'Content-Type': 'application/json',
                },
                body: JSON.stringify({
                    suit: card.suit,
                    value: card.rank, 
                    owner: "DefaultOwner" 
                })
            });
            if (!response.ok) {
                throw new Error('Network response was not ok');
            }
            const data = await response.json();
            console.log('Server response:', data);
        } catch (error) {
            console.error('Error sending card click data:', error);
        }
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
                    cursor: 'pointer'
                }} onClick={() => handleCardClick(card)}>
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