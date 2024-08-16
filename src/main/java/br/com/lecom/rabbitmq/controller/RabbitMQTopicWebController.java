package br.com.lecom.rabbitmq.controller;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/topic")
public class RabbitMQTopicWebController {

	@Autowired
	private AmqpTemplate amqpTemplate;

	@PostMapping(value = "/producer")
	public String producer(@RequestParam("routingKey") String routingKey) {

		amqpTemplate.convertAndSend("topic-exchange", routingKey, "RabbitMQTopicMessage");

		return "Message sent to the RabbitMQ Topic Exchange Successfully";
	}

}