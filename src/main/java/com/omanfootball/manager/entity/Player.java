package com.omanfootball.manager.entity;


import jakarta.persistence.*;
import lombok.Data;


@Entity
@Table(name="players")
@Data
public class Player {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long playerId;



    private String name;


    private String position;


    private Integer age;


    private Double price;


    private Integer overallRating;



    @ManyToOne
    @JoinColumn(name="club_id")
    private Club club;



    @OneToOne(mappedBy="player",
            cascade=CascadeType.ALL)
    private AIRating aiRating;



}