package br.com.lecom.rabbitmq.controller;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/fanout")
public class RabbitMQFanoutWebController {

	@Autowired
	private AmqpTemplate amqpTemplate;

	@PostMapping(value = "/producer")
	public String producer() {

		amqpTemplate.convertAndSend("fanout-exchange", "", "RabbitMQFanoutMessage");

		return "Message sent to the RabbitMQ Fanout Exchange Successfully";
	}
}