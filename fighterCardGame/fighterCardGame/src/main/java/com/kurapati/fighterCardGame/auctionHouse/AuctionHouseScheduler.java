package com.kurapati.fighterCardGame.auctionHouse;

import com.kurapati.fighterCardGame.card.Card;
import com.kurapati.fighterCardGame.card.CardRepository;
import com.kurapati.fighterCardGame.users.Users;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Transactional
@Component
public class AuctionHouseScheduler {
    private final AuctionHouseCardRepository auctionHouseCardRepository;

    public AuctionHouseScheduler(AuctionHouseCardRepository auctionHouseCardRepository, CardRepository cardRepository) {
        this.auctionHouseCardRepository = auctionHouseCardRepository;
    }

    @Scheduled(fixedRate = 1000L, initialDelay = 20000L)
    public void cleanAuctionHouse() {
        List<AuctionHouseCard> expiredCards = auctionHouseCardRepository.getExpiredCards();
        for(AuctionHouseCard auctionCard:expiredCards) {
            Card card = auctionCard.getCard();
            Users seller = auctionCard.getSeller();
            seller.addToCards(card);
            auctionHouseCardRepository.deleteById(auctionCard.getAuctionHouseCardId());

        }
        System.out.println(auctionHouseCardRepository.findAll());
    }
}
