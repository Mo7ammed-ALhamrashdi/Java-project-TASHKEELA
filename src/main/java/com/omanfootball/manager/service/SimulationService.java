package com.omanfootball.manager.service;


import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;


import com.omanfootball.manager.entity.WhatIfSimulation;
import com.omanfootball.manager.repository.WhatIfSimulationRepository;



@Service
@RequiredArgsConstructor
public class SimulationService {



    private final WhatIfSimulationRepository repository;





    public List<WhatIfSimulation> getAll() {

        return repository.findAll();

    }





    public WhatIfSimulation getById(Long id) {


        return repository.findById(id)
                .orElseThrow(
                        () -> new RuntimeException(
                                "Simulation not found with id: " + id
                        )
                );

    }





    @Transactional
    public WhatIfSimulation create(
            WhatIfSimulation simulation
    ) {

        return repository.save(simulation);

    }





    @Transactional
    public WhatIfSimulation update(
            Long id,
            WhatIfSimulation newSimulation
    ) {


        WhatIfSimulation simulation = getById(id);



        simulation.setOriginalTeam(
                newSimulation.getOriginalTeam()
        );



        simulation.setChanges(
                newSimulation.getChanges()
        );



        simulation.setFormationChange(
                newSimulation.getFormationChange()
        );



        simulation.setCaptainChange(
                newSimulation.getCaptainChange()
        );



        simulation.setPredictedPoints(
                newSimulation.getPredictedPoints()
        );



        simulation.setExpectedDifference(
                newSimulation.getExpectedDifference()
        );



        simulation.setUser(
                newSimulation.getUser()
        );



        return repository.save(simulation);

    }





    @Transactional
    public void delete(Long id) {


        WhatIfSimulation simulation = getById(id);



        repository.delete(simulation);


    }


}