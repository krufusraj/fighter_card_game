package com.kurapati.fighterCardGame.services;

import com.kurapati.fighterCardGame.models.AuctionHouseCard;
import com.kurapati.fighterCardGame.repositories.AuctionHouseCardRepository;
import com.kurapati.fighterCardGame.repositories.CardRepository;

import java.util.Collection;
import java.util.List;

public class AuctionHouseCardService {

    private final AuctionHouseCardRepository auctionHouseCardRepo;
    private final CardRepository cardRepo;

    public AuctionHouseCardService(AuctionHouseCardRepository auctionHouseCardRepo, CardRepository cardRepo) {
        this.auctionHouseCardRepo = auctionHouseCardRepo;
        this.cardRepo = cardRepo;
    }

    public void createAuctionHouseCard(int cardId, int auctionStartingPrice, int buyNowPrice, int duration){
        auctionHouseCardRepo.save(
                new AuctionHouseCard(
                        cardRepo.findById(cardId).orElseThrow(
                                ()->new RuntimeException("Card does not exist")
                        ),
                        buyNowPrice,
                        auctionStartingPrice,
                        duration
                )
        );

    }

    public void updateAuctionHouseCard(){

    }

    public void removeAAuctionHouseCard(int auctionHouseCardId){
        auctionHouseCardRepo.deleteById(auctionHouseCardId);
    }

    public List<AuctionHouseCard> getAuctionCards(){
        return auctionHouseCardRepo.findAll();
    }

}
