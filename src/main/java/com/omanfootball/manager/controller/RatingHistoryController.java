package com.omanfootball.manager.controller;


import lombok.RequiredArgsConstructor;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;


import com.omanfootball.manager.entity.RatingHistory;
import com.omanfootball.manager.service.RatingHistoryService;



@RestController
@RequestMapping("/api/rating-history")
@RequiredArgsConstructor
public class RatingHistoryController {



    private final RatingHistoryService service;





    @GetMapping
    public ResponseEntity<List<RatingHistory>> getAll() {



        return ResponseEntity.ok(
                service.getAll()
        );



    }





    @GetMapping("/{id}")
    public ResponseEntity<RatingHistory> getById(

            @PathVariable Long id

    ) {



        return ResponseEntity.ok(
                service.getById(id)
        );



    }





    @PostMapping
    public ResponseEntity<RatingHistory> create(

            @RequestBody RatingHistory history

    ) {



        return ResponseEntity.ok(
                service.create(history)
        );



    }





    @PutMapping("/{id}")
    public ResponseEntity<RatingHistory> update(

            @PathVariable Long id,

            @RequestBody RatingHistory history

    ) {



        return ResponseEntity.ok(
                service.update(id, history)
        );



    }





    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(

            @PathVariable Long id

    ) {



        service.delete(id);



        return ResponseEntity.ok(
                "Rating history deleted successfully"
        );



    }


}