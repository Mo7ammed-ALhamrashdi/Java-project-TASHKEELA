package com.omanfootball.manager.controller;


import lombok.RequiredArgsConstructor;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;


import com.omanfootball.manager.entity.AIMatchReport;
import com.omanfootball.manager.service.AIMatchReportService;



@RestController
@RequestMapping("/api/ai-match-reports")
@RequiredArgsConstructor
public class AIMatchReportController {



    private final AIMatchReportService service;





    @GetMapping
    public ResponseEntity<List<AIMatchReport>> getAll() {



        return ResponseEntity.ok(
                service.getAll()
        );



    }





    @GetMapping("/{id}")
    public ResponseEntity<AIMatchReport> getById(

            @PathVariable Long id

    ) {



        return ResponseEntity.ok(
                service.getReportById(id)
        );



    }





    @PostMapping
    public ResponseEntity<AIMatchReport> create(

            @RequestBody AIMatchReport report

    ) {



        return ResponseEntity.ok(
                service.generateReport(report)
        );



    }





    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(

            @PathVariable Long id

    ) {



        service.deleteReport(id);



        return ResponseEntity.ok(
                "AI report deleted successfully"
        );



    }


}