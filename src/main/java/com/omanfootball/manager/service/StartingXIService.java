package com.omanfootball.manager.service;


import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;


import com.omanfootball.manager.entity.StartingXIRecommendation;
import com.omanfootball.manager.repository.StartingXIRecommendationRepository;



@Service
@RequiredArgsConstructor
public class StartingXIService {



    private final StartingXIRecommendationRepository repository;





    public List<StartingXIRecommendation> getAll() {

        return repository.findAll();

    }





    public StartingXIRecommendation getById(Long id) {


        return repository.findById(id)
                .orElseThrow(
                        () -> new RuntimeException(
                                "Starting XI recommendation not found with id: " + id
                        )
                );

    }





    @Transactional
    public StartingXIRecommendation create(
            StartingXIRecommendation recommendation
    ) {

        return repository.save(recommendation);

    }





    @Transactional
    public StartingXIRecommendation update(
            Long id,
            StartingXIRecommendation newRecommendation
    ) {


        StartingXIRecommendation recommendation = getById(id);



        recommendation.setFormation(
                newRecommendation.getFormation()
        );



        recommendation.setRecommendedPlayers(
                newRecommendation.getRecommendedPlayers()
        );



        recommendation.setAiReason(
                newRecommendation.getAiReason()
        );



        recommendation.setConfidenceScore(
                newRecommendation.getConfidenceScore()
        );



        recommendation.setMatch(
                newRecommendation.getMatch()
        );



        return repository.save(recommendation);

    }





    @Transactional
    public void delete(Long id) {


        StartingXIRecommendation recommendation = getById(id);



        repository.delete(recommendation);


    }


}