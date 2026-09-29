package com.omanfootball.manager.service;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

import com.omanfootball.manager.entity.Match;
import com.omanfootball.manager.repository.MatchRepository;


@Service
@RequiredArgsConstructor
public class MatchService {



    private final MatchRepository matchRepository;



    public List<Match> getAllMatches(){

        return matchRepository.findAll();

    }



    public Match getMatchById(Long id){

        return matchRepository.findById(id)
                .orElseThrow(
                        () -> new RuntimeException("Match not found")
                );

    }



    public Match createMatch(Match match){

        return matchRepository.save(match);

    }



    public void deleteMatch(Long id){

        matchRepository.deleteById(id);

    }


}