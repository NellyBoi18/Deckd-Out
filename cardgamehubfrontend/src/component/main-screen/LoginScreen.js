/**
 * LoginScreen component for user login functionality.
 * @module LoginScreen
 */

import React, { useState } from 'react';
import { styled } from '@mui/system';
import { Container, Typography, Button } from '@mui/material';
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
 * FormContainer styled component for the login form container.
 * @const {JSX.Element}
 */
const FormContainer = styled('div')({
  backgroundColor: '#CC4124',
  padding: '60px',
  borderRadius: '10px',
  boxShadow: '0 8px 12px rgba(0, 0, 0, 0.1)',
  display: 'flex',
  flexDirection: 'column',
  alignItems: 'center',
});

/**
 * InputField styled component for the input fields.
 * @const {JSX.Element}
 */
const InputField = styled('input')({
  width: '100%',
  padding: '10px',
  marginBottom: '20px',
  borderRadius: '5px',
  border: '1px solid #ccc',
  backgroundColor: '#F1E5C2',
  type: 'password',
  '::placeholder': {
    fontSize: '18px', // Adjust placeholder font size here
    color: 'black', // Adjust placeholder color here
  },
});

/**
 * LoginButton styled component for the login button.
 * @const {JSX.Element}
 */
const LoginButton = styled(Button)({
  backgroundColor: '#2D080A',
  color: '#fff',
  border: 'none',
  borderRadius: '5px',
  padding: '15px 30px',
  marginTop: '20px',
  cursor: 'pointer',
  '&:hover': {
    backgroundColor: '#2D080A',
  },
});

/**
 * SignUpLink styled component for the sign-up link.
 * @const {JSX.Element}
 */
const SignUpLink = styled('a')({
  marginTop: '10px',
  color: '#F1E5C2',
  textDecoration: 'underline',
  cursor: 'pointer',
  fontSize: '26px',
});

/**
 * LogoImage styled component for the logo image.
 * @const {JSX.Element}
 */
const LogoImage = styled('img')({
    position: 'absolute', // Position the logo absolute to the container
    top: '20px', // Adjust top position as needed
    left: '20px', // Adjust left position as needed
    width: '10%', // Adjust the width of the logo as needed
  });

/**
 * LoginScreen functional component for user login.
 * @returns {JSX.Element} JSX representation of the login screen.
 */
export default function LoginScreen() {
  const [username, setUsername] = useState('');
  const [password, setPassword] = useState('');

  /**
   * Handle login form submission.
   * @param {Event} event - The event object.
   */
  const handleLogin = (event) => {
    // event.preventDefault(); 
    // if (!username || !password) {
    //   alert('You must provide a username and password!');
    // } else if (0) {
    //   //verify user and pass here
    //   alert('Your passwords do not match!');
    // } else {
    //   // Make a POST request to the registration API
    //   // Upon successful login, redirect to the home page
    //   window.location.href = '/home';
    // }
    window.location.href = '/home';
  };

  return (
    <RootContainer>
      <LogoImage src={Logo} alt="Logo" />
      <FormContainer>
        <Typography variant="h2" gutterBottom style={{ zIndex: 1, position: 'relative', textAlign: 'left', color: '#F1E5C2' }}>
          Login
        </Typography>
        <form onSubmit={handleLogin} style={{ width: '400px' }}>
          <InputField
            type="text"
            id="username"
            name="username"
            placeholder="Username"
            required
            value={username}
            onChange={(e) => setUsername(e.target.value)}
          />
          <InputField
            type="password"
            id="password"
            name="password"
            placeholder="Password"
            required
            value={password}
            onChange={(e) => setPassword(e.target.value)}
          />
          <LoginButton type="submit">
            Login
          </LoginButton>
        </form>
      </FormContainer>
      <Typography variant="h5" style={{ marginTop: 20 }}>Don't have an account?</Typography>
      <SignUpLink href="/register">Sign up here!</SignUpLink>
    </RootContainer>
  );
}
