package com.antel;

import com.antel.entities.Order;

import javax.ejb.Local;
import javax.ejb.Timer;

@Local
public interface TimerAlertOrderInt {

    public void timerAlertOrder(Order order);
    public void timerCallback(Timer timer);

}
