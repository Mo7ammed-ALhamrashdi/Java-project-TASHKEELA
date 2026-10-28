package com.omanfootball.manager.service;


import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;


import com.omanfootball.manager.entity.PlayerPerformance;
import com.omanfootball.manager.repository.PlayerPerformanceRepository;



@Service
@RequiredArgsConstructor
public class PerformanceService {



    private final PlayerPerformanceRepository repository;





    public List<PlayerPerformance> getAll() {

        return repository.findAll();

    }





    public PlayerPerformance getById(Long id) {


        return repository.findById(id)
                .orElseThrow(
                        () -> new RuntimeException(
                                "Performance not found with id: " + id
                        )
                );

    }





    @Transactional
    public PlayerPerformance create(
            PlayerPerformance performance
    ) {

        return repository.save(performance);

    }





    @Transactional
    public PlayerPerformance update(
            Long id,
            PlayerPerformance newPerformance
    ) {


        PlayerPerformance performance = getById(id);



        performance.setGoals(
                newPerformance.getGoals()
        );



        performance.setAssists(
                newPerformance.getAssists()
        );



        performance.setYellowCards(
                newPerformance.getYellowCards()
        );



        performance.setRedCards(
                newPerformance.getRedCards()
        );



        performance.setPassAccuracy(
                newPerformance.getPassAccuracy()
        );



        performance.setMinutesPlayed(
                newPerformance.getMinutesPlayed()
        );



        performance.setCleanSheet(
                newPerformance.getCleanSheet()
        );



        performance.setManOfMatch(
                newPerformance.getManOfMatch()
        );



        performance.setMatch(
                newPerformance.getMatch()
        );



        performance.setPlayer(
                newPerformance.getPlayer()
        );



        return repository.save(performance);

    }





    @Transactional
    public void delete(Long id) {


        PlayerPerformance performance = getById(id);



        repository.delete(performance);


    }


}