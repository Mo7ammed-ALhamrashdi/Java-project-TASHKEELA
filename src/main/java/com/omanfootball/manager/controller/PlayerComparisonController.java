package com.omanfootball.manager.controller;


import lombok.RequiredArgsConstructor;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;


import com.omanfootball.manager.entity.PlayerComparison;
import com.omanfootball.manager.service.PlayerComparisonService;



@RestController
@RequestMapping("/api/player-comparisons")
@RequiredArgsConstructor
public class PlayerComparisonController {



    private final PlayerComparisonService service;





    @GetMapping
    public ResponseEntity<List<PlayerComparison>> getAll() {



        return ResponseEntity.ok(
                service.getAll()
        );



    }





    @GetMapping("/{id}")
    public ResponseEntity<PlayerComparison> getById(

            @PathVariable Long id

    ) {



        return ResponseEntity.ok(
                service.getById(id)
        );



    }





    @PostMapping
    public ResponseEntity<PlayerComparison> create(

            @RequestBody PlayerComparison comparison

    ) {



        return ResponseEntity.ok(
                service.create(comparison)
        );



    }





    @PutMapping("/{id}")
    public ResponseEntity<PlayerComparison> update(

            @PathVariable Long id,

            @RequestBody PlayerComparison comparison

    ) {



        return ResponseEntity.ok(
                service.update(id, comparison)
        );



    }





    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(

            @PathVariable Long id

    ) {



        service.delete(id);



        return ResponseEntity.ok(
                "Comparison deleted successfully"
        );



    }


}