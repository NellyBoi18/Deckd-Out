import React from 'react';
import { styled } from '@mui/system';
import { Container, Typography, Button, Grid, Avatar } from '@mui/material';
import Logo from '../../assets/logo.svg';
import SpadesIcon from '../../assets/spades-icon.png';
import EuchreIcon from '../../assets/euchre-icon.webp';

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
 * Custom button component with styled
 */
const CustomButton = styled(Button)({
  backgroundColor: '#CC4124',
  color: 'white',
  border: '3px solid white',
  borderRadius: '20px',
  padding: '18px 6px',
  width: '220px',
  height: '200px',
  textTransform: 'none',
  '&:hover': {
    backgroundColor: '#B33020',
  },
});

/**
 * Styles for the button text
 */
const ButtonText = styled(Typography)({
  textShadow: '2px 2px 4px rgba(0,0,0,0.3)',
  textTransform: 'none',
  fontSize: '1.2rem',
});

/**
 * Functional component representing the home screen
 */
function HomeScreen() {
  return (
    <RootContainer>
      <LogoImage src={Logo} alt="Logo" />
      <Grid container spacing={15} alignItems="center" justifyContent="center">
        <Grid item>
          <CustomButton variant="contained">
            <Grid container alignItems="center" justifyContent="center" direction="column">
              <Grid item sx={{ marginBottom: '0.5rem' }}>
                <Avatar alt="Spades Icon" src={SpadesIcon} sx={{ width: 80, height: 80, marginLeft: '0.5rem' }} />
              </Grid>
              <Grid item>
                <ButtonText variant="button">Play Spades</ButtonText>
              </Grid>
            </Grid>
          </CustomButton>
        </Grid>
        <Grid item>
          <CustomButton variant="contained">
            <Grid container alignItems="center" justifyContent="center" direction="column">
              <Grid item sx={{ marginBottom: '0.5rem' }}>
                <Avatar alt="Euchre Icon" src={EuchreIcon} sx={{ width: 80, height: 80, marginLeft: '0.5rem' }} />
              </Grid>
              <Grid item>
                <ButtonText variant="button">Play Euchre</ButtonText>
              </Grid>
            </Grid>
          </CustomButton>
        </Grid>
      </Grid>
    </RootContainer>
  );
}

export default HomeScreen;
