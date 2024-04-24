import React from 'react';
import { useState, useEffect } from 'react';
import { styled } from '@mui/system';
import { Container, Typography, Avatar, Button, Box } from '@mui/material';

import Logo from '../../assets/logo.svg'; // Ensure the logo path is correct
import TrophyIcon from '../../assets/trophy.png'; // Ensure the trophy icon path is correct
import BurstImage from '../../assets/burst.png'; // Ensure the burst image path is correct
import BackArrowImage from '../../assets/backArrow.png'; // Adjust the path according to your file structure

/**
 * Styled component for the logo with absolute positioning
 */
const LogoContainer = styled(Box)(({ theme }) => ({ 
  position: 'absolute',
  top: theme.spacing(0),
  left: theme.spacing(0),
}));

/**
 * Container for the entire leaderboard, styled for full viewport height, width, and background
 */
const LeaderboardContainer = styled(Container)(({ theme }) => ({
  display: 'flex',
  flexDirection: 'column',
  alignItems: 'center',
  justifyContent: 'center',
  width: '100%',
  height: '100%',
  background: `url(${BurstImage}) center/cover no-repeat, ${'#EC8F47'}`,
  overflow: 'hidden',
  position: 'absolute', // Make it cover the entire viewport
  top: 0,
  left: 80,
}));
/**
 * Main content area for leaderboard, defining size, color, and layout
 */
const LeaderboardContent = styled(Box)(({ theme }) => ({
  backgroundColor: '#F1E5C2',
  borderRadius: '50px',
  padding: theme.spacing(3),
  width: '700px',
  height: '500px',
  display: 'flex',
  flexDirection: 'column',
  alignItems: 'center', // This should center the children
  justifyContent: 'space-between', // This will push the button to the bottom
}));

const LeaderboardTitleContainer = styled(Box)({
  display: 'flex',
  alignItems: 'center',
  justifyContent: 'center',
  margin: '0 auto',
  marginTop: '-75px', // Adjust this value as needed to move the title up
});

/**
 * Header section containing the app logo, leaderboard title, and trophy icon
 */
const LeaderboardHeader = styled('header')({
  display: 'flex',
  alignItems: 'center',
  flexDirection: 'column', 
  justifyContent: 'center', // Changed to center the title and trophies
  width: '100%',
  marginBottom: '20px',
});

/**
 * Style for the leaderboard title, making it prominent and centered
 */
const LeaderboardTitle = styled(Typography)({
  backgroundColor: '#CC4124',
  fontSize: '3.2em',
  color: '#F1E5C2',
  borderRadius: '25px',
  padding: '10px 20px', // Adjust padding as needed
  // Removed 'position' and 'top' properties to keep the element in the normal document flow
});

/**
 * Individual list item in the leaderboard, styled for visibility and layout
 */
const LeaderboardItem = styled('li')(({ theme, isTopUser }) => ({
  backgroundColor: '#EC8F47',
  borderRadius: '10px',
  margin: theme.spacing(1),
  padding: theme.spacing(1),
  display: 'flex',
  alignItems: 'center',
  justifyContent: 'space-around',
}));

/**
 * List container for leaderboard items, ensuring proper list formatting
 */
const LeaderboardList = styled('ul')({
  listStyle: 'none',
  padding: 0,
  width: '100%',
});

/**
 * Button for future functionality, styled for consistency with the theme
 * Ensure that any potential pseudo-elements or additional styling that might interfere
 * with transparency are also handled.
 */
const LeaderboardButton = styled(Button)(({ theme }) => ({
  fontSize: '4rem',
  padding: '10px 20px',
  minWidth: 'auto',
  backgroundColor: 'transparent', // Ensures the button itself has a transparent background
  boxShadow: 'none', // Removes any box shadow that might be applied
  '&:hover': {
    backgroundColor: 'transparent', // Ensures the hover state is also transparent
    boxShadow: 'none',
  },
  // If there's an ::after or ::before pseudo-element causing the issue, override it here
  '&::before': {
    content: 'none',
  },
  '&::after': {
    content: 'none',
  },
}));

/**
 * Style overrides for the MUI Avatar component to ensure it has a transparent background
 */
const TransparentAvatar = styled(Avatar)({
  backgroundColor: 'transparent !important', // Override any other background styles
});


/**
 * Functional component representing the Leaderboard
 */
const Leaderboard = () => {

  // Fetch users from api
  const [users, setUsers] = useState([]);
  useEffect(() => {
      fetch("http://localhost:8080/user")
      .then(res => res.json())
      .then(users => {
        users.sort((a, b) => b.spadesGamesWon - a.spadesGamesWon); // Sort users by games won
        setUsers(users);})
      .catch(e => console.log(e))
  }
  , [users]);
  
  return (

    <LeaderboardContainer>
      <LogoContainer>
        <Avatar src={Logo} alt="Deck'd Out Logo" sx={{ width: 110, height: 110 }} />
      </LogoContainer>
      <LeaderboardContent>
      <LeaderboardHeader>
          <LeaderboardTitleContainer>
            <Avatar src={TrophyIcon} alt="Trophy" sx={{ width: 50, height: 50, marginRight: 2 }} />
            <LeaderboardTitle>LEADERBOARD</LeaderboardTitle>
            <Avatar src={TrophyIcon} alt="Trophy" sx={{ width: 50, height: 50, marginLeft: 2 }} />
          </LeaderboardTitleContainer>
        </LeaderboardHeader>
        <LeaderboardList>
        {users.map((user, index) => (
            <LeaderboardItem key={index}>
              <Typography>{user.username}</Typography>
              <Typography>{user.spadesGamesWon}</Typography>
            </LeaderboardItem>
          ))}
        </LeaderboardList>
        <LeaderboardButton href="/home" variant="contained">
        <TransparentAvatar src={BackArrowImage} alt="Back" />
      </LeaderboardButton>

      </LeaderboardContent>
    </LeaderboardContainer>
    
  );
};

export default Leaderboard;
