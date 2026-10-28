package com.omanfootball.manager.controller;


import lombok.RequiredArgsConstructor;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;


import com.omanfootball.manager.entity.MatchStatistics;
import com.omanfootball.manager.service.MatchStatisticsService;



@RestController
@RequestMapping("/api/match-statistics")
@RequiredArgsConstructor
public class MatchStatisticsController {



    private final MatchStatisticsService service;





    @GetMapping
    public ResponseEntity<List<MatchStatistics>> getAll() {



        return ResponseEntity.ok(
                service.getAllStatistics()
        );



    }





    @GetMapping("/{id}")
    public ResponseEntity<MatchStatistics> getById(

            @PathVariable Long id

    ) {



        return ResponseEntity.ok(
                service.getStatisticsById(id)
        );



    }





    @PostMapping
    public ResponseEntity<MatchStatistics> create(

            @RequestBody MatchStatistics statistics

    ) {



        return ResponseEntity.ok(
                service.createStatistics(statistics)
        );



    }





    @PutMapping("/{id}")
    public ResponseEntity<MatchStatistics> update(

            @PathVariable Long id,

            @RequestBody MatchStatistics statistics

    ) {



        return ResponseEntity.ok(
                service.updateStatistics(id, statistics)
        );



    }





    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(

            @PathVariable Long id

    ) {



        service.deleteStatistics(id);



        return ResponseEntity.ok(
                "Statistics deleted successfully"
        );



    }


}