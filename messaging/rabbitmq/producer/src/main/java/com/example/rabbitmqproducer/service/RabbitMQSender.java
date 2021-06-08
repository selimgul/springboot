package com.example.rabbitmqproducer.service;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class RabbitMQSender {
    
    @Value("${rabbitmq.exchange}")
    private String exchange;

    @Value("${rabbitmq.routingKey}")
    private String routingKey;

    @Autowired
    private RabbitTemplate rabbit;

	public void send(String message) {	    		
	    rabbit.convertAndSend(exchange, routingKey, message);
	    System.out.println("Message sent to RabbitMQ: " + message);
	}
}
