package com.omanfootball.manager.service;


import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;


import com.omanfootball.manager.entity.FantasyTeam;
import com.omanfootball.manager.repository.FantasyTeamRepository;



@Service
@RequiredArgsConstructor
public class FantasyTeamService {


    private final FantasyTeamRepository repository;





    public List<FantasyTeam> getAllTeams() {

        return repository.findAll();

    }





    public FantasyTeam getTeamById(Long id) {


        return repository.findById(id)
                .orElseThrow(
                        () -> new RuntimeException(
                                "Fantasy team not found with id: " + id
                        )
                );

    }





    @Transactional
    public FantasyTeam createTeam(FantasyTeam team) {

        return repository.save(team);

    }





    @Transactional
    public FantasyTeam updateTeam(
            Long id,
            FantasyTeam newTeam
    ) {


        FantasyTeam team = getTeamById(id);



        team.setTeamName(
                newTeam.getTeamName()
        );



        team.setBudget(
                newTeam.getBudget()
        );



        team.setTotalPoints(
                newTeam.getTotalPoints()
        );



        team.setOverallRating(
                newTeam.getOverallRating()
        );



        team.setUser(
                newTeam.getUser()
        );



        return repository.save(team);

    }





    @Transactional
    public void deleteTeam(Long id) {


        FantasyTeam team = getTeamById(id);



        repository.delete(team);


    }


}