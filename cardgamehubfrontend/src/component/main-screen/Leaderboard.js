import React from 'react';
import { useState, useEffect } from 'react';
import { styled } from '@mui/system';
import { Container, Typography, Avatar, Button, Box } from '@mui/material';
import { DataGrid } from '@mui/x-data-grid';

import Logo from '../../assets/logo.svg'; // Ensure the logo path is correct
import TrophyIcon from '../../assets/trophy.png'; // Ensure the trophy icon path is correct
import BurstImage from '../../assets/burst.png'; // Ensure the burst image path is correct
import BackArrowImage from '../../assets/backArrow.png'; // Adjust the path according to your file structure

const columns = [
  { field: 'username', headerName: 'NAME', width: 130 },
  { field: 'spadesGamesWon', headerName: 'SPADES GAMES WON', width: 130 },
];

// // Dummy data for leaderboard - replace with data fetching logic in a real application
// const users = [
//   { id: 1, username: 'USERNAME_1', score: 15000, avatar: 'path-to-avatar-1.png' },
//   // ... more users
// ];


/**
 * Styled component for the logo with absolute positioning
 */
const LogoContainer = styled(Box)(({ theme }) => ({ 
  position: 'absolute',
  top: theme.spacing(2),
  left: theme.spacing(2),
}));


/**
 * Container for the entire leaderboard, styled for full viewport height, width, and background
 */
const LeaderboardContainer = styled(Container)(({ theme }) => ({
  backgroundColor: '#EC8F47',
  display: 'flex',
  flexDirection: 'column',
  alignItems: 'center',
  justifyContent: 'center',
  width: '100vw',//todo make 100% for both 
  height: '100vh',
  background: `url(${BurstImage}) center/cover no-repeat, ${'#EC8F47'}`,
}));

/**
 * Main content area for leaderboard, defining size, color, and layout
 */
const LeaderboardContent = styled(Box)(({ theme }) => ({
  backgroundColor: '#F1E5C2',
  borderRadius: '50px',
  padding: theme.spacing(3),
  width: '700px',
  height: '600px',
  display: 'flex',
  flexDirection: 'column',
  alignItems: 'center', // This should center the children
  justifyContent: 'space-between', // This will push the button to the bottom
  margin: 'auto', // This centers the box itself within its container
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
 */
const LeaderboardButton = styled(Button)(({ theme }) => ({
  fontSize: '4rem', // Increases the font size, which also increases the icon size inside the button
  padding: '10px 20px', // Adjusts the padding to make the button larger
  minWidth: 'auto',
  backgroundColor: 'transparent', // Remove the blue background color
  '&:hover': {
    backgroundColor: 'transparent', // Remove the blue background color on hover
  },
}));

/**
 * Functional component representing the Leaderboard
 */
const Leaderboard = () => {
  // const [users, setUsers] = useState([]);
  // const [username, setUsername] = useState('');
  // const [spadesGamesWon, setSpadesGamesWon] = useState(0);

  // useEffect(() => {
  //   const fetchLeaderboard = async () => {
  //     try {
  //       const response = await fetch('http://localhost:8080/user', {
  //           method: 'GET',
  //           headers: {
  //             'Content-Type': 'application/json',
  //           },
  //         });
  //       if (!response.ok) {
  //         throw new Error('Failed to fetch leaderboard');
  //       }
  //       const data = await response.json();
  //       setUsers(data.users);
  //     } catch (error) {
  //       console.error('Error fetching leaderboard:', error.message);
  //     }
  //   };

  //   fetchLeaderboard();
  // }, []); // Empty dependency array to fetch data only once when component mounts

  const [users, setUser] = useState([]);

    /**Here, we are fetching users from the api */
    useEffect(()=>{
        fetch("http://localhost:8080/user")
        .then(res=>res.json())
        .then(userObj=>{
          userObj.sort((a, b) => b.spades_games_won - a.spades_games_won); // Doesn't work. Supposed to sort
          setUser(userObj);})
        .catch(e=>console.log(e))
    },[users]);
  
  return (
    <LeaderboardContainer>
      <LogoContainer>
        <Avatar src={Logo} alt="Deck'd Out Logo" sx={{ width: 150, height: 150 }} />
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
            // <LeaderboardItem key={user.id} isTopUser={index < 3}>
            //   <Typography variant="h6" component="span">{index + 1}</Typography>
            //   <Avatar src={user.avatar} alt={user.username} />
            //   <Typography>{user.username}</Typography>
            //   <Typography>{user.spadesGamesWon}</Typography>
            // </LeaderboardItem>
            <LeaderboardItem key={index}>
              <Typography variant="h6" component="span">{index + 1}</Typography>
              <Typography>{user.username}</Typography>
              <Typography>{user.spades_games_won}</Typography>
            </LeaderboardItem>
          ))}
        </LeaderboardList>
        {/* <DataGrid
        rows={users}
        columns={columns}
        pageSize={5}
        rowsPerPageOptions={[5]}
        checkboxSelection
        /> */}
        <LeaderboardButton href="/home" variant="contained">
          <Avatar src={BackArrowImage} alt="Back" sx={{ width: 48, height: 48 }} /> 
        </LeaderboardButton>
      </LeaderboardContent>
    </LeaderboardContainer>
  );
};

export default Leaderboard;
