/**
 * LogoutScreen component for handling user logout functionality.
 * This component displays a logout button and a back button.
 */
import React, { useContext } from "react";
import { Button, Container, Typography } from "@mui/material";
import { styled } from "@mui/system";

import LoginStatusContext from "../contexts/LoginStatusContext";

/**
 * Root container styled component for centering the content vertically in the viewport.
 */
const RootContainer = styled(Container)({
  display: 'flex',
  flexDirection: 'column',
  alignItems: 'center',
  justifyContent: 'center',
  height: '100vh',
});

/**
 * Logout button styled component for displaying the logout button.
 */
const LogoutButton = styled(Button)({
  marginTop: '1rem',
  backgroundColor: '#CC4124',
  color: '#fff',
  border: 'none',
  borderRadius: '5px',
  padding: '15px 30px',
  cursor: 'pointer',
  '&:hover': {
    backgroundColor: '#B33020',
  },
});

/**
 * Back button styled component for displaying the back button.
 */
const BackButton = styled(Button)({
  marginTop: '1rem',
  backgroundColor: '#EC8F47',
  color: '#fff',
  border: 'none',
  borderRadius: '5px',
  padding: '15px 30px',
  cursor: 'pointer',
  '&:hover': {
    backgroundColor: '#DE8036',
  },
});

/**
 * LogoutScreen component function.
 * @returns JSX.Element
 */
export default function LogoutScreen() {
  const [, setLoginStatus] = useContext(LoginStatusContext);

  /**
   * Handles logout functionality.
   * Clears login status and redirects to the login screen.
   */
  const handleLogout = () => {
    setLoginStatus({
      isLoggedIn: false,
      loggedInUsername: 'Not Logged In',
    });
    sessionStorage.removeItem("username");
    window.location.href = '/login';
  };

  /**
   * Handles back functionality.
   * Redirects to the home screen.
   */
  const handleBack = () => {
    window.location.href = '/home';
  };

  return (
    <RootContainer>
      <Typography variant="h2" gutterBottom>
        Logout
      </Typography>
      <LogoutButton onClick={handleLogout}>
        Logout
      </LogoutButton>
      <BackButton onClick={handleBack}>
        Back
      </BackButton>
    </RootContainer>
  );
}
