package com.kurapati.fighterCardGame.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.util.Objects;


public class AuctionHouseCard extends Card{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private int buyNowPrice;
    private int startingAuction;


    public AuctionHouseCard(String name, String weightClass, int rating, int buyNowPrice, int startingAuction, String tier, String country, String nickname, String record, String height, String age, String nextFight, String name1, String weightClass1, int rating1, int buyNowPrice1, int startingAuction1, String tier1, String country1, String nickname1, String record1, String height1, String age1, String nextFight1) {
        super(name, weightClass, tier, country, nickname, record, height, age, nextFight);
        this.buyNowPrice = buyNowPrice1;
        this.startingAuction = startingAuction1;
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

    @Override
    public int getId() {
        return id;
    }

    @Override
    public void setId(int id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        AuctionHouseCard that = (AuctionHouseCard) o;
        return id == that.id && buyNowPrice == that.buyNowPrice && startingAuction == that.startingAuction;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), id, buyNowPrice, startingAuction);
    }

    @Override
    public String toString() {
        return "AuctionHouseCard{" +
                "id=" + id +
                ", buyNowPrice=" + buyNowPrice +
                ", startingAuction=" + startingAuction +
                '}';
    }
}
