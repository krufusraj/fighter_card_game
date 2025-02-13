package com.kurapati.fighterCardGame.controllers;

import com.kurapati.fighterCardGame.models.Card;
import com.kurapati.fighterCardGame.models.Users;
import com.kurapati.fighterCardGame.services.PackService;
import com.kurapati.fighterCardGame.services.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    private final UserService userService;
    private final PackService packService;

    public UserController(UserService userService, PackService packService) {

        this.userService = userService;
        this.packService = packService;
    }

    @PostMapping("/user")
    public List<Card> addUser(@RequestBody Users user){
        List<Card> pack = packService.generatePack("Starter",user);
        userService.createUser(user);
        System.out.println(pack);
        return pack;
    }
}
