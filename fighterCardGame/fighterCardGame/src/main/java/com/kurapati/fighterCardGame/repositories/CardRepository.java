package com.kurapati.fighterCardGame.repositories;

import com.kurapati.fighterCardGame.models.Card;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CardRepository extends CrudRepository<Card,Integer> {
}
