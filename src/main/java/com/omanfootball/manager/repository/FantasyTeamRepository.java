package com.omanfootball.manager.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.omanfootball.manager.entity.FantasyTeam;


@Repository
public interface FantasyTeamRepository
        extends JpaRepository<FantasyTeam, Long> {



    FantasyTeam findByUserUserId(Long userId);


}