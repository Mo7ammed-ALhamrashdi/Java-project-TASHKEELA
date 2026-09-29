package com.omanfootball.manager.controller;


import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import com.omanfootball.manager.entity.Club;
import com.omanfootball.manager.service.ClubService;



@RestController
@RequestMapping("/api/clubs")
@RequiredArgsConstructor
public class ClubController {



    private final ClubService clubService;



    @GetMapping
    public List<Club> getAll(){

        return clubService.getAllClubs();

    }




    @PostMapping
    public Club create(
            @RequestBody Club club
    ){

        return clubService.createClub(club);

    }



    @GetMapping("/{id}")
    public Club getById(
            @PathVariable Long id
    ){

        return clubService.getClubById(id);

    }



    @DeleteMapping("/{id}")
    public String delete(
            @PathVariable Long id
    ){

        clubService.deleteClub(id);

        return "Club deleted";

    }


}