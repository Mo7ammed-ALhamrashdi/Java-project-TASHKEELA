package com.omanfootball.manager.dto;


import lombok.Data;


import java.time.LocalDateTime;



@Data
public class AIMatchReportResponse {



    private Long reportId;



    private Long matchId;



    private String summary;



    private String keyPlayer;



    private String aiAnalysis;



    private LocalDateTime createdAt;



}