import React, { useContext } from "react";
import { Button, Container, Typography } from "@mui/material";
import { styled } from "@mui/system";

import LoginStatusContext from "../contexts/LoginStatusContext";

const RootContainer = styled(Container)({
  display: 'flex',
  flexDirection: 'column',
  alignItems: 'center',
  justifyContent: 'center',
  height: '100vh',
});

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

export default function LogoutScreen() {
  const [, setLoginStatus] = useContext(LoginStatusContext);

  const handleLogout = () => {
    // Clear login status and redirect to login screen
    setLoginStatus({
      isLoggedIn: false,
      loggedInUsername: 'Not Logged In',
    });
    sessionStorage.removeItem("username");
    window.location.href = '/login';
  };

  const handleBack = () => {
    // Redirect to home screen
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
