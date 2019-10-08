package com.kanasuki.nadbank.backend.product;

import com.kanasuki.nadbank.backend.bank.Bank;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Embedded
    private Bank bank;

    private String name;

    protected Product() {
    }

    public Product(String name, Bank bank) {
        this.name = name;
        this.bank = bank;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", bank=" + bank +
                ", name='" + name + '\'' +
                '}';
    }

    public Long getId() {
        return id;
    }

    public Bank getBank() {
        return bank;
    }

    public String getName() {
        return name;
    }
}
