package com.antel;

import com.antel.entities.Order;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.ejb.EJB;
import javax.ejb.Remove;
import javax.ejb.Stateful;
import javax.interceptor.Interceptors;

@Stateful
@Interceptors({InterceptorLogger.class})
public class PlaceOrderBean implements PlaceOrderLocal {

    @EJB
    EnviarOrden enviarOrden;

    @EJB
    TimerAlertOrderInt timerAlertOrderInt;

    private Order order;

    @PostConstruct
    public void Initialize(){
        order = new Order();
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

        timerAlertOrderInt.timerAlertOrder(order);
        enviarOrden.sendMessage(order);

    }
}
