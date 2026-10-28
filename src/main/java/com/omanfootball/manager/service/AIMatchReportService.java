package com.omanfootball.manager.service;

import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import com.omanfootball.manager.entity.AIMatchReport;
import com.omanfootball.manager.repository.AIMatchReportRepository;


@Service
@RequiredArgsConstructor
public class AIMatchReportService {


    private final AIMatchReportRepository repository;



    public List<AIMatchReport> getAll() {

        return repository.findAll();

    }



    public AIMatchReport getReportById(Long id) {

        return repository.findById(id)
                .orElseThrow(
                        () -> new RuntimeException(
                                "AI Match Report not found with id: " + id
                        )
                );

    }



    @Transactional
    public AIMatchReport generateReport(AIMatchReport report) {

        return repository.save(report);

    }



    @Transactional
    public void deleteReport(Long id) {

        AIMatchReport report = getReportById(id);

        repository.delete(report);

    }


}