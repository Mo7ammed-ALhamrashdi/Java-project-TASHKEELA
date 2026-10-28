package com.omanfootball.manager.entity;


import jakarta.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.time.LocalDateTime;



@Entity
@Table(name = "matches")

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Match {



    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;




    @ManyToOne
    @JoinColumn(name = "home_club_id")
    private Club homeClub;




    @ManyToOne
    @JoinColumn(name = "away_club_id")
    private Club awayClub;





    private LocalDateTime matchDate;





    private String venue;





    private int homeScore;





    private int awayScore;





    private String status;


}