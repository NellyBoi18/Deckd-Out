package com.DeckdOut.cardgamehub.controller;

import com.DeckdOut.cardgamehub.model.Player;
import com.DeckdOut.cardgamehub.service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controller class responsible for handling HTTP requests related to cards in the card game hub application.
 */
@RestController
@RequestMapping("/player")
@CrossOrigin
public class PlayerController {
 
    @Autowired
    PlayerService playerService;

    /*
     * Endpoint for adding a new player
     * 
     * @param player the player object to be added
     * @return a string indicating the success or failure of teh operation
     */
    @PostMapping("/add")
    public String addPlayer(@RequestBody Player player){
        return playerService.addPlayer(player);
    }

    /*
     * Endpoint for retrieving all cards.
     * 
     * @return a list of all cards stored in the system
     */
    @GetMapping
    public List<Player> finaAllPlayers(){
        return playerService.findAllPlayers();
    }
}
