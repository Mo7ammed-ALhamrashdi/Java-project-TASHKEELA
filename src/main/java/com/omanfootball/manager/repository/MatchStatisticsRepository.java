package com.omanfootball.manager.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import com.omanfootball.manager.entity.MatchStatistics;



@Repository
public interface MatchStatisticsRepository
        extends JpaRepository<MatchStatistics, Long> {



}