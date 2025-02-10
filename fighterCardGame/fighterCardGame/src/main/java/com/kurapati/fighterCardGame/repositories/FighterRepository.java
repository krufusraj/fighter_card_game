package com.kurapati.fighterCardGame.repositories;


import com.kurapati.fighterCardGame.models.Fighter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FighterRepository extends JpaRepository<Fighter,Long> {

}
