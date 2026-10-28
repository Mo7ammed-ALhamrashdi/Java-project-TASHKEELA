package com.omanfootball.manager.service;


import com.omanfootball.manager.entity.AIFantasyPoints;
import com.omanfootball.manager.entity.Player;
import com.omanfootball.manager.repository.PlayerRepository;


import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;



@Service
@RequiredArgsConstructor
public class AIService {


    private final PlayerRepository playerRepository;



    public AIFantasyPoints analyzePlayer(
            Long playerId,
            int goals,
            int assists,
            int appearances,
            double price,
            double rating
    ) {



        Player player = playerRepository.findById(playerId)
                .orElseThrow(
                        () -> new RuntimeException(
                                "Player not found with id: " + playerId
                        )
                );



        AIFantasyPoints ai = new AIFantasyPoints();



        ai.setPlayer(player);



        double predictedPoints =
                (goals * 5.0)
                        + (assists * 3.0)
                        + appearances
                        + (rating / 10.0);



        ai.setPredictedPoints(predictedPoints);



        double performanceScore =
                (rating * 0.6)
                        + ((goals + assists) * 5.0);



        double valueScore =
                price > 0
                        ? predictedPoints / price
                        : 0.0;



        double aiScore =
                performanceScore + valueScore;



        ai.setAiRating(aiScore);



        if (aiScore >= 70) {


            ai.setRecommendation("BUY");

            ai.setExplanation(
                    "Player has high performance and good fantasy value"
            );


        } else if (aiScore >= 50) {


            ai.setRecommendation("CONSIDER");

            ai.setExplanation(
                    "Player has average performance and reasonable fantasy value"
            );


        } else {


            ai.setRecommendation("AVOID");

            ai.setExplanation(
                    "Player performance or fantasy value is low"
            );

        }



        return ai;

    }

}