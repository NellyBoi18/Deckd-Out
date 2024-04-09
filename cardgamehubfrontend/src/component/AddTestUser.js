import * as React from 'react';
import Box from '@mui/material/Box';
import TextField from '@mui/material/TextField';
import Button from '@mui/material/Button';
import { useState } from 'react';

/**
 * Component for adding a test user.
 */
export default function AddTestUser() {
    // State variables to store name and level
    const [name, setName] = useState("");
    const [level, setLevel] = useState("");

    /**
     * Function to submit test user data.
     * @param {Event} e - The event object.
     */
    const submitData = (e) => {
        e.preventDefault();
        const testUserData = { name, level };
        // Here, we are using a post request to send data to the API
        fetch("http://localhost:8080/testUser/add", {
            method: "POST",
            headers: { "Content-Type": "application/json" },
            body: JSON.stringify(testUserData)
        })
        .then(res => console.log(res))
        .catch(e => console.log(e))
    };

    return (
        <div>
            <h1>Add Test User</h1>
            <Box
                component="form"
                sx={{
                    '& > :not(style)': { m: 0.5, width: '50%' },
                }}
                noValidate
                autoComplete="off"
            >
                <TextField label="name" variant="outlined" onChange={(e) => setName(e.target.value)} />
                <TextField label="level" variant="outlined" onChange={(e) => setLevel(e.target.value)} />
                <Button onClick={submitData} style={{ padding: "14px" }} variant="contained">Add Test User</Button>
            </Box>
        </div>
    );
}
