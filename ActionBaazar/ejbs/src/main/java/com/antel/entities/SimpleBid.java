package com.antel.entities;

import javax.persistence.Entity;

@Entity(name="SIMPLE_BID")
public class SimpleBid extends Bid {

    private String simpleBidId;

    public String getSimpleBidId() {
        return simpleBidId;
    }

    public void setSimpleBidId(String simpleBidId) {
        this.simpleBidId = simpleBidId;
    }
}
