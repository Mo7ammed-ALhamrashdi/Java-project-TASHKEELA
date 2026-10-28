package com.omanfootball.manager.controller;


import lombok.RequiredArgsConstructor;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;


import com.omanfootball.manager.entity.Match;
import com.omanfootball.manager.service.MatchService;



@RestController
@RequestMapping("/api/matches")
@RequiredArgsConstructor
public class MatchController {



    private final MatchService service;





    @GetMapping
    public ResponseEntity<List<Match>> getAll() {



        return ResponseEntity.ok(
                service.getAllMatches()
        );



    }





    @GetMapping("/{id}")
    public ResponseEntity<Match> getById(

            @PathVariable Long id

    ) {



        return ResponseEntity.ok(
                service.getMatchById(id)
        );



    }





    @PostMapping
    public ResponseEntity<Match> create(

            @RequestBody Match match

    ) {



        return ResponseEntity.ok(
                service.createMatch(match)
        );



    }





    @PutMapping("/{id}")
    public ResponseEntity<Match> update(

            @PathVariable Long id,

            @RequestBody Match match

    ) {



        return ResponseEntity.ok(
                service.updateMatch(id, match)
        );



    }





    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(

            @PathVariable Long id

    ) {



        service.deleteMatch(id);



        return ResponseEntity.ok(
                "Match deleted successfully"
        );



    }


}