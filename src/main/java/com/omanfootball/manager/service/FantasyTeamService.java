package com.omanfootball.manager.service;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

import com.omanfootball.manager.entity.FantasyTeam;
import com.omanfootball.manager.entity.FantasyTeamPlayer;
import com.omanfootball.manager.entity.Player;

import com.omanfootball.manager.repository.FantasyTeamRepository;
import com.omanfootball.manager.repository.FantasyTeamPlayerRepository;
import com.omanfootball.manager.repository.PlayerRepository;


@Service
@RequiredArgsConstructor
public class FantasyTeamService {



    private final FantasyTeamRepository teamRepository;


    private final FantasyTeamPlayerRepository playerRepository;


    private final PlayerRepository repository;




    public FantasyTeam createTeam(
            FantasyTeam team
    ){

        return teamRepository.save(team);

    }




    public FantasyTeam getTeam(Long id){

        return teamRepository.findById(id)
                .orElseThrow(
                        () -> new RuntimeException("Team not found")
                );

    }




    public FantasyTeamPlayer addPlayer(
            Long teamId,
            Long playerId
    ){


        FantasyTeam team =
                getTeam(teamId);



        Player player =
                repository.findById(playerId)
                        .orElseThrow(
                                () -> new RuntimeException(
                                        "Player not found")
                        );



        FantasyTeamPlayer fp =
                new FantasyTeamPlayer();


        fp.setFantasyTeam(team);

        fp.setPlayer(player);

        fp.setIsCaptain(false);

        fp.setPosition(player.getPosition());

        fp.setPrice(player.getPrice());

        fp.setOverallRating(
                player.getOverallRating()
        );


        return playerRepository.save(fp);

    }


}