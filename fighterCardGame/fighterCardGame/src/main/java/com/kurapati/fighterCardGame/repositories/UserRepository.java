package com.kurapati.fighterCardGame.repositories;

import com.kurapati.fighterCardGame.models.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<Users,Integer> {



}
