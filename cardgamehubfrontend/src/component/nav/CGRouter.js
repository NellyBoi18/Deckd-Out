/**
 * This component represents a router for the Card Games application using React Router.
 * It defines routes for different components/pages.
 */
import { BrowserRouter, Route, Routes } from "react-router-dom";
import HomeScreen from "../main-screen/HomeScreen";

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
                <Route path="/" element={<HomeScreen />} />

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
