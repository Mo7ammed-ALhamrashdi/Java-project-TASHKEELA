package com.omanfootball.manager.controller;


import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;


import com.omanfootball.manager.entity.AIRating;
import com.omanfootball.manager.service.AIRatingService;



@RestController
@RequestMapping("/api/ai")
@RequiredArgsConstructor
public class AIController {



    private final AIRatingService aiRatingService;



    // Create AI rating

    @PostMapping("/rating")
    public AIRating createRating(
            @RequestBody AIRating rating
    ){

        return aiRatingService.createRating(
                rating
        );

    }



    // Get player AI rating

    @GetMapping("/player/{id}")
    public AIRating getPlayerRating(
            @PathVariable Long id
    ){

        return aiRatingService
                .getRatingByPlayer(id);

    }


}