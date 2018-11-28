package com.antel;

import com.antel.entities.Bid;

import javax.ejb.Local;

@Local
public interface PlaceBid {

    Bid addBid(Bid bid);

}
