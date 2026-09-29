package com.omanfootball.manager.entity;


import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;


@Entity
@Table(name="fantasy_team")
@Data
public class FantasyTeam {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long teamId;



    private String teamName;


    private Double budget;


    private Integer totalPoints;


    private Double overallRating;


    private LocalDateTime createdAt;



    @OneToOne
    @JoinColumn(name="user_id")
    private User user;



    @OneToMany(mappedBy="fantasyTeam",
            cascade=CascadeType.ALL)
    private List<FantasyTeamPlayer> players;


}