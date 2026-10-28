package com.omanfootball.manager.controller;


import lombok.RequiredArgsConstructor;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;


import com.omanfootball.manager.entity.WhatIfSimulation;
import com.omanfootball.manager.service.SimulationService;



@RestController
@RequestMapping("/api/simulations")
@RequiredArgsConstructor
public class SimulationController {



    private final SimulationService service;





    @GetMapping
    public ResponseEntity<List<WhatIfSimulation>> getAll() {



        return ResponseEntity.ok(
                service.getAll()
        );



    }





    @GetMapping("/{id}")
    public ResponseEntity<WhatIfSimulation> getById(

            @PathVariable Long id

    ) {



        return ResponseEntity.ok(
                service.getById(id)
        );



    }





    @PostMapping
    public ResponseEntity<WhatIfSimulation> create(

            @RequestBody WhatIfSimulation simulation

    ) {



        return ResponseEntity.ok(
                service.create(simulation)
        );



    }





    @PutMapping("/{id}")
    public ResponseEntity<WhatIfSimulation> update(

            @PathVariable Long id,

            @RequestBody WhatIfSimulation simulation

    ) {



        return ResponseEntity.ok(
                service.update(id, simulation)
        );



    }





    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(

            @PathVariable Long id

    ) {



        service.delete(id);



        return ResponseEntity.ok(
                "Simulation deleted successfully"
        );



    }


}