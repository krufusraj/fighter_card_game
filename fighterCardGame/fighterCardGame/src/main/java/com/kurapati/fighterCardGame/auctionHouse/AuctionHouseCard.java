package com.kurapati.fighterCardGame.auctionHouse;

import com.kurapati.fighterCardGame.card.Card;
import com.kurapati.fighterCardGame.users.Users;
import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;

import java.util.Date;
import java.util.Objects;

@Entity
public class AuctionHouseCard{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "posted_time")
    @Temporal(TemporalType.TIMESTAMP)
    private Date postedTime = new Date();

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "card_id")
    private Card card;
    private int buyNowPrice;
    private int startingAuction;
    private int duration;

    @OneToOne
    private Users seller;

    private AuctionHouseCard() {
    }

    public AuctionHouseCard(Users seller,Card card, int buyNowPrice, int startingAuction,int duration) {
        this.seller = seller;
        this.card = card;
        this.buyNowPrice = buyNowPrice;
        this.startingAuction = startingAuction;
        this.duration = duration;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getPostedTime() {
        return postedTime;
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
