package com.kurapati.fighterCardGame.auctionHouse;

public class BidAuctionDTO {

    private int bidderId;
    private int auctionCardId;
    private int bidAmount;

    public int getBidderId() {
        return bidderId;
    }

    public void setBidderId(int bidderId) {
        this.bidderId = bidderId;
    }

    public int getAuctionCardId() {
        return auctionCardId;
    }

    public void setAuctionCardId(int auctionCardId) {
        this.auctionCardId = auctionCardId;
    }

    public int getBidAmount() {
        return bidAmount;
    }

    public void setBidAmount(int bidAmount) {
        this.bidAmount = bidAmount;
    }

    @Override
    public String toString() {
        return "BidAuctionDTO{" +
                "bidderId=" + bidderId +
                ", auctionCardId=" + auctionCardId +
                ", bidAmount=" + bidAmount +
                '}';
    }
}
