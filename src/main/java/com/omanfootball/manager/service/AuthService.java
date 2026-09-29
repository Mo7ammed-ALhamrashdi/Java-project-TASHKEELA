package com.omanfootball.manager.service;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


import com.omanfootball.manager.entity.User;
import com.omanfootball.manager.repository.UserRepository;



@Service
@RequiredArgsConstructor
public class AuthService {



    private final UserRepository userRepository;




    public User register(User user){



        if(userRepository.existsByEmail(
                user.getEmail())){


            throw new RuntimeException(
                    "Email already exists"
            );

        }



        user.setRole("USER");



        return userRepository.save(user);


    }




    public User login(
            String email,
            String password
    ){


        User user =
                userRepository.findByEmail(email);



        if(user == null){

            throw new RuntimeException(
                    "User not found"
            );

        }



        if(!user.getPassword()
                .equals(password)){


            throw new RuntimeException(
                    "Wrong password"
            );

        }



        return user;


    }


}