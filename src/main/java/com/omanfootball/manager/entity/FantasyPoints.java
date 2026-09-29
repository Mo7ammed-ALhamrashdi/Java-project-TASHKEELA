package com.omanfootball.manager.entity;


import jakarta.persistence.*;
import lombok.Data;


@Entity
@Table(name="fantasy_points")
@Data
public class FantasyPoints {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long pointId;



    private Integer points;


    private Double multiplier;


    private String explanation;



    @ManyToOne
    @JoinColumn(name="match_id")
    private Match match;



    @ManyToOne
    @JoinColumn(name="team_id")
    private FantasyTeam fantasyTeam;



    @ManyToOne
    @JoinColumn(name="player_id")
    private Player player;


}