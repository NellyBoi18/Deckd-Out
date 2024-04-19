/**
 * This component represents a router for the Card Games application using React Router.
 * It defines routes for different components/pages.
 */
import { BrowserRouter, Route, Routes } from "react-router-dom";
import HomeScreen from "../main-screen/HomeScreen";
import RegisterScreen from "../main-screen/RegisterScreen";
import LoginScreen from "../main-screen/LoginScreen";
import Leaderboard from "../main-screen/Leaderboard";
import SpadesDefault from "../game-screens/SpadesDefault";

export default function CGRouter() {
    /**
     * Renders a BrowserRouter component with defined routes.
     * @returns JSX element representing the router with routes.
     */
    return (
        <BrowserRouter>
            <Routes>
                {/* 
                Renders a Route component for the root path, rendering the DisplayTestUser component.
                */}
                <Route path="/" element={<RegisterScreen />} />
                <Route path="/home" element={<HomeScreen />} />
                <Route path="/register" element={<RegisterScreen />} />
                <Route path="/login" element={<LoginScreen />} />
                <Route path="/leaderboard" element={<Leaderboard />} />
                <Route path="/spades" element={<SpadesDefault />} />
                {/* <Route path="/TESTING" element={<TestTable />} /> */}

                {/* (temporary reference for how to set up navigation)
                <Route path="/" element={<BadgerBuds />}>
                    <Route index element={<BadgerBudsLanding />} />
                    <Route path="available-cats" element={<BadgerBudsAdoptable />} />
                    <Route path="basket" element={<BadgerBudsBasket />} />
                </Route>
                */}
            </Routes>
        </BrowserRouter>
    );
}
