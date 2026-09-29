package com.omanfootball.manager.entity;


import jakarta.persistence.*;
import lombok.Data;


@Entity
@Table(name="fantasy_player")
@Data
public class FantasyTeamPlayer {



    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;



    private String position;


    private Double price;


    private Integer overallRating;


    private Boolean isCaptain;



    @ManyToOne
    @JoinColumn(name="team_id")
    private FantasyTeam fantasyTeam;



    @ManyToOne
    @JoinColumn(name="player_id")
    private Player player;


}