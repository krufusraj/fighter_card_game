package com.kurapati.fighterCardGame.services;

import com.kurapati.fighterCardGame.models.Card;
import com.kurapati.fighterCardGame.models.Users;
import com.kurapati.fighterCardGame.repositories.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserService {


    private final UserRepository userRepo;

    public UserService(UserRepository userRepo, PackService packService) {
        this.userRepo = userRepo;
    }


    @Transactional
    public void createUser(Users newUsers){
        userRepo.save(
                newUsers
        );


    }
    public void deleteUser(int userId){

    }
    public void updateUser(int userId){

    }

    public void getUser(int userId){

    }


}

