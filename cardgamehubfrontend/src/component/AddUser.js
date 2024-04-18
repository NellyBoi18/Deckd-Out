import * as React from 'react';
import Box from '@mui/material/Box';
import TextField from '@mui/material/TextField';
import Button from '@mui/material/Button';
import { useState } from 'react';

/**
 * Component for registering a user.
 */
export default function RegisterUser() {
    // State variables to store name and level
    const [name, setName] = useState("");
    const [password, setPassword] = useState("");

    /**
     * Function to register user data.
     * @param {Event} e - The event object.
     */
    const submitData = (e) => {
        e.preventDefault();
        const userData = { name, password };
        // Here, we are using a post request to send data to the API
        fetch("http://localhost:8080/Users/add", {
            method: "POST",
            headers: { "Content-Type": "application/json" },
            body: JSON.stringify(userData)
        })
        .then(res => console.log(res))
        .catch(e => console.log(e))
    };

    return (
        <div>
            <h1>Add User</h1>
            <Box
                component="form"
                sx={{
                    '& > :not(style)': { m: 0.5, width: '50%' },
                }}
                noValidate
                autoComplete="off"
            >
                <TextField label="name" variant="outlined" onChange={(e) => setName(e.target.value)} />
                <TextField label="password" variant="outlined" onChange={(e) => setPassword(e.target.value)} />
                <Button onClick={submitData} style={{ padding: "14px" }} variant="contained">Re User</Button>
            </Box>
        </div>
    );
}
