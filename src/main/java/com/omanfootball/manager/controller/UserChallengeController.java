package com.omanfootball.manager.controller;


import lombok.RequiredArgsConstructor;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;


import com.omanfootball.manager.entity.UserChallenge;
import com.omanfootball.manager.service.UserChallengeService;



@RestController
@RequestMapping("/api/user-challenges")
@RequiredArgsConstructor
public class UserChallengeController {



    private final UserChallengeService service;





    @GetMapping
    public ResponseEntity<List<UserChallenge>> getAll() {



        return ResponseEntity.ok(
                service.getAll()
        );



    }





    @GetMapping("/{id}")
    public ResponseEntity<UserChallenge> getById(

            @PathVariable Long id

    ) {



        return ResponseEntity.ok(
                service.getById(id)
        );



    }





    @PostMapping
    public ResponseEntity<UserChallenge> create(

            @RequestBody UserChallenge challenge

    ) {



        return ResponseEntity.ok(
                service.create(challenge)
        );



    }





    @PutMapping("/{id}")
    public ResponseEntity<UserChallenge> update(

            @PathVariable Long id,

            @RequestBody UserChallenge challenge

    ) {



        return ResponseEntity.ok(
                service.update(id, challenge)
        );



    }





    @PutMapping("/{id}/complete")
    public ResponseEntity<UserChallenge> complete(

            @PathVariable Long id,

            @RequestParam Integer earnedPoints

    ) {



        return ResponseEntity.ok(
                service.completeChallenge(
                        id,
                        earnedPoints
                )
        );



    }





    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(

            @PathVariable Long id

    ) {



        service.delete(id);



        return ResponseEntity.ok(
                "User challenge deleted successfully"
        );



    }


}