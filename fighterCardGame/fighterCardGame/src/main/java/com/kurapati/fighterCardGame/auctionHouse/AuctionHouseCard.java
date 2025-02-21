package com.kurapati.fighterCardGame.auctionHouse;

import com.kurapati.fighterCardGame.card.Card;
import com.kurapati.fighterCardGame.users.Users;
import jakarta.persistence.*;

import java.util.Date;
import java.util.Objects;

@Entity
public class AuctionHouseCard{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "auction_house_card_id")
    private int auctionHouseCardId;

    @Column(name = "posted_time")
    @Temporal(TemporalType.TIMESTAMP)
    private Date postedTime = new Date();

    @Column(name = "expiration_time")
    @Temporal(TemporalType.TIMESTAMP)
    private Date expirationTime = new Date();

    @ManyToOne(cascade = CascadeType.MERGE)
    private Card card;

    private int buyNowPrice;
    private int bidAmount;
    private int duration;

    @ManyToOne
    private Users seller;

    @ManyToOne
    private Users maxBidder;

    private AuctionHouseCard() {
    }

    public AuctionHouseCard(Users seller, Card card, int buyNowPrice, int bidAmount, int duration) {
        this.seller = seller;
        this.card = card;
        this.buyNowPrice = buyNowPrice;
        this.bidAmount = bidAmount;
        this.duration = duration;
        this.maxBidder = seller;
        this.expirationTime = new Date(postedTime.getTime()+duration);
    }

    public Date getExpirationTime() {
        return expirationTime;
    }

    public void setExpirationTime(Date expirationTime) {
        this.expirationTime = expirationTime;
    }

    public int getAuctionHouseCardId() {
        return auctionHouseCardId;
    }

    public void setAuctionHouseCardId(int auctionHouseCardId) {
        this.auctionHouseCardId = auctionHouseCardId;
    }

    public Date getPostedTime() {
        return postedTime;
    }

    public Users getMaxBidder() {
        return maxBidder;
    }

    public void setMaxBidder(Users maxBidder) {
        this.maxBidder = maxBidder;
    }

    public void setPostedTime(Date postedTime) {
        this.postedTime = postedTime;
    }

    public Users getSeller() {
        return seller;
    }

    public void setSeller(Users seller) {
        this.seller = seller;
    }

    public Card getCard() {
        return card;
    }

    public void setCard(Card card) {
        this.card = card;
    }

    public int getBuyNowPrice() {
        return buyNowPrice;
    }

    public void setBuyNowPrice(int buyNowPrice) {
        this.buyNowPrice = buyNowPrice;
    }

    public int getBidAmount() {
        return bidAmount;
    }

    public void setBidAmount(int bidAmount) {
        this.bidAmount = bidAmount;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AuctionHouseCard that = (AuctionHouseCard) o;
        return auctionHouseCardId == that.auctionHouseCardId && buyNowPrice == that.buyNowPrice && bidAmount == that.bidAmount && duration == that.duration && Objects.equals(postedTime, that.postedTime) && Objects.equals(expirationTime, that.expirationTime) && Objects.equals(card, that.card) && Objects.equals(seller, that.seller) && Objects.equals(maxBidder, that.maxBidder);
    }

    @Override
    public int hashCode() {
        return Objects.hash(auctionHouseCardId, postedTime, expirationTime, card, buyNowPrice, bidAmount, duration, seller, maxBidder);
    }

    @Override
    public String toString() {
        return "AuctionHouseCard{" +
                "auctionHouseCardId=" + auctionHouseCardId +
                ", postedTime=" + postedTime +
                ", expirationTime=" + expirationTime +
                ", card=" + card +
                ", buyNowPrice=" + buyNowPrice +
                ", bidAmount=" + bidAmount +
                ", duration=" + duration +
                ", seller=" + seller +
                ", maxBidder=" + maxBidder +
                '}';
    }

}
