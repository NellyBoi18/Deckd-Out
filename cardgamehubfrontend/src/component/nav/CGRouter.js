/**
 * This component represents a router for the Card Games application using React Router.
 * It defines routes for different components/pages.
 */
import React, { useState, useEffect } from "react";
import { BrowserRouter, Route, Routes } from "react-router-dom";
import HomeScreen from "../main-screen/HomeScreen";
import RegisterScreen from "../main-screen/RegisterScreen";
import LoginScreen from "../main-screen/LoginScreen";
import LogoutScreen from "../main-screen/LogoutScreen";
import Leaderboard from "../main-screen/Leaderboard";

import LoginStatusContext from "../contexts/LoginStatusContext";

export default function CGRouter() {
    const [loginStatus, setLoginStatus] = useState({
        isLoggedIn: false,
        loggedInUsername: 'Not Logged In',
    });

    // Check for login status in sessionStorage on component mount
    useEffect(() => {
        const storedLoginStatus = JSON.parse(sessionStorage.getItem('loginStatus'));
        if (storedLoginStatus) {
            setLoginStatus(storedLoginStatus);
        }
    }, []);

    // Update sessionStorage and context when login status changes
    useEffect(() => {
        sessionStorage.setItem('loginStatus', JSON.stringify(loginStatus));
    }, [loginStatus]);
    
    return (
        <LoginStatusContext.Provider value={[loginStatus, setLoginStatus]}>
            <BrowserRouter>
                <Routes>
                    <Route path="/" element={<RegisterScreen />} />
                    <Route path="/home" element={<HomeScreen />} />
                    <Route path="/register" element={<RegisterScreen />} />
                    <Route path="/login" element={<LoginScreen />} />
                    <Route path="/logout" element={<LogoutScreen />} />
                    <Route path="/leaderboard" element={<Leaderboard />} />
                </Routes>
            </BrowserRouter>
        </LoginStatusContext.Provider>
    );
}
