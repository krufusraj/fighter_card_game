package com.kurapati.fighterCardGame.repositories;

import com.kurapati.fighterCardGame.models.AuctionHouseCard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuctionHouseCardRepository extends JpaRepository<AuctionHouseCard,Integer> {
}
