package com.example.rabbitmqconsumer.service;

import com.example.rabbitmqconsumer.exception.BusinessException;
import com.rabbitmq.client.Channel;

import org.springframework.amqp.AmqpRejectAndDontRequeueException;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class RabbitMQReceiver {

    @RabbitListener(queues = "${rabbitmq.queue}", containerFactory = "rabbitMQContainerFactory")
	public void recievedMessage(String msg, Message message, Channel channel) throws Exception {
			
		log.info("Recieved Message From RabbitMQ: " + msg);
		
		if (msg.equals("error")){		
			throw new BusinessException();
			
		} else if (msg.equals("ignore")){
			throw new AmqpRejectAndDontRequeueException("Ignore it");
		}		
	}
}
