package com.omanfootball.manager.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

import com.omanfootball.manager.entity.Match;


@Repository
public interface MatchRepository
        extends JpaRepository<Match, Long> {



    List<Match> findByRound(String round);


}