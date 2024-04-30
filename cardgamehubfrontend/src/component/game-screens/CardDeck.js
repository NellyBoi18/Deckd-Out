import React, { useState } from 'react';
import Button from '@mui/material/Button';
import CustomCard from './CustomCard';
import CustomCardFlipped from './CustomCardFlipped';

// Define the ranks of playing cards
const RANKS = ["A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K"];

// Define the suits of playing cards
const SUITS = ["diamonds", "clubs", "hearts", "spades"];

// Function to convert a rank to its corresponding numerical value
const rankToValue = (rank) => {
    const faceValues = { 'A': 14, 'J': 11, 'Q': 12, 'K': 13 };
    return faceValues[rank] || parseInt(rank);
};

// Function to create a standard deck of playing cards
export const createDeck = () => {
    let cards = [];
    for (let suit of SUITS) {
        for (let rank of RANKS) {
            cards.push({ suit, rank });
        }
    }
    return cards;
};

// Function to shuffle a deck of cards
export const shuffleDeck = (cards) => {
    for (let i = cards.length - 1; i > 0; i--) {
        const j = Math.floor(Math.random() * (i + 1));
        [cards[i], cards[j]] = [cards[j], cards[i]];
    }
    return cards;
};

// Function to assign owners to each card in the deck
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

// Component representing the CardDeck
const CardDeck = () => {
    // State variables
    const [winner, setWinner] = useState(null);
    const [gameFinished, setGameFinished] = useState(false);
    const [gameStart, setGameStart] = useState(false);

    // Asynchronously grab the winner of the game
    const grabWinner = async () => {
        if (gameStart) {
            try {
                const response = await fetch('http://localhost:8080/card');
                if (!response.ok) {
                    throw new Error('Network response was not ok');
                }
                const data = await response.json();
                const victoryCard = data.find(card => card.suit === 'victory');
                if (victoryCard) {
                    setWinner(victoryCard.owner);
                    setGameFinished(true);
                }
            } catch (error) {
                console.error('Error fetching card data:', error);
            }
        }
    };

    // Asynchronously check for victory conditions
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

    // Handle click event on a card
    const handleCardClick = async (card) => {
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

    // Function to deal cards to players
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

    // Function to remove the deck from the database
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

    // Function to send the deck to the database
    const sendDeckDB = () => {
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

    // Function to start the game
    const handleStart = () => {
        dealCards();
        removeDeckDB();
        sendDeckDB();
        setGameStart(true);
    };

    // Render components based on game state
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
