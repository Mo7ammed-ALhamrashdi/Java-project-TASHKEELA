package com.omanfootball.manager.service;


import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;


import com.omanfootball.manager.entity.PlayerComparison;
import com.omanfootball.manager.repository.PlayerComparisonRepository;



@Service
@RequiredArgsConstructor
public class PlayerComparisonService {



    private final PlayerComparisonRepository repository;





    public List<PlayerComparison> getAll() {

        return repository.findAll();

    }





    public PlayerComparison getById(Long id) {

        return repository.findById(id)
                .orElseThrow(
                        () -> new RuntimeException(
                                "Comparison not found with id: " + id
                        )
                );

    }





    @Transactional
    public PlayerComparison create(
            PlayerComparison comparison
    ) {

        return repository.save(comparison);

    }





    @Transactional
    public PlayerComparison update(
            Long id,
            PlayerComparison newComparison
    ) {


        PlayerComparison comparison = getById(id);



        comparison.setGoalsDifference(
                newComparison.getGoalsDifference()
        );



        comparison.setAssistsDifference(
                newComparison.getAssistsDifference()
        );



        comparison.setRatingDifference(
                newComparison.getRatingDifference()
        );



        comparison.setFantasyPointsDifference(
                newComparison.getFantasyPointsDifference()
        );



        comparison.setAiExplanation(
                newComparison.getAiExplanation()
        );



        comparison.setPlayerOne(
                newComparison.getPlayerOne()
        );



        comparison.setPlayerTwo(
                newComparison.getPlayerTwo()
        );



        return repository.save(comparison);

    }





    @Transactional
    public void delete(Long id) {


        PlayerComparison comparison = getById(id);


        repository.delete(comparison);


    }


}