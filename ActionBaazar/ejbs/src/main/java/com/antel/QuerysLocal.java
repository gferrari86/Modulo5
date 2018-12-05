package com.antel;

import com.antel.entities.Order;

import javax.ejb.Local;
import java.util.List;

@Local
public interface QuerysLocal {

    public List<Order> findAllOrderDONE();
    public List<Order> findAllOrderBidId(Long bidId);

}
