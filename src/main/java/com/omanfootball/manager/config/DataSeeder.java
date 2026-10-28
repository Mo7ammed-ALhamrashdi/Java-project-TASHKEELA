package com.omanfootball.manager.config;


import com.omanfootball.manager.entity.Club;
import com.omanfootball.manager.entity.Player;


import com.omanfootball.manager.repository.ClubRepository;
import com.omanfootball.manager.repository.PlayerRepository;


import lombok.RequiredArgsConstructor;


import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;



@Component
@RequiredArgsConstructor
public class DataSeeder implements CommandLineRunner {



    private final ClubRepository clubRepository;



    private final PlayerRepository playerRepository;





    @Override
    public void run(String... args) {



        if (clubRepository.count() == 0) {



            Club club = new Club();



            club.setClubName(
                    "Al-Seeb Club"
            );



            club.setShortName(
                    "SEEB"
            );



            clubRepository.save(club);





            Player player = new Player();



            player.setName(
                    "Example Player"
            );



            player.setPosition(
                    "Forward"
            );



            player.setAge(25);



            player.setPrice(
                    10.0
            );



            player.setOverallRating(
                    85
            );



            player.setClub(
                    club
            );



            playerRepository.save(player);



        }


    }


}