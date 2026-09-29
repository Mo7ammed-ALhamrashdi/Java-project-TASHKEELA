package com.omanfootball.manager.controller;


import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;


import com.omanfootball.manager.entity.FantasyTeam;
import com.omanfootball.manager.repository.FantasyTeamRepository;



@RestController
@RequestMapping("/api/leaderboard")
@RequiredArgsConstructor
public class LeaderboardController {



    private final FantasyTeamRepository repository;



    @GetMapping
    public List<FantasyTeam> getLeaderboard(){


        return repository.findAll();


    }


}