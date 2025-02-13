package com.kurapati.fighterCardGame.repositories;

import com.kurapati.fighterCardGame.models.Fighter;
import com.kurapati.fighterCardGame.models.Pack;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface PackRepository extends JpaRepository<Pack,Integer> {

    public Pack findByName(String packName);



}
