import React, { useState, useEffect } from 'react';
import { Button, Box, AppBar, Toolbar } from '@mui/material';
import CardDeck from './CardDeck';
import Logo from '../../assets/logo.svg';

function SpadesDefault() {
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

                <CardDeck/>
                
                <Button variant="contained" href="/home" color="primary" style={{ position: 'absolute', bottom: '20px', right: '20px' }}>Back</Button>
            </Box>
            {/* add a component here to show the player's cards */}
        </div>
    );
}

export default SpadesDefault;
