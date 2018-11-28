package com.antel;

import com.antel.entities.Bid;
import com.antel.entities.PremiumBid;
import com.antel.entities.SimpleBid;

import javax.annotation.Resource;
import javax.ejb.*;


@Stateless
public class TimerBid {

    @EJB
    PlaceBid placeBidLocal;


    @Schedules(value = {@Schedule(minute = "*",hour = "*")})
    public void timerBid(Timer timer){
        System.out.println("timerBid");

        SimpleBid simpleBid = new SimpleBid();
        simpleBid.setBidAmount(400);
        simpleBid.setSimpleBidId("SimpleBid1");

        PremiumBid premiumBid = new PremiumBid();
        premiumBid.setBidAmount(500);
        premiumBid.setPremiumBid("PremiumBid1");


        placeBidLocal.addBid(simpleBid);
        placeBidLocal.addBid(premiumBid);


    }

}
