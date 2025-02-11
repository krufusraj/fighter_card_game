package com.kurapati.fighterCardGame.models;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
public class AuctionHouseCard{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "card_id")
    private Card card;
    private int buyNowPrice;
    private int startingAuction;
    private int duration;

    private AuctionHouseCard() {
    }

    public AuctionHouseCard(Card card, int buyNowPrice, int startingAuction,int duration) {
        this.card = card;
        this.buyNowPrice = buyNowPrice;
        this.startingAuction = startingAuction;
        this.duration = duration;
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

    public int getStartingAuction() {
        return startingAuction;
    }

    public void setStartingAuction(int startingAuction) {
        this.startingAuction = startingAuction;
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
        return id == that.id && buyNowPrice == that.buyNowPrice && startingAuction == that.startingAuction && duration == that.duration && Objects.equals(card, that.card);
    }

    @Override
    public String toString() {
        return "AuctionHouseCard{" +
                "id=" + id +
                ", card=" + card +
                ", buyNowPrice=" + buyNowPrice +
                ", startingAuction=" + startingAuction +
                ", duration=" + duration +
                '}';
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, card, buyNowPrice, startingAuction, duration);
    }

}
