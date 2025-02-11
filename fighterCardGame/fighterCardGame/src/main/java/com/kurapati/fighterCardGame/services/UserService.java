package com.kurapati.fighterCardGame.services;

import com.kurapati.fighterCardGame.models.User;
import com.kurapati.fighterCardGame.repositories.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService {


    private final UserRepository userRepo;

    public UserService(UserRepository userRepo) {
        this.userRepo = userRepo;
    }

    public void createUser(String team, String name, String password, String email){
        userRepo.save(
                new User(
                        team,
                        password,
                        email,
                        name)
        );

    }
    public void deleteUser(int userId){

    }
    public void updateUser(int userId){

    }

    public void getUser(int userId){

    }
}

