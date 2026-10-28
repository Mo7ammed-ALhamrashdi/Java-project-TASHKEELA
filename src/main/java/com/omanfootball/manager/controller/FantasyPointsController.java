package com.omanfootball.manager.controller;

import com.omanfootball.manager.entity.FantasyPoints;
import com.omanfootball.manager.service.FantasyPointsService;

import lombok.RequiredArgsConstructor;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/fantasy-points")
@RequiredArgsConstructor
public class FantasyPointsController {

    private final FantasyPointsService service;

    @GetMapping
    public ResponseEntity<List<FantasyPoints>> getAll() {
        return ResponseEntity.ok(
                service.getAllPoints()
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<FantasyPoints> getById(
            @PathVariable Long id
    ) {
        return ResponseEntity.ok(
                service.getPointsById(id)
        );
    }

    @PostMapping
    public ResponseEntity<FantasyPoints> create(
            @RequestBody FantasyPoints points
    ) {
        return ResponseEntity.ok(
                service.createPoints(points)
        );
    }

    @PutMapping("/{id}")
    public ResponseEntity<FantasyPoints> update(
            @PathVariable Long id,
            @RequestBody FantasyPoints points
    ) {
        return ResponseEntity.ok(
                service.updatePoints(id, points)
        );
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(
            @PathVariable Long id
    ) {
        service.deletePoints(id);

        return ResponseEntity.ok(
                "Fantasy points deleted successfully"
        );
    }
}