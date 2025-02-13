package com.kurapati.fighterCardGame.controllers;

import com.kurapati.fighterCardGame.models.Users;
import com.kurapati.fighterCardGame.services.UserService;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/user")
    public void addUser(@RequestBody Users users){
        userService.createUser(users);
    }
}
