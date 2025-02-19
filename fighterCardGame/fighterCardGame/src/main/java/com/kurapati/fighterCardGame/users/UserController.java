package com.kurapati.fighterCardGame.users;

import com.kurapati.fighterCardGame.card.Card;
import com.kurapati.fighterCardGame.pack.PackService;
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
        user.setUserCards(pack);
        userService.createUser(user);
        System.out.println(pack);
        return pack;
    }
}
