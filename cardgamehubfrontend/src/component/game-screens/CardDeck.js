import React, { useState, useEffect } from 'react';
import Button from '@mui/material/Button';
import CustomCard from './CustomCard';
import CustomCardFlipped from './CustomCardFlipped';

const RANKS = ["A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K"];
const SUITS = ["diamonds", "clubs", "hearts", "spades"];

const rankToValue = (rank) => {
    const faceValues = { 'A': 14, 'J': 11, 'Q': 12, 'K': 13 };
    return faceValues[rank] || parseInt(rank);
};

// These functions are now defined outside the component and are exported
export const createDeck = () => {
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

export const assignOwner = (cards) => {
    const DECK_SIZE = RANKS.length * SUITS.length;
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

const CardDeck = () => {
    const [winner, setWinner] = useState(null);
    const [gameFinished, setGameFinished] = useState(false);
    const [gameStart, setGameStart] = useState(false);

    // const getSuitSymbol = (suit) => {
    //     const symbols = {
    //         diamonds: '♦',
    //         clubs: '♣',
    //         hearts: '♥',
    //         spades: '♠'
    //     };
    //     return symbols[suit];
    // };

    const grabWinner = async () => {
        if (gameStart) {
            try {
                const response = await fetch('http://localhost:8080/card');
                if (!response.ok) {
                    throw new Error('Network response was not ok');
                }
                const data = await response.json();
                
                // Check if any item has a "suit" attribute equal to "Victory"
                console.log("CHECKING...");
                const victoryCard = data.find(card => card.suit === 'victory');
                if (victoryCard) {
                    setWinner(victoryCard.owner);
                    setGameFinished(true);
                    console.log("SET TO GAME FINISHED IS TRUE");
                }
            } catch (error) {
                console.error('Error fetching card data:', error);
            }
        }
    };

    const checkVictory = async () => {
        try {
            const response = await fetch('http://localhost:8080/card/checkvictory', {
                method: 'POST',
                headers: {
                    'Content-Type': 'application/json'
                },
            });
            if (!response.ok) {
                throw new Error('Network response was not ok');
            }
            const data = await response.text();
            console.log('Server response:', data);
        } catch (error) {
            console.error('Error victory check:', error);
        }

        grabWinner();
    };

    const handleCardClick = async (card) => {
        console.log(`Clicked on ${card.rank} of ${card.suit} owned by ${card.owner}`);
        try {
            const response = await fetch('http://localhost:8080/card/update', {
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

        checkVictory();

    };


//
const [dealtCards, setDealtCards] = useState({ player: [], cpu1: [], cpu2: [], cpu3: [] });

const deck = assignOwner(shuffleDeck(createDeck()));

const dealCards = () => {
    const hands = { player: [], cpu1: [], cpu2: [], cpu3: [] };

    deck.forEach(card => {
        switch (card.owner) {
            case 'Player':
                hands.player.push(card);
                break;
            case 'CPU1':
                hands.cpu1.push(card);
                break;
            case 'CPU2':
                hands.cpu2.push(card);
                break;
            case 'CPU3':
                hands.cpu3.push(card);
                break;
            default:
                break;
        }
    });

    setDealtCards(hands);
};

useEffect(() => { // testing purposes
    console.log("DEALT LIST: " + dealtCards);
}, [dealtCards]);    

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
    deck.forEach(card => {
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

const handleStart = () => {
    dealCards();
    removeDeckDB();
    sendDeckDB();
    setGameStart(true);
};

return (
    <div>
        {winner && gameStart && gameFinished && (
                <div style={{ textAlign: 'center', marginBottom: '20px' }}>
                    <h2>{`${winner} won!`}</h2>
                </div>
        )}

        {!gameStart && (
            <Button variant="contained" color="primary" onClick={handleStart}>Start</Button>
        )}
        {gameStart && (
            <div style={{ display: 'flex', flexDirection: 'column', alignItems: 'center' }}>
                {/* Player's Cards */}
                <div>
                    <div style={{ display: 'flex', justifyContent: 'center' }}>
                        <h3>Player's Cards: </h3>
                        {dealtCards.player.map((card, index) => (<CustomCard key={index} card={card} onClick={handleCardClick} />))}
                    </div>
                </div>

                {/* CPU1's Cards */}
                <div>
                    <div style={{ display: 'flex', justifyContent: 'center' }}>
                        <h3>CPU1's Cards: </h3>
                        {dealtCards.cpu1.map((card, index) => (<CustomCardFlipped key={index} card={card} onClick={handleCardClick} />))}
                    </div>
                </div>

                {/* CPU2's Cards */}
                <div>
                    <div style={{ display: 'flex', justifyContent: 'center' }}>
                        <h3>CPU2's Cards: </h3>
                        {dealtCards.cpu2.map((card, index) => (<CustomCardFlipped key={index} card={card} onClick={handleCardClick} />))}
                    </div>
                </div>

                {/* CPU3's Cards */}
                <div>
                    <div style={{ display: 'flex', justifyContent: 'center' }}>
                        <h3>CPU3's Cards: </h3>
                        {dealtCards.cpu3.map((card, index) => (<CustomCardFlipped key={index} card={card} onClick={handleCardClick} />))}
                    </div>
                </div>
            </div>
        )}
    </div>
);
};

export default CardDeck;
