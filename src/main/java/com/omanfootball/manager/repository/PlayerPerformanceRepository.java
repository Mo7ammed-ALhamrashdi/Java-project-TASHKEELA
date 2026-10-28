package com.omanfootball.manager.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import java.util.List;


import com.omanfootball.manager.entity.PlayerPerformance;



@Repository
public interface PlayerPerformanceRepository
        extends JpaRepository<PlayerPerformance, Long> {



    List<PlayerPerformance> findByPlayer_Id(Long playerId);



    List<PlayerPerformance> findByMatch_Id(Long matchId);



}