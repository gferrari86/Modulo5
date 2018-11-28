package com.antel;

import com.antel.entities.Bid;

import javax.ejb.Stateless;
import javax.interceptor.Interceptors;

@Stateless
@Interceptors({InterceptorLogger.class})
public class PlaceBidBean implements PlaceBid{

    public PlaceBidBean(){};

    public Bid addBid(Bid bid) {

        System.out.println("Adding Bid" +
                ", Bidder ID =" + bid.getBidderId() +
                ", Item ID= " + bid.getItemId() +
                ", Bid Amount= " + bid.getBidAmount());




        return bid;
    }


}
