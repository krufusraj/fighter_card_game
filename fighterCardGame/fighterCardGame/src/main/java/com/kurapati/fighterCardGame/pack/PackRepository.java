package com.kurapati.fighterCardGame.pack;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PackRepository extends JpaRepository<Pack,Integer> {

    public Pack findByName(String packName);



}
