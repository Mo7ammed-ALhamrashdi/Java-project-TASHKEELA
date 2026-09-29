package com.omanfootball.manager.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.omanfootball.manager.entity.AIRating;


@Repository
public interface AIRatingRepository
        extends JpaRepository<AIRating, Long> {



    AIRating findByPlayerPlayerId(Long playerId);


}