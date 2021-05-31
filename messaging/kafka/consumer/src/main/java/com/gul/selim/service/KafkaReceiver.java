package com.gul.selim.service;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class KafkaReceiver {
	
	@KafkaListener(topics = "${kafka.topic}", containerFactory = "kafkaListenerContainerFactory")
	public void recievedMessage(String message) {
		System.out.println("Recieved Message From Kafka: " + message);
	}
	
	
//	@KafkaListener(topics = "javainuse-topic", containerFactory = "kafkaListenerContainerFactory")
//	public void recievedMessage(ConsumerRecord<?, ?> message, Acknowledgment ack) {
//		System.out.println("================================================================");
//		System.out.println("Partition: " + message.partition());		
//		System.out.println("Offset   : " + message.offset());
//		System.out.println("Topic    : " + message.topic());
//		System.out.println("Value    : " + message.value());
//		System.out.println("TimeStamp: " + message.timestamp());
//		System.out.println("================================================================");
//	}	
	
}
