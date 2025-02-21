package com.kurapati.fighterCardGame.auctionHouse;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AuctionHouseCardRepository extends JpaRepository<AuctionHouseCard,Integer> {

    @Modifying
    @Query(value = "DELETE FROM auction_house_card where expiration_time < CURRENT_TIMESTAMP", nativeQuery = true)
    void handleTimeExpired();

    @Query(value= "SELECT * FROM auction_house_card where expiration_time < CURRENT_TIMESTAMP", nativeQuery = true)
    List<AuctionHouseCard> getExpiredCards();
}
