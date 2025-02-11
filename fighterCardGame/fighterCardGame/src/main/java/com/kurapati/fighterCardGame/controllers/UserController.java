package com.kurapati.fighterCardGame.controllers;

import com.kurapati.fighterCardGame.models.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @PostMapping("/user")
    public void addUser(User user){

    }
}
