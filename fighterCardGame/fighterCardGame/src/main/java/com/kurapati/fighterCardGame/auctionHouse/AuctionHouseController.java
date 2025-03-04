package com.kurapati.fighterCardGame.auctionHouse;

import com.kurapati.fighterCardGame.card.Card;
import com.kurapati.fighterCardGame.pack.PackService;
import com.kurapati.fighterCardGame.users.UserService;
import com.kurapati.fighterCardGame.users.Users;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AuctionHouseController {

    private final AuctionHouseCardService auctionHouseCardService;



    public AuctionHouseController(AuctionHouseCardService auctionHouseCardService) {
        this.auctionHouseCardService = auctionHouseCardService;
    }

    @PostMapping("/auction/post")
        public List<AuctionHouseCard> addCardToAuction(@RequestBody PostAuctionDTO postAuctionDTO) {
            auctionHouseCardService.createAuctionHouseCard(
                    postAuctionDTO.getSellerId(),
                    postAuctionDTO.getCardId(),
                    postAuctionDTO.getStartingPrice(),
                    postAuctionDTO.getBuyNowPrice(),
                    postAuctionDTO.getDuration()
            );
            return auctionHouseCardService.getAuctionCards();
        }

    @PostMapping("/auction/bid")
    public List<AuctionHouseCard> bidOnCard(@RequestBody BidAuctionDTO bidAuctionDTO){
        System.out.println(bidAuctionDTO.toString());
        auctionHouseCardService.placeBid(
                bidAuctionDTO.getBidderId(),
                bidAuctionDTO.getAuctionCardId(),
                bidAuctionDTO.getBidAmount()
        );
        return auctionHouseCardService.getAuctionCards();
    }

    @PostMapping("/auction/buy")
    public List<AuctionHouseCard> buyCard(@RequestBody BuyAuctionDTO buyAuctionDTO){
        auctionHouseCardService.buyAuctionHouseCard(
                buyAuctionDTO.getAuctionCardId(),
                buyAuctionDTO.getSellerId(),
                buyAuctionDTO.getBuyerId(),
                buyAuctionDTO.getCardId(),
                buyAuctionDTO.getSellingPrice()
        );
        return auctionHouseCardService.getAuctionCards();
    }

    @GetMapping("/auction")
    public List<AuctionHouseCard> getAuctionHouseCards(){
        return auctionHouseCardService.getAuctionCards();
    }

}
