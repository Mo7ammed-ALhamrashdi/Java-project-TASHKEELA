package com.omanfootball.manager.controller;


import com.omanfootball.manager.entity.AIFantasyPoints;
import com.omanfootball.manager.service.AIService;


import lombok.RequiredArgsConstructor;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;



@RestController
@RequestMapping("/api/ai")
@RequiredArgsConstructor
public class AIController {



    private final AIService service;





    @GetMapping("/player/{id}")
    public ResponseEntity<AIFantasyPoints> analyzePlayer(

            @PathVariable Long id,

            @RequestParam int goals,

            @RequestParam int assists,

            @RequestParam int appearances,

            @RequestParam double price,

            @RequestParam double rating

    ) {



        AIFantasyPoints result =

                service.analyzePlayer(

                        id,

                        goals,

                        assists,

                        appearances,

                        price,

                        rating

                );



        return ResponseEntity.ok(result);



    }


}