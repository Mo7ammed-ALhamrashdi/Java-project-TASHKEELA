package com.omanfootball.manager.controller;


import com.omanfootball.manager.entity.AIFantasyPoints;
import com.omanfootball.manager.service.AIFantasyPointsService;


import lombok.RequiredArgsConstructor;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;



@RestController
@RequestMapping("/api/ai-fantasy-points")
@RequiredArgsConstructor
public class AIFantasyPointsController {



    private final AIFantasyPointsService service;





    @GetMapping
    public ResponseEntity<List<AIFantasyPoints>> getAll() {



        return ResponseEntity.ok(
                service.getAll()
        );



    }





    @GetMapping("/{id}")
    public ResponseEntity<AIFantasyPoints> getById(

            @PathVariable Long id

    ) {



        return ResponseEntity.ok(
                service.getById(id)
        );



    }





    @PostMapping
    public ResponseEntity<AIFantasyPoints> create(

            @RequestBody AIFantasyPoints points

    ) {



        return ResponseEntity.ok(
                service.create(points)
        );



    }





    @PutMapping("/{id}")
    public ResponseEntity<AIFantasyPoints> update(

            @PathVariable Long id,

            @RequestBody AIFantasyPoints points

    ) {



        return ResponseEntity.ok(
                service.update(id, points)
        );



    }





    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(

            @PathVariable Long id

    ) {



        service.delete(id);



        return ResponseEntity.ok(
                "AI Fantasy Points deleted successfully"
        );



    }


}