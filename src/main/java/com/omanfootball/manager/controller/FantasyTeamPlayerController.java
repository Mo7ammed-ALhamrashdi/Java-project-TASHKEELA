package com.omanfootball.manager.controller;


import lombok.RequiredArgsConstructor;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;


import com.omanfootball.manager.entity.FantasyTeamPlayer;
import com.omanfootball.manager.service.FantasyTeamPlayerService;



@RestController
@RequestMapping("/api/fantasy-team-players")
@RequiredArgsConstructor
public class FantasyTeamPlayerController {



    private final FantasyTeamPlayerService service;





    @GetMapping
    public ResponseEntity<List<FantasyTeamPlayer>> getAll() {



        return ResponseEntity.ok(
                service.getAll()
        );



    }





    @GetMapping("/{id}")
    public ResponseEntity<FantasyTeamPlayer> getById(

            @PathVariable Long id

    ) {



        return ResponseEntity.ok(
                service.getById(id)
        );



    }





    @PostMapping
    public ResponseEntity<FantasyTeamPlayer> create(

            @RequestBody FantasyTeamPlayer player

    ) {



        return ResponseEntity.ok(
                service.create(player)
        );



    }





    @PutMapping("/{id}")
    public ResponseEntity<FantasyTeamPlayer> update(

            @PathVariable Long id,

            @RequestBody FantasyTeamPlayer player

    ) {



        return ResponseEntity.ok(
                service.update(id, player)
        );



    }





    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(

            @PathVariable Long id

    ) {



        service.delete(id);



        return ResponseEntity.ok(
                "Fantasy team player deleted successfully"
        );



    }


}