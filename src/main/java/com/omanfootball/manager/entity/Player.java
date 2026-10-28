package com.omanfootball.manager.entity;


import jakarta.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



@Entity
@Table(name = "players")

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Player {



    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;




    @Column(nullable = false)
    private String name;




    private String position;




    private int age;




    private double price;




    private double overallRating;




    private int fantasyPoints;




    private String nationality;




    private String image;




    @ManyToOne
    @JoinColumn(name = "club_id")
    private Club club;



}