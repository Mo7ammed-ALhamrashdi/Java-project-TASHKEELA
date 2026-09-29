package com.omanfootball.manager.entity;


import jakarta.persistence.*;
import lombok.Data;


@Entity
@Table(name="ai_rating")
@Data
public class AIRating {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long aiRatingId;



    private Integer overall;


    private Integer passing;


    private Integer defense;


    private Integer physical;


    private String analysis;



    @OneToOne
    @JoinColumn(name="player_id")
    private Player player;


}