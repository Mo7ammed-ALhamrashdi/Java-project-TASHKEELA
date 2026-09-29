package com.omanfootball.manager.controller;


import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;


import com.omanfootball.manager.entity.Match;
import com.omanfootball.manager.service.MatchService;



@RestController
@RequestMapping("/api/matches")
@RequiredArgsConstructor
public class MatchController {



    private final MatchService matchService;



    @GetMapping
    public List<Match> getMatches(){

        return matchService.getAllMatches();

    }



    @PostMapping
    public Match create(
            @RequestBody Match match
    ){

        return matchService.createMatch(match);

    }



    @GetMapping("/{id}")
    public Match getMatch(
            @PathVariable Long id
    ){

        return matchService.getMatchById(id);

    }



    @DeleteMapping("/{id}")
    public String delete(
            @PathVariable Long id
    ){

        matchService.deleteMatch(id);

        return "Match deleted";

    }


}