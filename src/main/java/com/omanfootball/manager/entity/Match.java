package com.omanfootball.manager.entity;


import jakarta.persistence.*;
import lombok.Data;

import java.util.List;


@Entity
@Table(name="matches")
@Data
public class Match {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long matchId;



    private String matchDate;


    private String round;


    private String venue;



    @ManyToOne
    @JoinColumn(name="home_team_id")
    private Club homeClub;



    @ManyToOne
    @JoinColumn(name="away_team_id")
    private Club awayClub;



    @OneToMany(mappedBy="match")
    private List<PlayerPerformance> performances;


}