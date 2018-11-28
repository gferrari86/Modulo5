package com.antel.entities;


import javax.persistence.Entity;

@Entity(name = "PREMIUM_BID")
public class PremiumBid extends Bid {

    private String PremiumBid;

    public String getPremiumBid() {
        return PremiumBid;
    }

    public void setPremiumBid(String premiumBid) {
        PremiumBid = premiumBid;
    }

}
