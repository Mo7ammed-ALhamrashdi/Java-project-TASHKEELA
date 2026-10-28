package com.omanfootball.manager.controller;


import lombok.RequiredArgsConstructor;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;


import com.omanfootball.manager.entity.FantasyTeam;
import com.omanfootball.manager.service.FantasyTeamService;



@RestController
@RequestMapping("/api/fantasy-teams")
@RequiredArgsConstructor
public class FantasyTeamController {



    private final FantasyTeamService service;





    @GetMapping
    public ResponseEntity<List<FantasyTeam>> getAll() {



        return ResponseEntity.ok(
                service.getAllTeams()
        );



    }





    @GetMapping("/{id}")
    public ResponseEntity<FantasyTeam> getById(

            @PathVariable Long id

    ) {



        return ResponseEntity.ok(
                service.getTeamById(id)
        );



    }





    @PostMapping
    public ResponseEntity<FantasyTeam> create(

            @RequestBody FantasyTeam team

    ) {



        return ResponseEntity.ok(
                service.createTeam(team)
        );



    }





    @PutMapping("/{id}")
    public ResponseEntity<FantasyTeam> update(

            @PathVariable Long id,

            @RequestBody FantasyTeam team

    ) {



        return ResponseEntity.ok(
                service.updateTeam(id, team)
        );



    }





    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(

            @PathVariable Long id

    ) {



        service.deleteTeam(id);



        return ResponseEntity.ok(
                "Fantasy team deleted successfully"
        );



    }


}