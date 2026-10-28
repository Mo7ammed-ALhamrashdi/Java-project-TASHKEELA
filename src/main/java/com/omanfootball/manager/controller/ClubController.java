package com.omanfootball.manager.controller;


import com.omanfootball.manager.entity.Club;
import com.omanfootball.manager.service.ClubService;


import lombok.RequiredArgsConstructor;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;



@RestController
@RequestMapping("/api/clubs")
@RequiredArgsConstructor
public class ClubController {



    private final ClubService service;





    @GetMapping
    public ResponseEntity<List<Club>> getAll() {



        return ResponseEntity.ok(
                service.getAllClubs()
        );



    }





    @GetMapping("/{id}")
    public ResponseEntity<Club> getById(

            @PathVariable Long id

    ) {



        return ResponseEntity.ok(
                service.getClubById(id)
        );



    }





    @PostMapping
    public ResponseEntity<Club> create(

            @RequestBody Club club

    ) {



        return ResponseEntity.ok(
                service.createClub(club)
        );



    }





    @PutMapping("/{id}")
    public ResponseEntity<Club> update(

            @PathVariable Long id,

            @RequestBody Club club

    ) {



        return ResponseEntity.ok(
                service.updateClub(id, club)
        );



    }





    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(

            @PathVariable Long id

    ) {



        service.deleteClub(id);



        return ResponseEntity.ok(
                "Club deleted successfully"
        );



    }


}