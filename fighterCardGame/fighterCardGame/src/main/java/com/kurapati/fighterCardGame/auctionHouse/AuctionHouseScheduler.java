package com.kurapati.fighterCardGame.auctionHouse;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

@Transactional
@Component
public class AuctionHouseScheduler {
    private final AuctionHouseCardRepository auctionHouseCardRepository;

    public AuctionHouseScheduler(AuctionHouseCardRepository auctionHouseCardRepository) {
        this.auctionHouseCardRepository = auctionHouseCardRepository;
    }

    @Modifying
    @Scheduled(fixedRate = 1000L, initialDelay = 20000L)
    public void cleanAuctionHouse(){
        try {
            auctionHouseCardRepository.handleTimeExpired();
            System.out.println("Deleted Expired Card");
        } catch (Exception e) {
            //throw new RuntimeException(e);
        }
    }
}
