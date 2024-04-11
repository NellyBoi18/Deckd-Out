import React, { useState } from 'react';
//import { Form, Button } from "react-bootstrap";
import { styled } from '@mui/system';
import { Container, Typography, Button, Grid, FormControl } from '@mui/material';
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
  
  const FormContainer = styled('div')({
    backgroundColor: '#CC4124',
    padding: '60px',
    borderRadius: '10px',
    boxShadow: '0 8px 12px rgba(0, 0, 0, 0.1)',
    display: 'flex',
    flexDirection: 'column',
    alignItems: 'center',
  });
  
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
   * Styles for the button
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

  const SignInLink = styled('a')({
    marginTop: '10px',
    color: '#F1E5C2',
    textDecoration: 'underline',
    cursor: 'pointer',
    fontSize: '26px'
  });

  const LogoImage = styled('img')({
    position: 'absolute', // Position the logo absolute to the container
    top: '20px', // Adjust top position as needed
    left: '20px', // Adjust left position as needed
    width: '10%', // Adjust the width of the logo as needed
  });

export default function RegisterScreen() {
    const [username, setUsername] = useState('');
    const [email, setEmail] = useState('');
    const [password, setPassword] = useState('');
    const [confirmPassword, setConfirmPassword] = useState('');

    const handleRegister = (e) => {
      e.preventDefault();
      const userData = { email, username, password};
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
          // Make a POST request to the registration API
          fetch("http://localhost:8080/Users/add", {
            method: "POST",
            headers: { "Content-Type": "application/json" },
            body: JSON.stringify(userData)
        })
        .then(res => console.log(res))
        .catch(e => console.log(e))
        console.log("user created");
        window.location.href = '/home';
      }
      //window.location.href = '/home';
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
                    // required 
                    onChange={(e) => setPassword(e.target.value)}
                />
                <InputField 
                    type="password" 
                    id="confirm_password" 
                    name="confirm_password" 
                    placeholder="Confirm Password" 
                    // required 
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