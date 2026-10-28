package com.omanfootball.manager.controller;


import lombok.RequiredArgsConstructor;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;


import com.omanfootball.manager.entity.SharedFantasyTeam;
import com.omanfootball.manager.service.ShareTeamService;



@RestController
@RequestMapping("/api/shared-teams")
@RequiredArgsConstructor
public class ShareTeamController {



    private final ShareTeamService service;





    @GetMapping
    public ResponseEntity<List<SharedFantasyTeam>> getAll() {



        return ResponseEntity.ok(
                service.getAll()
        );



    }





    @GetMapping("/{id}")
    public ResponseEntity<SharedFantasyTeam> getById(

            @PathVariable Long id

    ) {



        return ResponseEntity.ok(
                service.getById(id)
        );



    }





    @PostMapping
    public ResponseEntity<SharedFantasyTeam> create(

            @RequestBody SharedFantasyTeam sharedTeam

    ) {



        return ResponseEntity.ok(
                service.create(sharedTeam)
        );



    }





    @PutMapping("/{id}")
    public ResponseEntity<SharedFantasyTeam> update(

            @PathVariable Long id,

            @RequestBody SharedFantasyTeam sharedTeam

    ) {



        return ResponseEntity.ok(
                service.update(id, sharedTeam)
        );



    }





    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(

            @PathVariable Long id

    ) {



        service.delete(id);



        return ResponseEntity.ok(
                "Shared team deleted successfully"
        );



    }


}