package com.omanfootball.manager.controller;


import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;


import com.omanfootball.manager.entity.PlayerPerformance;
import com.omanfootball.manager.service.PerformanceService;



@RestController
@RequestMapping("/api/performance")
@RequiredArgsConstructor
public class PerformanceController {



    private final PerformanceService service;




    @GetMapping
    public List<PlayerPerformance> getAll(){

        return service.getAll();

    }




    @PostMapping
    public PlayerPerformance create(
            @RequestBody PlayerPerformance performance
    ){

        return service.create(performance);

    }




    @GetMapping("/player/{id}")
    public List<PlayerPerformance> getByPlayer(
            @PathVariable Long id
    ){

        return service.getByPlayer(id);

    }


}