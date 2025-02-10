package com.kurapati.fighterCardGame.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;


import java.util.Objects;

@Entity
public class Fighter {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;
    private String country;
    private String nickname;
    private String record;
    private String weightClass;
    private String height;
    private String age;
    private String nextFight;

    public Fighter( String name, String country, String nickname, String record, String weightClass, String height, String age, String nextFight) {

        this.name = name;
        this.country = country;
        this.nickname = nickname;
        this.record = record;
        this.weightClass = weightClass;
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

    public String getWeightClass() {
        return weightClass;
    }

    public void setWeightClass(String weightClass) {
        this.weightClass = weightClass;
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
        return "Fighters{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", country='" + country + '\'' +
                ", nickname='" + nickname + '\'' +
                ", record='" + record + '\'' +
                ", weightClass='" + weightClass + '\'' +
                ", height='" + height + '\'' +
                ", age='" + age + '\'' +
                ", nextFight='" + nextFight + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Fighter fighters = (Fighter) o;
        return Objects.equals(id, fighters.id) && Objects.equals(name, fighters.name) && Objects.equals(country, fighters.country) && Objects.equals(nickname, fighters.nickname) && Objects.equals(record, fighters.record) && Objects.equals(weightClass, fighters.weightClass) && Objects.equals(height, fighters.height) && Objects.equals(age, fighters.age) && Objects.equals(nextFight, fighters.nextFight);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, country, nickname, record, weightClass, height, age, nextFight);
    }


}
