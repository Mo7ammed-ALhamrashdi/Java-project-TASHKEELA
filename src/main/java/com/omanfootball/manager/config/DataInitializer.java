package com.omanfootball.manager.config;


import lombok.RequiredArgsConstructor;

import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;


import com.omanfootball.manager.entity.Role;
import com.omanfootball.manager.entity.User;
import com.omanfootball.manager.repository.UserRepository;


@Component
@RequiredArgsConstructor
public class DataInitializer implements CommandLineRunner {


    private final UserRepository userRepository;

    private final PasswordEncoder passwordEncoder;


    @Override
    public void run(String... args) {


        String adminEmail = "Malhamrashdi900@gmail.com";


        if(!userRepository.existsByEmail(adminEmail)) {


            User admin = new User();


            admin.setFullName(
                    "System Admin"
            );


            admin.setEmail(
                    adminEmail
            );


            admin.setPassword(
                    passwordEncoder.encode(
                            "Admin@123"
                    )
            );


            admin.setRole(
                    Role.ADMIN
            );


            userRepository.save(admin);


            System.out.println(
                    "ADMIN CREATED"
            );


            System.out.println(
                    "Email: " + adminEmail
            );


            System.out.println(
                    "Password: Admin@123"
            );

        }


    }


}