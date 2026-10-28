package com.omanfootball.manager.service;


import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;


import com.omanfootball.manager.entity.MatchStatistics;
import com.omanfootball.manager.repository.MatchStatisticsRepository;



@Service
@RequiredArgsConstructor
public class MatchStatisticsService {



    private final MatchStatisticsRepository matchStatisticsRepository;





    public List<MatchStatistics> getAllStatistics() {

        return matchStatisticsRepository.findAll();

    }





    public MatchStatistics getStatisticsById(Long id) {


        return matchStatisticsRepository.findById(id)
                .orElseThrow(
                        () -> new RuntimeException(
                                "Match statistics not found with id: " + id
                        )
                );

    }





    @Transactional
    public MatchStatistics createStatistics(
            MatchStatistics statistics
    ) {

        return matchStatisticsRepository.save(statistics);

    }





    @Transactional
    public MatchStatistics updateStatistics(
            Long id,
            MatchStatistics newStatistics
    ) {


        MatchStatistics statistics =
                getStatisticsById(id);




        statistics.setPossessionHome(
                newStatistics.getPossessionHome()
        );



        statistics.setPossessionAway(
                newStatistics.getPossessionAway()
        );



        statistics.setShotsHome(
                newStatistics.getShotsHome()
        );



        statistics.setShotsAway(
                newStatistics.getShotsAway()
        );



        statistics.setShotsOnTargetHome(
                newStatistics.getShotsOnTargetHome()
        );



        statistics.setShotsOnTargetAway(
                newStatistics.getShotsOnTargetAway()
        );



        statistics.setCornersHome(
                newStatistics.getCornersHome()
        );



        statistics.setCornersAway(
                newStatistics.getCornersAway()
        );



        statistics.setFoulsHome(
                newStatistics.getFoulsHome()
        );



        statistics.setFoulsAway(
                newStatistics.getFoulsAway()
        );



        statistics.setYellowCardsHome(
                newStatistics.getYellowCardsHome()
        );



        statistics.setYellowCardsAway(
                newStatistics.getYellowCardsAway()
        );



        statistics.setRedCardsHome(
                newStatistics.getRedCardsHome()
        );



        statistics.setRedCardsAway(
                newStatistics.getRedCardsAway()
        );



        statistics.setMatch(
                newStatistics.getMatch()
        );



        return matchStatisticsRepository.save(statistics);

    }





    @Transactional
    public void deleteStatistics(Long id) {


        MatchStatistics statistics =
                getStatisticsById(id);



        matchStatisticsRepository.delete(statistics);


    }


}