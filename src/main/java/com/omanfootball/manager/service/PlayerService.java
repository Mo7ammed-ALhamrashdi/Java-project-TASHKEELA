package com.omanfootball.manager.service;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

import com.omanfootball.manager.entity.Player;
import com.omanfootball.manager.repository.PlayerRepository;


@Service
@RequiredArgsConstructor
public class PlayerService {


    private final PlayerRepository playerRepository;



    public List<Player> getAllPlayers(){

        return playerRepository.findAll();

    }



    public Player getPlayerById(Long id){

        return playerRepository.findById(id)
                .orElseThrow(
                        () -> new RuntimeException("Player not found")
                );

    }



    public Player createPlayer(Player player){

        return playerRepository.save(player);

    }



    public Player updatePlayer(
            Long id,
            Player newPlayer
    ){


        Player player = getPlayerById(id);


        player.setName(newPlayer.getName());

        player.setPosition(newPlayer.getPosition());

        player.setAge(newPlayer.getAge());

        player.setPrice(newPlayer.getPrice());

        player.setOverallRating(
                newPlayer.getOverallRating()
        );


        return playerRepository.save(player);

    }




    public void deletePlayer(Long id){

        playerRepository.deleteById(id);

    }


}