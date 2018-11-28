package com.antel;

import com.antel.entities.Order;

import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.interceptor.Interceptors;
import javax.jms.*;

@MessageDriven(
        name = "Recibe Orden",
        activationConfig = {
                @ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Queue"),
                @ActivationConfigProperty(propertyName = "destination", propertyValue = "java:jboss/exported/jms/queue/test"),
        }

)

@Interceptors({InterceptorMessage.class})
public class RecibeOrden implements MessageListener {

    public void onMessage(Message message) {

        System.out.println("Recibiendo Mensaje");

        //TextMessage textMessage = (TextMessage) message;
        ObjectMessage objectMessage = (ObjectMessage) message;

        try {
            Order order = (Order) objectMessage.getObject();
            System.out.println("se recibio la orden " + order.getItemId() );
            //System.out.println(textMessage.getText());
        } catch (JMSException e) {
            e.printStackTrace();
        }

    }

}
