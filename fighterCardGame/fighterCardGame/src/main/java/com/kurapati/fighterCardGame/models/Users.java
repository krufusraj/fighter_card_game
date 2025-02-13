package com.kurapati.fighterCardGame.models;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
public class Users {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @OneToMany(cascade = CascadeType.MERGE)
//    @JoinColumn
    List<Card> userCards = new ArrayList<Card>();

    private String username;
    private String email;
    private String password;
    private Long money = 0L;
    private String role;

    public Users(String username, String email, String password, String role) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.role = role;
    }

    private Users() {
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public List<Card> getUserCards() {
        return userCards;
    }

    public void setUserCards(List<Card> userCards) {
        this.userCards = userCards;
    }


    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    public String getPassword() {
        return password;
    }


    public void setPassword(String password) {
        this.password = password;
    }

    public Long getMoney() {
        return money;
    }

    public void setMoney(Long money) {
        this.money = money;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", userCards=" + userCards +
                ", username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", money=" + money +
                ", role='" + role + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Users users = (Users) o;
        return id == users.id && Objects.equals(userCards, users.userCards) && Objects.equals(username, users.username) && Objects.equals(email, users.email) && Objects.equals(password, users.password) && Objects.equals(money, users.money) && Objects.equals(role, users.role);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, userCards, username, email, password, money, role);
    }
}
