package com.omanfootball.manager.controller;


import lombok.RequiredArgsConstructor;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;


import com.omanfootball.manager.entity.Player;
import com.omanfootball.manager.service.PlayerService;



@RestController
@RequestMapping("/api/players")
@RequiredArgsConstructor
public class PlayerController {



    private final PlayerService service;





    @GetMapping
    public ResponseEntity<List<Player>> getAll() {



        return ResponseEntity.ok(
                service.getAllPlayers()
        );



    }





    @GetMapping("/{id}")
    public ResponseEntity<Player> getById(

            @PathVariable Long id

    ) {



        return ResponseEntity.ok(
                service.getPlayerById(id)
        );



    }





    @PostMapping
    public ResponseEntity<Player> create(

            @RequestBody Player player

    ) {



        return ResponseEntity.ok(
                service.createPlayer(player)
        );



    }





    @PutMapping("/{id}")
    public ResponseEntity<Player> update(

            @PathVariable Long id,

            @RequestBody Player player

    ) {



        return ResponseEntity.ok(
                service.updatePlayer(id, player)
        );



    }





    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(

            @PathVariable Long id

    ) {



        service.deletePlayer(id);



        return ResponseEntity.ok(
                "Player deleted successfully"
        );



    }


}