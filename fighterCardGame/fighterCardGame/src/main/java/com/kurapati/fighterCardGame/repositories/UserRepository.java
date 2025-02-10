package com.kurapati.fighterCardGame.repositories;

import com.kurapati.fighterCardGame.models.Fighter;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<Fighter,Integer> {

}
