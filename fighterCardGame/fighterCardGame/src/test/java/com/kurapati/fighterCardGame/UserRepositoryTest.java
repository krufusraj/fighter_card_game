package com.kurapati.fighterCardGame;

import com.kurapati.fighterCardGame.users.UserRepository;
import com.kurapati.fighterCardGame.users.Users;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@DataJpaTest
public class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    public void saveUserTest(){
        Users user =new Users(
           "Rafs",
           "rafs@email.com",
           "password",
           "ADMIN"
        );

        userRepository.save(user);
        assertThat(user.getUserId()).isGreaterThan(0);

    }
}
