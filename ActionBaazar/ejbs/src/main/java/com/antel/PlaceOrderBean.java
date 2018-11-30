package com.antel;

import com.antel.entities.Bid;
import com.antel.entities.EnumStatus;
import com.antel.entities.Order;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.ejb.EJB;
import javax.ejb.Remove;
import javax.ejb.Stateful;
import javax.interceptor.Interceptors;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateful
@Interceptors({InterceptorLogger.class})
public class PlaceOrderBean implements PlaceOrderLocal {

    @EJB
    EnviarOrden enviarOrden;

    @EJB
    TimerAlertOrderInt timerAlertOrderInt;

    private Order order;

    @PersistenceContext
    EntityManager entityManager;

    @PostConstruct
    public void Initialize(){
        order = new Order();
        order.setStatus(EnumStatus.PROGRESS);
        System.out.println("Stateful - PostConstruct");
    }

    @PreDestroy
    public void destroy(){
        System.out.println("Stateful - PreDestroy");
    }

    public void setItemId(long itemId) {

        order.setItemId(itemId);

    }

    public void setShippingAddress(String shippingAddress) {

        order.setShippingAddress(shippingAddress);
    }

    @Interceptors(InterceptorBillOrder.class)
    public void setBillingAddress(String billingAddress) {

        order.setBillingAddress(billingAddress);
    }

    @Remove
    public void confirmOrder() {
        System.out.println("item id "+ order.getItemId());
        System.out.println("shipping address "+ order.getShippingAddress());
        System.out.println("billing address "+ order.getBillingAddress());
        System.out.println("enviarOrden.sendMessage");

        entityManager.persist(order);
        //timerAlertOrderInt.timerAlertOrder(order);
        enviarOrden.sendMessage(order);

    }

    public void addBid(long l) {
        //buscar en la base
        Bid bid = entityManager.find(Bid.class, l);

        order.getBids().add(bid);

    }
}
