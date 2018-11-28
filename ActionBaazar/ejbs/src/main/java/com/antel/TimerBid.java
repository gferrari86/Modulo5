package com.antel;

import com.antel.entities.Bid;

import javax.annotation.Resource;
import javax.ejb.*;


@Stateless
public class TimerBid {

    @EJB
    PlaceBid placeBidLocal;


    @Schedules(value = {@Schedule(minute = "*",hour = "*")})
    public void timerBid(Timer timer){
        System.out.println("timerBid");

        Bid bid = new Bid();
        bid.setBidAmount(400);
        placeBidLocal.addBid(bid);


    }

}
