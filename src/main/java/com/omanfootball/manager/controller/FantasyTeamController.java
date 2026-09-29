package com.omanfootball.manager.controller;


import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;


import com.omanfootball.manager.entity.FantasyTeam;
import com.omanfootball.manager.entity.FantasyTeamPlayer;

import com.omanfootball.manager.service.FantasyTeamService;



@RestController
@RequestMapping("/api/fantasy-team")
@RequiredArgsConstructor
public class FantasyTeamController {


    private final FantasyTeamService fantasyTeamService;



    // Create fantasy team

    @PostMapping
    public FantasyTeam createTeam(
            @RequestBody FantasyTeam team
    ){

        return fantasyTeamService.createTeam(team);

    }



    // Add player to team

    @PostMapping("/{teamId}/add-player/{playerId}")
    public FantasyTeamPlayer addPlayer(
            @PathVariable Long teamId,
            @PathVariable Long playerId
    ){

        return fantasyTeamService.addPlayer(
                teamId,
                playerId
        );

    }



    // Get team

    @GetMapping("/{id}")
    public FantasyTeam getTeam(
            @PathVariable Long id
    ){

        return fantasyTeamService.getTeam(id);

    }


}