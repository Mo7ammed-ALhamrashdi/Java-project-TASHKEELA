package com.omanfootball.manager.controller;


import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;


import java.util.List;


import com.omanfootball.manager.entity.User;
import com.omanfootball.manager.repository.UserRepository;



@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {



    private final UserRepository userRepository;



    @GetMapping
    public List<User> getUsers(){

        return userRepository.findAll();

    }



    @GetMapping("/{id}")
    public User getUser(
            @PathVariable Long id
    ){

        return userRepository.findById(id)
                .orElseThrow(
                        () -> new RuntimeException(
                                "User not found"
                        ));

    }


}