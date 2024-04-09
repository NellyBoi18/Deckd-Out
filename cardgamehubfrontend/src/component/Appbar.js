import * as React from 'react';
import AppBar from '@mui/material/AppBar';
import Box from '@mui/material/Box';
import Toolbar from '@mui/material/Toolbar';
import Typography from '@mui/material/Typography';
import Button from '@mui/material/Button';
import IconButton from '@mui/material/IconButton';

/**
 * Component for rendering the application's app bar.
 */
export default function Appbar() {
  return (
    <Box sx={{ flexGrow: 1 }}>
      <AppBar position="static">
        <Toolbar>
          {/* Icon button placeholder */}
          <IconButton
            size="large"
            edge="start"
            color="inherit"
            aria-label="menu"
            sx={{ mr: 2 }}
          >
          </IconButton>
          {/* Application title */}
          <Typography variant="h6" component="div" sx={{ flexGrow: 1 }}>
            Test Users
          </Typography>
          {/* Button to add test user */}
          <Button color="inherit">Add Test User</Button>
        </Toolbar>
      </AppBar>
    </Box>
  );
}
