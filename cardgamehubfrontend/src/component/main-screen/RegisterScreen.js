/**
 * RegisterScreen component for user registration functionality.
 * @module RegisterScreen
 */

import React, { useState, useContext } from 'react';
import { styled } from '@mui/system';
import { Container, Typography, Button } from '@mui/material';
import Logo from '../../assets/logo.svg';

import LoginStatusContext from "../contexts/LoginStatusContext";
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
   * FormContainer styled component for the registration form container.
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
   * RegisterButton styled component for the registration button.
   * @const {JSX.Element}
   */
  const RegisterButton = styled(Button)({
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
   * SignInLink styled component for the sign-in link.
   * @const {JSX.Element}
   */
  const SignInLink = styled('a')({
    marginTop: '10px',
    color: '#F1E5C2',
    textDecoration: 'underline',
    cursor: 'pointer',
    fontSize: '26px'
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
 * RegisterScreen functional component for user registration.
 * @returns {JSX.Element} JSX representation of the registration screen.
 */
export default function RegisterScreen() {
    const [username, setUsername] = useState('');
    const [email, setEmail] = useState('');
    const [password, setPassword] = useState('');
    const [confirmPassword, setConfirmPassword] = useState('');

    const [loginStatus, setLoginStatus] = useContext(LoginStatusContext);

    /**
     * Handle registration form submission.
     * @param {Event} e - The event object.
     */
    const handleRegister = async (e) => {
      e.preventDefault(); // To prevent default form submission
      if (!username) {
        alert('You must provide a username!');
      } else if(!password){
        alert('You must provide a password!');
      } else if(!confirmPassword){
        alert('You must confirm your password!');
      }else if(!email){
        alert('You must provide an email!');
      }else if (password !== confirmPassword) {
          alert('Your passwords do not match!');
      } else {
        try {
          //fetch to user register API
          const response = await fetch('http://localhost:8080/user/register', {
            method: 'POST',
            headers: {
              'Content-Type': 'application/json',
            },
            body: JSON.stringify({
              username: username,
              email: email,
              password: password,
              "spadesNumGames": 0,
              "spadesGamesWon": 0,
              "euchreNumGames": 0,
              "euchreGamesWon": 0
            }),
          });
          const data = await response.text();
          console.log(data)
          //handle responses
          if (data.status === '500') {
            throw new Error('Network response was not ok');
          } else if (data === "User with username already exists"){
            alert("User with username already exists.")
            return;
          } else if (data === "User with email already exists"){
            alert("User with email already exists.")
            return;
          } else if (data === "registerUser Successful"){
          } else if (data === "registerUser Successful"){
            //const data = await response.json();
            console.log('Registration successful:', data.msg);

            //Logs user in with sessionstorage
            setLoginStatus({
              isLoggedIn: true,
              loggedInUsername: username,
            });
            sessionStorage.setItem("username", username);
            console.log(loginStatus.loggedInUsername)

            // Redirect user to home
            console.log(sessionStorage.getItem("username"))
            window.location.href = '/home';
          } else{
            alert("Something went wrong.");
            console.log(data);
          }
        } catch (error) {
          console.error('Registration error:', error.message);
        }
      }
      
    };    

    return (
        <RootContainer>
          <LogoImage src={Logo} alt="Logo" />
          <FormContainer>
            <Typography variant="h2" gutterBottom style={{ zIndex: 1, position: 'relative', textAlign: 'left', color: '#F1E5C2' }}>
                Register
            </Typography>
                <form onSubmit={handleRegister} style={{ width: '400px' }}>
                <InputField type="text" 
                    id="username" 
                    name="username" 
                    placeholder="Username" 
                    required 
                    onChange={(e) => setUsername(e.target.value)}
                />
                <InputField 
                    type="email" 
                    id="email" 
                    name="email" 
                    placeholder="Email" 
                    required 
                    onChange={(e) => setEmail(e.target.value)}
                />
                <InputField 
                    type="password" 
                    id="password" 
                    name="password" 
                    placeholder="Password" 
                    required 
                    onChange={(e) => setPassword(e.target.value)}
                />
                <InputField 
                    type="password" 
                    id="confirm_password" 
                    name="confirm_password" 
                    placeholder="Confirm Password" 
                    required 
                    onChange={(e) => setConfirmPassword(e.target.value)}
                />
                <RegisterButton 
                    type="submit" 
                    onClick={handleRegister}
                    >
                        Register
                    </RegisterButton>
                </form>
          </FormContainer>
          <Typography variant="h5" style={{marginTop: 20}}>Already have an account?</Typography><SignInLink href="/login">
            Sign in here!
           </SignInLink>
        </RootContainer>
      );
}
