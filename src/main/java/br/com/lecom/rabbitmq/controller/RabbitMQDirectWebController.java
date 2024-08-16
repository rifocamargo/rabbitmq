package br.com.lecom.rabbitmq.controller;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/direct")
public class RabbitMQDirectWebController {

	@Autowired
	private AmqpTemplate amqpTemplate;

	@PostMapping(value = "/producer")
	public String producer(@RequestParam("routingKey") String routingKey) {

		amqpTemplate.convertAndSend("direct-exchange", routingKey, "RabbitMQDirectMessage");

		return "Message sent to the RabbitMQ Successfully";
	}

}
