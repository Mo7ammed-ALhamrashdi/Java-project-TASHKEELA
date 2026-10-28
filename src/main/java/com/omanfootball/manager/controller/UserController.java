package com.omanfootball.manager.controller;


import lombok.RequiredArgsConstructor;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;


import com.omanfootball.manager.entity.User;
import com.omanfootball.manager.service.UserService;



@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {



    private final UserService userService;





    @GetMapping
    public ResponseEntity<List<User>> getAllUsers() {



        return ResponseEntity.ok(
                userService.getAllUsers()
        );



    }





    @GetMapping("/{id}")
    public ResponseEntity<User> getUser(

            @PathVariable Long id

    ) {



        return ResponseEntity.ok(
                userService.getUserById(id)
        );



    }





    @PutMapping("/{id}")
    public ResponseEntity<User> updateUser(

            @PathVariable Long id,

            @RequestBody User user

    ) {



        return ResponseEntity.ok(
                userService.updateUser(id, user)
        );



    }





    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteUser(

            @PathVariable Long id

    ) {



        userService.deleteUser(id);



        return ResponseEntity.ok(
                "User deleted successfully"
        );



    }


}