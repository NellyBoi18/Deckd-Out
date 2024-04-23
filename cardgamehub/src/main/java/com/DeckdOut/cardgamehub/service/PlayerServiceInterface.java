package com.DeckdOut.cardgamehub.service;

import com.DeckdOut.cardgamehub.model.Player;

import java.util.List;

/**
 * Interface defining methods for managing Player entities
 */
public interface PlayerServiceInterface {
    /**
     * Adds a new Player
     * 
     * @param player the player to be added
     * @return a string indicating the result of the operation
     */
    public String addPlayer(Player player);

    /**
     * Removes a player
     * 
     * @param player the player to be removed
     * @return a string indicating the result of the operation
     */
    public String removePlayer(Player player);

    /**
     * Retrieves all players
     * 
     * @return a list containing all players
     */
    public List<Player> findAllPlayers();
}
