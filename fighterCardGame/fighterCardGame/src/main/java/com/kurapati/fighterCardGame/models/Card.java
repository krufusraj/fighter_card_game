package com.kurapati.fighterCardGame.models;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Card {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;
    private String weightClass;
    private String tier;
    private String country;
    private String nickname;
    private String record;
    private String height;
    private String age;
    private String nextFight;

    private Card() {
    }

    public Card( String name, String weightClass, String tier, String country, String nickname, String record, String height, String age, String nextFight) {
        this.name = name;
        this.weightClass = weightClass;
        this.tier = tier;
        this.country = country;
        this.nickname = nickname;
        this.record = record;
        this.height = height;
        this.age = age;
        this.nextFight = nextFight;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getWeightClass() {
        return weightClass;
    }

    public void setWeightClass(String weightClass) {
        this.weightClass = weightClass;
    }


    public String getTier() {
        return tier;
    }

    public void setTier(String tier) {
        this.tier = tier;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getRecord() {
        return record;
    }

    public void setRecord(String record) {
        this.record = record;
    }

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getNextFight() {
        return nextFight;
    }

    public void setNextFight(String nextFight) {
        this.nextFight = nextFight;
    }

    @Override
    public String toString() {
        return "Card{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", weightClass='" + weightClass + '\'' +
                ", tier='" + tier + '\'' +
                ", country='" + country + '\'' +
                ", nickname='" + nickname + '\'' +
                ", record='" + record + '\'' +
                ", height='" + height + '\'' +
                ", age='" + age + '\'' +
                ", nextFight='" + nextFight + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Card card = (Card) o;
        return Objects.equals(id, card.id) && Objects.equals(name, card.name) && Objects.equals(weightClass, card.weightClass) && Objects.equals(tier, card.tier) && Objects.equals(country, card.country) && Objects.equals(nickname, card.nickname) && Objects.equals(record, card.record) && Objects.equals(height, card.height) && Objects.equals(age, card.age) && Objects.equals(nextFight, card.nextFight);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, weightClass, tier, country, nickname, record, height, age, nextFight);
    }


}
