package com.omanfootball.manager.controller;


import lombok.RequiredArgsConstructor;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;


import com.omanfootball.manager.entity.FantasyTeam;
import com.omanfootball.manager.service.LeaderboardService;



@RestController
@RequestMapping("/api/leaderboard")
@RequiredArgsConstructor
public class LeaderboardController {



    private final LeaderboardService service;





    @GetMapping
    public ResponseEntity<List<FantasyTeam>> getLeaderboard() {



        return ResponseEntity.ok(
                service.getLeaderboard()
        );



    }


}