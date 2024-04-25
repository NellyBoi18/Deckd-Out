import React from 'react';
import { styled } from '@mui/system';
import { Container, Typography, Button, Grid, Avatar, Box, AppBar, Toolbar } from '@mui/material';
import Logo from '../../assets/logo.svg';

/**
 * Define custom styles using styled
 */
const RootContainer = styled(Container)({
  display: 'flex',
  flexDirection: 'column',
  alignItems: 'center',
  justifyContent: 'center',
  height: '100vh',
  backgroundColor: '#539987',
});

/**
 * Styles for the logo image
 */
const LogoImage = styled('img')({
  maxWidth: '100%',
  width: '350px',
  height: 'auto',
  marginBottom: '2rem',
});

/**
 * Functional component representing the home screen
 */
function SpadesDefault() {
  return (
    <div style={{ backgroundColor: '#F1E5C2', minHeight: '100vh' }}>
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
          <Button variant="contained" color="primary">Deal</Button>
        </Box>
    </div>
  );
}

export default SpadesDefault;
