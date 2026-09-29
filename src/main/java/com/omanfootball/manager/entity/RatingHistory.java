package com.omanfootball.manager.entity;


import jakarta.persistence.*;
import lombok.Data;


import java.time.LocalDateTime;


@Entity
@Table(name="rating_history")
@Data
public class RatingHistory {



    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long historyId;



    private Integer oldRating;


    private Integer newRating;


    private String reason;


    private LocalDateTime changeDate;



    @ManyToOne
    @JoinColumn(name="player_id")
    private Player player;


}