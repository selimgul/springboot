package com.example.rabbitmqproducer.controller;

import com.example.rabbitmqproducer.service.RabbitMQSender;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RabbitMQWebController {

	@Autowired
	private RabbitMQSender rabbitMQSender;

	@GetMapping(value = "/producer")
	public String producer(@RequestParam("message") String message) {
		rabbitMQSender.send(message);
		return "Message sent to the RabbitMQ.";
	}

}