package com.kurapati.fighterCardGame.auctionHouse;

import com.kurapati.fighterCardGame.card.Card;
import com.kurapati.fighterCardGame.card.CardRepository;
import com.kurapati.fighterCardGame.users.UserRepository;
import com.kurapati.fighterCardGame.users.Users;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuctionHouseCardService {

    private final AuctionHouseCardRepository auctionHouseCardRepo;
    private final CardRepository cardRepo;
    private final UserRepository userRepository;

    public AuctionHouseCardService(AuctionHouseCardRepository auctionHouseCardRepo, CardRepository cardRepo, UserRepository userRepository) {
        this.auctionHouseCardRepo = auctionHouseCardRepo;
        this.cardRepo = cardRepo;
        this.userRepository = userRepository;
    }

    public void createAuctionHouseCard(int sellerId, int cardId, int auctionStartingPrice, int buyNowPrice, int duration){
        auctionHouseCardRepo.save(
                new AuctionHouseCard(
                        userRepository.findById(sellerId).orElseThrow(
                                ()->new RuntimeException("user does not exist")
                        ),
                        cardRepo.findById(cardId).orElseThrow(
                                ()->new RuntimeException("Card does not exist")
                        ),
                        buyNowPrice,
                        auctionStartingPrice,
                        duration
                )
        );

    }

    public void buyAuctionHouseCard(int sellerId, int buyerId, int cardId, int sellingPrice){
        //remove card from seller
        Users seller = userRepository.findById(sellerId).orElseThrow(
                ()->new RuntimeException("user does not exist")
        );
        List<Card> cards = seller.getUserCards();
        //cards.remove()
        //add money to buyer
        //add card to buyer
        //remove money form buyer
        //remove card from auctionHouse

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
