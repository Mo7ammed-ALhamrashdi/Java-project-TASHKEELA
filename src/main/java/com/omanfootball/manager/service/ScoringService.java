package com.omanfootball.manager.service;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


import com.omanfootball.manager.entity.FantasyPoints;
import com.omanfootball.manager.entity.PlayerPerformance;

import com.omanfootball.manager.repository.FantasyPointsRepository;



@Service
@RequiredArgsConstructor
public class ScoringService {



    private final FantasyPointsRepository fantasyPointsRepository;


    private final PointsCalculator pointsCalculator;



    public FantasyPoints calculatePoints(
            PlayerPerformance performance,
            FantasyPoints fantasyPoints
    ){


        int points =
                pointsCalculator.calculatePoints(

                        performance.getGoals(),

                        performance.getAssists(),

                        performance.getYellowCards(),

                        performance.getRedCards(),

                        performance.getCleanSheet(),

                        performance.getManOfMatch()

                );



        fantasyPoints.setPoints(points);



        fantasyPoints.setExplanation(
                "Points calculated from match performance"
        );



        return fantasyPointsRepository.save(
                fantasyPoints
        );


    }


}