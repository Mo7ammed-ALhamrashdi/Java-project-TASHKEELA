package com.omanfootball.manager.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import java.util.Optional;


import com.omanfootball.manager.entity.AIMatchReport;



@Repository
public interface AIMatchReportRepository
        extends JpaRepository<AIMatchReport, Long> {



    Optional<AIMatchReport> findByMatch_Id(Long matchId);



}