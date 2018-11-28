package com.antel.entities;

import javax.persistence.*;

@Entity
@Table(name="BID")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class Bid {

    protected Long id;
    private int bidderId;
    private long itemId;
    private double bidAmount;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getBidderId() {
        return bidderId;
    }

    public void setBidderId(int bidderId) {
        this.bidderId = bidderId;
    }

    public long getItemId() {
        return itemId;
    }

    public void setItemId(int itemId) {
        this.itemId = itemId;
    }

    public double getBidAmount() {
        return bidAmount;
    }

    public void setBidAmount(double bidAmount) {
        this.bidAmount = bidAmount;
    }
}
