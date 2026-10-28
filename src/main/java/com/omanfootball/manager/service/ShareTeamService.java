package com.omanfootball.manager.service;


import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;


import com.omanfootball.manager.entity.SharedFantasyTeam;
import com.omanfootball.manager.repository.SharedFantasyTeamRepository;



@Service
@RequiredArgsConstructor
public class ShareTeamService {



    private final SharedFantasyTeamRepository repository;





    public List<SharedFantasyTeam> getAll() {

        return repository.findAll();

    }





    public SharedFantasyTeam getById(Long id) {


        return repository.findById(id)
                .orElseThrow(
                        () -> new RuntimeException(
                                "Shared team not found with id: " + id
                        )
                );

    }





    @Transactional
    public SharedFantasyTeam create(
            SharedFantasyTeam team
    ) {

        return repository.save(team);

    }





    @Transactional
    public SharedFantasyTeam update(
            Long id,
            SharedFantasyTeam newTeam
    ) {


        SharedFantasyTeam team = getById(id);



        team.setShareCode(
                newTeam.getShareCode()
        );



        team.setShareUrl(
                newTeam.getShareUrl()
        );



        team.setUser(
                newTeam.getUser()
        );



        team.setFantasyTeam(
                newTeam.getFantasyTeam()
        );



        return repository.save(team);

    }





    @Transactional
    public void delete(Long id) {


        SharedFantasyTeam team = getById(id);


        repository.delete(team);


    }


}