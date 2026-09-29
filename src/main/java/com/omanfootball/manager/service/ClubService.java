package com.omanfootball.manager.service;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

import com.omanfootball.manager.entity.Club;
import com.omanfootball.manager.repository.ClubRepository;


@Service
@RequiredArgsConstructor
public class ClubService {



    private final ClubRepository clubRepository;




    public List<Club> getAllClubs(){

        return clubRepository.findAll();

    }




    public Club getClubById(Long id){

        return clubRepository.findById(id)
                .orElseThrow(
                        () -> new RuntimeException("Club not found")
                );

    }




    public Club createClub(Club club){

        return clubRepository.save(club);

    }




    public void deleteClub(Long id){

        clubRepository.deleteById(id);

    }


}