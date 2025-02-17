package com.kurapati.fighterCardGame.auctionHouse;

public class BuyAuctionDTO {
    private int auctionCardId;
    private int sellerId;
    private int buyerId;
    private int cardId;
    private int sellingPrice;

    public int getAuctionCardId() {
        return auctionCardId;
    }

    public void setAuctionCardId(int auctionCardId) {
        this.auctionCardId = auctionCardId;
    }

    public int getSellerId() {
        return sellerId;
    }

    public void setSellerId(int sellerId) {
        this.sellerId = sellerId;
    }

    public int getBuyerId() {
        return buyerId;
    }

    public void setBuyerId(int buyerId) {
        this.buyerId = buyerId;
    }

    public int getCardId() {
        return cardId;
    }

    public void setCardId(int cardId) {
        this.cardId = cardId;
    }

    public int getSellingPrice() {
        return sellingPrice;
    }

    public void setSellingPrice(int sellingPrice) {
        this.sellingPrice = sellingPrice;
    }
}
