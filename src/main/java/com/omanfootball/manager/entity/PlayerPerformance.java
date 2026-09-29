package com.omanfootball.manager.entity;


import jakarta.persistence.*;
import lombok.Data;


@Entity
@Table(name="match_statistics")
@Data
public class PlayerPerformance {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long stateId;



    private Integer goals;


    private Integer assists;


    private Integer yellowCards;


    private Integer redCards;


    private Double passAccuracy;


    private Integer minutesPlayed;


    private Boolean cleanSheet;


    private Boolean manOfMatch;



    @ManyToOne
    @JoinColumn(name="match_id")
    private Match match;



    @ManyToOne
    @JoinColumn(name="player_id")
    private Player player;


}