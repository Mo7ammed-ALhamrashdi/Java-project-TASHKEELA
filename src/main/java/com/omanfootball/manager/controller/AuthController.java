package com.omanfootball.manager.controller;


import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import com.omanfootball.manager.entity.User;
import com.omanfootball.manager.service.AuthService;



@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {


    private final AuthService authService;



    @PostMapping("/register")
    public User register(
            @RequestBody User user
    ){

        return authService.register(user);

    }




    @PostMapping("/login")
    public User login(
            @RequestParam String email,
            @RequestParam String password
    ){

        return authService.login(
                email,
                password
        );

    }


}