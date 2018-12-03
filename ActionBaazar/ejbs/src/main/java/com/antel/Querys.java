package com.antel;

import com.antel.entities.Order;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Stateless

public class Querys implements QuerysLocal {

    @PersistenceContext
    EntityManager entityManager;

    public List<Order> findAllOrderDONE(){

        Query query = entityManager.createQuery("SELECT o FROM Order o WHERE o.status = 'DONE'");
        return query.getResultList();

    }



}
