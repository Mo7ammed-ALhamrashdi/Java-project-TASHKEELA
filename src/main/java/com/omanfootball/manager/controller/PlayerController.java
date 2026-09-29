package com.omanfootball.manager.controller;


import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;


import com.omanfootball.manager.entity.Player;
import com.omanfootball.manager.service.PlayerService;



@RestController
@RequestMapping("/api/players")
@RequiredArgsConstructor
public class PlayerController {



    private final PlayerService playerService;




    @GetMapping
    public List<Player> getAllPlayers(){

        return playerService.getAllPlayers();

    }




    @GetMapping("/{id}")
    public Player getPlayer(
            @PathVariable Long id
    ){

        return playerService.getPlayerById(id);

    }




    @PostMapping
    public Player createPlayer(
            @RequestBody Player player
    ){

        return playerService.createPlayer(player);

    }





    @PutMapping("/{id}")
    public Player updatePlayer(
            @PathVariable Long id,
            @RequestBody Player player
    ){

        return playerService.updatePlayer(
                id,
                player
        );

    }




    @DeleteMapping("/{id}")
    public String deletePlayer(
            @PathVariable Long id
    ){

        playerService.deletePlayer(id);

        return "Player deleted";

    }


}