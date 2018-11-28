package com.antel;

import com.antel.entities.Bid;

import javax.ejb.Stateless;
import javax.interceptor.Interceptors;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
@Interceptors({InterceptorLogger.class})
public class PlaceBidBean implements PlaceBid{


    @PersistenceContext
    EntityManager entityManager;

    public PlaceBidBean(){};

    public Bid addBid(Bid bid) {

        entityManager.persist(bid);

        System.out.println("Adding Bid" +
                ", Bidder ID =" + bid.getBidderId() +
                ", Item ID= " + bid.getItemId() +
                ", Bid Amount= " + bid.getBidAmount());




        return bid;
    }


}
