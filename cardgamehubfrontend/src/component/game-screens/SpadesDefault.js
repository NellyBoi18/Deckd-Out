import { Button, Box, AppBar, Toolbar } from '@mui/material';
import CardDeck from './CardDeck';
import Logo from '../../assets/logo.svg';

/**
 * Function component for the SpadesDefault page.
 * @returns {JSX.Element} The JSX element for the SpadesDefault page.
 */
function SpadesDefault() {
    return (
        // Main container with background color and minimum height
        <div style={{ backgroundColor: '#F1E5C2', minHeight: '100vh' }}>
            {/* App bar with logo */}
            <AppBar position="static" style={{ backgroundColor: '#CC4124' }}>
                <Toolbar>
                    {/* Logo image */}
                    <img src={Logo} alt="Logo" style={{ marginRight: '10px', width: '50px' }} />
                </Toolbar>
            </AppBar>
            {/* Container for the main content */}
            <Box
                sx={{
                    backgroundColor: '#539987',
                    borderRadius: '8px',
                    width: '90%',
                    height: '500px',
                    margin: '50px auto',
                    transition: 'box-shadow 0.3s',
                    boxShadow: '0px 0px 10px 0px rgba(0,0,0,0.75)',
                    display: 'flex',
                    alignItems: 'center',
                    justifyContent: 'center'
                }}
            >
                {/* Render the CardDeck component */}
                <CardDeck/>
                {/* Back button */}
                <Button variant="contained" href="/home" color="primary" style={{ position: 'absolute', bottom: '20px', right: '20px' }}>Back</Button>
            </Box>
        </div>
    );
}

export default SpadesDefault;
