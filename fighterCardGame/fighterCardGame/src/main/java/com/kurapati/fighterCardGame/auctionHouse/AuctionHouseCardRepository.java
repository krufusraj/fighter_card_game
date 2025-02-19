package com.kurapati.fighterCardGame.auctionHouse;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface AuctionHouseCardRepository extends JpaRepository<AuctionHouseCard,Integer> {

    @Query(value = "DELETE FROM auction_house_card where expiration_time < CURRENT_TIMESTAMP", nativeQuery = true)
    void handleTimeExpired();
}
