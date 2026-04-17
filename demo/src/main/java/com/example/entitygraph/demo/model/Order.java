package com.example.entitygraph.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

@Entity
@Table(name="orders")
public class Order {
    @Id
    private long id;

    private double amount;

    @ManyToOne
    @JsonIgnore
    private User user;

    public Order(long id, double amount, User user) {
        this.id = id;
        this.amount = amount;
        this.user = user;
    }
    public Order(){}
    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", amount=" + amount +
                '}';
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}

