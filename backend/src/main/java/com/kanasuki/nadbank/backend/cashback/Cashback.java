package com.kanasuki.nadbank.backend.cashback;

import javax.persistence.*;

@Embeddable
public class Cashback {

    @Column(name = "percent")
    private Double percent;

    protected Cashback() {
    }

    public Cashback(Double percent) {
        this.percent = percent;
    }

    @Override
    public String toString() {
        return "Cashback{" +
                "percent=" + percent +
                '}';
    }

    public Double getPercent() {
        return percent;
    }
}
