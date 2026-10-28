package com.omanfootball.manager.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import java.util.Optional;


import com.omanfootball.manager.entity.StartingXIRecommendation;



@Repository
public interface StartingXIRecommendationRepository
        extends JpaRepository<StartingXIRecommendation, Long> {



    Optional<StartingXIRecommendation> findByMatch_Id(Long matchId);



}