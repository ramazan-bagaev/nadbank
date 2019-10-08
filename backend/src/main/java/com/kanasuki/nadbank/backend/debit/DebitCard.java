package com.kanasuki.nadbank.backend.debit;

import com.kanasuki.nadbank.backend.cashback.Cashback;

import javax.persistence.*;

@Entity
public class DebitCard {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Long productId;

    @Embedded
    private Cashback cashback;

    protected DebitCard() {

    }

    public DebitCard(Long productId, Cashback cashback) {
        this.productId = productId;
        this.cashback = cashback;
    }

    @Override
    public String toString() {
        return "DebitCard{" +
                "id=" + id +
                ", productId=" + productId +
                ", cashbackId=" + cashback +
                '}';
    }

    public Long getProductId() {
        return productId;
    }

    public Cashback getCashback() {
        return cashback;
    }

    public Long getId() {
        return id;
    }
}
