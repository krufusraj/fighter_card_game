package com.kurapati.fighterCardGame.auctionHouse;

import com.kurapati.fighterCardGame.card.Card;
import com.kurapati.fighterCardGame.card.CardRepository;
import com.kurapati.fighterCardGame.users.UserRepository;
import com.kurapati.fighterCardGame.users.Users;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

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

    public void buyAuctionHouseCard(int auctionCardId,int sellerId, int buyerId, int cardId, int sellingPrice){
        //remove card from seller
        Users seller = userRepository.findById(sellerId).orElseThrow(
                ()->new RuntimeException("user does not exist")
        );
        seller.setUserCards( seller.getUserCards().stream()
                .filter(card -> card.getCardId()!=cardId)
                .collect(Collectors.toList())
        );
        //add money to buyer
        seller.setMoney(seller.getMoney()+sellingPrice);

        //add card to buyer
        Users buyer = userRepository.findById(buyerId).orElseThrow(
                ()->new RuntimeException("user does not exist")
        );
        Card card = cardRepo.findById(cardId).orElseThrow(
                ()->new RuntimeException("user does not exist")
        );

        List<Card> cards =buyer.getUserCards();
        cards.add(card);
        buyer.setUserCards(cards);
        //remove money form buyer
        buyer.setMoney(buyer.getMoney()-sellingPrice);
        //remove card from auctionHouse
        auctionHouseCardRepo.deleteById(auctionCardId);
    }

    public void placeBid(int bidderId, int auctionCardId,int bidAmount){
        AuctionHouseCard auctionHouseCard = auctionHouseCardRepo.findById(auctionCardId).orElseThrow();
        auctionHouseCard.setMaxBidder(userRepository.findById(bidderId).orElseThrow());
        auctionHouseCard.setStartingAuction(bidAmount);

        Users bidder = userRepository.findById(bidderId).orElseThrow();
        bidder.setMoney(bidder.getMoney()-bidAmount);
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
