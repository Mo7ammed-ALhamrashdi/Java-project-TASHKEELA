package com.omanfootball.manager.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

import com.omanfootball.manager.entity.Player;


@Repository
public interface PlayerRepository
        extends JpaRepository<Player, Long> {



    List<Player> findByClubClubId(Long clubId);



    List<Player> findByPosition(String position);


}