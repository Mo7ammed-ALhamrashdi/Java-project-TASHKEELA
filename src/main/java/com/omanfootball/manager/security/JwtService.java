package com.omanfootball.manager.security;


import org.springframework.stereotype.Service;


import java.util.Date;



@Service
public class JwtService {



    private final String SECRET_KEY =
            "OMAN_AI_FOOTBALL_SECRET_KEY";



    public String generateToken(
            String email
    ){


        return email + "-" +
                new Date().getTime();


    }




    public String extractEmail(
            String token
    ){

        return token.split("-")[0];

    }


}