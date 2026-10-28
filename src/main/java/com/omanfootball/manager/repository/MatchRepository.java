package com.omanfootball.manager.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import com.omanfootball.manager.entity.Match;



@Repository
public interface MatchRepository
        extends JpaRepository<Match, Long> {



}