package com.omanfootball.manager.service;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


import com.omanfootball.manager.entity.AIRating;
import com.omanfootball.manager.repository.AIRatingRepository;



@Service
@RequiredArgsConstructor
public class AIRatingService {



    private final AIRatingRepository repository;



    public AIRating createRating(
            AIRating rating
    ){

        rating.setAnalysis(
                generateAnalysis(rating)
        );


        return repository.save(rating);

    }




    public AIRating getRatingByPlayer(
            Long playerId
    ){

        return repository
                .findByPlayerPlayerId(playerId);

    }




    private String generateAnalysis(
            AIRating rating
    ){


        if(rating.getOverall() >= 85){

            return "Excellent player with high performance";


        }else if(rating.getOverall() >=70){


            return "Good player with potential improvement";


        }else{


            return "Player needs development";

        }


    }


}