package com.omanfootball.manager.controller;


import lombok.RequiredArgsConstructor;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;


import com.omanfootball.manager.entity.PlayerPerformance;
import com.omanfootball.manager.service.PerformanceService;



@RestController
@RequestMapping("/api/performances")
@RequiredArgsConstructor
public class PerformanceController {



    private final PerformanceService service;





    @GetMapping
    public ResponseEntity<List<PlayerPerformance>> getAll() {



        return ResponseEntity.ok(
                service.getAll()
        );



    }





    @GetMapping("/{id}")
    public ResponseEntity<PlayerPerformance> getById(

            @PathVariable Long id

    ) {



        return ResponseEntity.ok(
                service.getById(id)
        );



    }





    @PostMapping
    public ResponseEntity<PlayerPerformance> create(

            @RequestBody PlayerPerformance performance

    ) {



        return ResponseEntity.ok(
                service.create(performance)
        );



    }





    @PutMapping("/{id}")
    public ResponseEntity<PlayerPerformance> update(

            @PathVariable Long id,

            @RequestBody PlayerPerformance performance

    ) {



        return ResponseEntity.ok(
                service.update(id, performance)
        );



    }





    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(

            @PathVariable Long id

    ) {



        service.delete(id);



        return ResponseEntity.ok(
                "Performance deleted successfully"
        );



    }


}