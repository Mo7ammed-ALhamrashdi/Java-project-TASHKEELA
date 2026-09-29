package com.omanfootball.manager.service;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

import com.omanfootball.manager.entity.PlayerPerformance;
import com.omanfootball.manager.repository.PlayerPerformanceRepository;


@Service
@RequiredArgsConstructor
public class PerformanceService {



    private final PlayerPerformanceRepository repository;



    public List<PlayerPerformance> getAll(){

        return repository.findAll();

    }



    public PlayerPerformance create(
            PlayerPerformance performance
    ){

        return repository.save(performance);

    }



    public List<PlayerPerformance> getByPlayer(
            Long playerId
    ){

        return repository
                .findByPlayerPlayerId(playerId);

    }



}