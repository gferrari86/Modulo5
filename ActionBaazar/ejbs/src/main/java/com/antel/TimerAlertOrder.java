package com.antel;

import com.antel.entities.Order;

import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.ejb.Timeout;
import javax.ejb.Timer;
import javax.ejb.TimerService;

@Stateless
public class TimerAlertOrder implements TimerAlertOrderInt{

    @Resource TimerService _timerService;

    public void timerAlertOrder(Order order){
        _timerService.createTimer(15000,order);

    }

    @Timeout
    public void timerCallback(Timer timer){

        Order order = (Order)timer.getInfo();

        System.out.println("Alerta de Orden: " + order.getItemId());

    }

}
