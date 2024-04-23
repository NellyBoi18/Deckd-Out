package com.DeckdOut.cardgamehub.service;

import com.DeckdOut.cardgamehub.model.Player;
import com.DeckdOut.cardgamehub.repository.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Service class responsible for managing Card entities.
 */
@Service
public class PlayerService implements PlayerServiceInterface{
    
    @Autowired
    PlayerRepository playerRepository;

    /**
     * Addes a new player to the repository
     * 
     * @param player the player to be added
     * @return a string indicating the result of the operation
     */
    @Override
    public String addPlayer(Player player){
        if(playerRepository.findByName(player.getuserName()) != null){
            return "Player with username already exists";
        }
        Player result = playerRepository.save(player);
        return "Successful";
    }

    /**
     * Removes a player from the repository
     * 
     * @param player the player to be removed
     * @return a string indicating the result of the operation
     */
    @Override
    public String removePlayer(Player player){
        if(playerRepository.findByName(player.getuserName()) != null){
            return "Player with username already exists";
        }
        playerRepository.delete(player);
        return "Successful";
    }

    /**
     * Retrieves all cards from the repository
     * 
     * @return a list containing all players, sorted by descending ID
     */
    @Override
    public List<Player> findAllPlayers(){
        return playerRepository.findAll(Sort.by(Sort.Direction.DESC, "id"));
    }
}
