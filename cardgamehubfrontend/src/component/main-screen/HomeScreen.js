import React from 'react';
import { styled } from '@mui/system';
import { Container, Typography, Button, Grid, Avatar } from '@mui/material';
import Logo from '../../assets/logo.svg';
import SpadesIcon from '../../assets/spades-icon.png';
import EuchreIcon from '../../assets/euchre-icon.png';
import DefaultProfileIcon from '../../assets/default-icon.webp';
import SettingsIcon from '../../assets/settings-icon.png';

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
const PlayButton = styled(Button)({
  backgroundColor: '#CC4124',
  color: 'white',
  border: '3px solid white',
  borderRadius: '20px',
  padding: '18px 6px',
  width: '200px',
  height: '180px',
  textTransform: 'none',
  '&:hover': {
    backgroundColor: '#B33020',
  },
});

/**
 * Custom button component with styled
 */
const SecondaryOrangeButton = styled(Button)({
  backgroundColor: '#EC8F47',
  color: 'white',
  border: '3px solid white',
  borderRadius: '20px',
  height: '50px',
  textTransform: 'none',
  '&:hover': {
    backgroundColor: '#DE8036',
  },
});

/**
 * Custom button component with styled
 */
const SecondaryRedButton = styled(Button)({
  backgroundColor: '#CC4124',
  color: 'white',
  border: '3px solid white',
  borderRadius: '20px',
  height: '50px',
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
          <PlayButton variant="contained">
            <Grid container alignItems="center" justifyContent="center" direction="column">
              <Grid item sx={{ marginBottom: '0.5rem' }}>
                <Avatar alt="Spades Icon" src={SpadesIcon} sx={{ width: 80, height: 80, marginLeft: '0.5rem' }} />
              </Grid>
              <Grid item>
                <ButtonText variant="button">Play Spades</ButtonText>
              </Grid>
            </Grid>
          </PlayButton>
        </Grid>
        <Grid item>
          <PlayButton variant="contained">
            <Grid container alignItems="center" justifyContent="center" direction="column">
              <Grid item sx={{ marginBottom: '0.5rem' }}>
                <Avatar alt="Euchre Icon" src={EuchreIcon} sx={{ width: 80, height: 80, marginLeft: '0.5rem', borderRadius: 0 }} />
              </Grid>
              <Grid item>
                <ButtonText variant="button">Play Euchre</ButtonText>
              </Grid>
            </Grid>
          </PlayButton>
        </Grid>
      </Grid>
      <Grid container justifyContent="flex-start" sx={{ marginTop: '2rem', width: '100%', paddingLeft: '1rem' }}>
        <Grid item>
          <SecondaryOrangeButton href="/leaderboard" variant="contained" sx={{ position: 'fixed', bottom: 0, left: 0, marginLeft: '1rem', marginBottom: '1rem' }}>
          <ButtonText variant="button">Leaderboard</ButtonText>
          </SecondaryOrangeButton>
        </Grid>
        <Grid item>
          <SecondaryOrangeButton variant="contained" sx={{ position: 'fixed', bottom: 0, left: 160, marginLeft: '1rem', marginBottom: '1rem' }}>
          <ButtonText variant="button">Stats</ButtonText>
          </SecondaryOrangeButton>
        </Grid>
        <Grid item>
            <SecondaryRedButton variant="contained" sx={{ position: 'fixed', bottom: 0, right: 75, marginRight: '1rem', marginBottom: '1rem' }}>
              <Grid item sx={{ marginRight: '0.5rem' }}>
                    <Avatar alt="Default Profile Icon" src={DefaultProfileIcon} sx={{ width: 30, height: 30 }} />
              </Grid>
            <ButtonText variant="button">username</ButtonText>
          </SecondaryRedButton>
        </Grid>
        <Grid item>
            <SecondaryRedButton variant="contained" sx={{ position: 'fixed', bottom: 0, right: 0, marginRight: '1rem', marginBottom: '1rem' }}>
              <Grid item>
                    <Avatar alt="Settings Icon" src={SettingsIcon} sx={{ width: 30, height: 50 }} />
              </Grid>
          </SecondaryRedButton>
        </Grid>
      </Grid>
    </RootContainer>
  );
}

export default HomeScreen;
