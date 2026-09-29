package com.omanfootball.manager.entity;


import jakarta.persistence.*;
import lombok.Data;

import java.util.List;


@Entity
@Table(name="clubs")
@Data
public class Club {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long clubId;



    private String clubName;


    private String shortName;


    private String logo;



    @OneToMany(mappedBy="club")
    private List<Player> players;



    @OneToMany(mappedBy="homeClub")
    private List<Match> homeMatches;



    @OneToMany(mappedBy="awayClub")
    private List<Match> awayMatches;


}