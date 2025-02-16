package com.kurapati.fighterCardGame.auctionHouse;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuctionHouseCardRepository extends JpaRepository<AuctionHouseCard,Integer> {
}
