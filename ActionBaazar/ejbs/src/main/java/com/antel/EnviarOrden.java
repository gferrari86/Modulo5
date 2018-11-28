package com.antel;

import com.antel.entities.Order;

import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.jms.*;


@Stateless
public class EnviarOrden {

    @Resource(lookup = "java:/ConnectionFactory")
    ConnectionFactory connectionFactory;

    @Resource(lookup = "java:jboss/exported/jms/queue/test")
    Destination queue;

    public void sendMessage(Order order){

        System.out.println("Enviando Mensaje");

        try {
            Connection connection = connectionFactory.createConnection();
            Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
            connection.start();
            MessageProducer sender = session.createProducer(queue);
            //TextMessage textMessage = session.createTextMessage();
            //textMessage.setText("Mensaje de Prueba");
            //sender.send(textMessage);
            ObjectMessage message = session.createObjectMessage();
            message.setObject(order);
            sender.send(message);

            sender.close();
            session.close();
            connection.stop();


        } catch (JMSException e) {
            e.printStackTrace();
        }

    }


}
