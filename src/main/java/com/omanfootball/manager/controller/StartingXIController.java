package com.omanfootball.manager.controller;


import lombok.RequiredArgsConstructor;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;


import com.omanfootball.manager.entity.StartingXIRecommendation;
import com.omanfootball.manager.service.StartingXIService;



@RestController
@RequestMapping("/api/starting-xi")
@RequiredArgsConstructor
public class StartingXIController {



    private final StartingXIService service;





    @GetMapping
    public ResponseEntity<List<StartingXIRecommendation>> getAll() {



        return ResponseEntity.ok(
                service.getAll()
        );



    }





    @GetMapping("/{id}")
    public ResponseEntity<StartingXIRecommendation> getById(

            @PathVariable Long id

    ) {



        return ResponseEntity.ok(
                service.getById(id)
        );



    }





    @PostMapping
    public ResponseEntity<StartingXIRecommendation> create(

            @RequestBody StartingXIRecommendation recommendation

    ) {



        return ResponseEntity.ok(
                service.create(recommendation)
        );



    }





    @PutMapping("/{id}")
    public ResponseEntity<StartingXIRecommendation> update(

            @PathVariable Long id,

            @RequestBody StartingXIRecommendation recommendation

    ) {



        return ResponseEntity.ok(
                service.update(id, recommendation)
        );



    }





    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(

            @PathVariable Long id

    ) {



        service.delete(id);



        return ResponseEntity.ok(
                "Starting XI recommendation deleted successfully"
        );



    }


}