import React, { useState } from 'react';
import { Typography, Button, Box, AppBar, Toolbar } from '@mui/material';
import Logo from '../../assets/logo.svg';
import { shuffleDeck, createDeck, getSuitSymbol } from './CardDeck';

function SpadesDefault() {
    const [dealtCards, setDealtCards] = useState({ player: [], cpu1: [], cpu2: [], cpu3: [] });
    const [isDealt, setIsDealt] = useState(false);

    const dealCards = () => {
        const deck = shuffleDeck(createDeck());
        const hands = { player: [], cpu1: [], cpu2: [], cpu3: [] };
        for (let i = 0; i < deck.length; i++) {
            const playerKey = Object.keys(hands)[i % 4];
            hands[playerKey].push(deck[i]);
        }
        setDealtCards(hands);
        setIsDealt(true);
        // Log each hand to the console
      console.log("Player's hand:", hands.player);
      console.log("CPU1's hand:", hands.cpu1);
      console.log("CPU2's hand:", hands.cpu2);
      console.log("CPU3's hand:", hands.cpu3);

    };

    const cardStyle = {
        height: "100px",
        width: "70px",
        margin: "5px",
        display: "flex",
        flexDirection: "column",
        justifyContent: "center",
        alignItems: "center",
        background: "#fff",
        border: "1px solid #000",
        borderRadius: "8px",
        boxShadow: "0 2px 10px rgba(0,0,0,0.3)",
        fontFamily: "'Times New Roman', serif",
        position: 'relative',
        fontSize: '18px',
        cursor: 'pointer', // You may or may not want the pointer effect
    };


    const cardBackStyle = {
      height: "100px",
      width: "70px",
      margin: "5px",
      backgroundColor: "#CC4124", 
      border: "1px solid #000",
      borderRadius: "10px",
      boxShadow: "0 2px 10px rgba(0,0,0,0.3)"
    };

    const renderCard = (card, index) => {
        return (
            <div
                key={card.suit + card.rank + index}
                style={{
                    ...cardStyle,
                    color: card.suit === 'diamonds' || card.suit === 'hearts' ? 'red' : 'black',
                }}
                // onClick={() => handleCardClick(card)} // Include if you want a click handler
            >
                <div style={{ position: 'absolute', top: '5px', left: '5px' }}>
                    <div style={{ fontSize: '24px' }}>{card.rank}</div>
                    <div style={{ fontSize: '18px' }}>{getSuitSymbol(card.suit)}</div>
                </div>
                <div style={{ fontSize: '35px' }}>{getSuitSymbol(card.suit)}</div>
                <div style={{ position: 'absolute', bottom: '5px', right: '5px', transform: 'rotate(180deg)' }}>
                    <div style={{ fontSize: '24px' }}>{card.rank}</div>
                    <div style={{ fontSize: '18px' }}>{getSuitSymbol(card.suit)}</div>
                </div>
            </div>
        );
    };

    const renderCardBack = (index, isHorizontal = true) => {
        const offsetStyle = isHorizontal
            ? { left: `${index * 15}px` }
            : { top: `${index * 30}px` };

        return (
            <div
                key={'back' + index}
                style={{
                    ...cardBackStyle,
                    position: 'absolute',
                    ...offsetStyle,
                }}
            >
            </div>
        );
    };
    const renderCardBackHorizontal = (index) => {
        const offsetStyle = { 
            left: `${index * 15}px`, 
            zIndex: index, // Ensures that cards are stacked with the correct card on top
        };
    
        return (
            <div
                key={'back' + index}
                style={{
                    ...cardBackStyle,
                    position: 'absolute',
                    ...offsetStyle,
                }}
            >
            </div>
        );
    };

    // Define the styles for the player and CPU hands
    const handStyles = {
        player: {
            position: 'absolute',
            bottom: '10%',
            left: '50%',
            transform: 'translateX(-50%)',
            display: 'flex',
            flexWrap: 'nowrap',
            overflowX: 'auto'
        },
        cpu1: {
            position: 'absolute',
            left: '13%',
            top: '15%',
            transform: 'translateY(-50%) rotate(90deg)', // Rotate the hand to be horizontal
            transformOrigin: 'bottom left', // Ensures that the rotation happens relative to the bottom left corner
        },
        cpu2: {
            position: 'absolute',
            top: '5%',
            left: '40%',
            transform: 'translateX(-50%)',
            display: 'flex',
            justifyContent: 'center'
        },
        cpu3: {
            position: 'absolute',
            right: '4%',
            top: '15%',
            transform: 'translateY(-50%) rotate(90deg)', // Rotate the hand to be horizontal
            transformOrigin: 'bottom right', // Ensures that the rotation happens relative to the bottom right corner
        }
    }
    

    return (
        <div style={{ backgroundColor: '#F1E5C2', minHeight: '100vh', position: 'relative' }}>
            <AppBar position="static" style={{ backgroundColor: '#CC4124' }}>
                <Toolbar>
                    <img src={Logo} alt="Logo" style={{ marginRight: '10px', width: '50px' }} />
                    <Typography variant="h6" component="div" sx={{ flexGrow: 1, textAlign: 'left', marginLeft: '10px' }}>
                        Team Score: 30
                    </Typography>
                    <Typography variant="h6" component="div" sx={{ flexGrow: 1, textAlign: 'center' }}>
                        Round 3
                    </Typography>
                    <Typography variant="h6" component="div" sx={{ flexGrow: 1, textAlign: 'right' }}>
                        Opponent Score: 40
                    </Typography>
                </Toolbar>
            </AppBar>

            <Box sx={{
                backgroundColor: '#539987',
                borderRadius: '8px',
                width: '90%',
                height: '500px',
                margin: '50px auto',
                boxShadow: '0px 0px 10px 0px rgba(0,0,0,0.75)',
                display: 'flex',
                alignItems: 'center',
                justifyContent: 'center',
                position: 'relative'  // Ensure absolute positioning within
            }}>
                <Button variant="contained" color="primary" onClick={dealCards}>Deal</Button>
                {isDealt && (
                  <>
                  <Box sx={handStyles.player}>
                      {dealtCards.player.map(renderCard)}
                  </Box>
                  <Box sx={handStyles.cpu1}>
                      {dealtCards.cpu1.map((_, index) => renderCardBackHorizontal(index))}
                  </Box>
                  <Box sx={handStyles.cpu2}>
                      {dealtCards.cpu2.map((_, index) => renderCardBack(index, true))}
                  </Box>
                  <Box sx={handStyles.cpu3}>
                      {dealtCards.cpu3.map((_, index) => renderCardBackHorizontal(index))}
                  </Box>
              </>
            )}

            </Box>

            <Button variant="contained" href="/home" color="primary" style={{ position: 'absolute', bottom: '20px', right: '20px' }}>Back</Button>
        </div>
    );
}

export default SpadesDefault;
