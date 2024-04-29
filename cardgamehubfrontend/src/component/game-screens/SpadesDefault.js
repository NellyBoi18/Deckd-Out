import React, { useState } from 'react';
import { Typography, Button, Box, AppBar, Toolbar } from '@mui/material';
import { shuffleDeck, createDeck } from './CardDeck';
import Logo from '../../assets/logo.svg';

function SpadesDefault() {
    const [dealtCards, setDealtCards] = useState({ player: [], cpu1: [], cpu2: [], cpu3: [] });

    const dealCards = () => {
      const deck = shuffleDeck(createDeck());
      const hands = { player: [], cpu1: [], cpu2: [], cpu3: [] };
      deck.forEach((card, index) => {
          const playerKey = Object.keys(hands)[index % 4];
          hands[playerKey].push(card);
      });
      setDealtCards(hands);
      // Log each hand to the console
      console.log("Player's hand:", hands.player);
      console.log("CPU1's hand:", hands.cpu1);
      console.log("CPU2's hand:", hands.cpu2);
      console.log("CPU3's hand:", hands.cpu3);
  };
  

    return (
        <div style={{ backgroundColor: '#F1E5C2', minHeight: '100vh' }}>
            <AppBar position="static" style={{ backgroundColor: '#CC4124' }}>
                <Toolbar>
                    <img src={Logo} alt="Logo" style={{ marginRight: '10px', width: '50px' }} />
                    {/* Scores and Round Info Here */}
                </Toolbar>
            </AppBar>
            <Box
                sx={{
                    backgroundColor: '#539987',
                    borderRadius: '8px',
                    width: '90%',
                    height: '500px',
                    margin: '50px auto',
                    transition: 'box-shadow 0.3s',
                    boxShadow: '0px 0px 10px 0px rgba(0,0,0,0.75)',
                    display: 'flex',
                    alignItems: 'center',
                    justifyContent: 'center'
                }}
            >
                <Button variant="contained" color="primary" onClick={dealCards}>Deal</Button>
                <Button variant="contained" href="/home" color="primary" style={{ position: 'absolute', bottom: '20px', right: '20px' }}>Back</Button>
            </Box>
            {/* add a component here to show the player's cards */}
        </div>
    );
}

export default SpadesDefault;
