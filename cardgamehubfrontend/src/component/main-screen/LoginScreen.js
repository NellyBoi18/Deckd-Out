/**
 * LoginScreen component for user login functionality.
 * @module LoginScreen
 */

import React, { useState, useContext , useEffect} from 'react';
import { styled } from '@mui/system';
import { Container, Typography, Button } from '@mui/material';
import Logo from '../../assets/logo.svg';

import LoginStatusContext from "../contexts/LoginStatusContext";

/**
 * RootContainer styled component for the main container.
 * @const {JSX.Element}
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
    fontSize: '18px', 
    color: 'black', 
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
    position: 'absolute', 
    top: '20px', 
    left: '20px', 
    width: '10%', 
  });

/**
 * LoginScreen functional component for user login.
 * @returns {JSX.Element} JSX representation of the login screen.
 */
export default function LoginScreen() {
  const [username, setUsername] = useState('');
  const [password, setPassword] = useState('');
  const [users, setUsers] = useState([]);
  const [loginStatus, setLoginStatus] = useContext(LoginStatusContext);

  // Fetch users from api. Don't worry. It's VERY SECURE.
  useEffect(() => {
    fetch("http://localhost:8080/user")
      .then(res => res.json())
      .then(users => setUsers(users))
      .catch(error => console.error("Error fetching users: ", error))
  }
  , []); // Empty dependency array means this effect runs only once after initial render

  /**
   * Handle login form submission.
   * @param {Event} event - The event object.
   */
  const handleLogin = async (e) => {
    e.preventDefault(); 

    if (!username || !password) {
      alert('You must provide a username and password!');
    } else {
      try{
        // Check if user exists
        const loggedInUser = users.find(user => user.username === username);

        if (loggedInUser) { // User exists
          if (loggedInUser.password === password) { // Password is correct
            console.log('Login successful')

            //sign user in
            setLoginStatus({
              isLoggedIn: true,
              loggedInUsername: username,
            });
            sessionStorage.setItem("username", username);
            console.log(loginStatus.loggedInUsername);
            console.log(sessionStorage.getItem("username"));
            // Redirect user to home
            window.location.href = '/home';
          } else { 
            alert('Password is incorrect');
            return; 
          }
        } else { 
          alert('User does not exist');
          return;
        }
      } catch (error){
        console.error('Login error:', error.message);
      }
    }
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
