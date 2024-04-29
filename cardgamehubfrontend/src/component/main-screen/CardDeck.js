import React, { useState } from 'react';
import Button from '@mui/material/Button';

const CardDeck = () => {
    const RANKS = ["A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K"];
    const SUITS = ["diamonds", "clubs", "hearts", "spades"];
    const DECK_SIZE = RANKS.length * SUITS.length;

    const rankToValue = (rank) => {
        const faceValues = { 'A': 14, 'J': 11, 'Q': 12, 'K': 13 };
        return faceValues[rank] || parseInt(rank);
    };

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

    const assignOwner = (cards) => {
        const owners = ['Player', 'CPU1', 'CPU2', 'CPU3'];
        const cardsPerOwner = DECK_SIZE / owners.length;
        let currentOwnerIndex = 0;
        
        for (let i = 0; i < cards.length; i++) {
            cards[i].owner = owners[currentOwnerIndex];
            if ((i + 1) % cardsPerOwner === 0) {
                currentOwnerIndex++;
            }
        }
        
        return cards;
    };

    // const [cards] = useState(shuffleDeck(createDeck()));
    const [cards] = useState(assignOwner(shuffleDeck(createDeck())));
    const [gameStarted, setGameStarted] = useState(false);

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
        console.log(`Clicked on ${card.rank} of ${card.suit} owned by ${card.owner}`);
        try {
            const response = await fetch('http://localhost:8080/card/add', {
                method: 'POST',
                headers: {
                    'Content-Type': 'application/json',
                },
                body: JSON.stringify({
                    suit: card.suit,
                    value: rankToValue(card.rank),  
                    owner: card.owner
                })
            });
            if (!response.ok) {
                throw new Error('Network response was not ok');
            }
            const data = await response.text();
            console.log('Server response:', data);
        } catch (error) {
            console.error('Error sending card click data:', error);
        }
    };

    const removeDeckDB = () => {
        fetch("http://localhost:8080/card/removeAll", {
            method: 'POST'
        })
        .then(response => {
            if (!response.ok) {
                throw new Error(`Server returned status: ${response.status}`);
            }
            return response.text();
        })
        .then(data => {
            console.log('Server response:', data);
        })
        .catch(error => {
            console.error('Error emptying card table:', error);
        });
    };
    
    const sendDeckDB = () => {
        console.log("sendDeckDB");
        cards.forEach(card => {
            fetch('http://localhost:8080/card/add', {
                method: 'POST',
                headers: {
                    'Content-Type': 'application/json',
                },
                body: JSON.stringify({
                    suit: card.suit,
                    value: rankToValue(card.rank),  
                    owner: card.owner
                })
            })
            .then(response => {
                if (!response.ok) {
                    throw new Error('Network response was not ok');
                }
                return response.text();
            })
            .then(data => {
                console.log('Server response:', data);
            })
            .catch(error => {
                console.error('Error sending card data:', error);
            });
        });
    };
    
    // useEffect(() => {
    //     removeDeckDB();
    //     sendDeckDB();
    //     console.log("Cards: " + cardNum);
    // }, []);

    const handleStart = () => {
        setGameStarted(true);
        removeDeckDB();
        sendDeckDB();
    };

    return (
        <div>
            {!gameStarted && (
                <Button variant="contained" color="primary" onClick={handleStart}>Start</Button>
            )}
            {gameStarted && (
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
            )}
        </div>
    );
};

export default CardDeck;