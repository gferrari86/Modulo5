package com.antel;

import com.antel.entities.Bid;
import com.antel.entities.Order;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

@Stateless

public class Querys implements QuerysLocal {

    @PersistenceContext
    EntityManager entityManager;

    public List<Order> findAllOrderDONE(){

        Query query = entityManager.createQuery("SELECT o FROM Order o WHERE o.status = 'DONE'");
        return query.getResultList();

    }

    public List<Order> findAllOrderBidId(Long bidId){

        Query query1 = entityManager.createQuery("SELECT bid FROM Bid bid WHERE bid.id = :bidId");
        query1.setParameter("bidId", bidId);
        List<Bid> listaBids = query1.getResultList();

        if(listaBids.size()==0){
            return new ArrayList<Order>();
        }
        Bid requiredBid = listaBids.get(0);

        Query query2 = entityManager.createQuery("SELECT o FROM Order o WHERE :requiredBid MEMBER OF o.bids");
        query2.setParameter("requiredBid", requiredBid);
        return query2.getResultList();

        //Se podria simplificar con algo por el estilo
        //"Select b From Order o Join o.bids bid where bid.id = :param"
    }


}
